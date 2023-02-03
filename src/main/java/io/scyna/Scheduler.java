package io.scyna;

import io.nats.client.Message;
import io.nats.client.PullSubscribeOptions;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.time.Duration;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;

public class Scheduler {
    public static <T extends com.google.protobuf.Message> void register(String channel, String receiver,
            Handler<T> handler) throws Exception {

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
        var trace = Trace.newTaskTrace(subject);
        handler.init(trace);
        thread.start();
    }

    public static abstract class Handler<T extends com.google.protobuf.Message> {
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

        public void process(Message m) {
            try {
                trace.reset(Engine.ID().next());
                context.id = trace.ID();
                this.data = parser.parseFrom(m.getData());
                this.execute();
                trace.record();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
