package scyna;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import io.nats.client.MessageHandler;

public class Signal {
    public static <T extends Message> void emit(String channel, T data) {
        var nc = Engine.connection();
        nc.publish(channel, data.toByteArray());
    }

    public static <T extends Message> void register(String channel, Handler<T> handler) throws java.lang.Exception {
        System.out.println("Register Signal:" + channel);
        handler.init();
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(channel, Engine.module());
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Parser<T> parser;
        protected T data;

        public abstract void execute();

        @SuppressWarnings("unchecked")
        public void init() throws java.lang.Exception {
            try {
                Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
                Method m = cls.getMethod("parser");
                this.parser = (Parser<T>) m.invoke(null);

            } catch (java.lang.Exception e) {
                e.printStackTrace();
                throw new java.lang.Exception();
            }
        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                this.data = parser.parseFrom(msg.getData());
                this.execute();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
