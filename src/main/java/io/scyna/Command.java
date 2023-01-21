package io.scyna;

import io.nats.client.MessageHandler;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

public abstract class Command {

    public static void register(String url, Handler handler) {
        System.out.println("Register Service:" + url);
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static Response send(String url) {
        return Endpoint.sendRequest(url, null);
    }

    public static abstract class Handler extends Endpoint.BaseHandler implements MessageHandler {
        public abstract void execute();

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = Request.parseFrom(msg.getData());
                context.reset(request.getTraceID());
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
}
