package scyna.testing;

import com.google.protobuf.Message;

import scyna.DomainEvent;
import scyna.Event;
import scyna.Task;

public class Testing {
    public static EndpointTest Endpoint(String url) {
        return new EndpointTest(url);
    }

    public static <T extends Message> DomainEventTest<T> DomainEvent(DomainEvent.Handler<T> handler) {
        return new DomainEventTest<T>(handler);
    }

    public static <T extends Message> EventTest<T> Event(Event.Handler<T> handler) {
        return new EventTest<T>(handler);
    }

    public static <T extends Message> TaskTest<T> Task(Task.Handler<T> handler) {
        return new TaskTest<T>(handler);
    }
}
