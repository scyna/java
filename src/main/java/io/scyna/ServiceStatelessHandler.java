package io.scyna;

import io.nats.client.MessageHandler;
import io.scyna.proto.Request;

public abstract class ServiceStatelessHandler extends Service.BaseHandler implements MessageHandler {
    public abstract void execute();

    @Override
    public void onMessage(io.nats.client.Message msg) {
        try {
            var request = Request.parseFrom(msg.getData());
            LOG.reset(request.getCallID());
            reply = msg.getReplyTo();
            JSON = request.getJSON();
            source = request.getData();
            execute();
        } catch (Exception e) {
            flush(400, io.scyna.Error.BAD_REQUEST);
            e.printStackTrace();
        }
    }
}
