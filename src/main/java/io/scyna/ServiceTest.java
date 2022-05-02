package io.scyna;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

public class ServiceTest {
    private String url;
    private Message request = null;
    private Message response = null;
    private int status;

    private ServiceTest(String url) {
        this.url = url;
    }

    public static ServiceTest New(String url) {
        return new ServiceTest(url);
    }

    public ServiceTest withRequest(Message request) {
        this.request = request;
        return this;
    }

    public ServiceTest expectSuccess() {
        this.status = 200;
        return this;
    }

    public ServiceTest expectError(io.scyna.proto.Error error) {
        this.status = 400;
        this.response = error;
        return this;
    }

    public ServiceTest expectResponse(Message response) {
        this.status = 200;
        this.response = response;
        return this;
    }

    public void run() {
        var res = Service.sendRequest(url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());

        if (response != null) {

            try {
                var parser = response.getParserForType();
                var o = parser.parseFrom(res.getBody());
                assertEquals(response, o);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }

    public <T extends Message> T run(Parser<T> parser) {
        var res = Service.sendRequest(url, request);
        assertNotNull(res);
        assertEquals(status, res.getCode());
        try {
            return parser.parseFrom(res.getBody());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return null;
    }
}
