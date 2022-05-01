package io.scyna;

import com.google.protobuf.Message;

public class Command {
    public static void send(String channel, Message data) {
        var nc = Engine.connection();
        nc.publish(channel, data.toByteArray());
    }

    public static void register(String channel, Handler handler) {
        System.out.println("Register Signal:" + channel);
        var nc = Engine.connection();
        var d = nc.createDispatcher((msg) -> {
            handler.execute(msg.getData());
        });
        d.subscribe(channel, Engine.module());
    }

    public interface Handler {
        void execute(byte[] data);
    }
}
