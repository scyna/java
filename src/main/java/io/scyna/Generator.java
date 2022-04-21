package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import io.nats.client.Message;
import io.scyna.proto.GetIDResponse;
import io.scyna.proto.Request;
import io.scyna.proto.Response;

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
        return Utils.calculateGID(prefix, value);
    }

    private boolean getID() {
        var nc = Engine.connection();
        var request = Request.newBuilder().setCallID(0).setJSON(false).build();
        try {
            Future<Message> incoming = nc.request(Utils.publishURL(Path.GEN_GET_ID_URL), request.toByteArray());
            var msg = incoming.get(5, TimeUnit.SECONDS);
            var response = Response.parseFrom(msg.getData());
            if (response.getCode() != 200)
                return false;
            var gid = GetIDResponse.parseFrom(response.getBody());
            this.prefix = gid.getPrefix();
            this.value = gid.getStart();
            this.end = gid.getEnd();
            return true;
        } catch (InterruptedException | ExecutionException | TimeoutException | InvalidProtocolBufferException e) {
            e.printStackTrace();
            return false;
        }
    }
}
