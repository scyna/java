package scyna.testing;

import com.google.protobuf.Message;

import scyna.DomainEvent;

public class Testing {
    public static EndpointTest Endpoint(String url) {
        return new EndpointTest(url);
    }

    public static <T extends Message> DomainEventTest<T> DomainEvent(DomainEvent.Handler<T> handler) {
        return new DomainEventTest<T>(handler);
    }

}
