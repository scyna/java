// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: task.proto

package scyna.proto;

public interface StartTaskRequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:scyna.StartTaskRequest)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string Module = 1;</code>
     * 
     * @return The module.
     */
    java.lang.String getModule();

    /**
     * <code>string Module = 1;</code>
     * 
     * @return The bytes for module.
     */
    com.google.protobuf.ByteString getModuleBytes();

    /**
     * <code>string Topic = 2;</code>
     * 
     * @return The topic.
     */
    java.lang.String getTopic();

    /**
     * <code>string Topic = 2;</code>
     * 
     * @return The bytes for topic.
     */
    com.google.protobuf.ByteString getTopicBytes();

    /**
     * <code>bytes Data = 3;</code>
     * 
     * @return The data.
     */
    com.google.protobuf.ByteString getData();

    /**
     * <pre>
     * Unit: second
     * </pre>
     *
     * <code>int64 Time = 4;</code>
     * 
     * @return The time.
     */
    long getTime();

    /**
     * <pre>
     * In second, must be greater than 60
     * </pre>
     *
     * <code>int64 Interval = 5;</code>
     * 
     * @return The interval.
     */
    long getInterval();

    /**
     * <code>uint64 Loop = 6;</code>
     * 
     * @return The loop.
     */
    long getLoop();
}
