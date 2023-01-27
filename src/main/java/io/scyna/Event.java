package io.scyna;

import java.io.IOException;
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

    public static class Stream {
        String sender;
        String receiver;
        Map<String, MessageHandler> executors;

        Stream(String sender, String receiver) {
            this.sender = sender;
            this.receiver = receiver;
            executors = new HashMap<String, MessageHandler>();
        }

        public static Stream createOrGet(String sender)
                throws TimeoutException, InterruptedException, IOException, JetStreamApiException {
            var stream = streams.get(sender);
            if (stream != null)
                return stream;

            stream = new Stream(sender, Engine.module());
            streams.put(sender, stream);
            stream.start();
            return stream;
        }

        void start() throws TimeoutException, InterruptedException, IOException, JetStreamApiException {
            var opt = PullSubscribeOptions.builder().durable(receiver).stream(sender).build();

            var sub = Engine.stream().subscribe("", opt);
            Engine.connection().flush(Duration.ofSeconds(1));

            var runable = new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        var messages = sub.fetch(1, Duration.ofSeconds(1));
                        for (io.nats.client.Message m : messages) {
                            var executor = executors.get(m.getSubject());
                            if (executor != null) {
                                /* TODO: event stream */
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

    public static <T extends Message> void register(String sender, String channel, Handler<T> handler,
            Parser<T> parser) throws TimeoutException, InterruptedException, IOException, JetStreamApiException {
        System.out.println("Register Event:" + channel);

        var stream = Stream.createOrGet(sender);
        var subject = sender + "." + channel;
        var trace = Trace.newEventTrace(subject);
        handler.init(parser, trace);
        stream.executors.put(subject, handler);
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;

        public abstract void execute();

        public void init(Parser<T> parser, Trace trace) {
            this.parser = parser;
            this.trace = trace;
        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            // try {
            // var request = EventOrSignal.parseFrom(msg.getData());
            // trace.reset(request.getParentID());
            // context.reset(request.getParentID());
            // var requestBody = request.getBody();
            // this.data = parser.parseFrom(requestBody);
            // this.execute();
            // trace.record();
            // } catch (InvalidProtocolBufferException e) {
            // e.printStackTrace();
            // }
        }
    }
}