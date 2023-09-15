package scyna.registration;

import com.google.protobuf.Message;
import scyna.Endpoint;

public class RCommand {
    String url;
    BaseRegistration<?> registration;

    RCommand(BaseRegistration<?> registration, String url) {
        this.registration = registration;
        this.url = url;
    }

    public <R extends Message> Request<R> Given(Class<R> request) {
        return new Request<R>(this);
    }

    public static class Request<R extends Message> {
        private RCommand command;

        Request(RCommand command) {
            this.command = command;
        }

        public <H extends Endpoint.Handler<R>> Handler When(Class<H> handler) throws Exception {
            Endpoint.Register(command.url, handler.getDeclaredConstructor().newInstance());
            return new Handler(command.registration);
        }
    }
}