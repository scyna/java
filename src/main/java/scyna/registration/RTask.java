package scyna.registration;

import com.google.protobuf.Message;

public class RTask {
    BaseRegistration<?> registration;
    String sender;
    String channel;

    RTask(BaseRegistration<?> registration, String sender, String channel) {
        this.sender = sender;
        this.channel = channel;
        this.registration = registration;
    }

    public <R extends Message> Event<R> Given(Class<R> Event) {
        return new Event<R>(this);
    }

    public static class Event<R extends Message> {
        RTask event;

        Event(RTask event) {
            this.event = event;
        }

        public <H extends scyna.Task.Handler<R>> Handler When(Class<H> handler) throws Exception {
            if (!event.registration.testMode) {
                scyna.Task.Register(event.sender, event.channel, handler.getDeclaredConstructor().newInstance());
            }
            return new Handler(event.registration);
        }
    }
}