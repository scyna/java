package scyna.eventstore;

import java.nio.ByteBuffer;

import com.google.protobuf.Message;

public interface IProjection {
    void Update(ByteBuffer event, ByteBuffer data);

    boolean Matched(String type);

    String Type();

    Message ParseEvent(byte[] data);
}
