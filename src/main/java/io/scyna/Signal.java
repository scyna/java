package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import io.nats.client.MessageHandler;
import io.scyna.proto.EventOrSignal;

public class Signal {
    /* stateful */
    public static <T extends Message> void emit(String channel, T data) {
        var msg = EventOrSignal.newBuilder().setCallID(Engine.ID().next()).setBody(data.toByteString()).build();
        var nc = Engine.connection();
        nc.publish(channel, msg.toByteArray());
    }

    public static <T extends Message> void register(String channel, Handler<T> handler, Parser<T> parser) {
        System.out.println("Register Signal StatefulHandler:" + channel);
        handler.init(parser);
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(channel, Engine.module());
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Logger LOG = new Logger(0, false);
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
                LOG.reset(request.getCallID());
                var requestBody = request.getBody();
                this.data = parser.parseFrom(requestBody);
                this.execute();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }

    /* Command (aka old Signal) */
    public static void sendCommand(String channel, Message data) {
        var nc = Engine.connection();
        nc.publish(channel, data.toByteArray());
    }

    public static void register(String channel, Command handler) {
        System.out.println("Register Signal:" + channel);
        var nc = Engine.connection();
        var d = nc.createDispatcher((msg) -> {
            handler.execute(msg.getData());
        });
        d.subscribe(channel, Engine.module());
    }

    public interface Command {
        void execute(byte[] data);
    }
}
