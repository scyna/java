package io.scyna;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.util.JsonFormat;
import io.nats.client.MessageHandler;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public abstract class Service implements MessageHandler {
    protected Logger log = new Logger(0, false);
    protected boolean json;
    protected ByteString requestBody;
    protected String requestSource;
    protected String reply;

    public static void register(String url, Service service) {
        System.out.println("Register Service:" + url);
        var nc = Engine.connection();
        var d = nc.createDispatcher(service);
        d.subscribe(Utils.subscribeURL(url), "API");
    }

    public static Response sendRequest(String url, Message request) {
        var callID = Engine.ID().next();
        var req = Request.newBuilder().setCallID(callID).setJSON(false);
        if (request != null)
            req.setBody(request.toByteString());
        Future<io.nats.client.Message> incoming = Engine.connection().request(Utils.publishURL(url),
                req.build().toByteArray());
        try {
            var msg = incoming.get(5, TimeUnit.SECONDS);
            return Response.parseFrom(msg.getData());
        } catch (InterruptedException | ExecutionException | TimeoutException | InvalidProtocolBufferException e) {
            e.printStackTrace();
            return null;
        }
    }

    public abstract void execute();

    public void onMessage(io.nats.client.Message msg) throws InterruptedException {
        try {
            var request = Request.parseFrom(msg.getData());
            log.reset(request.getCallID(), !request.getLogDisable()); // TODO: verify
            reply = msg.getReplyTo();
            json = request.getJSON();
            requestBody = request.getBody();
            requestSource = request.getData();
            this.execute();
        } catch (InvalidProtocolBufferException e) {
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
            if (json)
                body = JsonFormat.printer().print(m).getBytes();
            else
                body = m.toByteArray();

            var response = Response.newBuilder()
                    .setCode(status)
                    .setSessionID(Engine.session()
                            .ID())
                    .setBody(ByteString.copyFrom(body)).build();
            Engine.connection().publish(reply, response.toByteArray());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
    }

    static public abstract class Base<T extends Message> extends Service {
        protected Message parse(Parser<T> parser, Message.Builder builder) {
            try {
                if (json) {
                    JsonFormat.parser().merge(requestBody.toStringUtf8(), builder);
                    return builder.build();
                } else
                    return parser.parseFrom(requestBody);

            } catch (InvalidProtocolBufferException e) {
                flush(400, io.scyna.Error.BAD_REQUEST);
                return null;
            }
        }
    }
}
