package scyna;

import com.google.protobuf.Message;
import scyna.proto.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Request {
    public static Response send(long traceID, String url, Message request) {
        try {
            var trace = Trace.Endpoint(url, traceID);
            var callID = Engine.ID().next();
            var req = scyna.proto.Request.newBuilder().setTraceID(callID).setJSON(false);

            if (request != null) {
                req.setBody(request.toByteString());
            }

            Future<io.nats.client.Message> incoming = Engine.Connection().request(Utils.publishURL(url),
                    req.build().toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            var ret = Response.parseFrom(msg.getData());

            trace.setStatus(ret.getCode());
            trace.record();
            return ret;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
