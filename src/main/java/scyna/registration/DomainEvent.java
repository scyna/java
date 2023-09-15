package scyna.registration;

import com.google.protobuf.Message;

public class DomainEvent {
    public <R extends Message> Event<R> Given(Class<R> Event) {
        return new Event<R>();
    }

    public static class Event<R extends Message> {
        public <H extends scyna.DomainEvent.Handler<R>> Handler When(Class<H> handler) throws Exception {
            if (!Regitration.testMode) {
                scyna.DomainEvent.Register(handler.getDeclaredConstructor().newInstance());
            }
            return new Handler();
        }
    }
}