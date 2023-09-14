package scyna.eventstore;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.HashMap;
import com.datastax.driver.core.PreparedStatement;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import scyna.Engine;

public class EventStore<D extends Message> {
    private String tableName;
    private PreparedStatement getModelQuery;
    private PreparedStatement writeModelQuery;
    private PreparedStatement getLastSyncedQuery;
    private PreparedStatement tryToLockQuery;
    private PreparedStatement markSyncedQuery;
    private PreparedStatement getSyncRowQuery;
    private Parser<D> parser;
    private Message.Builder builder;
    private Map<String, IProjection> projections = new HashMap<String, IProjection>();

    @SuppressWarnings("unchecked")
    EventStore(String tableName, Class<D> cls) throws Exception {
        var session = Engine.DB().getSession();
        this.tableName = tableName;

        Method m = cls.getMethod("newBuilder");
        builder = (Message.Builder) m.invoke(null);
        var tObj = builder.build();
        parser = (Parser<D>) tObj.getParserForType();

        getModelQuery = session.prepare("SELECT version,data FROM " + tableName + " WHERE id=? LIMIT 1");
        writeModelQuery = session.prepare("INSERT INTO " + tableName
                + "(id,type,data,event,created,version,state) VALUES(?,?,?,?,?,?,0) IF NOT EXISTS");
        getLastSyncedQuery = session.prepare("SELECT version FROM " + tableName + " WHERE id=? AND state=2 LIMIT 1");
        tryToLockQuery = session
                .prepare("UPDATE " + tableName + " SET locked=?, state=1 WHERE id=? AND version=? IF state=0");
        markSyncedQuery = session.prepare("UPDATE " + tableName + " SET state=2 WHERE id=? AND version=?");
        getSyncRowQuery = session
                .prepare("SELECT type,data,event FROM " + tableName + " WHERE id=? AND version=? LIMIT 1");
    }

    public static <D extends Message> EventStore<D> Create(String tableName, Class<D> cls) throws Exception {
        return new EventStore<D>(tableName, cls);
    }

    public String getTableName() {
        return tableName;
    }

    public Model<D> readModel(Object id) throws scyna.Error {
        try {
            var row = Engine.DB().getSession().execute(getModelQuery.bind(id)).one();
            if (row == null)
                throw scyna.Error.OBJECT_NOT_FOUND;
            if (row.isNull("data"))
                throw scyna.Error.BAD_DATA;
            var data = parser.parseFrom(row.getBytes("data"));
            return new Model<D>(id, row.getLong("version"), data, this);
        } catch (scyna.Error e) {
            throw e;
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            throw scyna.Error.BAD_DATA;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    @SuppressWarnings("unchecked")
    public Model<D> createModel(Object id) throws scyna.Error {
        try {
            var rs = Engine.DB().getSession().execute(getModelQuery.bind(id));
            if (rs.one() != null)
                throw scyna.Error.OBJECT_EXISTS;
            return new Model<D>(id, 0, (D) builder.build(), this);
        } catch (scyna.Error e) {
            throw e;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    void updateWriteModel(Model<D> model, Message event) throws scyna.Error {
        try {
            model.version++;
            if (!Engine.DB().getSession().execute(writeModelQuery.bind(
                    model.ID, event.getClass().getName(),
                    ByteBuffer.wrap(model.data.toByteArray()),
                    ByteBuffer.wrap(event.toByteArray()),
                    java.time.Instant.now(), model.version)).one().getBool("[applied]"))
                throw scyna.Error.COMMAND_NOT_COMPLETED;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            throw scyna.Error.COMMAND_NOT_COMPLETED;
        }
    }

    void updateReadModel(Object id) {
        var version = getLastSynced(id);
        if (version == -1)
            return;
        version++;
        while (sync(id, version)) {
            version++;
        }
    }

    boolean sync(Object id, long version) {
        if (!tryToLock(id, version)) {
            if (!lockingLongRow(id, version))
                return false;
        }
        if (!syncRow(id, version))
            return false;
        if (!markSynced(id, version))
            return false;
        return true;
    }

    long getLastSynced(Object id) {
        try {
            var row = Engine.DB().getSession().execute(getLastSyncedQuery.bind(id)).one();
            if (row == null)
                return 0;
            return row.getLong("version");
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            return -1;
        }
    }

    boolean tryToLock(Object id, long version) {
        try {
            return Engine.DB().getSession().execute(tryToLockQuery.bind(
                    java.time.Instant.now(), id, version)).one().getBool("[applied]");
        } catch (Exception e) {
            return false;
        }
    }

    boolean lockingLongRow(Object id, long version) {
        /* TODO */
        return false;
    }

    boolean syncRow(Object id, long version) {
        try {
            var row = Engine.DB().getSession().execute(getSyncRowQuery.bind(id, version)).one();
            if (row == null)
                return false;

            var type = row.getString("type");
            var data = row.getBytes("data");
            var event = row.getBytes("event");
            var p = projections.get(type);
            if (p != null) {
                p.update(event, data);
                return true;
            }

            Engine.LOG().error("No projection for type=" + type);
            return false;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            return true; /* FIXME: MUST be FALSE or ALERT to ADMIN */
        }
    }

    boolean markSynced(Object id, long version) {
        try {
            Engine.DB().getSession().execute(markSyncedQuery.bind(id, version));
            return true;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            return false;
        }
    }

    public void registerProjection(IProjection projection) throws Exception {
        if (projections.containsKey(projection.getType()))
            throw new RuntimeException("Type '" + projection.getType() + "' is already registered");
        projections.put(projection.getType(), projection);
    }
}
