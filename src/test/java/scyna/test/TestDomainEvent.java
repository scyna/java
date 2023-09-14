package scyna.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import scyna.DomainEvent;
import scyna.Engine;
import scyna.Error;

public class TestDomainEvent {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        DomainEvent.Instance().register(new EventReceivedHandler());
        DomainEvent.Instance().start();
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void testGivenGoodRequest_ShouldSuccess() throws InterruptedException {
        DomainEvent.Instance().addEvent(0, scyna.proto.EventReceived.newBuilder().setText("Hello").build());
        Thread.sleep(100);
    }

    public static class EventReceivedHandler extends DomainEvent.Handler<scyna.proto.EventReceived> {
        @Override
        public void Execute() throws Error {
            context.info("Receive EventReceived: " + data.toString());
        }
    }
}
