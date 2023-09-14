package scyna.eventstore;

import com.google.protobuf.Message;

public class Model<D extends Message> {
    private EventStore<D> store;
    Object ID;
    long Version;
    D data;
    Message event;

    public Object getID() {
        return ID;
    }

    public long getVersion() {
        return Version;
    }

    public D getData() {
        return data;
    }

    public Message getEvent() {
        return event;
    }

    public Model(Object id, long version, D data, EventStore<D> store) {
        this.ID = id;
        this.Version = version;
        this.store = store;
        this.data = data;
    }

    public void CommitAndProject(Message event) {
        this.event = event;
        // store.UpdateWriteModel(this, event);
        // store.UpdateReadModel(ID);
    }
}
