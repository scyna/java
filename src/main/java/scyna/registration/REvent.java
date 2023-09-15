package scyna.registration;

import com.google.protobuf.Message;

public class REvent {
    BaseRegistration<?> registration;
    String sender;
    String channel;

    REvent(BaseRegistration<?> registration, String sender, String channel) {
        this.sender = sender;
        this.channel = channel;
        this.registration = registration;
    }

    public <R extends Message> Event<R> Given(Class<R> Event) {
        return new Event<R>(this);
    }

    public static class Event<R extends Message> {
        REvent event;

        Event(REvent event) {
            this.event = event;
        }

        public <H extends scyna.Event.Handler<R>> Handler When(Class<H> handler) throws Exception {
            if (!event.registration.testMode) {
                scyna.Event.Register(event.sender, event.channel, handler.getDeclaredConstructor().newInstance());
            }
            return new Handler(event.registration);
        }
    }
}