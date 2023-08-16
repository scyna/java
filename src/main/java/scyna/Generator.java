package scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import io.nats.client.Message;
import scyna.proto.GetIDResponse;
import scyna.proto.Request;
import scyna.proto.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Generator {
    private int prefix;
    private long value;
    private long end;

    public synchronized long next() {
        if (value < end) {
            value++;
        } else {
            if (!getID())
                System.exit(1);
        }
        return Utils.calculateID(prefix, value);
    }

    private boolean getID() {
        var nc = Engine.connection();
        var request = Request.newBuilder().setTraceID(0).setJSON(false).build();
        try {
            Future<Message> incoming = nc.request(Utils.publishURL(Path.GEN_GET_ID_URL), request.toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            var response = Response.parseFrom(msg.getData());
            if (response.getCode() != 200)
                return false;
            var id = GetIDResponse.parseFrom(response.getBody());
            this.prefix = id.getPrefix();
            this.value = id.getStart();
            this.end = id.getEnd();
            return true;
        } catch (InterruptedException | ExecutionException | TimeoutException | InvalidProtocolBufferException e) {
            e.printStackTrace();
            return false;
        }
    }
}
