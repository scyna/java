package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;

import io.nats.client.MessageHandler;
import io.scyna.proto.EventOrSignal;

public abstract class SignalLite {
    public static void emit(String channel) {
        var msg = EventOrSignal.newBuilder().setCallID(Engine.ID().next()).build();
        var nc = Engine.connection();
        nc.publish(channel, msg.toByteArray());
    }

    public static void register(String channel, Handler handler) {
        System.out.println("Register Signal:" + channel);
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(channel, Engine.module());
    }

    public static abstract class Handler implements MessageHandler {
        protected Logger LOG = new Logger(0, false);

        public abstract void execute();

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = EventOrSignal.parseFrom(msg.getData());
                LOG.reset(request.getCallID());
                this.execute();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
