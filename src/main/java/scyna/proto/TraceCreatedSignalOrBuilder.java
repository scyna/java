// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package scyna.proto;

public interface TraceCreatedSignalOrBuilder extends
        // @@protoc_insertion_point(interface_extends:scyna.TraceCreatedSignal)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>uint64 ID = 1;</code>
     * 
     * @return The iD.
     */
    long getID();

    /**
     * <code>uint64 ParentID = 2;</code>
     * 
     * @return The parentID.
     */
    long getParentID();

    /**
     * <code>uint32 Type = 3;</code>
     * 
     * @return The type.
     */
    int getType();

    /**
     * <code>uint64 Time = 4;</code>
     * 
     * @return The time.
     */
    long getTime();

    /**
     * <code>uint64 Duration = 5;</code>
     * 
     * @return The duration.
     */
    long getDuration();

    /**
     * <code>string Path = 6;</code>
     * 
     * @return The path.
     */
    java.lang.String getPath();

    /**
     * <code>string Path = 6;</code>
     * 
     * @return The bytes for path.
     */
    com.google.protobuf.ByteString getPathBytes();

    /**
     * <code>string Source = 7;</code>
     * 
     * @return The source.
     */
    java.lang.String getSource();

    /**
     * <code>string Source = 7;</code>
     * 
     * @return The bytes for source.
     */
    com.google.protobuf.ByteString getSourceBytes();

    /**
     * <code>uint64 SessionID = 8;</code>
     * 
     * @return The sessionID.
     */
    long getSessionID();

    /**
     * <code>int32 Status = 9;</code>
     * 
     * @return The status.
     */
    int getStatus();
}
