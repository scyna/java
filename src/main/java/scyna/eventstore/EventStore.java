package scyna.eventstore;

import java.lang.reflect.Method;
import com.datastax.driver.core.PreparedStatement;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import scyna.Engine;

public class EventStore<D extends Message> {
    private static EventStore instance;
    private String tableName;
    private PreparedStatement getModelQuery;
    private PreparedStatement writeModelQuery;
    private PreparedStatement getLastSyncedQuery;
    private PreparedStatement tryToLockQuery;
    private PreparedStatement markSyncedQuery;
    private PreparedStatement getSyncRowQuery;
    private Parser<D> parser;
    private Message.Builder builder;

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

    public static <D extends Message> void Init(String tableName, Class<D> cls) throws Exception {
        if (instance != null)
            throw new RuntimeException("Event store already initlized");
        instance = new EventStore<D>(tableName, cls);
    }

    @SuppressWarnings("unchecked")
    public static <D extends Message> EventStore<D> Instance() throws scyna.Error {
        if (instance == null)
            throw scyna.Error.EVENT_STORE_NULL;
        return instance;
    }

    public static void Reset() {
        instance = null;
    }

    public String getTableName() {
        return tableName;
    }

    @SuppressWarnings("unchecked")
    public static <D extends Message> Model<D> ReadModel(Object id) throws scyna.Error {
        if (instance == null)
            throw scyna.Error.EVENT_STORE_NULL;
        return instance.readModel(id);
    }

    @SuppressWarnings("unchecked")
    public static <D extends Message> Model<D> CreateModel(Object id) throws scyna.Error {
        if (instance == null)
            throw scyna.Error.EVENT_STORE_NULL;
        return instance.createModel(id);
    }

    private Model<D> readModel(Object id) throws scyna.Error {
        var rs = Engine.DB().getSession().execute(getModelQuery.bind(id));
        var row = rs.one();
        if (row == null)
            throw scyna.Error.OBJECT_NOT_FOUND;
        if (row.isNull("data"))
            throw scyna.Error.BAD_DATA;
        try {
            var data = parser.parseFrom(row.getBytes("data"));
            return new Model<D>(id, row.getLong("version"), data, this);
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            throw scyna.Error.BAD_DATA;
        }
    }

    @SuppressWarnings("unchecked")
    private Model<D> createModel(Object id) throws scyna.Error {
        var rs = Engine.DB().getSession().execute(getModelQuery.bind(id));
        if (rs.one() != null)
            throw scyna.Error.OBJECT_EXISTS;
        var data = (D) builder.build();
        return new Model<D>(id, 0, data, this);
    }

    void UpdateWriteModel(Model<D> model, Message event) throws scyna.Error {
        try {
            model.Version++;
            if (!Engine.DB().getSession().execute(writeModelQuery.bind(model.ID, event.getClass().getName(),
                    model.data.toByteArray(), event.toByteArray(), java.time.Instant.now(), model.Version))
                    .one().getBool("[applied]"))
                throw scyna.Error.COMMAND_NOT_COMPLETED;
        } catch (Exception e) {
            Engine.LOG().error(e.getMessage());
            throw scyna.Error.COMMAND_NOT_COMPLETED;
        }
    }
}
