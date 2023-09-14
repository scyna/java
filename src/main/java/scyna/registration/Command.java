package scyna.registration;

import java.lang.reflect.InvocationTargetException;

import com.google.protobuf.Message;

import scyna.Endpoint;
import scyna.eventstore.Projection;

public class Command {
    private String url;

    Command(String url) {
        this.url = url;
    }

    public <R extends Message> Request<R> Given(Class<R> request) {
        return new Request<R>();
    }

    public static class Request<R extends Message> {
        public <H extends Endpoint.Handler<R>> Handler When(Class<H> handler) throws Exception {
            Endpoint.Register("", handler.getDeclaredConstructor().newInstance());
            return new Handler();
        }
    }

    public static class Handler {
        public <E extends Message> void Then(Class<E> event) {
            /* do nothing */
        }

        public <E extends Message, P extends Projection<E, ?>> void Then(Class<E> event, Class<P> projection) {
            /* do nothing */
        }
    }
}