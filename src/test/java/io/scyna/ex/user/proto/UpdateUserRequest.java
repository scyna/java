// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package io.scyna.ex.user.proto;

/**
 * <pre>
 * UPDATE
 * </pre>
 *
 * Protobuf type {@code io.scyna.user.proto.UpdateUserRequest}
 */
public final class UpdateUserRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.scyna.user.proto.UpdateUserRequest)
    UpdateUserRequestOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use UpdateUserRequest.newBuilder() to construct.
  private UpdateUserRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private UpdateUserRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({ "unused" })
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new UpdateUserRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private UpdateUserRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    com.google.protobuf.UnknownFieldSet.Builder unknownFields = com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            io.scyna.ex.user.proto.User.Builder subBuilder = null;
            if (user_ != null) {
              subBuilder = user_.toBuilder();
            }
            user_ = input.readMessage(io.scyna.ex.user.proto.User.parser(), extensionRegistry);
            if (subBuilder != null) {
              subBuilder.mergeFrom(user_);
              user_ = subBuilder.buildPartial();
            }

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

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_scyna_user_proto_UpdateUserRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_scyna_user_proto_UpdateUserRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.ex.user.proto.UpdateUserRequest.class, io.scyna.ex.user.proto.UpdateUserRequest.Builder.class);
  }

  public static final int USER_FIELD_NUMBER = 1;
  private io.scyna.ex.user.proto.User user_;

  /**
   * <code>.io.scyna.user.proto.User user = 1;</code>
   * 
   * @return Whether the user field is set.
   */
  @java.lang.Override
  public boolean hasUser() {
    return user_ != null;
  }

  /**
   * <code>.io.scyna.user.proto.User user = 1;</code>
   * 
   * @return The user.
   */
  @java.lang.Override
  public io.scyna.ex.user.proto.User getUser() {
    return user_ == null ? io.scyna.ex.user.proto.User.getDefaultInstance() : user_;
  }

  /**
   * <code>.io.scyna.user.proto.User user = 1;</code>
   */
  @java.lang.Override
  public io.scyna.ex.user.proto.UserOrBuilder getUserOrBuilder() {
    return getUser();
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1)
      return true;
    if (isInitialized == 0)
      return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
      throws java.io.IOException {
    if (user_ != null) {
      output.writeMessage(1, getUser());
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1)
      return size;

    size = 0;
    if (user_ != null) {
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, getUser());
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
    if (!(obj instanceof io.scyna.ex.user.proto.UpdateUserRequest)) {
      return super.equals(obj);
    }
    io.scyna.ex.user.proto.UpdateUserRequest other = (io.scyna.ex.user.proto.UpdateUserRequest) obj;

    if (hasUser() != other.hasUser())
      return false;
    if (hasUser()) {
      if (!getUser()
          .equals(other.getUser()))
        return false;
    }
    if (!unknownFields.equals(other.unknownFields))
      return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasUser()) {
      hash = (37 * hash) + USER_FIELD_NUMBER;
      hash = (53 * hash) + getUser().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(io.scyna.ex.user.proto.UpdateUserRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder()
        : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  /**
   * <pre>
   * UPDATE
   * </pre>
   *
   * Protobuf type {@code io.scyna.user.proto.UpdateUserRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.scyna.user.proto.UpdateUserRequest)
      io.scyna.ex.user.proto.UpdateUserRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_scyna_user_proto_UpdateUserRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_scyna_user_proto_UpdateUserRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.ex.user.proto.UpdateUserRequest.class,
              io.scyna.ex.user.proto.UpdateUserRequest.Builder.class);
    }

    // Construct using io.scyna.ex.user.proto.UpdateUserRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (userBuilder_ == null) {
        user_ = null;
      } else {
        user_ = null;
        userBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_scyna_user_proto_UpdateUserRequest_descriptor;
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.UpdateUserRequest getDefaultInstanceForType() {
      return io.scyna.ex.user.proto.UpdateUserRequest.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.UpdateUserRequest build() {
      io.scyna.ex.user.proto.UpdateUserRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.UpdateUserRequest buildPartial() {
      io.scyna.ex.user.proto.UpdateUserRequest result = new io.scyna.ex.user.proto.UpdateUserRequest(this);
      if (userBuilder_ == null) {
        result.user_ = user_;
      } else {
        result.user_ = userBuilder_.build();
      }
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
      if (other instanceof io.scyna.ex.user.proto.UpdateUserRequest) {
        return mergeFrom((io.scyna.ex.user.proto.UpdateUserRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.scyna.ex.user.proto.UpdateUserRequest other) {
      if (other == io.scyna.ex.user.proto.UpdateUserRequest.getDefaultInstance())
        return this;
      if (other.hasUser()) {
        mergeUser(other.getUser());
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
      io.scyna.ex.user.proto.UpdateUserRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.scyna.ex.user.proto.UpdateUserRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private io.scyna.ex.user.proto.User user_;
    private com.google.protobuf.SingleFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder> userBuilder_;

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     * 
     * @return Whether the user field is set.
     */
    public boolean hasUser() {
      return userBuilder_ != null || user_ != null;
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     * 
     * @return The user.
     */
    public io.scyna.ex.user.proto.User getUser() {
      if (userBuilder_ == null) {
        return user_ == null ? io.scyna.ex.user.proto.User.getDefaultInstance() : user_;
      } else {
        return userBuilder_.getMessage();
      }
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public Builder setUser(io.scyna.ex.user.proto.User value) {
      if (userBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        user_ = value;
        onChanged();
      } else {
        userBuilder_.setMessage(value);
      }

      return this;
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public Builder setUser(
        io.scyna.ex.user.proto.User.Builder builderForValue) {
      if (userBuilder_ == null) {
        user_ = builderForValue.build();
        onChanged();
      } else {
        userBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public Builder mergeUser(io.scyna.ex.user.proto.User value) {
      if (userBuilder_ == null) {
        if (user_ != null) {
          user_ = io.scyna.ex.user.proto.User.newBuilder(user_).mergeFrom(value).buildPartial();
        } else {
          user_ = value;
        }
        onChanged();
      } else {
        userBuilder_.mergeFrom(value);
      }

      return this;
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public Builder clearUser() {
      if (userBuilder_ == null) {
        user_ = null;
        onChanged();
      } else {
        user_ = null;
        userBuilder_ = null;
      }

      return this;
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public io.scyna.ex.user.proto.User.Builder getUserBuilder() {

      onChanged();
      return getUserFieldBuilder().getBuilder();
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    public io.scyna.ex.user.proto.UserOrBuilder getUserOrBuilder() {
      if (userBuilder_ != null) {
        return userBuilder_.getMessageOrBuilder();
      } else {
        return user_ == null ? io.scyna.ex.user.proto.User.getDefaultInstance() : user_;
      }
    }

    /**
     * <code>.io.scyna.user.proto.User user = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder> getUserFieldBuilder() {
      if (userBuilder_ == null) {
        userBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder>(
            getUser(),
            getParentForChildren(),
            isClean());
        user_ = null;
      }
      return userBuilder_;
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

    // @@protoc_insertion_point(builder_scope:io.scyna.user.proto.UpdateUserRequest)
  }

  // @@protoc_insertion_point(class_scope:io.scyna.user.proto.UpdateUserRequest)
  private static final io.scyna.ex.user.proto.UpdateUserRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.ex.user.proto.UpdateUserRequest();
  }

  public static io.scyna.ex.user.proto.UpdateUserRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateUserRequest> PARSER = new com.google.protobuf.AbstractParser<UpdateUserRequest>() {
    @java.lang.Override
    public UpdateUserRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new UpdateUserRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<UpdateUserRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateUserRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.ex.user.proto.UpdateUserRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
