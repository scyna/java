package scyna;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import io.nats.client.JetStreamApiException;
import io.nats.client.PullSubscribeOptions;

public class Event {
    static Map<String, Stream> streams = new HashMap<String, Stream>();

    interface MessageHandler {
        void onMessage(io.nats.client.Message msg);
    }

    public static void startListening() throws Exception {
        for (var stream : streams.values()) {
            stream.start();
        }
    }

    public static class Stream {
        String sender;
        String receiver;
        Map<String, MessageHandler> executors;

        Stream(String sender, String receiver) {
            this.sender = sender;
            this.receiver = receiver;
            executors = new HashMap<String, MessageHandler>();
        }

        private static Stream createOrGet(String sender)
                throws TimeoutException, InterruptedException, IOException, JetStreamApiException {
            var stream = streams.get(sender);
            if (stream != null)
                return stream;

            stream = new Stream(sender, Engine.Module());
            streams.put(sender, stream);
            return stream;
        }

        void start() throws Exception {
            var opt = PullSubscribeOptions.builder()
                    .durable(receiver)
                    .stream(sender)
                    .build();

            var sub = Engine.Stream().subscribe(sender + ".>", opt);
            Engine.Connection().flush(Duration.ofSeconds(1));

            new Thread(() -> {
                while (true) {
                    var messages = sub.fetch(1, Duration.ofSeconds(1));
                    for (io.nats.client.Message m : messages) {
                        var executor = executors.get(m.getSubject());
                        if (executor != null) {
                            executor.onMessage(m);
                        }
                        m.ack();
                    }
                }
            }).start();
        }
    }

    public static <T extends Message> void Register(String sender, String channel, Handler<T> handler)
            throws Exception {
        System.out.println("Register Event:" + channel);

        var stream = Stream.createOrGet(sender);
        var subject = sender + "." + channel;
        var trace = Trace.Event(subject);
        handler.init(trace);
        stream.executors.put(subject, handler);
    }

    public static void addToStream(String sender, String channel, MessageHandler handler)
            throws Exception {
        var stream = Stream.createOrGet(sender);
        var subject = sender + "." + channel;
        stream.executors.put(subject, handler);
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context(0);
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;
        protected long entity;
        protected long version;

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
            messageReceived(msg.getData());
        }

        public void messageReceived(byte[] data) {
            try {
                var event = scyna.proto.Event.parseFrom(data);
                trace.reset(event.getTraceID());
                context.id = event.getTraceID();
                this.data = parser.parseFrom(event.getBody());
                this.execute();
                trace.record();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}