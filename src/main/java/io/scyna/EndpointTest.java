package io.scyna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

public class EndpointTest {
    private String url;
    private Message request = null;
    private Message response = null;
    private int status;

    private EndpointTest(String url) {
        this.url = url;
    }

    public static EndpointTest New(String url) {
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

    public void run() {
        var trace = Trace.newEndpointTrace(url, 0);
        var res = Endpoint.sendRequest(url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());
        trace.update(res.getSessionID(), res.getCode());

        if (response != null) {
            try {
                var parser = response.getParserForType();
                var o = parser.parseFrom(res.getBody());
                assertEquals(response, o);
            } catch (InvalidProtocolBufferException e) {
                assertTrue(false);
                e.printStackTrace();
            }
        }
        trace.record();
    }

    public <T extends Message> T run(Parser<T> parser) {
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
        return null;
    }
}
