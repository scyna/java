// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: account.proto

package io.scyna.ex.account.proto;

public interface GetAccountResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:io.scyna.customer.proto.GetAccountResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 id = 1;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>string email = 2;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>string email = 2;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>string name = 3;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>string name = 3;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();
}
