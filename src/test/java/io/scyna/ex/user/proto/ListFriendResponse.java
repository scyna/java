// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package io.scyna.ex.user.proto;

/**
 * Protobuf type {@code io.velo.user.proto.ListFriendResponse}
 */
public final class ListFriendResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:io.velo.user.proto.ListFriendResponse)
    ListFriendResponseOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use ListFriendResponse.newBuilder() to construct.
  private ListFriendResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private ListFriendResponse() {
    friends_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({ "unused" })
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new ListFriendResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  private ListFriendResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
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
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              friends_ = new java.util.ArrayList<io.scyna.ex.user.proto.User>();
              mutable_bitField0_ |= 0x00000001;
            }
            friends_.add(
                input.readMessage(io.scyna.ex.user.proto.User.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        friends_ = java.util.Collections.unmodifiableList(friends_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_velo_user_proto_ListFriendResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
    return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_velo_user_proto_ListFriendResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.scyna.ex.user.proto.ListFriendResponse.class, io.scyna.ex.user.proto.ListFriendResponse.Builder.class);
  }

  public static final int FRIENDS_FIELD_NUMBER = 1;
  private java.util.List<io.scyna.ex.user.proto.User> friends_;

  /**
   * <code>repeated .io.velo.user.proto.User friends = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.scyna.ex.user.proto.User> getFriendsList() {
    return friends_;
  }

  /**
   * <code>repeated .io.velo.user.proto.User friends = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.scyna.ex.user.proto.UserOrBuilder> getFriendsOrBuilderList() {
    return friends_;
  }

  /**
   * <code>repeated .io.velo.user.proto.User friends = 1;</code>
   */
  @java.lang.Override
  public int getFriendsCount() {
    return friends_.size();
  }

  /**
   * <code>repeated .io.velo.user.proto.User friends = 1;</code>
   */
  @java.lang.Override
  public io.scyna.ex.user.proto.User getFriends(int index) {
    return friends_.get(index);
  }

  /**
   * <code>repeated .io.velo.user.proto.User friends = 1;</code>
   */
  @java.lang.Override
  public io.scyna.ex.user.proto.UserOrBuilder getFriendsOrBuilder(
      int index) {
    return friends_.get(index);
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
    for (int i = 0; i < friends_.size(); i++) {
      output.writeMessage(1, friends_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1)
      return size;

    size = 0;
    for (int i = 0; i < friends_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, friends_.get(i));
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
    if (!(obj instanceof io.scyna.ex.user.proto.ListFriendResponse)) {
      return super.equals(obj);
    }
    io.scyna.ex.user.proto.ListFriendResponse other = (io.scyna.ex.user.proto.ListFriendResponse) obj;

    if (!getFriendsList()
        .equals(other.getFriendsList()))
      return false;
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
    if (getFriendsCount() > 0) {
      hash = (37 * hash) + FRIENDS_FIELD_NUMBER;
      hash = (53 * hash) + getFriendsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }

  public static io.scyna.ex.user.proto.ListFriendResponse parseFrom(
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

  public static Builder newBuilder(io.scyna.ex.user.proto.ListFriendResponse prototype) {
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
   * Protobuf type {@code io.velo.user.proto.ListFriendResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:io.velo.user.proto.ListFriendResponse)
      io.scyna.ex.user.proto.ListFriendResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_velo_user_proto_ListFriendResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_velo_user_proto_ListFriendResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.scyna.ex.user.proto.ListFriendResponse.class, io.scyna.ex.user.proto.ListFriendResponse.Builder.class);
    }

    // Construct using io.velo.user.proto.ListFriendResponse.newBuilder()
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
        getFriendsFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (friendsBuilder_ == null) {
        friends_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        friendsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return io.scyna.ex.user.proto.UserOuterClass.internal_static_io_velo_user_proto_ListFriendResponse_descriptor;
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.ListFriendResponse getDefaultInstanceForType() {
      return io.scyna.ex.user.proto.ListFriendResponse.getDefaultInstance();
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.ListFriendResponse build() {
      io.scyna.ex.user.proto.ListFriendResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.scyna.ex.user.proto.ListFriendResponse buildPartial() {
      io.scyna.ex.user.proto.ListFriendResponse result = new io.scyna.ex.user.proto.ListFriendResponse(this);
      int from_bitField0_ = bitField0_;
      if (friendsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          friends_ = java.util.Collections.unmodifiableList(friends_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.friends_ = friends_;
      } else {
        result.friends_ = friendsBuilder_.build();
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
      if (other instanceof io.scyna.ex.user.proto.ListFriendResponse) {
        return mergeFrom((io.scyna.ex.user.proto.ListFriendResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.scyna.ex.user.proto.ListFriendResponse other) {
      if (other == io.scyna.ex.user.proto.ListFriendResponse.getDefaultInstance())
        return this;
      if (friendsBuilder_ == null) {
        if (!other.friends_.isEmpty()) {
          if (friends_.isEmpty()) {
            friends_ = other.friends_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureFriendsIsMutable();
            friends_.addAll(other.friends_);
          }
          onChanged();
        }
      } else {
        if (!other.friends_.isEmpty()) {
          if (friendsBuilder_.isEmpty()) {
            friendsBuilder_.dispose();
            friendsBuilder_ = null;
            friends_ = other.friends_;
            bitField0_ = (bitField0_ & ~0x00000001);
            friendsBuilder_ = com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ? getFriendsFieldBuilder()
                : null;
          } else {
            friendsBuilder_.addAllMessages(other.friends_);
          }
        }
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
      io.scyna.ex.user.proto.ListFriendResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (io.scyna.ex.user.proto.ListFriendResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int bitField0_;

    private java.util.List<io.scyna.ex.user.proto.User> friends_ = java.util.Collections.emptyList();

    private void ensureFriendsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        friends_ = new java.util.ArrayList<io.scyna.ex.user.proto.User>(friends_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder> friendsBuilder_;

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public java.util.List<io.scyna.ex.user.proto.User> getFriendsList() {
      if (friendsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(friends_);
      } else {
        return friendsBuilder_.getMessageList();
      }
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public int getFriendsCount() {
      if (friendsBuilder_ == null) {
        return friends_.size();
      } else {
        return friendsBuilder_.getCount();
      }
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public io.scyna.ex.user.proto.User getFriends(int index) {
      if (friendsBuilder_ == null) {
        return friends_.get(index);
      } else {
        return friendsBuilder_.getMessage(index);
      }
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder setFriends(
        int index, io.scyna.ex.user.proto.User value) {
      if (friendsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFriendsIsMutable();
        friends_.set(index, value);
        onChanged();
      } else {
        friendsBuilder_.setMessage(index, value);
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder setFriends(
        int index, io.scyna.ex.user.proto.User.Builder builderForValue) {
      if (friendsBuilder_ == null) {
        ensureFriendsIsMutable();
        friends_.set(index, builderForValue.build());
        onChanged();
      } else {
        friendsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder addFriends(io.scyna.ex.user.proto.User value) {
      if (friendsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFriendsIsMutable();
        friends_.add(value);
        onChanged();
      } else {
        friendsBuilder_.addMessage(value);
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder addFriends(
        int index, io.scyna.ex.user.proto.User value) {
      if (friendsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFriendsIsMutable();
        friends_.add(index, value);
        onChanged();
      } else {
        friendsBuilder_.addMessage(index, value);
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder addFriends(
        io.scyna.ex.user.proto.User.Builder builderForValue) {
      if (friendsBuilder_ == null) {
        ensureFriendsIsMutable();
        friends_.add(builderForValue.build());
        onChanged();
      } else {
        friendsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder addFriends(
        int index, io.scyna.ex.user.proto.User.Builder builderForValue) {
      if (friendsBuilder_ == null) {
        ensureFriendsIsMutable();
        friends_.add(index, builderForValue.build());
        onChanged();
      } else {
        friendsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder addAllFriends(
        java.lang.Iterable<? extends io.scyna.ex.user.proto.User> values) {
      if (friendsBuilder_ == null) {
        ensureFriendsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, friends_);
        onChanged();
      } else {
        friendsBuilder_.addAllMessages(values);
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder clearFriends() {
      if (friendsBuilder_ == null) {
        friends_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        friendsBuilder_.clear();
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public Builder removeFriends(int index) {
      if (friendsBuilder_ == null) {
        ensureFriendsIsMutable();
        friends_.remove(index);
        onChanged();
      } else {
        friendsBuilder_.remove(index);
      }
      return this;
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public io.scyna.ex.user.proto.User.Builder getFriendsBuilder(
        int index) {
      return getFriendsFieldBuilder().getBuilder(index);
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public io.scyna.ex.user.proto.UserOrBuilder getFriendsOrBuilder(
        int index) {
      if (friendsBuilder_ == null) {
        return friends_.get(index);
      } else {
        return friendsBuilder_.getMessageOrBuilder(index);
      }
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public java.util.List<? extends io.scyna.ex.user.proto.UserOrBuilder> getFriendsOrBuilderList() {
      if (friendsBuilder_ != null) {
        return friendsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(friends_);
      }
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public io.scyna.ex.user.proto.User.Builder addFriendsBuilder() {
      return getFriendsFieldBuilder().addBuilder(
          io.scyna.ex.user.proto.User.getDefaultInstance());
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public io.scyna.ex.user.proto.User.Builder addFriendsBuilder(
        int index) {
      return getFriendsFieldBuilder().addBuilder(
          index, io.scyna.ex.user.proto.User.getDefaultInstance());
    }

    /**
     * <code>repeated .io.velo.user.proto.User friends = 1;</code>
     */
    public java.util.List<io.scyna.ex.user.proto.User.Builder> getFriendsBuilderList() {
      return getFriendsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder> getFriendsFieldBuilder() {
      if (friendsBuilder_ == null) {
        friendsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<io.scyna.ex.user.proto.User, io.scyna.ex.user.proto.User.Builder, io.scyna.ex.user.proto.UserOrBuilder>(
            friends_,
            ((bitField0_ & 0x00000001) != 0),
            getParentForChildren(),
            isClean());
        friends_ = null;
      }
      return friendsBuilder_;
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

    // @@protoc_insertion_point(builder_scope:io.velo.user.proto.ListFriendResponse)
  }

  // @@protoc_insertion_point(class_scope:io.velo.user.proto.ListFriendResponse)
  private static final io.scyna.ex.user.proto.ListFriendResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.scyna.ex.user.proto.ListFriendResponse();
  }

  public static io.scyna.ex.user.proto.ListFriendResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ListFriendResponse> PARSER = new com.google.protobuf.AbstractParser<ListFriendResponse>() {
    @java.lang.Override
    public ListFriendResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ListFriendResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ListFriendResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ListFriendResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.scyna.ex.user.proto.ListFriendResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
