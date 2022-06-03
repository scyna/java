package io.scyna;

import java.nio.ByteBuffer;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Row;
import com.google.protobuf.Message;

public class ActivityStream {
    private String tableName;

    public ActivityStream(String keyspace) {
        this.tableName = keyspace + ".activity";
    }

    public void add(long entity, int type, Message activity) {
        var session = Engine.DB().session();
        try {
            var buf = activity.toByteArray();
            ByteBuffer buffer = ByteBuffer.wrap(buf);
            long time = Utils.currentMicroSeconds();

            var ps = session.prepare(
                    "INSERT INTO " + tableName + " (entity_id, type, time, data) VALUES(?,?,?,?) IF NOT EXISTS");

            BoundStatement boundStatement = new BoundStatement(ps);

            int count = 0;

            while (count < 10) {
                var rs = session.execute(boundStatement.bind(entity, type, time, buffer));
                Row row = rs.one();
                if (row.getBool("applied"))
                    break;
                time++;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
