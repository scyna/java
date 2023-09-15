package scyna.registration;

import com.google.protobuf.Message;
import scyna.Endpoint;

public class Command {
    String url;
    BaseRegistration<?> regitration;

    Command(BaseRegistration<?> registration, String url) {
        this.regitration = registration;
        this.url = url;
    }

    public <R extends Message> Request<R> Given(Class<R> request) {
        return new Request<R>(this);
    }

    public static class Request<R extends Message> {
        private Command command;

        Request(Command command) {
            this.command = command;
        }

        public <H extends Endpoint.Handler<R>> Handler When(Class<H> handler) throws Exception {
            Endpoint.Register(command.url, handler.getDeclaredConstructor().newInstance());
            return new Handler(command.regitration);
        }
    }
}