package scyna.eventstore;

import java.nio.ByteBuffer;

import com.google.protobuf.Message;

public interface IProjection {
    void init() throws Exception;

    void update(ByteBuffer event, ByteBuffer data);

    String getType();

    Message parseEvent(ByteBuffer data);
}
