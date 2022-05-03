package io.scyna;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import io.nats.client.MessageHandler;
import io.scyna.proto.EventOrSignal;

public class Signal {
    public static <T extends Message> void emit(String channel, T data) {
        var msg = EventOrSignal.newBuilder().setCallID(Engine.ID().next()).setBody(data.toByteString()).build();
        var nc = Engine.connection();
        nc.publish(channel, msg.toByteArray());
    }

    public static <T extends Message> void register(String channel, Handler<T> handler) throws Exception {
        System.out.println("Register Signal:" + channel);
        handler.init();
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(channel, Engine.module());
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Logger LOG = new Logger(0, false);
        protected Parser<T> parser;
        protected T data;

        public abstract void execute();

        public void init() throws Exception {
            try {
                Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
                Method m = cls.getMethod("parser");
                this.parser = (Parser<T>) m.invoke(null);

            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception();
            }

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
}
