// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package scyna.proto;

public interface EndpointDoneSignalOrBuilder extends
        // @@protoc_insertion_point(interface_extends:scyna.EndpointDoneSignal)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 TraceID = 1;</code>
     * 
     * @return The traceID.
     */
    long getTraceID();

    /**
     * <code>string Response = 2;</code>
     * 
     * @return The response.
     */
    java.lang.String getResponse();

    /**
     * <code>string Response = 2;</code>
     * 
     * @return The bytes for response.
     */
    com.google.protobuf.ByteString getResponseBytes();
}