// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

public interface CreateAuthResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.scyna.proto.CreateAuthResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string Token = 1;</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <code>string Token = 1;</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();

  /**
   * <code>uint64 Expired = 2;</code>
   * @return The expired.
   */
  long getExpired();
}
