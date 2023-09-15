package scyna.registration;

import com.google.protobuf.Message;

public class DomainEvent {
    Registration registration;

    DomainEvent(Registration registration) {
        this.registration = registration;
    }

    public <R extends Message> Event<R> Given(Class<R> Event) {
        return new Event<R>(registration);
    }

    public static class Event<R extends Message> {
        Registration registration;

        Event(Registration registration) {
            this.registration = registration;
        }

        public <H extends scyna.DomainEvent.Handler<R>> Handler When(Class<H> handler) throws Exception {
            if (!registration.testMode) {
                scyna.DomainEvent.Register(handler.getDeclaredConstructor().newInstance());
            }
            return new Handler(registration);
        }
    }
}