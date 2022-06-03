package io.scyna;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import com.google.protobuf.Message;
import io.nats.client.JetStreamApiException;
import io.scyna.proto.EventOrSignal;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

public class Context extends Logger {

    Context() {
        super(0, false);
    }

    public <T extends Message> void emitSignal(String channel, T data) {
        var msg = EventOrSignal.newBuilder().setParentID(this.id).setBody(data.toByteString()).build();
        var nc = Engine.connection();
        nc.publish(channel, msg.toByteArray());
    }

    public <T extends Message> void post(String channel, T data) {
        try {
            var msg = EventOrSignal.newBuilder().setParentID(this.id).setBody(data.toByteString()).build();
            Engine.stream().publish(channel, msg.toByteArray());
        } catch (IOException | JetStreamApiException e) {
            e.printStackTrace();
        }
    }

    public Response sendRequest(String url, Message request) {
        Trace trace = new Trace();
        trace.ID = Engine.ID().next();
        trace.ParentID = this.id;
        trace.Time = LocalDateTime.now();
        trace.Path = url;
        trace.Type = Trace.SERVICE;
        trace.Source = Engine.module();
        Response ret = null;

        try {
            var req = Request.newBuilder().setTraceID(trace.ID).setJSON(false);
            if (request != null) {
                req.setBody(request.toByteString());
            }

            Future<io.nats.client.Message> incoming = Engine.connection().request(Utils.publishURL(url),
                    req.build().toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            ret = Response.parseFrom(msg.getData());

            trace.SessionID = ret.getSessionID();
            trace.Status = ret.getCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
        trace.record();
        return ret;
    }

}