// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: trace.proto

package scyna.proto;

/**
 * Protobuf type {@code scyna.LogCreatedSignal}
 */
public  final class LogCreatedSignal extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.LogCreatedSignal)
    LogCreatedSignalOrBuilder {
private static final long serialVersionUID = 0L;
  // Use LogCreatedSignal.newBuilder() to construct.
  private LogCreatedSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private LogCreatedSignal() {
    time_ = 0L;
    iD_ = 0L;
    sEQ_ = 0L;
    text_ = "";
    level_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return scyna.proto.Trace.internal_static_scyna_LogCreatedSignal_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return scyna.proto.Trace.internal_static_scyna_LogCreatedSignal_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            scyna.proto.LogCreatedSignal.class, scyna.proto.LogCreatedSignal.Builder.class);
  }

  public static final int TIME_FIELD_NUMBER = 1;
  private long time_;
  /**
   * <code>uint64 Time = 1;</code>
   */
  public long getTime() {
    return time_;
  }

  public static final int ID_FIELD_NUMBER = 4;
  private long iD_;
  /**
   * <code>uint64 ID = 4;</code>
   */
  public long getID() {
    return iD_;
  }

  public static final int SEQ_FIELD_NUMBER = 5;
  private long sEQ_;
  /**
   * <code>uint64 SEQ = 5;</code>
   */
  public long getSEQ() {
    return sEQ_;
  }

  public static final int TEXT_FIELD_NUMBER = 3;
  private volatile java.lang.Object text_;
  /**
   * <code>string Text = 3;</code>
   */
  public java.lang.String getText() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      text_ = s;
      return s;
    }
  }
  /**
   * <code>string Text = 3;</code>
   */
  public com.google.protobuf.ByteString
      getTextBytes() {
    java.lang.Object ref = text_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      text_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int LEVEL_FIELD_NUMBER = 2;
  private int level_;
  /**
   * <code>uint32 Level = 2;</code>
   */
  public int getLevel() {
    return level_;
  }

  public static scyna.proto.LogCreatedSignal parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.LogCreatedSignal parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static scyna.proto.LogCreatedSignal parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.LogCreatedSignal parseFrom(
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
  public static Builder newBuilder(scyna.proto.LogCreatedSignal prototype) {
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
   * Protobuf type {@code scyna.LogCreatedSignal}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.LogCreatedSignal)
      scyna.proto.LogCreatedSignalOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return scyna.proto.Trace.internal_static_scyna_LogCreatedSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return scyna.proto.Trace.internal_static_scyna_LogCreatedSignal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              scyna.proto.LogCreatedSignal.class, scyna.proto.LogCreatedSignal.Builder.class);
    }

    // Construct using scyna.proto.LogCreatedSignal.newBuilder()
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
      time_ = 0L;

      iD_ = 0L;

      sEQ_ = 0L;

      text_ = "";

      level_ = 0;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return scyna.proto.Trace.internal_static_scyna_LogCreatedSignal_descriptor;
    }

    @java.lang.Override
    public scyna.proto.LogCreatedSignal getDefaultInstanceForType() {
      return scyna.proto.LogCreatedSignal.getDefaultInstance();
    }

    @java.lang.Override
    public scyna.proto.LogCreatedSignal build() {
      scyna.proto.LogCreatedSignal result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public scyna.proto.LogCreatedSignal buildPartial() {
      scyna.proto.LogCreatedSignal result = new scyna.proto.LogCreatedSignal(this);
      result.time_ = time_;
      result.iD_ = iD_;
      result.sEQ_ = sEQ_;
      result.text_ = text_;
      result.level_ = level_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }

    private long time_ ;
    /**
     * <code>uint64 Time = 1;</code>
     */
    public long getTime() {
      return time_;
    }
    /**
     * <code>uint64 Time = 1;</code>
     */
    public Builder setTime(long value) {
      
      time_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 Time = 1;</code>
     */
    public Builder clearTime() {
      
      time_ = 0L;
      onChanged();
      return this;
    }

    private long iD_ ;
    /**
     * <code>uint64 ID = 4;</code>
     */
    public long getID() {
      return iD_;
    }
    /**
     * <code>uint64 ID = 4;</code>
     */
    public Builder setID(long value) {
      
      iD_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 ID = 4;</code>
     */
    public Builder clearID() {
      
      iD_ = 0L;
      onChanged();
      return this;
    }

    private long sEQ_ ;
    /**
     * <code>uint64 SEQ = 5;</code>
     */
    public long getSEQ() {
      return sEQ_;
    }
    /**
     * <code>uint64 SEQ = 5;</code>
     */
    public Builder setSEQ(long value) {
      
      sEQ_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 SEQ = 5;</code>
     */
    public Builder clearSEQ() {
      
      sEQ_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object text_ = "";
    /**
     * <code>string Text = 3;</code>
     */
    public java.lang.String getText() {
      java.lang.Object ref = text_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        text_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Text = 3;</code>
     */
    public com.google.protobuf.ByteString
        getTextBytes() {
      java.lang.Object ref = text_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        text_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Text = 3;</code>
     */
    public Builder setText(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      text_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Text = 3;</code>
     */
    public Builder clearText() {
      
      text_ = getDefaultInstance().getText();
      onChanged();
      return this;
    }
    /**
     * <code>string Text = 3;</code>
     */
    public Builder setTextBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      text_ = value;
      onChanged();
      return this;
    }

    private int level_ ;
    /**
     * <code>uint32 Level = 2;</code>
     */
    public int getLevel() {
      return level_;
    }
    /**
     * <code>uint32 Level = 2;</code>
     */
    public Builder setLevel(int value) {
      
      level_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 Level = 2;</code>
     */
    public Builder clearLevel() {
      
      level_ = 0;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:scyna.LogCreatedSignal)
  }

  // @@protoc_insertion_point(class_scope:scyna.LogCreatedSignal)
  private static final scyna.proto.LogCreatedSignal DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new scyna.proto.LogCreatedSignal();
  }

  public static scyna.proto.LogCreatedSignal getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<LogCreatedSignal>
      PARSER = new com.google.protobuf.AbstractParser<LogCreatedSignal>() {
    @java.lang.Override
    public LogCreatedSignal parsePartialFrom(
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

  public static com.google.protobuf.Parser<LogCreatedSignal> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<LogCreatedSignal> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public scyna.proto.LogCreatedSignal getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

