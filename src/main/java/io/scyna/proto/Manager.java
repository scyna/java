// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: manager.proto

package io.scyna.proto;

public final class Manager {
  private Manager() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_Configuration_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_Configuration_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_AuthenticationRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_AuthenticationRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_AuthenticationResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_AuthenticationResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_EndSessionSignal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_EndSessionSignal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_UpdateSessionSignal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_UpdateSessionSignal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_GetIDResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_GetIDResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_GetSNRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_GetSNRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_GetSNResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_GetSNResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_WriteLogSignal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_WriteLogSignal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_Setting_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_Setting_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_WriteSettingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_WriteSettingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_ReadSettingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_ReadSettingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_ReadSettingResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_ReadSettingResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_SettingUpdatedSignal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_SettingUpdatedSignal_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_RemoveSettingRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_RemoveSettingRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_io_velo_proto_WriteCallSignal_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_io_velo_proto_WriteCallSignal_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rmanager.proto\022\rio.velo.proto\"\230\001\n\rConfi" +
      "guration\022\017\n\007NatsUrl\030\001 \001(\t\022\024\n\014NatsUsernam" +
      "e\030\002 \001(\t\022\024\n\014NatsPassword\030\003 \001(\t\022\016\n\006DBHost\030" +
      "\004 \001(\t\022\022\n\nDBUsername\030\005 \001(\t\022\022\n\nDBPassword\030" +
      "\006 \001(\t\022\022\n\nDBLocation\030\007 \001(\t\"7\n\025Authenticat" +
      "ionRequest\022\016\n\006Module\030\001 \001(\t\022\016\n\006Secret\030\002 \001" +
      "(\t\"Y\n\026AuthenticationResponse\022\021\n\tSessionI" +
      "D\030\001 \001(\004\022,\n\006Config\030\005 \001(\0132\034.io.velo.proto." +
      "Configuration\",\n\020EndSessionSignal\022\n\n\002ID\030" +
      "\001 \001(\004\022\014\n\004Code\030\002 \001(\r\"!\n\023UpdateSessionSign" +
      "al\022\n\n\002ID\030\001 \001(\004\";\n\rGetIDResponse\022\016\n\006prefi" +
      "x\030\001 \001(\r\022\r\n\005start\030\002 \001(\004\022\013\n\003end\030\003 \001(\004\"\033\n\014G" +
      "etSNRequest\022\013\n\003key\030\001 \001(\t\";\n\rGetSNRespons" +
      "e\022\016\n\006prefix\030\001 \001(\r\022\r\n\005start\030\002 \001(\004\022\013\n\003end\030" +
      "\003 \001(\004\"e\n\016WriteLogSignal\022\014\n\004time\030\001 \001(\004\022\r\n" +
      "\005level\030\002 \001(\r\022\014\n\004text\030\003 \001(\t\022\n\n\002id\030\004 \001(\004\022\013" +
      "\n\003seq\030\005 \001(\004\022\017\n\007session\030\006 \001(\010\"%\n\007Setting\022" +
      "\013\n\003Key\030\001 \001(\t\022\r\n\005Value\030\002 \001(\t\"A\n\023WriteSett" +
      "ingRequest\022\016\n\006Module\030\001 \001(\t\022\013\n\003Key\030\002 \001(\t\022" +
      "\r\n\005Value\030\003 \001(\t\"1\n\022ReadSettingRequest\022\016\n\006" +
      "Module\030\001 \001(\t\022\013\n\003Key\030\002 \001(\t\"$\n\023ReadSetting" +
      "Response\022\r\n\005Value\030\001 \001(\t\"B\n\024SettingUpdate" +
      "dSignal\022\016\n\006Module\030\001 \001(\t\022\013\n\003Key\030\002 \001(\t\022\r\n\005" +
      "Value\030\003 \001(\t\"3\n\024RemoveSettingRequest\022\016\n\006M" +
      "odule\030\001 \001(\t\022\013\n\003Key\030\002 \001(\t\"\264\001\n\017WriteCallSi" +
      "gnal\022\n\n\002id\030\001 \001(\004\022\016\n\006source\030\002 \001(\t\022\021\n\tcall" +
      "er_id\030\003 \001(\t\022\022\n\nsession_id\030\004 \001(\004\022\020\n\010durat" +
      "ion\030\005 \001(\r\022\017\n\007request\030\006 \001(\014\022\020\n\010response\030\007" +
      " \001(\014\022\016\n\006status\030\010 \001(\r\022\014\n\004time\030\t \001(\004\022\013\n\003da" +
      "y\030\n \001(\rB\014H\002P\001Z\006.;velob\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_io_velo_proto_Configuration_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_io_velo_proto_Configuration_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_Configuration_descriptor,
        new java.lang.String[] { "NatsUrl", "NatsUsername", "NatsPassword", "DBHost", "DBUsername", "DBPassword", "DBLocation", });
    internal_static_io_velo_proto_AuthenticationRequest_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_io_velo_proto_AuthenticationRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_AuthenticationRequest_descriptor,
        new java.lang.String[] { "Module", "Secret", });
    internal_static_io_velo_proto_AuthenticationResponse_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_io_velo_proto_AuthenticationResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_AuthenticationResponse_descriptor,
        new java.lang.String[] { "SessionID", "Config", });
    internal_static_io_velo_proto_EndSessionSignal_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_io_velo_proto_EndSessionSignal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_EndSessionSignal_descriptor,
        new java.lang.String[] { "ID", "Code", });
    internal_static_io_velo_proto_UpdateSessionSignal_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_io_velo_proto_UpdateSessionSignal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_UpdateSessionSignal_descriptor,
        new java.lang.String[] { "ID", });
    internal_static_io_velo_proto_GetIDResponse_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_io_velo_proto_GetIDResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_GetIDResponse_descriptor,
        new java.lang.String[] { "Prefix", "Start", "End", });
    internal_static_io_velo_proto_GetSNRequest_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_io_velo_proto_GetSNRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_GetSNRequest_descriptor,
        new java.lang.String[] { "Key", });
    internal_static_io_velo_proto_GetSNResponse_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_io_velo_proto_GetSNResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_GetSNResponse_descriptor,
        new java.lang.String[] { "Prefix", "Start", "End", });
    internal_static_io_velo_proto_WriteLogSignal_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_io_velo_proto_WriteLogSignal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_WriteLogSignal_descriptor,
        new java.lang.String[] { "Time", "Level", "Text", "Id", "Seq", "Session", });
    internal_static_io_velo_proto_Setting_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_io_velo_proto_Setting_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_Setting_descriptor,
        new java.lang.String[] { "Key", "Value", });
    internal_static_io_velo_proto_WriteSettingRequest_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_io_velo_proto_WriteSettingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_WriteSettingRequest_descriptor,
        new java.lang.String[] { "Module", "Key", "Value", });
    internal_static_io_velo_proto_ReadSettingRequest_descriptor =
      getDescriptor().getMessageTypes().get(11);
    internal_static_io_velo_proto_ReadSettingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_ReadSettingRequest_descriptor,
        new java.lang.String[] { "Module", "Key", });
    internal_static_io_velo_proto_ReadSettingResponse_descriptor =
      getDescriptor().getMessageTypes().get(12);
    internal_static_io_velo_proto_ReadSettingResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_ReadSettingResponse_descriptor,
        new java.lang.String[] { "Value", });
    internal_static_io_velo_proto_SettingUpdatedSignal_descriptor =
      getDescriptor().getMessageTypes().get(13);
    internal_static_io_velo_proto_SettingUpdatedSignal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_SettingUpdatedSignal_descriptor,
        new java.lang.String[] { "Module", "Key", "Value", });
    internal_static_io_velo_proto_RemoveSettingRequest_descriptor =
      getDescriptor().getMessageTypes().get(14);
    internal_static_io_velo_proto_RemoveSettingRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_RemoveSettingRequest_descriptor,
        new java.lang.String[] { "Module", "Key", });
    internal_static_io_velo_proto_WriteCallSignal_descriptor =
      getDescriptor().getMessageTypes().get(15);
    internal_static_io_velo_proto_WriteCallSignal_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_io_velo_proto_WriteCallSignal_descriptor,
        new java.lang.String[] { "Id", "Source", "CallerId", "SessionId", "Duration", "Request", "Response", "Status", "Time", "Day", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
