// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: velo.proto

package io.scyna.proto;

public final class Velo {
  private Velo() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_Error_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_Error_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_Request_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_Request_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_Response_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_Response_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\nvelo.proto\022\rio.velo.proto\"&\n\005Error\022\014\n\004" +
      "Code\030\001 \001(\005\022\017\n\007Message\030\002 \001(\t\"C\n\007Request\022\016" +
      "\n\006CallID\030\001 \001(\004\022\014\n\004Body\030\002 \001(\014\022\014\n\004JSON\030\003 \001" +
      "(\010\022\014\n\004Data\030\004 \001(\t\"8\n\010Response\022\014\n\004Code\030\001 \001" +
      "(\005\022\014\n\004Body\030\002 \001(\014\022\020\n\010SesionID\030\003 \001(\004B\014H\002P\001" +
      "Z\006.;velob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_io_velo_proto_Error_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_velo_proto_Error_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_Error_descriptor,
        new java.lang.String[] { "Code", "Message", });
    internal_static_io_velo_proto_Request_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_io_velo_proto_Request_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_Request_descriptor,
        new java.lang.String[] { "CallID", "Body", "JSON", "Data", });
    internal_static_io_velo_proto_Response_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_io_velo_proto_Response_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_Response_descriptor,
        new java.lang.String[] { "Code", "Body", "SesionID", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}