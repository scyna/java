package io.scyna;

import java.nio.ByteBuffer;

import com.datastax.driver.core.BoundStatement;
import com.google.protobuf.Message;

public class ActivityStream {
    private final static int TRY_COUNT = 10;
    private String tableName;

    public ActivityStream(String table) {
        this.tableName = table;
    }

    public void add(long entity, int type, Message activity) {
        var session = Engine.DB().session();
        try {
            var data = activity.toByteArray();
            var buffer = ByteBuffer.wrap(data);
            var time = Utils.currentMicroSeconds();
            var qInsert = session.prepare(
                    "INSERT INTO " + tableName + " (entity_id, type, time, data) VALUES(?,?,?,?) IF NOT EXISTS");
            var statement = new BoundStatement(qInsert);

            for (int i = 0; i < TRY_COUNT; i++) {
                var rs = session.execute(statement.bind(entity, type, time + i, buffer));
                if (rs.one().getBool("applied")) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
