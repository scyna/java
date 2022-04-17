// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package io.scyna.proto;

/**
 * <pre>
 *Authentication
 * </pre>
 *
 * Protobuf type {@code scyna.CreateAuthRequest}
 */
public final class CreateAuthRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.CreateAuthRequest)
    CreateAuthRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateAuthRequest.newBuilder() to construct.
  private CreateAuthRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateAuthRequest() {
    organization_ = "";
    secret_ = "";
    userID_ = "";
    apps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateAuthRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.scyna.proto.Engine.internal_static_scyna_CreateAuthRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.scyna.proto.Engine.internal_static_scyna_CreateAuthRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.proto.CreateAuthRequest.class, io.scyna.proto.CreateAuthRequest.Builder.class);
  }

  public static final int ORGANIZATION_FIELD_NUMBER = 1;
  private volatile java.lang.Object organization_;
  /**
   * <code>string Organization = 1;</code>
   * @return The organization.
   */
  @java.lang.Override
  public java.lang.String getOrganization() {
    java.lang.Object ref = organization_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      organization_ = s;
      return s;
    }
  }
  /**
   * <code>string Organization = 1;</code>
   * @return The bytes for organization.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getOrganizationBytes() {
    java.lang.Object ref = organization_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      organization_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int SECRET_FIELD_NUMBER = 2;
  private volatile java.lang.Object secret_;
  /**
   * <code>string Secret = 2;</code>
   * @return The secret.
   */
  @java.lang.Override
  public java.lang.String getSecret() {
    java.lang.Object ref = secret_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      secret_ = s;
      return s;
    }
  }
  /**
   * <code>string Secret = 2;</code>
   * @return The bytes for secret.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getSecretBytes() {
    java.lang.Object ref = secret_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      secret_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int USERID_FIELD_NUMBER = 3;
  private volatile java.lang.Object userID_;
  /**
   * <code>string UserID = 3;</code>
   * @return The userID.
   */
  @java.lang.Override
  public java.lang.String getUserID() {
    java.lang.Object ref = userID_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      userID_ = s;
      return s;
    }
  }
  /**
   * <code>string UserID = 3;</code>
   * @return The bytes for userID.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getUserIDBytes() {
    java.lang.Object ref = userID_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      userID_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int APPS_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList apps_;
  /**
   * <code>repeated string Apps = 4;</code>
   * @return A list containing the apps.
   */
  public com.google.protobuf.ProtocolStringList
      getAppsList() {
    return apps_;
  }
  /**
   * <code>repeated string Apps = 4;</code>
   * @return The count of apps.
   */
  public int getAppsCount() {
    return apps_.size();
  }
  /**
   * <code>repeated string Apps = 4;</code>
   * @param index The index of the element to return.
   * @return The apps at the given index.
   */
  public java.lang.String getApps(int index) {
    return apps_.get(index);
  }
  /**
   * <code>repeated string Apps = 4;</code>
   * @param index The index of the value to return.
   * @return The bytes of the apps at the given index.
   */
  public com.google.protobuf.ByteString
      getAppsBytes(int index) {
    return apps_.getByteString(index);
  }

  public static io.scyna.proto.CreateAuthRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.CreateAuthRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static io.scyna.proto.CreateAuthRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static io.scyna.proto.CreateAuthRequest parseFrom(
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
  public static Builder newBuilder(io.scyna.proto.CreateAuthRequest prototype) {
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
   * <pre>
   *Authentication
   * </pre>
   *
   * Protobuf type {@code scyna.CreateAuthRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.CreateAuthRequest)
      io.scyna.proto.CreateAuthRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.scyna.proto.Engine.internal_static_scyna_CreateAuthRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.scyna.proto.Engine.internal_static_scyna_CreateAuthRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.proto.CreateAuthRequest.class, io.scyna.proto.CreateAuthRequest.Builder.class);
    }

    // Construct using io.scyna.proto.CreateAuthRequest.newBuilder()
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
      organization_ = "";

      secret_ = "";

      userID_ = "";

      apps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.scyna.proto.Engine.internal_static_scyna_CreateAuthRequest_descriptor;
    }

    @java.lang.Override
    public io.scyna.proto.CreateAuthRequest getDefaultInstanceForType() {
      return io.scyna.proto.CreateAuthRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.proto.CreateAuthRequest build() {
      io.scyna.proto.CreateAuthRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.proto.CreateAuthRequest buildPartial() {
      io.scyna.proto.CreateAuthRequest result = new io.scyna.proto.CreateAuthRequest(this);
      int from_bitField0_ = bitField0_;
      result.organization_ = organization_;
      result.secret_ = secret_;
      result.userID_ = userID_;
      if (((bitField0_ & 0x00000001) != 0)) {
        apps_ = apps_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000001);
      }
      result.apps_ = apps_;
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
    private int bitField0_;

    private java.lang.Object organization_ = "";
    /**
     * <code>string Organization = 1;</code>
     * @return The organization.
     */
    public java.lang.String getOrganization() {
      java.lang.Object ref = organization_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        organization_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Organization = 1;</code>
     * @return The bytes for organization.
     */
    public com.google.protobuf.ByteString
        getOrganizationBytes() {
      java.lang.Object ref = organization_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        organization_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Organization = 1;</code>
     * @param value The organization to set.
     * @return This builder for chaining.
     */
    public Builder setOrganization(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      organization_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Organization = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearOrganization() {
      
      organization_ = getDefaultInstance().getOrganization();
      onChanged();
      return this;
    }
    /**
     * <code>string Organization = 1;</code>
     * @param value The bytes for organization to set.
     * @return This builder for chaining.
     */
    public Builder setOrganizationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      organization_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object secret_ = "";
    /**
     * <code>string Secret = 2;</code>
     * @return The secret.
     */
    public java.lang.String getSecret() {
      java.lang.Object ref = secret_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        secret_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string Secret = 2;</code>
     * @return The bytes for secret.
     */
    public com.google.protobuf.ByteString
        getSecretBytes() {
      java.lang.Object ref = secret_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        secret_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string Secret = 2;</code>
     * @param value The secret to set.
     * @return This builder for chaining.
     */
    public Builder setSecret(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      secret_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string Secret = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearSecret() {
      
      secret_ = getDefaultInstance().getSecret();
      onChanged();
      return this;
    }
    /**
     * <code>string Secret = 2;</code>
     * @param value The bytes for secret to set.
     * @return This builder for chaining.
     */
    public Builder setSecretBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      secret_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object userID_ = "";
    /**
     * <code>string UserID = 3;</code>
     * @return The userID.
     */
    public java.lang.String getUserID() {
      java.lang.Object ref = userID_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        userID_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string UserID = 3;</code>
     * @return The bytes for userID.
     */
    public com.google.protobuf.ByteString
        getUserIDBytes() {
      java.lang.Object ref = userID_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        userID_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string UserID = 3;</code>
     * @param value The userID to set.
     * @return This builder for chaining.
     */
    public Builder setUserID(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      userID_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string UserID = 3;</code>
     * @return This builder for chaining.
     */
    public Builder clearUserID() {
      
      userID_ = getDefaultInstance().getUserID();
      onChanged();
      return this;
    }
    /**
     * <code>string UserID = 3;</code>
     * @param value The bytes for userID to set.
     * @return This builder for chaining.
     */
    public Builder setUserIDBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      userID_ = value;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList apps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureAppsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        apps_ = new com.google.protobuf.LazyStringArrayList(apps_);
        bitField0_ |= 0x00000001;
       }
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @return A list containing the apps.
     */
    public com.google.protobuf.ProtocolStringList
        getAppsList() {
      return apps_.getUnmodifiableView();
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @return The count of apps.
     */
    public int getAppsCount() {
      return apps_.size();
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param index The index of the element to return.
     * @return The apps at the given index.
     */
    public java.lang.String getApps(int index) {
      return apps_.get(index);
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param index The index of the value to return.
     * @return The bytes of the apps at the given index.
     */
    public com.google.protobuf.ByteString
        getAppsBytes(int index) {
      return apps_.getByteString(index);
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param index The index to set the value at.
     * @param value The apps to set.
     * @return This builder for chaining.
     */
    public Builder setApps(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAppsIsMutable();
      apps_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param value The apps to add.
     * @return This builder for chaining.
     */
    public Builder addApps(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureAppsIsMutable();
      apps_.add(value);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param values The apps to add.
     * @return This builder for chaining.
     */
    public Builder addAllApps(
        java.lang.Iterable<java.lang.String> values) {
      ensureAppsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, apps_);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @return This builder for chaining.
     */
    public Builder clearApps() {
      apps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>repeated string Apps = 4;</code>
     * @param value The bytes of the apps to add.
     * @return This builder for chaining.
     */
    public Builder addAppsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureAppsIsMutable();
      apps_.add(value);
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


    // @@protoc_insertion_point(builder_scope:scyna.CreateAuthRequest)
  }

  // @@protoc_insertion_point(class_scope:scyna.CreateAuthRequest)
  private static final io.scyna.proto.CreateAuthRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.proto.CreateAuthRequest();
  }

  public static io.scyna.proto.CreateAuthRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateAuthRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateAuthRequest>() {
    @java.lang.Override
    public CreateAuthRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<CreateAuthRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateAuthRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.proto.CreateAuthRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

