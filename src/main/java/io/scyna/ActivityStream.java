package io.scyna;

import java.nio.ByteBuffer;

import com.datastax.driver.core.BoundStatement;
import com.google.protobuf.Message;

public class ActivityStream {
    private final static int TRY_COUNT = 10;
    private String tableName;

    public ActivityStream(String keyspace) {
        this.tableName = keyspace + ".activity";
    }

    public void add(long entity, int type, Message activity) {
        var session = Engine.DB().session();
        try {
            var buf = activity.toByteArray();
            var buffer = ByteBuffer.wrap(buf);
            var time = Utils.currentMicroSeconds();
            var qInsert = session.prepare(
                    "INSERT INTO " + tableName + " (entity_id, type, time, data) VALUES(?,?,?,?) IF NOT EXISTS");
            var statement = new BoundStatement(qInsert);

            int count = 0;
            while (count < TRY_COUNT) {
                var rs = session.execute(statement.bind(entity, type, time, buffer));
                if (rs.one().getBool("applied")) {
                    break;
                }
                time++;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
