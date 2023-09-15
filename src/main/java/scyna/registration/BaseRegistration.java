package scyna.registration;

import com.google.protobuf.Message;
import scyna.Endpoint;
import scyna.eventstore.EventStore;

public abstract class BaseRegistration<D extends Message> {
    boolean testMode = false;
    protected EventStore<D> eventStore;

    protected abstract void setup() throws Exception;

    protected abstract EventStore<D> setupEventStore() throws Exception;

    public void testInit() throws Exception {
        testMode = true;
        init();
    }

    public void init() throws Exception {
        eventStore = setupEventStore();
        setup();
    }

    protected Command Command(String url) {
        return new Command(this, url);
    }

    protected DomainEvent DomainEvent() {
        return new DomainEvent(this);
    }

    protected <R extends Message> void Endpoint(String url, Endpoint.Handler<R> handler) throws Exception {
        Endpoint.Register(url, handler);
    }
}
