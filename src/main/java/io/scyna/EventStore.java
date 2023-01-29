package io.scyna;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.Batch;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.google.protobuf.Message;

public class EventStore {

    static final String TABLE_NAME = "event_store";
    long version;
    String keyspace;

    private static EventStore instance_ = null;

    public static EventStore instance() {
        if (instance_ == null) {
            Engine.LOG().error("EventStore is not initialized");
            System.exit(1);
        }
        return instance_;
    }

    public static void init(String keyspace) {
        var select = QueryBuilder.select(QueryBuilder.max("event_id")).from(keyspace, TABLE_NAME);
        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            long version = 1;
            if (row != null && (!row.isNull(0))) {
                version = row.getLong(0);
            }

            instance_ = new EventStore();
            instance_.version = version;
            instance_.keyspace = keyspace;
        } catch (DriverException e) {
            Engine.LOG().error("Can not load EventStore configuration fron database");
            System.exit(1);
        }
    }

    public void Append(Logger LOG, Batch batch, long agrregate, String channel, Message event) {
        /* TODO */
    }
}
