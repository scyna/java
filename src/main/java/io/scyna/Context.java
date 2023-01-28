package io.scyna;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.google.protobuf.Message;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

public class Context extends Logger {

    Context() {
        super(0, false);
    }

    public <T extends Message> void publishEvent(String channel, T data) {

    }

    public Response sendRequest(String url, Message request) {
        Trace trace = Trace.newEndpointTrace(url, this.id);
        Response ret = null;

        try {
            var req = Request.newBuilder().setTraceID(trace.ID()).setJSON(false);
            if (request != null) {
                req.setBody(request.toByteString());
            }

            Future<io.nats.client.Message> incoming = Engine.connection().request(Utils.publishURL(url),
                    req.build().toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            ret = Response.parseFrom(msg.getData());
            trace.update(ret.getSessionID(), ret.getCode());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        trace.record();
        return ret;
    }
}
