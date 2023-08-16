package scyna;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import io.nats.client.MessageHandler;
import scyna.proto.Request;
import scyna.proto.Response;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public abstract class Endpoint {

    public static <T extends Message> void register(String url, Handler<T> handler) throws java.lang.Exception {
        System.out.println("Register Service:" + url);
        handler.init();
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static class BaseHandler {
        protected Context context = new Context();
        protected boolean JSON;

        protected String source;
        protected String reply;
        protected boolean flushed = false;

        protected void response(Message m) {
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
                flushed = true;
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }

    public static abstract class Handler<T extends Message> extends BaseHandler implements MessageHandler {
        protected T request;
        protected Parser<T> parser;
        protected Message.Builder builder;

        protected abstract void execute() throws scyna.Error;

        @SuppressWarnings("unchecked")
        public void init() throws java.lang.Exception {
            try {
                Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
                Method m = cls.getMethod("newBuilder");
                builder = (Message.Builder) m.invoke(null);
                var tObj = builder.build();
                parser = (Parser<T>) tObj.getParserForType();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                throw new java.lang.Exception();
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = Request.parseFrom(msg.getData());
                context.id = request.getTraceID();
                reply = msg.getReplyTo();
                JSON = request.getJSON();
                flushed = false;
                var requestBody = request.getBody();
                source = request.getData();
                if (JSON) {
                    builder.clear();
                    JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                    this.request = (T) builder.build();
                    builder.clear();
                } else {
                    this.request = parser.parseFrom(requestBody);
                }
                this.execute();
                if (!flushed) {
                    flush(200, scyna.Error.OK.toProto());
                }
            } catch (scyna.Error e) {
                context.error(e.getMessage());
                flush(400, e.toProto());
            } catch (InvalidProtocolBufferException e) {
                flush(400, scyna.Error.BAD_REQUEST.toProto());
            }
        }
    }
}