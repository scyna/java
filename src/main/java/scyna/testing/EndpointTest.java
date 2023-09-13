package scyna.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import scyna.DomainEvent;
import scyna.Request;
import scyna.Trace;

public class EndpointTest extends BaseTest<EndpointTest> {
    private int status;
    private String url;
    private Message request = null;
    private Message response = null;

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

    public EndpointTest expectError(scyna.Error error) {
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
        createStream();
        DomainEvent.Instance().clear();
        var trace = Trace.Endpoint(url, 0);
        var res = Request.send(url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());

        if (response != null) {
            try {
                var parser = response.getParserForType();
                var o = parser.parseFrom(res.getBody());
                assertEquals(response, o);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
                fail("Error in parsing response");
            }
        }
        trace.record();
        receiveDomainEvents();
        receiveEvent();
        deleteStream();
    }
}
