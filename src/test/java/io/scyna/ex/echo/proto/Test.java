// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: test.proto

package io.scyna.ex.echo.proto;

public final class Test {
  private Test() {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  static final com.google.protobuf.Descriptors.Descriptor internal_static_io_velo_echo_proto_EchoRequest_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_velo_echo_proto_EchoRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor internal_static_io_velo_echo_proto_EchoResponse_descriptor;
  static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_velo_echo_proto_EchoResponse_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
    return descriptor;
  }

  private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
  static {
    java.lang.String[] descriptorData = {
        "\n\ntest.proto\022\022io.velo.echo.proto\"\033\n\013Echo" +
            "Request\022\014\n\004text\030\001 \001(\t\"\034\n\014EchoResponse\022\014\n" +
            "\004text\030\001 \001(\tB\002P\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
        .internalBuildGeneratedFileFrom(descriptorData,
            new com.google.protobuf.Descriptors.FileDescriptor[] {
            });
    internal_static_io_velo_echo_proto_EchoRequest_descriptor = getDescriptor().getMessageTypes().get(0);
    internal_static_io_velo_echo_proto_EchoRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_echo_proto_EchoRequest_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_io_velo_echo_proto_EchoResponse_descriptor = getDescriptor().getMessageTypes().get(1);
    internal_static_io_velo_echo_proto_EchoResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_echo_proto_EchoResponse_descriptor,
        new java.lang.String[] { "Text", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
