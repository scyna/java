package io.scyna;

import io.nats.client.JetStreamApiException;
import io.nats.client.Message;
import io.nats.client.PullSubscribeOptions;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.protobuf.Parser;

public class Scheduler {
    public static <T extends Message> void register(String channel, String receiver, Handler<T> handler)
            throws IOException, JetStreamApiException, TimeoutException, InterruptedException {

        var subject = Engine.module() + ".task." + channel;
        var durable = "task_" + channel + "_" + receiver;

        PullSubscribeOptions opt = PullSubscribeOptions.builder().durable(durable).build();

        var sub = Engine.stream().subscribe(subject, opt);
        Engine.connection().flush(Duration.ofSeconds(1));

        var runable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    var messages = sub.fetch(1, Duration.ofSeconds(1));
                    for (Message m : messages) {
                        handler.process(m);
                        m.ack();
                    }
                }
            }
        };

        Thread thread = new Thread(runable);
        thread.start();
    }

    public static abstract class Handler<T extends com.google.protobuf.Message> {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;

        public abstract void execute();

        public void init(Parser<T> parser, Trace trace) {
            this.parser = parser;
            this.trace = trace;
        }

        public void process(Message m) {
            /* TODO */
        }
    }
}
