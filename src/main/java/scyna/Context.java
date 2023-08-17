package scyna;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;

import io.nats.client.JetStreamApiException;
import scyna.proto.Event;
import scyna.proto.Request;
import scyna.proto.Response;
import scyna.proto.StartTaskRequest;
import scyna.proto.StartTaskResponse;
import scyna.proto.TagCreatedSignal;

public class Context extends Logger {

    Context() {
        super(0, false);
    }

    public void publishEvent(String channel, byte[] data) throws scyna.Error {
        try {
            var event = Event.newBuilder().setTraceID(this.id).setBody(ByteString.copyFrom(data)).build();
            var subject = Engine.module() + "." + channel;
            Engine.stream().publish(subject, event.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw scyna.Error.SERVER_ERROR;
        } catch (JetStreamApiException e) {
            e.printStackTrace();
            throw scyna.Error.STREAM_ERROR;
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

    public void tag(String key, String value) {
        if (id == 0) {
            return;
        }

        Signal.emit(Path.TRACE_CREATED_CHANNEL, TagCreatedSignal.newBuilder()
                .setTraceID(id)
                .setKey(key)
                .setValue(value)
                .build());
    }

    public long scheduleTask(String channel, long start, long interval, Message data, long loop)
            throws scyna.Error {

        var task = scyna.proto.Task.newBuilder().setTraceID(this.id).setData(data.toByteString()).build();
        var subject = Engine.module() + "." + channel;

        var response = sendRequest(Path.START_TASK_URL, StartTaskRequest.newBuilder()
                .setModule(Engine.module())
                .setTopic(subject)
                .setData(task.toByteString())
                .setTime(start)
                .setInterval(interval)
                .setLoop(loop)
                .build());
        if (response == null) {
            throw scyna.Error.REQUEST_INVALID;
        }

        try {
            var r = StartTaskResponse.parseFrom(response.getBody());
            return r.getId();
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
            throw scyna.Error.BAD_DATA;
        }
    }
}
