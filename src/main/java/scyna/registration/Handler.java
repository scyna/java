package scyna.registration;

import java.lang.reflect.InvocationTargetException;

import com.google.protobuf.Message;

import scyna.eventstore.Projection;

public class Handler {
    BaseRegistration registration;

    Handler(BaseRegistration registration) {
        this.registration = registration;
    }

    public <E extends Message> void Then(Class<E> event) {
        /* do nothing */
    }

    public <E extends Message, P extends Projection<E, ?>> void Then(Class<E> event, Class<P> projection)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
            NoSuchMethodException, SecurityException, Exception {
        registration.eventStore.registerProjection(projection.getDeclaredConstructor().newInstance());
    }
}