// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: id.proto

package scyna.proto;

/**
 * Protobuf type {@code scyna.GetIDResponse}
 */
public  final class GetIDResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.GetIDResponse)
    GetIDResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetIDResponse.newBuilder() to construct.
  private GetIDResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetIDResponse() {
    prefix_ = 0;
    start_ = 0L;
    end_ = 0L;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return scyna.proto.Id.internal_static_scyna_GetIDResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return scyna.proto.Id.internal_static_scyna_GetIDResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            scyna.proto.GetIDResponse.class, scyna.proto.GetIDResponse.Builder.class);
  }

  public static final int PREFIX_FIELD_NUMBER = 1;
  private int prefix_;
  /**
   * <code>uint32 prefix = 1;</code>
   */
  public int getPrefix() {
    return prefix_;
  }

  public static final int START_FIELD_NUMBER = 2;
  private long start_;
  /**
   * <code>uint64 start = 2;</code>
   */
  public long getStart() {
    return start_;
  }

  public static final int END_FIELD_NUMBER = 3;
  private long end_;
  /**
   * <code>uint64 end = 3;</code>
   */
  public long getEnd() {
    return end_;
  }

  public static scyna.proto.GetIDResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.GetIDResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.GetIDResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.GetIDResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static scyna.proto.GetIDResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.GetIDResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.GetIDResponse parseFrom(
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
  public static Builder newBuilder(scyna.proto.GetIDResponse prototype) {
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
   * Protobuf type {@code scyna.GetIDResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.GetIDResponse)
      scyna.proto.GetIDResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return scyna.proto.Id.internal_static_scyna_GetIDResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return scyna.proto.Id.internal_static_scyna_GetIDResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              scyna.proto.GetIDResponse.class, scyna.proto.GetIDResponse.Builder.class);
    }

    // Construct using scyna.proto.GetIDResponse.newBuilder()
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
      prefix_ = 0;

      start_ = 0L;

      end_ = 0L;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return scyna.proto.Id.internal_static_scyna_GetIDResponse_descriptor;
    }

    @java.lang.Override
    public scyna.proto.GetIDResponse getDefaultInstanceForType() {
      return scyna.proto.GetIDResponse.getDefaultInstance();
    }

    @java.lang.Override
    public scyna.proto.GetIDResponse build() {
      scyna.proto.GetIDResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public scyna.proto.GetIDResponse buildPartial() {
      scyna.proto.GetIDResponse result = new scyna.proto.GetIDResponse(this);
      result.prefix_ = prefix_;
      result.start_ = start_;
      result.end_ = end_;
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

    private int prefix_ ;
    /**
     * <code>uint32 prefix = 1;</code>
     */
    public int getPrefix() {
      return prefix_;
    }
    /**
     * <code>uint32 prefix = 1;</code>
     */
    public Builder setPrefix(int value) {
      
      prefix_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 prefix = 1;</code>
     */
    public Builder clearPrefix() {
      
      prefix_ = 0;
      onChanged();
      return this;
    }

    private long start_ ;
    /**
     * <code>uint64 start = 2;</code>
     */
    public long getStart() {
      return start_;
    }
    /**
     * <code>uint64 start = 2;</code>
     */
    public Builder setStart(long value) {
      
      start_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 start = 2;</code>
     */
    public Builder clearStart() {
      
      start_ = 0L;
      onChanged();
      return this;
    }

    private long end_ ;
    /**
     * <code>uint64 end = 3;</code>
     */
    public long getEnd() {
      return end_;
    }
    /**
     * <code>uint64 end = 3;</code>
     */
    public Builder setEnd(long value) {
      
      end_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 end = 3;</code>
     */
    public Builder clearEnd() {
      
      end_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:scyna.GetIDResponse)
  }

  // @@protoc_insertion_point(class_scope:scyna.GetIDResponse)
  private static final scyna.proto.GetIDResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new scyna.proto.GetIDResponse();
  }

  public static scyna.proto.GetIDResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetIDResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetIDResponse>() {
    @java.lang.Override
    public GetIDResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetIDResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetIDResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public scyna.proto.GetIDResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

