package io.scyna;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;

import io.nats.client.MessageHandler;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

public abstract class ServiceHandler<T extends Message> implements MessageHandler {
    protected Logger LOG = new Logger(0, false);
    protected boolean json;
    protected String source;
    protected String reply;

    protected Parser<T> parser;
    protected Message.Builder builder;

    public void init(Parser<T> parser, Message.Builder builder) {
        this.parser = parser;
        this.builder = builder;
    }

    public abstract void execute(T request);

    @Override
    public void onMessage(io.nats.client.Message msg) {
        try {
            var request = Request.parseFrom(msg.getData());
            LOG.reset(request.getCallID(), !request.getLogDisable()); // TODO: verify
            reply = msg.getReplyTo();
            json = request.getJSON();
            var requestBody = request.getBody();
            source = request.getData();
            if (json) {
                JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                this.execute((T) builder.build());
            } else
                this.execute((T) parser.parseFrom(requestBody));
        } catch (InvalidProtocolBufferException e) {
            flush(400, io.scyna.Error.BAD_REQUEST);
            e.printStackTrace();
        }
    }

    protected void error(io.scyna.proto.Error error) {
        flush(400, error);
    }

    protected void done(Message m) {
        flush(200, m);
    }

    protected void flush(int status, Message m) {
        try {
            byte[] body;
            if (json) {
                body = com.google.protobuf.util.JsonFormat.printer().print(m).getBytes();
            } else {
                body = m.toByteArray();
            }

            var response = Response.newBuilder()
                    .setCode(status)
                    .setSessionID(Engine.session().ID())
                    .setBody(ByteString.copyFrom(body)).build();
            Engine.connection().publish(reply, response.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }
}
