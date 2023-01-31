package io.scyna;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.protobuf.Message;

public class Command {
    static final String TABLE_NAME = "event_store";
    static long version = 0;
    static String keyspace;

    private Batch batch;
    private Context context;
    long entity = 0;
    String channel = null;
    Message event = null;

    private Command(Context context) {
        this.context = context;
        this.batch = QueryBuilder.batch();
    }

    public static Command create(Context context) {
        return new Command(context);
    }

    public Command setAggregateID(long id) {
        entity = id;
        return this;
    }

    public Command setEvent(Message event) {
        this.event = event;
        return this;
    }

    public Command setChannel(String channel) {
        this.channel = channel;
        return this;
    }

    public Batch getBatch() {
        return batch;
    }

    public void commit() throws io.scyna.Error {
        if (version == 0) {
            context.error("SingleWriter is not initialized");
            System.exit(1);
        }

        if (entity == 0 || event == null) {
            throw io.scyna.Error.BAD_DATA;
        }

        try {
            var id = version + 1;
            var data = event.toByteArray();
            batch.add(QueryBuilder.insertInto(keyspace, TABLE_NAME)
                    .value("event_id", id)
                    .value("entity_id", entity)
                    .value("channel", channel)
                    .value("data", data));

            Engine.DB().session().execute(batch);
            version = id;

            if (this.channel != null) {
                context.publishEvent(channel, data);
            }
        } catch (DriverException e) {
            e.printStackTrace();
            throw io.scyna.Error.SERVER_ERROR;
        }
    }

    public static void initSingleWriter(String keyspace) {
        var select = QueryBuilder.select(QueryBuilder.max("event_id")).from(keyspace, TABLE_NAME);
        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            long version = 1;
            if (row != null && (!row.isNull(0))) {
                version = row.getLong(0);
            }
            Command.version = version;
            Command.keyspace = keyspace;

            /* TODO: publish last event here */

        } catch (DriverException e) {
            Engine.LOG().error("Can not load SingleWriter configuration from database");
            System.exit(1);
        }
    }
}