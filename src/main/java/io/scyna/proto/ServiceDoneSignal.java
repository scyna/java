// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

/**
 * Protobuf type {@code scyna.ServiceDoneSignal}
 */
public final class ServiceDoneSignal extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.ServiceDoneSignal)
    ServiceDoneSignalOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ServiceDoneSignal.newBuilder() to construct.
  private ServiceDoneSignal(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ServiceDoneSignal() {
    request_ = "";
    response_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ServiceDoneSignal();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.proto.Engine.internal_static_scyna_ServiceDoneSignal_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.proto.Engine.internal_static_scyna_ServiceDoneSignal_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.proto.ServiceDoneSignal.class, io.scyna.proto.ServiceDoneSignal.Builder.class);
  }

  public static final int TRACEID_FIELD_NUMBER = 1;
  private long traceID_;
  /**
   * <code>uint64 TraceID = 1;</code>
   * @return The traceID.
   */
  @java.lang.Override
  public long getTraceID() {
    return traceID_;
  }

  public static final int REQUEST_FIELD_NUMBER = 2;
  private volatile java.lang.Object request_;
  /**
   * <code>string Request = 2;</code>
   * @return The request.
   */
  @java.lang.Override
  public java.lang.String getRequest() {
    java.lang.Object ref = request_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      request_ = s;
      return s;
    }
  }
  /**
   * <code>string Request = 2;</code>
   * @return The bytes for request.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getRequestBytes() {
    java.lang.Object ref = request_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      request_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int RESPONSE_FIELD_NUMBER = 3;
  private volatile java.lang.Object response_;
  /**
   * <code>string Response = 3;</code>
   * @return The response.
   */
  @java.lang.Override
  public java.lang.String getResponse() {
    java.lang.Object ref = response_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      response_ = s;
      return s;
    }
  }
  /**
   * <code>string Response = 3;</code>
   * @return The bytes for response.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getResponseBytes() {
    java.lang.Object ref = response_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      response_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.ServiceDoneSignal parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.proto.ServiceDoneSignal parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.ServiceDoneSignal parseFrom(
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
  public static Builder newBuilder(io.scyna.proto.ServiceDoneSignal prototype) {
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
   * Protobuf type {@code scyna.ServiceDoneSignal}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.ServiceDoneSignal)
      io.scyna.proto.ServiceDoneSignalOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.proto.Engine.internal_static_scyna_ServiceDoneSignal_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.proto.Engine.internal_static_scyna_ServiceDoneSignal_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.proto.ServiceDoneSignal.class, io.scyna.proto.ServiceDoneSignal.Builder.class);
    }

    // Construct using io.scyna.proto.ServiceDoneSignal.newBuilder()
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
      traceID_ = 0L;

      request_ = "";

      response_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.scyna.proto.Engine.internal_static_scyna_ServiceDoneSignal_descriptor;
    }

    @java.lang.Override
    public io.scyna.proto.ServiceDoneSignal getDefaultInstanceForType() {
      return io.scyna.proto.ServiceDoneSignal.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.proto.ServiceDoneSignal build() {
      io.scyna.proto.ServiceDoneSignal result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.proto.ServiceDoneSignal buildPartial() {
      io.scyna.proto.ServiceDoneSignal result = new io.scyna.proto.ServiceDoneSignal(this);
      result.traceID_ = traceID_;
      result.request_ = request_;
      result.response_ = response_;
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

    private long traceID_ ;
    /**
     * <code>uint64 TraceID = 1;</code>
     * @return The traceID.
     */
    @java.lang.Override
    public long getTraceID() {
      return traceID_;
    }
    /**
     * <code>uint64 TraceID = 1;</code>
     * @param value The traceID to set.
     * @return This builder for chaining.
     */
    public Builder setTraceID(long value) {
      
      traceID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>uint64 TraceID = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearTraceID() {
      
      traceID_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object request_ = "";
    /**
     * <code>string Request = 2;</code>
     * @return The request.
     */
    public java.lang.String getRequest() {
      java.lang.Object ref = request_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        request_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Request = 2;</code>
     * @return The bytes for request.
     */
    public com.google.protobuf.ByteString
        getRequestBytes() {
      java.lang.Object ref = request_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        request_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Request = 2;</code>
     * @param value The request to set.
     * @return This builder for chaining.
     */
    public Builder setRequest(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      request_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Request = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearRequest() {
      
      request_ = getDefaultInstance().getRequest();
      onChanged();
      return this;
    }
    /**
     * <code>string Request = 2;</code>
     * @param value The bytes for request to set.
     * @return This builder for chaining.
     */
    public Builder setRequestBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      request_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object response_ = "";
    /**
     * <code>string Response = 3;</code>
     * @return The response.
     */
    public java.lang.String getResponse() {
      java.lang.Object ref = response_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        response_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Response = 3;</code>
     * @return The bytes for response.
     */
    public com.google.protobuf.ByteString
        getResponseBytes() {
      java.lang.Object ref = response_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        response_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Response = 3;</code>
     * @param value The response to set.
     * @return This builder for chaining.
     */
    public Builder setResponse(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      response_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Response = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearResponse() {
      
      response_ = getDefaultInstance().getResponse();
      onChanged();
      return this;
    }
    /**
     * <code>string Response = 3;</code>
     * @param value The bytes for response to set.
     * @return This builder for chaining.
     */
    public Builder setResponseBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      response_ = value;
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


    // @@protoc_insertion_point(builder_scope:scyna.ServiceDoneSignal)
  }

  // @@protoc_insertion_point(class_scope:scyna.ServiceDoneSignal)
  private static final io.scyna.proto.ServiceDoneSignal DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.proto.ServiceDoneSignal();
  }

  public static io.scyna.proto.ServiceDoneSignal getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ServiceDoneSignal>
      PARSER = new com.google.protobuf.AbstractParser<ServiceDoneSignal>() {
    @java.lang.Override
    public ServiceDoneSignal parsePartialFrom(
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

  public static com.google.protobuf.Parser<ServiceDoneSignal> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ServiceDoneSignal> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.proto.ServiceDoneSignal getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

