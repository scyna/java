package io.scyna;

import io.nats.client.JetStreamApiException;
import io.nats.client.Message;
import io.nats.client.PullSubscribeOptions;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Sync {
    public static void register(String channel, String receiver, Handler handler)
            throws IOException, JetStreamApiException, TimeoutException, InterruptedException {

        var subject = Engine.module() + ".sync." + channel;
        var durable = "sync_" + channel + "_" + receiver;

        PullSubscribeOptions opt = PullSubscribeOptions.builder().durable(durable).build();

        var sub = Engine.stream().subscribe(subject, opt);
        Engine.connection().flush(Duration.ofSeconds(1));

        while (true) {
            var messages = sub.fetch(1, Duration.ofSeconds(1));
            for (Message m : messages) {
                var request = handler.execute(m.getData());
                if (sendRequest(request)) {
                    m.ack();
                } else {
                    Boolean ok = false;
                    for (int i = 0; i < 3; i++) {
                        request = handler.execute(m.getData());
                        if (sendRequest(request)) {
                            m.ack();
                            ok = true;
                            break;
                        }
                        TimeUnit.SECONDS.sleep(30);
                    }

                    if (!ok) {
                        m.nak();
                    }
                }
                m.ack();
            }
        }
    }

    private static boolean sendRequest(HttpRequest request) {
        if (request == null)
            return true;

        try {
            var response = HttpClient.newBuilder().build().send(request, BodyHandlers.ofByteArray());
            if (response.statusCode() == 500)
                return false;
        } catch (IOException | InterruptedException e) {
            Engine.LOG().error(e.getMessage());
            return false;
        }
        Engine.LOG().debug("Sent to: " + request.uri().toString() + " - " + request.method());
        return true;
    }

    public interface Handler {
        HttpRequest execute(byte[] data);
    }
}
