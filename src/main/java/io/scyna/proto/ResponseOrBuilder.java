// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: scyna.proto

package io.scyna.proto;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scyna.Response)
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
   * <code>uint64 SessionID = 3;</code>
   * @return The sessionID.
   */
  long getSessionID();

  /**
   * <code>string Token = 4;</code>
   * @return The token.
   */
  java.lang.String getToken();
  /**
   * <code>string Token = 4;</code>
   * @return The bytes for token.
   */
  com.google.protobuf.ByteString
      getTokenBytes();

  /**
   * <code>uint64 Expired = 5;</code>
   * @return The expired.
   */
  long getExpired();
}
