package io.scyna;

import com.google.protobuf.Message;
import io.scyna.proto.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class Request {
    public static Response send(String url, Message request) {
        try {
            var callID = Engine.ID().next();
            var req = io.scyna.proto.Request.newBuilder().setTraceID(callID).setJSON(false);

            if (request != null) {
                req.setBody(request.toByteString());
            }

            Future<io.nats.client.Message> incoming = Engine.connection().request(Utils.publishURL(url),
                    req.build().toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            return Response.parseFrom(msg.getData());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
