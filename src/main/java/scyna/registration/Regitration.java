package scyna.registration;

import com.google.protobuf.Message;

import scyna.Endpoint;

public class Regitration {
    protected static boolean testMode = false;

    public Command Command(String url) {
        return new Command(url);
    }

    public DomainEvent DomainEvent() {
        return new DomainEvent();
    }

    public <R extends Message> void Endpoint(String url, Endpoint.Handler<R> handler) throws Exception {
        Endpoint.Register(url, handler);
    }
}
