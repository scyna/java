package io.scyna;

import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.Row;
import com.google.protobuf.Message;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ActivityStream {
    private String tableName;
    private PreparedStatement addStm;
    private PreparedStatement getStm;

    public ActivityStream(String entity, String stream) {
        String[] parts = entity.split("[.]");
        tableName = parts[0] + ".es_" + parts[1] + "_" + stream;
        var insertQuery = String.format("INSERT INTO %s(entity_id, type, time, data) VALUES (?, ?, ?, ?)", tableName);
        addStm = Engine.db().prepare(insertQuery);

        var getQuery = String.format(
                "SELECT entity_id, type, time, data FROM vf_profile.es_account_activity WHERE entity_id = ? ALLOW FILTERING");
        getStm = Engine.db().prepare(getQuery);
    }

    public void add(long entityID, int type, Message message) {
        var now = System.currentTimeMillis();
        try {
            var boundStm = addStm.bind(entityID, type, now, ByteBuffer.wrap(message.toByteArray()));
            var rs = Engine.db().execute(boundStm);
            if (!rs.wasApplied()) {
                Engine.LOG().error("Cannot insert new event: " + entityID);
            }
        } catch (Exception ex) {
            Engine.LOG().error(ex.getMessage());
        }
    }

    public List<EventObject> get(long entityID) {
        // Select event from data base
        var events = new ArrayList<EventObject>();
        try {
            var rEvents = Engine.db().execute(getStm.bind(entityID));

            for (Row row : rEvents) {
                EventObject event = new EventObject(row.getLong("entity_id"), row.getShort("type"), row.getLong("time"),
                        row.getBytes("data"));
                events.add(event);
            }
        } catch (Exception ex) {
            Engine.LOG().error(ex.getMessage());
            return null;
        }
        return events;
    }

    public class EventObject {
        private long entityID;
        private int type;
        private long time;
        private byte[] data;

        public EventObject(long entityID, short type, long time, ByteBuffer data) {
            this.entityID = entityID;
            this.type = type;
            this.time = time;
            this.data = new byte[data.remaining()];
            data.get(this.data);
        }

        public long getEntityID() {
            return entityID;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }

        public long getTime() {
            return time;
        }

        public void setTime(long time) {
            this.time = time;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public void setEntityID(long entityID) {
            this.entityID = entityID;
        }
    }
}
