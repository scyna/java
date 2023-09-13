package scyna.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.time.Duration;
import com.google.protobuf.Message;
import io.nats.client.api.StreamConfiguration;
import scyna.DomainEvent;
import scyna.Engine;

public class BaseTest<T extends BaseTest<T>> {
    private Message event = null;
    private Message domainEvent = null;
    private String channel = "";
    private String streamName = "";

    @SuppressWarnings("unchecked")
    public T expectEvent(String channel, Message event) {
        this.channel = channel;
        this.event = event;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T expectDomainEvent(Message event) {
        this.domainEvent = event;
        return (T) this;
    }

    public void receiveDomainEvents() {
        if (domainEvent == null) {
            return;
        }

        var received = DomainEvent.Instance().nextEvent();
        if (received == null) {
            fail("No event received");
        }
        assertEquals("DomainEvent not matched", domainEvent, received);
    }

    public void receiveEvent() {
        if (event == null) {
            return;
        }

        try {
            var sub = Engine.Stream().subscribe(streamName + "." + channel);
            var msg = sub.nextMessage(Duration.ofSeconds(1));
            assertNotNull("No event received", msg);

            var ev = scyna.proto.Event.parseFrom(msg.getData());
            var parser = event.getParserForType();
            var received = parser.parseFrom(ev.getBody());
            assertEquals("Event not matched", event, received);

            sub.unsubscribe();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error in receiving event");
        }
    }

    public void createStream() {
        streamName = Engine.Module();
        try {
            StreamConfiguration config = StreamConfiguration.builder()
                    .name(streamName)
                    .subjects(streamName + ".>")
                    .build();

            var jsm = Engine.Connection().jetStreamManagement();
            if (jsm.getStreamNames().contains(streamName)) {
                jsm.deleteStream(streamName);
            }
            jsm.addStream(config);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error in creating stream");
        }
    }

    public void deleteStream() {
        try {
            Engine.Connection().jetStreamManagement().deleteStream(streamName);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error in deleting stream");
        }
    }
}
