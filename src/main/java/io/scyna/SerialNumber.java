package io.scyna;

import com.google.protobuf.InvalidProtocolBufferException;

import io.scyna.proto.GetSNRequest;
import io.scyna.proto.GetSNResponse;

public class SerialNumber {
    private final String key;
    private int prefix = 0;
    private long last = 0;
    private long next = 0;

    private SerialNumber(String key) {
        this.key = key;
    }

    public static SerialNumber create(String key) {
        return new SerialNumber(key);
    }

    public synchronized String next() throws io.scyna.Error {

        try {
            if (next < last) {
                next++;
            } else {
                var request = GetSNRequest.newBuilder().setKey(key).build();
                var response = Endpoint.sendRequest(Path.GEN_GET_SN_URL, request);
                if (response != null && response.getCode() == 200) {
                    var r = GetSNResponse.parseFrom(response.getBody());
                    prefix = r.getPrefix();
                    next = r.getStart();
                    last = r.getEnd();
                }
            }

        } catch (InvalidProtocolBufferException e) {
            throw Error.BAD_DATA;
        }

        return String.format("%d%07d", prefix, next);
    }
}
