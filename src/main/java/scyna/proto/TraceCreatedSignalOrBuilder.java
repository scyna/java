// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trace.proto

package scyna.proto;

public interface TraceCreatedSignalOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scyna.TraceCreatedSignal)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 ID = 1;</code>
   */
  long getID();

  /**
   * <code>uint64 ParentID = 2;</code>
   */
  long getParentID();

  /**
   * <code>uint32 Type = 3;</code>
   */
  int getType();

  /**
   * <code>uint64 Time = 4;</code>
   */
  long getTime();

  /**
   * <code>uint64 Duration = 5;</code>
   */
  long getDuration();

  /**
   * <code>string Path = 6;</code>
   */
  java.lang.String getPath();
  /**
   * <code>string Path = 6;</code>
   */
  com.google.protobuf.ByteString
      getPathBytes();

  /**
   * <code>uint64 SessionID = 8;</code>
   */
  long getSessionID();

  /**
   * <code>uint32 Status = 9;</code>
   */
  int getStatus();
}
