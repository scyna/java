// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: account.proto

package io.scyna.ex.account.proto;

public interface ChangePasswordRequestOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.scyna.customer.proto.ChangePasswordRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string current = 2;</code>
   * @return The current.
   */
  java.lang.String getCurrent();
  /**
   * <code>string current = 2;</code>
   * @return The bytes for current.
   */
  com.google.protobuf.ByteString
      getCurrentBytes();

  /**
   * <code>string future = 3;</code>
   * @return The future.
   */
  java.lang.String getFuture();
  /**
   * <code>string future = 3;</code>
   * @return The bytes for future.
   */
  com.google.protobuf.ByteString
      getFutureBytes();
}
