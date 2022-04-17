package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;
import io.nats.client.Message;
import io.scyna.proto.GetIDResponse;
import io.scyna.proto.GetSNRequest;
import io.scyna.proto.GetSNResponse;
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

    public static class SerialNumber
    {
        private final String key;
        private int prefix = 0;
        private long last = 0;
        private long next = 0;
    
        public SerialNumber(String key) {
            this.key = key;
        }
    
        public synchronized String next() throws InvalidProtocolBufferException {
            if (next < last) {
                next++;
            } else {
                var request = GetSNRequest.newBuilder().setKey(key).build();
                var response = Service.sendRequest("/velo/generator/sn", request);
                if (response != null && response.getCode() == 200) {
                    var r = GetSNResponse.parseFrom(response.getBody());
                    prefix = r.getPrefix();
                    next = r.getStart();
                    last = r.getEnd();
                }
            }
            return String.format("%d%07d", prefix, next);
        }
    
    }

    public synchronized long next() {
        if (value < end){
            value++;
        } else {
            if (!getID()) System.exit(1);
        }
        return Utils.calculateGID(prefix, value);
    }

    private boolean getID() {
        var nc = Engine.connection();
        var request = Request.newBuilder().setCallID(0).setJSON(false).build();
        try {
            Future<Message> incoming = nc.request(Utils.publishURL("/velo/generator/id"), request.toByteArray());
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
