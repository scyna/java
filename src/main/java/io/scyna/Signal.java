package io.scyna;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;

import io.nats.client.MessageHandler;
import io.scyna.proto.EventOrSignal;

public class Signal {
    public static <T extends Message> void register(String channel, Handler<T> handler) throws Exception {
        System.out.println("Register Signal:" + channel);
        var trace = Trace.newSignalTrace(channel);
        handler.init(trace);
        var nc = Engine.connection();
        var d = nc.createDispatcher(handler);
        d.subscribe(channel, Engine.module());
    }

    public static abstract class Handler<T extends Message> implements MessageHandler {
        protected Context context = new Context();
        protected Parser<T> parser;
        protected T data;
        protected Trace trace;

        public abstract void execute();

        public void init(Trace trace) throws Exception {
            try {
                Class<T> cls = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
                Method m = cls.getMethod("parser");
                this.parser = (Parser<T>) m.invoke(null);
                this.trace = trace;
            } catch (Exception e) {
                e.printStackTrace();
                throw new Exception();
            }

        }

        @Override
        public void onMessage(io.nats.client.Message msg) {
            try {
                var request = EventOrSignal.parseFrom(msg.getData());
                trace.update(request.getParentID());
                context.reset(trace.ID());
                var requestBody = request.getBody();
                this.data = parser.parseFrom(requestBody);
                this.execute();
                trace.record();
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        }
    }
}
