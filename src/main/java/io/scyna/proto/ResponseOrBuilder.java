// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: velo.proto

package io.scyna.proto;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.velo.proto.Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 Code = 1;</code>
   * @return The code.
   */
  int getCode();

  /**
   * <code>bytes Body = 2;</code>
   * @return The body.
   */
  com.google.protobuf.ByteString getBody();

  /**
   * <code>uint64 SesionID = 3;</code>
   * @return The sesionID.
   */
  long getSesionID();
}
