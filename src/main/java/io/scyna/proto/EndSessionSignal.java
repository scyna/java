// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

/**
 * Protobuf type {@code scyna.EndSessionSignal}
 */
public final class EndSessionSignal extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.EndSessionSignal)
    EndSessionSignalOrBuilder {
private static final long serialVersionUID = 0L;
  // Use EndSessionSignal.newBuilder() to construct.
  private EndSessionSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private EndSessionSignal() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new EndSessionSignal();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.proto.Engine.internal_static_scyna_EndSessionSignal_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.proto.Engine.internal_static_scyna_EndSessionSignal_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.proto.EndSessionSignal.class, io.scyna.proto.EndSessionSignal.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long iD_;
  /**
   * <code>uint64 ID = 1;</code>
   * @return The iD.
   */
  @java.lang.Override
  public long getID() {
    return iD_;
  }

  public static final int CODE_FIELD_NUMBER = 2;
  private int code_;
  /**
   * <code>uint32 Code = 2;</code>
   * @return The code.
   */
  @java.lang.Override
  public int getCode() {
    return code_;
  }

  public static io.scyna.proto.EndSessionSignal parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.EndSessionSignal parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.proto.EndSessionSignal parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.EndSessionSignal parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.scyna.proto.EndSessionSignal prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code scyna.EndSessionSignal}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.EndSessionSignal)
      io.scyna.proto.EndSessionSignalOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.proto.Engine.internal_static_scyna_EndSessionSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.proto.Engine.internal_static_scyna_EndSessionSignal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.proto.EndSessionSignal.class, io.scyna.proto.EndSessionSignal.Builder.class);
    }

    // Construct using io.scyna.proto.EndSessionSignal.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      iD_ = 0L;

      code_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.scyna.proto.Engine.internal_static_scyna_EndSessionSignal_descriptor;
    }

    @java.lang.Override
    public io.scyna.proto.EndSessionSignal getDefaultInstanceForType() {
      return io.scyna.proto.EndSessionSignal.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.proto.EndSessionSignal build() {
      io.scyna.proto.EndSessionSignal result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.proto.EndSessionSignal buildPartial() {
      io.scyna.proto.EndSessionSignal result = new io.scyna.proto.EndSessionSignal(this);
      result.iD_ = iD_;
      result.code_ = code_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    private long iD_ ;
    /**
     * <code>uint64 ID = 1;</code>
     * @return The iD.
     */
    @java.lang.Override
    public long getID() {
      return iD_;
    }
    /**
     * <code>uint64 ID = 1;</code>
     * @param value The iD to set.
     * @return This builder for chaining.
     */
    public Builder setID(long value) {
      
      iD_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 ID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearID() {
      
      iD_ = 0L;
      onChanged();
      return this;
    }

    private int code_ ;
    /**
     * <code>uint32 Code = 2;</code>
     * @return The code.
     */
    @java.lang.Override
    public int getCode() {
      return code_;
    }
    /**
     * <code>uint32 Code = 2;</code>
     * @param value The code to set.
     * @return This builder for chaining.
     */
    public Builder setCode(int value) {
      
      code_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 Code = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearCode() {
      
      code_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:scyna.EndSessionSignal)
  }

  // @@protoc_insertion_point(class_scope:scyna.EndSessionSignal)
  private static final io.scyna.proto.EndSessionSignal DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.proto.EndSessionSignal();
  }

  public static io.scyna.proto.EndSessionSignal getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<EndSessionSignal>
      PARSER = new com.google.protobuf.AbstractParser<EndSessionSignal>() {
    @java.lang.Override
    public EndSessionSignal parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(
                builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<EndSessionSignal> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<EndSessionSignal> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.proto.EndSessionSignal getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
