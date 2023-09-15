package scyna.registration;

import com.google.protobuf.Message;

import scyna.eventstore.Projection;

public class Handler {
    public <E extends Message> void Then(Class<E> event) {
        /* do nothing */
    }

    public <E extends Message, P extends Projection<E, ?>> void Then(Class<E> event, Class<P> projection) {
        /* do nothing */
    }
}