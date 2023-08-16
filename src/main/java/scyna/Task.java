package scyna;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import scyna.Event.MessageHandler;

public class Task {

    public static <T extends Message> void register(String sender, String channel, Handler<T> handler)
            throws Exception {
        System.out.println("Register Task:" + channel);
        var subject = sender + "." + channel;
        var trace = Trace.newEventTrace(subject);
        handler.init(trace);
        Event.addToStream(sender, channel, handler);
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;

        public abstract void execute();

        @SuppressWarnings("unchecked")
        public void init(Trace trace) throws Exception {
            Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                    .getActualTypeArguments()[0];
            Method m = cls.getMethod("parser");
            this.parser = (Parser<T>) m.invoke(null);
            this.trace = trace;
        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var event = scyna.proto.Task.parseFrom(msg.getData());
                trace.reset(event.getTraceID());
                context.id = event.getTraceID();
                this.data = parser.parseFrom(event.getData());
                this.execute();
                trace.record();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}