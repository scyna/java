// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

public interface CreateSessionRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scyna.CreateSessionRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string Module = 1;</code>
   * @return The module.
   */
  java.lang.String getModule();
  /**
   * <code>string Module = 1;</code>
   * @return The bytes for module.
   */
  com.google.protobuf.ByteString
      getModuleBytes();

  /**
   * <code>string Secret = 2;</code>
   * @return The secret.
   */
  java.lang.String getSecret();
  /**
   * <code>string Secret = 2;</code>
   * @return The bytes for secret.
   */
  com.google.protobuf.ByteString
      getSecretBytes();
}