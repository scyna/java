// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scyna.proto

package scyna.proto;

public interface RequestOrBuilder extends
        // @@protoc_insertion_point(interface_extends:scyna.Request)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 TraceID = 1;</code>
     * 
     * @return The traceID.
     */
    long getTraceID();

    /**
     * <code>bytes Body = 2;</code>
     * 
     * @return The body.
     */
    com.google.protobuf.ByteString getBody();

    /**
     * <code>string Data = 4;</code>
     * 
     * @return The data.
     */
    java.lang.String getData();

    /**
     * <code>string Data = 4;</code>
     * 
     * @return The bytes for data.
     */
    com.google.protobuf.ByteString getDataBytes();

    /**
     * <code>bool JSON = 3;</code>
     * 
     * @return The jSON.
     */
    boolean getJSON();
}