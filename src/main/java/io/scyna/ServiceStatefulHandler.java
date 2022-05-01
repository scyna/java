package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import io.nats.client.MessageHandler;
import io.scyna.proto.Request;

public abstract class ServiceStatefulHandler<T extends Message> extends Service.BaseHandler implements MessageHandler {
    protected T request;
    protected Parser<T> parser;
    protected Message.Builder builder;

    public void init(Parser<T> parser, Message.Builder builder) {
        this.parser = parser;
        this.builder = builder;
    }

    public abstract void execute();

    @Override
    public void onMessage(io.nats.client.Message msg) {
        try {
            var request = Request.parseFrom(msg.getData());
            LOG.reset(request.getCallID());
            reply = msg.getReplyTo();
            JSON = request.getJSON();
            var requestBody = request.getBody();
            source = request.getData();
            if (JSON) {
                JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                this.request = (T) builder.build();
                builder.clear();
                this.execute();

            } else {
                this.request = parser.parseFrom(requestBody);
                this.execute();
            }
        } catch (InvalidProtocolBufferException e) {
            flush(400, io.scyna.Error.BAD_REQUEST);
            e.printStackTrace();
        }
    }
}
