// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: error.proto

package io.scyna.proto;

public final class ErrorOuterClass {
  private ErrorOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_scyna_Error_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_scyna_Error_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013error.proto\022\005scyna\"&\n\005Error\022\014\n\004Code\030\001 " +
      "\001(\005\022\017\n\007Message\030\002 \001(\tB+\n\016io.scyna.protoH\002" +
      "P\001Z\007.;scyna\252\002\013scyna.protob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_scyna_Error_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_scyna_Error_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_scyna_Error_descriptor,
        new java.lang.String[] { "Code", "Message", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
