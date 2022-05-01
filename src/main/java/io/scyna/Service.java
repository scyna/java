package io.scyna;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;

import io.nats.client.MessageHandler;
import io.scyna.proto.Error;
import io.scyna.proto.Request;
import io.scyna.proto.Response;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class Service {

    public static <T extends Message> void register(String url, Handler<T> handler, Parser<T> parser,
            Message.Builder builder) {
        System.out.println("Register Service:" + url);
        handler.init(parser, builder);
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static Response sendRequest(String url, Message request) {
        try {
            var callID = Engine.ID().next();
            var req = Request.newBuilder().setCallID(callID).setJSON(false);

            if (request != null) {
                req.setBody(request.toByteString());
            }

            Future<io.nats.client.Message> incoming = Engine.connection().request(Utils.publishURL(url),
                    req.build().toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            return Response.parseFrom(msg.getData());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static class BaseHandler {

        protected Logger LOG = new Logger(0, false);
        protected boolean JSON;

        protected String source;
        protected String reply;

        protected void error(Error error) {
            flush(400, error);
        }

        protected void done(Message m) {
            flush(200, m);
        }

        protected void flush(int status, Message m) {
            try {
                byte[] body;
                if (JSON) {
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

    public static abstract class Handler<T extends Message> extends BaseHandler implements MessageHandler {
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
}
