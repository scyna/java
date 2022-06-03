package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import io.nats.client.MessageHandler;
import io.nats.client.PushSubscribeOptions;
import io.scyna.proto.EventOrSignal;

public class Event {

    public static <T extends Message> void register(String channel, String consumer, Handler<T> handler,
            Parser<T> parser) {
        System.out.println("Register Event:" + channel);
        try {
            handler.init(parser);
            var nc = Engine.connection();
            var js = Engine.stream();
            var d = nc.createDispatcher();

            PushSubscribeOptions so = PushSubscribeOptions.builder()
                    .durable(consumer)
                    .build();

            js.subscribe(channel, Engine.module(), d, handler, true, so);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;

        public abstract void execute();

        public void init(Parser<T> parser) {
            this.parser = parser;
        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = EventOrSignal.parseFrom(msg.getData());
                context.reset(request.getParentID());
                var requestBody = request.getBody();
                this.data = parser.parseFrom(requestBody);
                this.execute();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
