package io.scyna;

import io.nats.client.JetStreamApiException;
import io.nats.client.MessageHandler;
import io.nats.client.PushSubscribeOptions;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.concurrent.TimeUnit;

public class Sync {
    public static void register(String channel, String consumer, String group, Handler handler)
            throws IOException, JetStreamApiException {
        var js = Engine.stream();
        var dispatcher = Engine.connection().createDispatcher();

        MessageHandler h = (msg) -> {
            var request = handler.execute(msg.getData());
            if (sendRequest(request)) {
                msg.ack();
            } else {
                for (int i = 0; i < 3; i++) {
                    request = handler.execute(msg.getData());
                    if (sendRequest(request)) {
                        msg.ack();
                        return;
                    }
                    TimeUnit.SECONDS.sleep(30);
                }
                TimeUnit.MINUTES.sleep(10);
                msg.nak();
            }
        };

        PushSubscribeOptions so = PushSubscribeOptions.builder()
                .durable(consumer)
                .build();

        js.subscribe(channel, group, dispatcher, h, false, so);
    }

    private static boolean sendRequest(HttpRequest request) {
        if (request == null)
            return true;

        try {
            var response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofByteArray());
            if (response.statusCode() == 500)
                return false;
        } catch (IOException | InterruptedException e) {
            Engine.log().error(e.getMessage());
            return false;
        }
        Engine.log().debug("Sent to: " + request.uri().toString() + " - " + request.method());
        return true;
    }

    public interface Handler {
        HttpRequest execute(byte[] data);
    }
}
