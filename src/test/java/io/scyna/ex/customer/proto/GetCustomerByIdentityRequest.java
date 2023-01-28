// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer.proto

package io.scyna.ex.customer.proto;

/**
 * Protobuf type {@code io.scyna.customer.proto.GetCustomerByIdentityRequest}
 */
public final class GetCustomerByIdentityRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.scyna.customer.proto.GetCustomerByIdentityRequest)
    GetCustomerByIdentityRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GetCustomerByIdentityRequest.newBuilder() to construct.
  private GetCustomerByIdentityRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GetCustomerByIdentityRequest() {
    iDType_ = "";
    iDNumber_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GetCustomerByIdentityRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private GetCustomerByIdentityRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            iDType_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            iDNumber_ = s;
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_GetCustomerByIdentityRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_GetCustomerByIdentityRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.class, io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.Builder.class);
  }

  public static final int IDTYPE_FIELD_NUMBER = 1;
  private volatile java.lang.Object iDType_;
  /**
   * <code>string IDType = 1;</code>
   * @return The iDType.
   */
  @java.lang.Override
  public java.lang.String getIDType() {
    java.lang.Object ref = iDType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      iDType_ = s;
      return s;
    }
  }
  /**
   * <code>string IDType = 1;</code>
   * @return The bytes for iDType.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIDTypeBytes() {
    java.lang.Object ref = iDType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      iDType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int IDNUMBER_FIELD_NUMBER = 2;
  private volatile java.lang.Object iDNumber_;
  /**
   * <code>string IDNumber = 2;</code>
   * @return The iDNumber.
   */
  @java.lang.Override
  public java.lang.String getIDNumber() {
    java.lang.Object ref = iDNumber_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      iDNumber_ = s;
      return s;
    }
  }
  /**
   * <code>string IDNumber = 2;</code>
   * @return The bytes for iDNumber.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getIDNumberBytes() {
    java.lang.Object ref = iDNumber_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      iDNumber_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getIDTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, iDType_);
    }
    if (!getIDNumberBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, iDNumber_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getIDTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, iDType_);
    }
    if (!getIDNumberBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, iDNumber_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.scyna.ex.customer.proto.GetCustomerByIdentityRequest)) {
      return super.equals(obj);
    }
    io.scyna.ex.customer.proto.GetCustomerByIdentityRequest other = (io.scyna.ex.customer.proto.GetCustomerByIdentityRequest) obj;

    if (!getIDType()
        .equals(other.getIDType())) return false;
    if (!getIDNumber()
        .equals(other.getIDNumber())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + IDTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getIDType().hashCode();
    hash = (37 * hash) + IDNUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getIDNumber().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parseFrom(
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
  public static Builder newBuilder(io.scyna.ex.customer.proto.GetCustomerByIdentityRequest prototype) {
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
   * Protobuf type {@code io.scyna.customer.proto.GetCustomerByIdentityRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.scyna.customer.proto.GetCustomerByIdentityRequest)
      io.scyna.ex.customer.proto.GetCustomerByIdentityRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_GetCustomerByIdentityRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_GetCustomerByIdentityRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.class, io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.Builder.class);
    }

    // Construct using io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.newBuilder()
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
      iDType_ = "";

      iDNumber_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_GetCustomerByIdentityRequest_descriptor;
    }

    @java.lang.Override
    public io.scyna.ex.customer.proto.GetCustomerByIdentityRequest getDefaultInstanceForType() {
      return io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.ex.customer.proto.GetCustomerByIdentityRequest build() {
      io.scyna.ex.customer.proto.GetCustomerByIdentityRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.ex.customer.proto.GetCustomerByIdentityRequest buildPartial() {
      io.scyna.ex.customer.proto.GetCustomerByIdentityRequest result = new io.scyna.ex.customer.proto.GetCustomerByIdentityRequest(this);
      result.iDType_ = iDType_;
      result.iDNumber_ = iDNumber_;
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
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.scyna.ex.customer.proto.GetCustomerByIdentityRequest) {
        return mergeFrom((io.scyna.ex.customer.proto.GetCustomerByIdentityRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.scyna.ex.customer.proto.GetCustomerByIdentityRequest other) {
      if (other == io.scyna.ex.customer.proto.GetCustomerByIdentityRequest.getDefaultInstance()) return this;
      if (!other.getIDType().isEmpty()) {
        iDType_ = other.iDType_;
        onChanged();
      }
      if (!other.getIDNumber().isEmpty()) {
        iDNumber_ = other.iDNumber_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      io.scyna.ex.customer.proto.GetCustomerByIdentityRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.scyna.ex.customer.proto.GetCustomerByIdentityRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object iDType_ = "";
    /**
     * <code>string IDType = 1;</code>
     * @return The iDType.
     */
    public java.lang.String getIDType() {
      java.lang.Object ref = iDType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        iDType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string IDType = 1;</code>
     * @return The bytes for iDType.
     */
    public com.google.protobuf.ByteString
        getIDTypeBytes() {
      java.lang.Object ref = iDType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        iDType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string IDType = 1;</code>
     * @param value The iDType to set.
     * @return This builder for chaining.
     */
    public Builder setIDType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      iDType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string IDType = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearIDType() {
      
      iDType_ = getDefaultInstance().getIDType();
      onChanged();
      return this;
    }
    /**
     * <code>string IDType = 1;</code>
     * @param value The bytes for iDType to set.
     * @return This builder for chaining.
     */
    public Builder setIDTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      iDType_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object iDNumber_ = "";
    /**
     * <code>string IDNumber = 2;</code>
     * @return The iDNumber.
     */
    public java.lang.String getIDNumber() {
      java.lang.Object ref = iDNumber_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        iDNumber_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string IDNumber = 2;</code>
     * @return The bytes for iDNumber.
     */
    public com.google.protobuf.ByteString
        getIDNumberBytes() {
      java.lang.Object ref = iDNumber_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        iDNumber_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string IDNumber = 2;</code>
     * @param value The iDNumber to set.
     * @return This builder for chaining.
     */
    public Builder setIDNumber(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      iDNumber_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string IDNumber = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearIDNumber() {
      
      iDNumber_ = getDefaultInstance().getIDNumber();
      onChanged();
      return this;
    }
    /**
     * <code>string IDNumber = 2;</code>
     * @param value The bytes for iDNumber to set.
     * @return This builder for chaining.
     */
    public Builder setIDNumberBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      iDNumber_ = value;
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


    // @@protoc_insertion_point(builder_scope:io.scyna.customer.proto.GetCustomerByIdentityRequest)
  }

  // @@protoc_insertion_point(class_scope:io.scyna.customer.proto.GetCustomerByIdentityRequest)
  private static final io.scyna.ex.customer.proto.GetCustomerByIdentityRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.ex.customer.proto.GetCustomerByIdentityRequest();
  }

  public static io.scyna.ex.customer.proto.GetCustomerByIdentityRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GetCustomerByIdentityRequest>
      PARSER = new com.google.protobuf.AbstractParser<GetCustomerByIdentityRequest>() {
    @java.lang.Override
    public GetCustomerByIdentityRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new GetCustomerByIdentityRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<GetCustomerByIdentityRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GetCustomerByIdentityRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.ex.customer.proto.GetCustomerByIdentityRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

