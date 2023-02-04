package io.scyna;

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

            stream = new Stream(sender, Engine.module());
            streams.put(sender, stream);
            return stream;
        }

        void start() throws Exception {
            var opt = PullSubscribeOptions.builder()
                    .durable(receiver)
                    .stream(sender)
                    .build();

            var sub = Engine.stream().subscribe(sender + ".>", opt);
            Engine.connection().flush(Duration.ofSeconds(1));

            var runable = new Runnable() {
                @Override
                public void run() {
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
                }
            };

            Thread thread = new Thread(runable);
            thread.start();
        }
    }

    public static <T extends Message> void register(String sender, String channel, Handler<T> handler)
            throws Exception {
        System.out.println("Register Event:" + channel);

        var stream = Stream.createOrGet(sender);
        var subject = sender + "." + channel;
        var trace = Trace.newEventTrace(subject);
        handler.init(trace);
        stream.executors.put(subject, handler);
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;

        public abstract void execute();

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
                var event = io.scyna.proto.Event.parseFrom(msg.getData());
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