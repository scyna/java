// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

public interface EndSessionSignalOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scyna.EndSessionSignal)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 ID = 1;</code>
   * @return The iD.
   */
  long getID();

  /**
   * <code>string Code = 2;</code>
   * @return The code.
   */
  java.lang.String getCode();
  /**
   * <code>string Code = 2;</code>
   * @return The bytes for code.
   */
  com.google.protobuf.ByteString
      getCodeBytes();

  /**
   * <code>string Module = 3;</code>
   * @return The module.
   */
  java.lang.String getModule();
  /**
   * <code>string Module = 3;</code>
   * @return The bytes for module.
   */
  com.google.protobuf.ByteString
      getModuleBytes();
}
