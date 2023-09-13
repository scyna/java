package scyna.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;
import io.nats.client.api.StreamConfiguration;
import scyna.DomainEvent;
import scyna.Engine;

public class BaseTest<T extends BaseTest<T>> {
    private Message event = null;
    private List<Message> domainEvents = new LinkedList<Message>();
    private String channel = "";
    private String streamName = "";
    protected ByteString eventData = null;

    @SuppressWarnings("unchecked")
    public T expectEvent(String channel, Message event) {
        this.channel = channel;
        this.event = event;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public <E extends Message> T expectEventFrom(String channel) {
        this.channel = channel;
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T expectDomainEvent(Message event) {
        this.domainEvents.add(event);
        return (T) this;
    }

    protected void receiveDomainEvents() {
        if (domainEvents.isEmpty()) {
            return;
        }

        for (var ev : domainEvents) {
            var received = DomainEvent.Instance().nextEvent();
            if (received == null) {
                fail("DomainEvent must not be null");
            }
            assertEquals("DomainEvent not matched", ev, received);
        }
    }

    protected void receiveEvent() {
        if (channel.isEmpty()) {
            return;
        }

        try {
            var sub = Engine.Stream().subscribe(streamName + "." + channel);
            var msg = sub.nextMessage(Duration.ofSeconds(1));
            assertNotNull("No event received", msg);

            var ev = scyna.proto.Event.parseFrom(msg.getData());
            eventData = ev.getBody();
            if (event != null) {
                var parser = event.getParserForType();
                var received = parser.parseFrom(ev.getBody());
                assertEquals("Event not matched", event, received);
            }
            sub.unsubscribe();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error in receiving event");
        }
    }

    protected void createStream() {
        if (channel.isEmpty()) {
            return;
        }

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

    protected void deleteStream() {
        if (channel.isEmpty()) {
            return;
        }

        try {
            Engine.Connection().jetStreamManagement().deleteStream(streamName);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Error in deleting stream");
        }
    }
}
