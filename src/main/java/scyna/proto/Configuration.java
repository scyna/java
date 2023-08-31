// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: session.proto

package scyna.proto;

/**
 * Protobuf type {@code scyna.Configuration}
 */
public  final class Configuration extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:scyna.Configuration)
    ConfigurationOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Configuration.newBuilder() to construct.
  private Configuration(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Configuration() {
    natsUrl_ = "";
    natsUsername_ = "";
    natsPassword_ = "";
    dBHost_ = "";
    dBUsername_ = "";
    dBPassword_ = "";
    dBLocation_ = "";
    dBPemFile_ = "";
    isAWSKeyspaces_ = false;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return scyna.proto.Session.internal_static_scyna_Configuration_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return scyna.proto.Session.internal_static_scyna_Configuration_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            scyna.proto.Configuration.class, scyna.proto.Configuration.Builder.class);
  }

  public static final int NATSURL_FIELD_NUMBER = 1;
  private volatile java.lang.Object natsUrl_;
  /**
   * <code>string NatsUrl = 1;</code>
   */
  public java.lang.String getNatsUrl() {
    java.lang.Object ref = natsUrl_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      natsUrl_ = s;
      return s;
    }
  }
  /**
   * <code>string NatsUrl = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNatsUrlBytes() {
    java.lang.Object ref = natsUrl_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      natsUrl_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NATSUSERNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object natsUsername_;
  /**
   * <code>string NatsUsername = 2;</code>
   */
  public java.lang.String getNatsUsername() {
    java.lang.Object ref = natsUsername_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      natsUsername_ = s;
      return s;
    }
  }
  /**
   * <code>string NatsUsername = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNatsUsernameBytes() {
    java.lang.Object ref = natsUsername_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      natsUsername_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int NATSPASSWORD_FIELD_NUMBER = 3;
  private volatile java.lang.Object natsPassword_;
  /**
   * <code>string NatsPassword = 3;</code>
   */
  public java.lang.String getNatsPassword() {
    java.lang.Object ref = natsPassword_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      natsPassword_ = s;
      return s;
    }
  }
  /**
   * <code>string NatsPassword = 3;</code>
   */
  public com.google.protobuf.ByteString
      getNatsPasswordBytes() {
    java.lang.Object ref = natsPassword_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      natsPassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBHOST_FIELD_NUMBER = 4;
  private volatile java.lang.Object dBHost_;
  /**
   * <code>string DBHost = 4;</code>
   */
  public java.lang.String getDBHost() {
    java.lang.Object ref = dBHost_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dBHost_ = s;
      return s;
    }
  }
  /**
   * <code>string DBHost = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDBHostBytes() {
    java.lang.Object ref = dBHost_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dBHost_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBUSERNAME_FIELD_NUMBER = 5;
  private volatile java.lang.Object dBUsername_;
  /**
   * <code>string DBUsername = 5;</code>
   */
  public java.lang.String getDBUsername() {
    java.lang.Object ref = dBUsername_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dBUsername_ = s;
      return s;
    }
  }
  /**
   * <code>string DBUsername = 5;</code>
   */
  public com.google.protobuf.ByteString
      getDBUsernameBytes() {
    java.lang.Object ref = dBUsername_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dBUsername_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBPASSWORD_FIELD_NUMBER = 6;
  private volatile java.lang.Object dBPassword_;
  /**
   * <code>string DBPassword = 6;</code>
   */
  public java.lang.String getDBPassword() {
    java.lang.Object ref = dBPassword_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dBPassword_ = s;
      return s;
    }
  }
  /**
   * <code>string DBPassword = 6;</code>
   */
  public com.google.protobuf.ByteString
      getDBPasswordBytes() {
    java.lang.Object ref = dBPassword_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dBPassword_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBLOCATION_FIELD_NUMBER = 7;
  private volatile java.lang.Object dBLocation_;
  /**
   * <code>string DBLocation = 7;</code>
   */
  public java.lang.String getDBLocation() {
    java.lang.Object ref = dBLocation_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dBLocation_ = s;
      return s;
    }
  }
  /**
   * <code>string DBLocation = 7;</code>
   */
  public com.google.protobuf.ByteString
      getDBLocationBytes() {
    java.lang.Object ref = dBLocation_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dBLocation_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBPEMFILE_FIELD_NUMBER = 8;
  private volatile java.lang.Object dBPemFile_;
  /**
   * <code>string DBPemFile = 8;</code>
   */
  public java.lang.String getDBPemFile() {
    java.lang.Object ref = dBPemFile_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dBPemFile_ = s;
      return s;
    }
  }
  /**
   * <code>string DBPemFile = 8;</code>
   */
  public com.google.protobuf.ByteString
      getDBPemFileBytes() {
    java.lang.Object ref = dBPemFile_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dBPemFile_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ISAWSKEYSPACES_FIELD_NUMBER = 9;
  private boolean isAWSKeyspaces_;
  /**
   * <code>bool isAWSKeyspaces = 9;</code>
   */
  public boolean getIsAWSKeyspaces() {
    return isAWSKeyspaces_;
  }

  public static scyna.proto.Configuration parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.Configuration parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.Configuration parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.Configuration parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.Configuration parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static scyna.proto.Configuration parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static scyna.proto.Configuration parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.Configuration parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.Configuration parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static scyna.proto.Configuration parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static scyna.proto.Configuration parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static scyna.proto.Configuration parseFrom(
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
  public static Builder newBuilder(scyna.proto.Configuration prototype) {
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
   * Protobuf type {@code scyna.Configuration}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:scyna.Configuration)
      scyna.proto.ConfigurationOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return scyna.proto.Session.internal_static_scyna_Configuration_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return scyna.proto.Session.internal_static_scyna_Configuration_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              scyna.proto.Configuration.class, scyna.proto.Configuration.Builder.class);
    }

    // Construct using scyna.proto.Configuration.newBuilder()
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
      natsUrl_ = "";

      natsUsername_ = "";

      natsPassword_ = "";

      dBHost_ = "";

      dBUsername_ = "";

      dBPassword_ = "";

      dBLocation_ = "";

      dBPemFile_ = "";

      isAWSKeyspaces_ = false;

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return scyna.proto.Session.internal_static_scyna_Configuration_descriptor;
    }

    @java.lang.Override
    public scyna.proto.Configuration getDefaultInstanceForType() {
      return scyna.proto.Configuration.getDefaultInstance();
    }

    @java.lang.Override
    public scyna.proto.Configuration build() {
      scyna.proto.Configuration result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public scyna.proto.Configuration buildPartial() {
      scyna.proto.Configuration result = new scyna.proto.Configuration(this);
      result.natsUrl_ = natsUrl_;
      result.natsUsername_ = natsUsername_;
      result.natsPassword_ = natsPassword_;
      result.dBHost_ = dBHost_;
      result.dBUsername_ = dBUsername_;
      result.dBPassword_ = dBPassword_;
      result.dBLocation_ = dBLocation_;
      result.dBPemFile_ = dBPemFile_;
      result.isAWSKeyspaces_ = isAWSKeyspaces_;
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

    private java.lang.Object natsUrl_ = "";
    /**
     * <code>string NatsUrl = 1;</code>
     */
    public java.lang.String getNatsUrl() {
      java.lang.Object ref = natsUrl_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        natsUrl_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string NatsUrl = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNatsUrlBytes() {
      java.lang.Object ref = natsUrl_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        natsUrl_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string NatsUrl = 1;</code>
     */
    public Builder setNatsUrl(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      natsUrl_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string NatsUrl = 1;</code>
     */
    public Builder clearNatsUrl() {
      
      natsUrl_ = getDefaultInstance().getNatsUrl();
      onChanged();
      return this;
    }
    /**
     * <code>string NatsUrl = 1;</code>
     */
    public Builder setNatsUrlBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      natsUrl_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object natsUsername_ = "";
    /**
     * <code>string NatsUsername = 2;</code>
     */
    public java.lang.String getNatsUsername() {
      java.lang.Object ref = natsUsername_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        natsUsername_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string NatsUsername = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNatsUsernameBytes() {
      java.lang.Object ref = natsUsername_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        natsUsername_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string NatsUsername = 2;</code>
     */
    public Builder setNatsUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      natsUsername_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string NatsUsername = 2;</code>
     */
    public Builder clearNatsUsername() {
      
      natsUsername_ = getDefaultInstance().getNatsUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string NatsUsername = 2;</code>
     */
    public Builder setNatsUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      natsUsername_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object natsPassword_ = "";
    /**
     * <code>string NatsPassword = 3;</code>
     */
    public java.lang.String getNatsPassword() {
      java.lang.Object ref = natsPassword_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        natsPassword_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string NatsPassword = 3;</code>
     */
    public com.google.protobuf.ByteString
        getNatsPasswordBytes() {
      java.lang.Object ref = natsPassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        natsPassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string NatsPassword = 3;</code>
     */
    public Builder setNatsPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      natsPassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string NatsPassword = 3;</code>
     */
    public Builder clearNatsPassword() {
      
      natsPassword_ = getDefaultInstance().getNatsPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string NatsPassword = 3;</code>
     */
    public Builder setNatsPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      natsPassword_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dBHost_ = "";
    /**
     * <code>string DBHost = 4;</code>
     */
    public java.lang.String getDBHost() {
      java.lang.Object ref = dBHost_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dBHost_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string DBHost = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDBHostBytes() {
      java.lang.Object ref = dBHost_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dBHost_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string DBHost = 4;</code>
     */
    public Builder setDBHost(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dBHost_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string DBHost = 4;</code>
     */
    public Builder clearDBHost() {
      
      dBHost_ = getDefaultInstance().getDBHost();
      onChanged();
      return this;
    }
    /**
     * <code>string DBHost = 4;</code>
     */
    public Builder setDBHostBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dBHost_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dBUsername_ = "";
    /**
     * <code>string DBUsername = 5;</code>
     */
    public java.lang.String getDBUsername() {
      java.lang.Object ref = dBUsername_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dBUsername_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string DBUsername = 5;</code>
     */
    public com.google.protobuf.ByteString
        getDBUsernameBytes() {
      java.lang.Object ref = dBUsername_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dBUsername_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string DBUsername = 5;</code>
     */
    public Builder setDBUsername(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dBUsername_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string DBUsername = 5;</code>
     */
    public Builder clearDBUsername() {
      
      dBUsername_ = getDefaultInstance().getDBUsername();
      onChanged();
      return this;
    }
    /**
     * <code>string DBUsername = 5;</code>
     */
    public Builder setDBUsernameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dBUsername_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dBPassword_ = "";
    /**
     * <code>string DBPassword = 6;</code>
     */
    public java.lang.String getDBPassword() {
      java.lang.Object ref = dBPassword_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dBPassword_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string DBPassword = 6;</code>
     */
    public com.google.protobuf.ByteString
        getDBPasswordBytes() {
      java.lang.Object ref = dBPassword_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dBPassword_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string DBPassword = 6;</code>
     */
    public Builder setDBPassword(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dBPassword_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string DBPassword = 6;</code>
     */
    public Builder clearDBPassword() {
      
      dBPassword_ = getDefaultInstance().getDBPassword();
      onChanged();
      return this;
    }
    /**
     * <code>string DBPassword = 6;</code>
     */
    public Builder setDBPasswordBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dBPassword_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dBLocation_ = "";
    /**
     * <code>string DBLocation = 7;</code>
     */
    public java.lang.String getDBLocation() {
      java.lang.Object ref = dBLocation_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dBLocation_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string DBLocation = 7;</code>
     */
    public com.google.protobuf.ByteString
        getDBLocationBytes() {
      java.lang.Object ref = dBLocation_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dBLocation_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string DBLocation = 7;</code>
     */
    public Builder setDBLocation(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dBLocation_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string DBLocation = 7;</code>
     */
    public Builder clearDBLocation() {
      
      dBLocation_ = getDefaultInstance().getDBLocation();
      onChanged();
      return this;
    }
    /**
     * <code>string DBLocation = 7;</code>
     */
    public Builder setDBLocationBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dBLocation_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dBPemFile_ = "";
    /**
     * <code>string DBPemFile = 8;</code>
     */
    public java.lang.String getDBPemFile() {
      java.lang.Object ref = dBPemFile_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dBPemFile_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string DBPemFile = 8;</code>
     */
    public com.google.protobuf.ByteString
        getDBPemFileBytes() {
      java.lang.Object ref = dBPemFile_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dBPemFile_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string DBPemFile = 8;</code>
     */
    public Builder setDBPemFile(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dBPemFile_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string DBPemFile = 8;</code>
     */
    public Builder clearDBPemFile() {
      
      dBPemFile_ = getDefaultInstance().getDBPemFile();
      onChanged();
      return this;
    }
    /**
     * <code>string DBPemFile = 8;</code>
     */
    public Builder setDBPemFileBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dBPemFile_ = value;
      onChanged();
      return this;
    }

    private boolean isAWSKeyspaces_ ;
    /**
     * <code>bool isAWSKeyspaces = 9;</code>
     */
    public boolean getIsAWSKeyspaces() {
      return isAWSKeyspaces_;
    }
    /**
     * <code>bool isAWSKeyspaces = 9;</code>
     */
    public Builder setIsAWSKeyspaces(boolean value) {
      
      isAWSKeyspaces_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool isAWSKeyspaces = 9;</code>
     */
    public Builder clearIsAWSKeyspaces() {
      
      isAWSKeyspaces_ = false;
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


    // @@protoc_insertion_point(builder_scope:scyna.Configuration)
  }

  // @@protoc_insertion_point(class_scope:scyna.Configuration)
  private static final scyna.proto.Configuration DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new scyna.proto.Configuration();
  }

  public static scyna.proto.Configuration getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Configuration>
      PARSER = new com.google.protobuf.AbstractParser<Configuration>() {
    @java.lang.Override
    public Configuration parsePartialFrom(
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

  public static com.google.protobuf.Parser<Configuration> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Configuration> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public scyna.proto.Configuration getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

