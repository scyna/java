package io.scyna;

import com.datastax.driver.core.PreparedStatement;
import com.google.protobuf.Message;

import java.nio.ByteBuffer;

public class ActivityStream {
    private String tableName;
    private PreparedStatement addStm;

    public ActivityStream(String entity, String stream) {
        String[] parts = entity.split("[.]");
        tableName = parts[0] + ".es_" + parts[1] + "_" + stream;
        var insertQuery = String.format("INSERT INTO %s(entity_id, type, time, data) VALUES (?, ?, ?, ?)", tableName);
        addStm = Engine.DB().prepare(insertQuery);
    }

    public void add(long entityID, int type, Message message) {
        var now = System.currentTimeMillis();
        try {
            var boundStm = addStm.bind(entityID, type, now, ByteBuffer.wrap(message.toByteArray()));
            var rs = Engine.DB().execute(boundStm);
            if (!rs.wasApplied()) {
                Engine.LOG().error("Cannot insert new event: " + entityID);
            }
        } catch (Exception ex) {
            Engine.LOG().error(ex.getMessage());
        }
    }
}
