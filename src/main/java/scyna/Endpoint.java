package scyna;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import io.nats.client.MessageHandler;
import scyna.proto.EndpointDoneSignal;
import scyna.proto.Request;
import scyna.proto.Response;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

public abstract class Endpoint {

    public static <T extends Message> void Register(String url, Handler<T> handler) throws java.lang.Exception {
        System.out.println("Register Service:" + url);
        handler.init();
        var nc = Engine.Connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context;
        protected boolean JSON;

        protected String reply;
        protected boolean flushed = false;

        protected T request;
        protected Parser<T> parser;
        protected Message.Builder builder;
        private String requestBody = "";

        protected abstract void execute() throws scyna.Error;

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
                        .setBody(ByteString.copyFrom(body)).build();
                Engine.Connection().publish(reply, response.toByteArray());
                flushed = true;
                finish(response, response.getCode());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

        private void finish(Message response, int status) {
            if (context.id == 0) {
                return;
            }

            try {
                Signal.emit(scyna.Path.ENDPOINT_DONE_CHANNEL, EndpointDoneSignal.newBuilder()
                        .setTraceID(context.id)
                        .setResponse(JsonFormat.printer().print(response))
                        .setRequest(requestBody)
                        .setStatus(status)
                        .setSessionID(Engine.Session().ID())
                        .build());
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }

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
                throw e;
            }
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = Request.parseFrom(msg.getData());
                context = new Context(request.getTraceID());
                reply = msg.getReplyTo();
                JSON = request.getJSON();
                flushed = false;
                var requestBody = request.getBody();

                if (JSON) {
                    this.requestBody = requestBody.toStringUtf8();
                    builder.clear();
                    JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                    this.request = (T) builder.build();
                    builder.clear();
                } else {
                    this.request = parser.parseFrom(requestBody);
                    this.requestBody = JsonFormat.printer().print(this.request);
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
