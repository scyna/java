package scyna.testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import scyna.DomainEvent;
import scyna.Error;
import scyna.Request;

public class EndpointTest extends BaseTest<EndpointTest> {
    private int status = 200;
    private String url;
    private Message request = null;
    private Message response = null;
    private Error error = null;
    private ByteString responseData;

    EndpointTest(String url) {
        this.url = url;
    }

    public EndpointTest withRequest(Message request) {
        this.request = request;
        return this;
    }

    public EndpointTest expectError(scyna.Error error) {
        this.status = 400;
        this.error = error;
        return this;
    }

    public EndpointTest expectResponse(Message response) {
        this.status = 200;
        this.response = response;
        return this;
    }

    public Result run() {
        createStream();
        DomainEvent.Instance().clear();
        var res = Request.send(0, url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());
        responseData = res.getBody();
        if (response != null) {
            try {
                var parser = response.getParserForType();
                var o = parser.parseFrom(res.getBody());
                assertEquals(response, o);
            } catch (InvalidProtocolBufferException e) {
                fail("Error in parsing response");
            }
        } else if (error != null) {
            try {
                var e = scyna.proto.Error.parser().parseFrom(res.getBody());
                assertEquals(error.getMessage(), e.getMessage());
                assertEquals(error.getCode(), e.getCode());
            } catch (InvalidProtocolBufferException e) {
                fail("Error in parsing error");
            }
        }

        receiveDomainEvents();
        receiveEvent();
        deleteStream();
        return new Result(this);
    }

    public class Result {
        private EndpointTest test;

        Result(EndpointTest test) {
            this.test = test;
        }

        public <E extends Message> E parseResponse(Parser<E> parser) {
            try {
                return parser.parseFrom(test.responseData);
            } catch (InvalidProtocolBufferException e) {
                fail("Error in parsing response");
            }
            return null;
        }

        public <E extends Message> E parseEvent(Parser<E> parser) {
            try {
                return parser.parseFrom(test.eventData);
            } catch (InvalidProtocolBufferException e) {
                fail("Error in parsing event");
            }
            return null;
        }

        public <E extends Message> E parseNextDomainEvent(Parser<E> parser) {
            try {
                return parser.parseFrom(DomainEvent.Instance().nextEvent().toByteArray());
            } catch (Exception e) {
                fail("Error in parsing domain event");
            }
            return null;
        }
    }
}
