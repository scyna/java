package scyna.registration;

import com.google.protobuf.Message;
import scyna.Endpoint;
import scyna.eventstore.EventStore;

public abstract class BaseRegistration<D extends Message> {
    boolean testMode = false;
    protected EventStore<D> eventStore = null;

    protected abstract void setup() throws Exception;

    protected abstract EventStore<D> initEventStore() throws Exception;

    public void testInit() throws Exception {
        testMode = true;
        init();
    }

    public void init() throws Exception {
        eventStore = initEventStore();
        setup();
    }

    protected RCommand Command(String url) {
        return new RCommand(this, url);
    }

    protected RDomainEvent DomainEvent() {
        return new RDomainEvent(this);
    }

    protected REvent Event(String sender, String channel) {
        return new REvent(this, sender, channel);
    }

    protected <R extends Message> void Endpoint(String url, Endpoint.Handler<R> handler) throws Exception {
        Endpoint.Register(url, handler);
    }
}
