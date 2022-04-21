package io.scyna;

import com.google.protobuf.Message;
import io.nats.client.JetStreamApiException;
import io.nats.client.MessageHandler;
import io.nats.client.PushSubscribeOptions;

import java.io.IOException;

public class Event {

    public static void post(String channel, Message data) {
        try {
            Engine.stream().publish(channel, data.toByteArray());
        } catch (IOException | JetStreamApiException e) {
            e.printStackTrace();
        }
    }

    public static void post(String channel) {
        try {
            Engine.stream().publish(channel, null);
        } catch (IOException | JetStreamApiException e) {
            e.printStackTrace();
        }
    }

    public static void register(String channel, String consumer, Handler handler)
            throws IOException, JetStreamApiException {
        System.out.println("Register Event:" + channel);
        var nc = Engine.connection();
        var js = Engine.stream();
        var d = nc.createDispatcher();

        MessageHandler h = (msg) -> {
            handler.execute(msg.getData());
        };

        PushSubscribeOptions so = PushSubscribeOptions.builder()
                .durable(consumer)
                .build();

        js.subscribe(channel, Engine.module(), d, h, true, so);
    }

    public interface Handler {
        void execute(byte[] data);
    }
}
