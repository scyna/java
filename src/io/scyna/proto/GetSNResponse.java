// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

/**
 * Protobuf type {@code scyna.GetSNResponse}
 */
public final class GetSNResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.GetSNResponse)
    GetSNResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetSNResponse.newBuilder() to construct.
  private GetSNResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetSNResponse() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetSNResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.proto.Engine.internal_static_scyna_GetSNResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.proto.Engine.internal_static_scyna_GetSNResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.proto.GetSNResponse.class, io.scyna.proto.GetSNResponse.Builder.class);
  }

  public static final int PREFIX_FIELD_NUMBER = 1;
  private int prefix_;
  /**
   * <code>uint32 prefix = 1;</code>
   * @return The prefix.
   */
  @java.lang.Override
  public int getPrefix() {
    return prefix_;
  }

  public static final int START_FIELD_NUMBER = 2;
  private long start_;
  /**
   * <code>uint64 start = 2;</code>
   * @return The start.
   */
  @java.lang.Override
  public long getStart() {
    return start_;
  }

  public static final int END_FIELD_NUMBER = 3;
  private long end_;
  /**
   * <code>uint64 end = 3;</code>
   * @return The end.
   */
  @java.lang.Override
  public long getEnd() {
    return end_;
  }

  public static io.scyna.proto.GetSNResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.GetSNResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.proto.GetSNResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.GetSNResponse parseFrom(
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
  public static Builder newBuilder(io.scyna.proto.GetSNResponse prototype) {
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
   * Protobuf type {@code scyna.GetSNResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.GetSNResponse)
      io.scyna.proto.GetSNResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.proto.Engine.internal_static_scyna_GetSNResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.proto.Engine.internal_static_scyna_GetSNResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.proto.GetSNResponse.class, io.scyna.proto.GetSNResponse.Builder.class);
    }

    // Construct using io.scyna.proto.GetSNResponse.newBuilder()
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
      return io.scyna.proto.Engine.internal_static_scyna_GetSNResponse_descriptor;
    }

    @java.lang.Override
    public io.scyna.proto.GetSNResponse getDefaultInstanceForType() {
      return io.scyna.proto.GetSNResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.proto.GetSNResponse build() {
      io.scyna.proto.GetSNResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.proto.GetSNResponse buildPartial() {
      io.scyna.proto.GetSNResponse result = new io.scyna.proto.GetSNResponse(this);
      result.prefix_ = prefix_;
      result.start_ = start_;
      result.end_ = end_;
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

    private int prefix_ ;
    /**
     * <code>uint32 prefix = 1;</code>
     * @return The prefix.
     */
    @java.lang.Override
    public int getPrefix() {
      return prefix_;
    }
    /**
     * <code>uint32 prefix = 1;</code>
     * @param value The prefix to set.
     * @return This builder for chaining.
     */
    public Builder setPrefix(int value) {
      
      prefix_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint32 prefix = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearPrefix() {
      
      prefix_ = 0;
      onChanged();
      return this;
    }

    private long start_ ;
    /**
     * <code>uint64 start = 2;</code>
     * @return The start.
     */
    @java.lang.Override
    public long getStart() {
      return start_;
    }
    /**
     * <code>uint64 start = 2;</code>
     * @param value The start to set.
     * @return This builder for chaining.
     */
    public Builder setStart(long value) {
      
      start_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 start = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearStart() {
      
      start_ = 0L;
      onChanged();
      return this;
    }

    private long end_ ;
    /**
     * <code>uint64 end = 3;</code>
     * @return The end.
     */
    @java.lang.Override
    public long getEnd() {
      return end_;
    }
    /**
     * <code>uint64 end = 3;</code>
     * @param value The end to set.
     * @return This builder for chaining.
     */
    public Builder setEnd(long value) {
      
      end_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 end = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearEnd() {
      
      end_ = 0L;
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


    // @@protoc_insertion_point(builder_scope:scyna.GetSNResponse)
  }

  // @@protoc_insertion_point(class_scope:scyna.GetSNResponse)
  private static final io.scyna.proto.GetSNResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.proto.GetSNResponse();
  }

  public static io.scyna.proto.GetSNResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetSNResponse>
      PARSER = new com.google.protobuf.AbstractParser<GetSNResponse>() {
    @java.lang.Override
    public GetSNResponse parsePartialFrom(
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

  public static com.google.protobuf.Parser<GetSNResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetSNResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.proto.GetSNResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

