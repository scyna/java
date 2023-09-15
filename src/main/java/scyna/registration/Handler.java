package scyna.registration;

import com.google.protobuf.Message;
import scyna.eventstore.Projection;

public class Handler {
    BaseRegistration<?> registration;

    Handler(BaseRegistration<?> registration) {
        this.registration = registration;
    }

    public <E extends Message> void Then(Class<E> event) {
        /* do nothing */
    }

    public <E extends Message, P extends Projection<E, ?>> void Then(Class<E> event, Class<P> projection)
            throws Exception {
        if (registration.eventStore == null)
            throw new Exception("Event store is not initialized");
        registration.eventStore.registerProjection(projection.getDeclaredConstructor().newInstance());
    }
}