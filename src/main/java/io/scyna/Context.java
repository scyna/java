package io.scyna;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;
import com.google.protobuf.Message;

import io.nats.client.JetStreamApiException;
import io.scyna.proto.Event;
import io.scyna.proto.Request;
import io.scyna.proto.Response;
import io.scyna.proto.TagCreatedSignal;

public class Context extends Logger {

    Context() {
        super(0, false);
    }

    public void publishEvent(String channel, byte[] data) throws io.scyna.Error {
        System.out.println("publish event to " + channel);
        try {
            var event = Event.newBuilder().setTraceID(this.id).setBody(ByteString.copyFrom(data)).build();
            Engine.connection().jetStream().publish(channel, event.toByteArray());
        } catch (IOException e) {
            System.out.println("h1");
            e.printStackTrace();
            throw io.scyna.Error.SERVER_ERROR;
        } catch (JetStreamApiException e) {
            System.out.println("h2");
            e.printStackTrace();
            throw io.scyna.Error.STREAM_ERROR;
        }
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

    public void saveTag(String key, String value) {
        if (id == 0) {
            return;
        }

        Signal.emit(Path.TRACE_CREATED_CHANNEL, TagCreatedSignal.newBuilder()
                .setTraceID(id)
                .setKey(key)
                .setValue(value)
                .build());
    }

    public void scheduleTask() {
        /* TODO */
    }
}
