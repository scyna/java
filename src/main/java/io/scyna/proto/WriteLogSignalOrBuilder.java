// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

public interface WriteLogSignalOrBuilder extends
    // @@protoc_insertion_point(interface_extends:scyna.WriteLogSignal)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>uint64 time = 1;</code>
   * @return The time.
   */
  long getTime();

  /**
   * <code>uint32 level = 2;</code>
   * @return The level.
   */
  int getLevel();

  /**
   * <code>string text = 3;</code>
   * @return The text.
   */
  java.lang.String getText();
  /**
   * <code>string text = 3;</code>
   * @return The bytes for text.
   */
  com.google.protobuf.ByteString
      getTextBytes();

  /**
   * <code>uint64 id = 4;</code>
   * @return The id.
   */
  long getId();

  /**
   * <code>uint64 seq = 5;</code>
   * @return The seq.
   */
  long getSeq();

  /**
   * <code>bool session = 6;</code>
   * @return The session.
   */
  boolean getSession();
}