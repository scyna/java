package scyna.eventstore;

import com.google.protobuf.Message;

import scyna.Error;

public class Model<D extends Message> {
    private EventStore<D> store;
    Object ID;
    long version;
    D data;
    Message event;

    public Object getID() {
        return ID;
    }

    public long getVersion() {
        return version;
    }

    public D getData() {
        return data;
    }

    public Message getEvent() {
        return event;
    }

    public Model(Object id, long version, D data, EventStore<D> store) {
        this.ID = id;
        this.version = version;
        this.store = store;
        this.data = data;
    }

    public void commitAndProject(D data, Message event) throws Error {
        this.data = data;
        this.event = event;
        store.updateWriteModel(this, event);
        store.updateReadModel(ID);
    }
}
