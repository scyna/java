// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

/**
 * Protobuf type {@code scyna.UpdateSessionSignal}
 */
public final class UpdateSessionSignal extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.UpdateSessionSignal)
    UpdateSessionSignalOrBuilder {
private static final long serialVersionUID = 0L;
  // Use UpdateSessionSignal.newBuilder() to construct.
  private UpdateSessionSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private UpdateSessionSignal() {
    module_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateSessionSignal();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.proto.Engine.internal_static_scyna_UpdateSessionSignal_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.proto.Engine.internal_static_scyna_UpdateSessionSignal_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.proto.UpdateSessionSignal.class, io.scyna.proto.UpdateSessionSignal.Builder.class);
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

  public static final int MODULE_FIELD_NUMBER = 2;
  private volatile java.lang.Object module_;
  /**
   * <code>string Module = 2;</code>
   * @return The module.
   */
  @java.lang.Override
  public java.lang.String getModule() {
    java.lang.Object ref = module_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      module_ = s;
      return s;
    }
  }
  /**
   * <code>string Module = 2;</code>
   * @return The bytes for module.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getModuleBytes() {
    java.lang.Object ref = module_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      module_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.UpdateSessionSignal parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.proto.UpdateSessionSignal parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.UpdateSessionSignal parseFrom(
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
  public static Builder newBuilder(io.scyna.proto.UpdateSessionSignal prototype) {
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
   * Protobuf type {@code scyna.UpdateSessionSignal}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.UpdateSessionSignal)
      io.scyna.proto.UpdateSessionSignalOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.proto.Engine.internal_static_scyna_UpdateSessionSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.proto.Engine.internal_static_scyna_UpdateSessionSignal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.proto.UpdateSessionSignal.class, io.scyna.proto.UpdateSessionSignal.Builder.class);
    }

    // Construct using io.scyna.proto.UpdateSessionSignal.newBuilder()
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

      module_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.scyna.proto.Engine.internal_static_scyna_UpdateSessionSignal_descriptor;
    }

    @java.lang.Override
    public io.scyna.proto.UpdateSessionSignal getDefaultInstanceForType() {
      return io.scyna.proto.UpdateSessionSignal.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.proto.UpdateSessionSignal build() {
      io.scyna.proto.UpdateSessionSignal result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.proto.UpdateSessionSignal buildPartial() {
      io.scyna.proto.UpdateSessionSignal result = new io.scyna.proto.UpdateSessionSignal(this);
      result.iD_ = iD_;
      result.module_ = module_;
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

    private java.lang.Object module_ = "";
    /**
     * <code>string Module = 2;</code>
     * @return The module.
     */
    public java.lang.String getModule() {
      java.lang.Object ref = module_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        module_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Module = 2;</code>
     * @return The bytes for module.
     */
    public com.google.protobuf.ByteString
        getModuleBytes() {
      java.lang.Object ref = module_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        module_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Module = 2;</code>
     * @param value The module to set.
     * @return This builder for chaining.
     */
    public Builder setModule(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      module_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Module = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearModule() {
      
      module_ = getDefaultInstance().getModule();
      onChanged();
      return this;
    }
    /**
     * <code>string Module = 2;</code>
     * @param value The bytes for module to set.
     * @return This builder for chaining.
     */
    public Builder setModuleBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      module_ = value;
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


    // @@protoc_insertion_point(builder_scope:scyna.UpdateSessionSignal)
  }

  // @@protoc_insertion_point(class_scope:scyna.UpdateSessionSignal)
  private static final io.scyna.proto.UpdateSessionSignal DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.proto.UpdateSessionSignal();
  }

  public static io.scyna.proto.UpdateSessionSignal getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateSessionSignal>
      PARSER = new com.google.protobuf.AbstractParser<UpdateSessionSignal>() {
    @java.lang.Override
    public UpdateSessionSignal parsePartialFrom(
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

  public static com.google.protobuf.Parser<UpdateSessionSignal> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateSessionSignal> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.proto.UpdateSessionSignal getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

