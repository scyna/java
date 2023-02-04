package io.scyna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.time.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import io.nats.client.api.StreamConfiguration;

public class EndpointTest {
    private int status;
    private String url;
    private Message request = null;
    private Message response = null;
    private Message event = null;
    private String channel = "";
    private String streamName = "";
    private boolean exactEventMatch = true;
    private boolean exactResponseMatch = true;

    private EndpointTest(String url) {
        this.url = url;
    }

    public static EndpointTest create(String url) {
        return new EndpointTest(url);
    }

    public EndpointTest withRequest(Message request) {
        this.request = request;
        return this;
    }

    public EndpointTest expectSuccess() {
        this.status = 200;
        return this;
    }

    public EndpointTest expectError(io.scyna.Error error) {
        this.status = 400;
        this.response = error.toProto();
        return this;
    }

    public EndpointTest expectResponse(Message response) {
        this.status = 200;
        this.response = response;
        return this;
    }

    public EndpointTest matchResponse(Message response) {
        this.status = 200;
        this.response = response;
        this.exactResponseMatch = false;
        return this;
    }

    public EndpointTest expectEvent(Message event) {
        this.event = event;
        return this;
    }

    public EndpointTest matchEvent(Message event) {
        this.event = event;
        this.exactEventMatch = false;
        return this;
    }

    public EndpointTest publishEventTo(String channel) {
        this.channel = channel;
        return this;
    }

    public void run() {
        createStream();
        var trace = Trace.newEndpointTrace(url, 0);
        var res = Endpoint.sendRequest(url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());
        trace.update(res.getSessionID(), res.getCode());

        if (response != null) {
            try {
                var parser = response.getParserForType();
                var o = parser.parseFrom(res.getBody());
                if (exactResponseMatch) {
                    assertEquals(response, o);
                } else {
                    assertTrue("Response not match", partialMatchMessage(response, o));
                }
            } catch (InvalidProtocolBufferException e) {
                assertTrue(false);
                e.printStackTrace();
            }
        }
        trace.record();
        receiveEvent();
        deleteStream();
    }

    public <T extends Message> T run(Parser<T> parser) {
        createStream();
        var trace = Trace.newEndpointTrace(url, 0);
        var res = Endpoint.sendRequest(url, request);
        trace.update(res.getSessionID(), res.getCode());
        assertNotNull(res);
        assertEquals(status, res.getCode());
        try {
            trace.record();
            return parser.parseFrom(res.getBody());
        } catch (InvalidProtocolBufferException e) {
            assertTrue(false);
            e.printStackTrace();
        }
        trace.record();
        receiveEvent();
        deleteStream();
        return null;
    }

    private void receiveEvent() {
        if (event == null) {
            return;
        }

        try {
            var sub = Engine.stream().subscribe(streamName + "." + channel);
            var msg = sub.nextMessage(Duration.ofSeconds(1));

            if (msg == null)
                System.out.println("Timeout");

            assertNotNull(msg);

            var ev = io.scyna.proto.Event.parseFrom(msg.getData());
            var parser = event.getParserForType();
            var received = parser.parseFrom(ev.getBody());

            if (exactEventMatch) {
                assertEquals(event, received);
            } else {
                assertTrue("Event not match", partialMatchMessage(event, received));
            }

            sub.unsubscribe();
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Error in receiving event", false);
        }
    }

    private void createStream() {
        if (channel.length() == 0) {
            return;
        }
        streamName = Engine.module();
        try {
            StreamConfiguration config = StreamConfiguration.builder()
                    .name(streamName)
                    .subjects(streamName + ".>")
                    .build();

            var jsm = Engine.connection().jetStreamManagement();
            if (jsm.getStreamNames().contains(streamName)) {
                jsm.deleteStream(streamName);
            }
            jsm.addStream(config);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Error in creating stream", false);
        }
    }

    private void deleteStream() {
        if (channel.length() == 0) {
            return;
        }

        try {
            Engine.connection().jetStreamManagement().deleteStream(streamName);
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue("Error in deleting stream", false);
        }
    }

    private boolean partialMatchMessage(Message x, Message y) {
        if (x.getDescriptorForType() != y.getDescriptorForType()) {
            return false;
        }

        var equal = true;
        for (var i : y.getAllFields().entrySet()) {
            var fd = i.getKey();

            if (x.hasField(fd)) {
                var vx = x.getField(fd);
                equal = vx.equals(i.getValue());
            }

            if (!equal) {
                return false;
            }
        }
        return equal;
    }
}
