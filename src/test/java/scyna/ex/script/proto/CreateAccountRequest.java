// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: account.proto

package scyna.ex.script.proto;

/**
 * <pre>
 * CREATE
 * </pre>
 *
 * Protobuf type {@code io.scyna.account.proto.CreateAccountRequest}
 */
public final class CreateAccountRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:io.scyna.account.proto.CreateAccountRequest)
        CreateAccountRequestOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use CreateAccountRequest.newBuilder() to construct.
    private CreateAccountRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private CreateAccountRequest() {
        email_ = "";
        name_ = "";
        password_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new CreateAccountRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private CreateAccountRequest(
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
                        java.lang.String s = input.readStringRequireUtf8();

                        email_ = s;
                        break;
                    }
                    case 18: {
                        java.lang.String s = input.readStringRequireUtf8();

                        name_ = s;
                        break;
                    }
                    case 26: {
                        java.lang.String s = input.readStringRequireUtf8();

                        password_ = s;
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
        return scyna.ex.script.proto.Account.internal_static_io_scyna_account_proto_CreateAccountRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return scyna.ex.script.proto.Account.internal_static_io_scyna_account_proto_CreateAccountRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        scyna.ex.script.proto.CreateAccountRequest.class,
                        scyna.ex.script.proto.CreateAccountRequest.Builder.class);
    }

    public static final int EMAIL_FIELD_NUMBER = 1;
    private volatile java.lang.Object email_;

    /**
     * <code>string email = 1;</code>
     * 
     * @return The email.
     */
    @java.lang.Override
    public java.lang.String getEmail() {
        java.lang.Object ref = email_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            email_ = s;
            return s;
        }
    }

    /**
     * <code>string email = 1;</code>
     * 
     * @return The bytes for email.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getEmailBytes() {
        java.lang.Object ref = email_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            email_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int NAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object name_;

    /**
     * <code>string name = 2;</code>
     * 
     * @return The name.
     */
    @java.lang.Override
    public java.lang.String getName() {
        java.lang.Object ref = name_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            name_ = s;
            return s;
        }
    }

    /**
     * <code>string name = 2;</code>
     * 
     * @return The bytes for name.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getNameBytes() {
        java.lang.Object ref = name_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            name_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int PASSWORD_FIELD_NUMBER = 3;
    private volatile java.lang.Object password_;

    /**
     * <code>string password = 3;</code>
     * 
     * @return The password.
     */
    @java.lang.Override
    public java.lang.String getPassword() {
        java.lang.Object ref = password_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            password_ = s;
            return s;
        }
    }

    /**
     * <code>string password = 3;</code>
     * 
     * @return The bytes for password.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getPasswordBytes() {
        java.lang.Object ref = password_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            password_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
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
        if (!getEmailBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, email_);
        }
        if (!getNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, name_);
        }
        if (!getPasswordBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 3, password_);
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1)
            return size;

        size = 0;
        if (!getEmailBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, email_);
        }
        if (!getNameBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, name_);
        }
        if (!getPasswordBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, password_);
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
        if (!(obj instanceof scyna.ex.script.proto.CreateAccountRequest)) {
            return super.equals(obj);
        }
        scyna.ex.script.proto.CreateAccountRequest other = (scyna.ex.script.proto.CreateAccountRequest) obj;

        if (!getEmail()
                .equals(other.getEmail()))
            return false;
        if (!getName()
                .equals(other.getName()))
            return false;
        if (!getPassword()
                .equals(other.getPassword()))
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
        hash = (37 * hash) + EMAIL_FIELD_NUMBER;
        hash = (53 * hash) + getEmail().hashCode();
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getName().hashCode();
        hash = (37 * hash) + PASSWORD_FIELD_NUMBER;
        hash = (53 * hash) + getPassword().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.ex.script.proto.CreateAccountRequest parseFrom(
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

    public static Builder newBuilder(scyna.ex.script.proto.CreateAccountRequest prototype) {
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
     * CREATE
     * </pre>
     *
     * Protobuf type {@code io.scyna.account.proto.CreateAccountRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:io.scyna.account.proto.CreateAccountRequest)
            scyna.ex.script.proto.CreateAccountRequestOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return scyna.ex.script.proto.Account.internal_static_io_scyna_account_proto_CreateAccountRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return scyna.ex.script.proto.Account.internal_static_io_scyna_account_proto_CreateAccountRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            scyna.ex.script.proto.CreateAccountRequest.class,
                            scyna.ex.script.proto.CreateAccountRequest.Builder.class);
        }

        // Construct using io.scyna.ex.script.proto.CreateAccountRequest.newBuilder()
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
            email_ = "";

            name_ = "";

            password_ = "";

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return scyna.ex.script.proto.Account.internal_static_io_scyna_account_proto_CreateAccountRequest_descriptor;
        }

        @java.lang.Override
        public scyna.ex.script.proto.CreateAccountRequest getDefaultInstanceForType() {
            return scyna.ex.script.proto.CreateAccountRequest.getDefaultInstance();
        }

        @java.lang.Override
        public scyna.ex.script.proto.CreateAccountRequest build() {
            scyna.ex.script.proto.CreateAccountRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public scyna.ex.script.proto.CreateAccountRequest buildPartial() {
            scyna.ex.script.proto.CreateAccountRequest result = new scyna.ex.script.proto.CreateAccountRequest(this);
            result.email_ = email_;
            result.name_ = name_;
            result.password_ = password_;
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
            if (other instanceof scyna.ex.script.proto.CreateAccountRequest) {
                return mergeFrom((scyna.ex.script.proto.CreateAccountRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(scyna.ex.script.proto.CreateAccountRequest other) {
            if (other == scyna.ex.script.proto.CreateAccountRequest.getDefaultInstance())
                return this;
            if (!other.getEmail().isEmpty()) {
                email_ = other.email_;
                onChanged();
            }
            if (!other.getName().isEmpty()) {
                name_ = other.name_;
                onChanged();
            }
            if (!other.getPassword().isEmpty()) {
                password_ = other.password_;
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
            scyna.ex.script.proto.CreateAccountRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (scyna.ex.script.proto.CreateAccountRequest) e.getUnfinishedMessage();
                throw e.unwrapIOException();
            } finally {
                if (parsedMessage != null) {
                    mergeFrom(parsedMessage);
                }
            }
            return this;
        }

        private java.lang.Object email_ = "";

        /**
         * <code>string email = 1;</code>
         * 
         * @return The email.
         */
        public java.lang.String getEmail() {
            java.lang.Object ref = email_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                email_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string email = 1;</code>
         * 
         * @return The bytes for email.
         */
        public com.google.protobuf.ByteString getEmailBytes() {
            java.lang.Object ref = email_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                email_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string email = 1;</code>
         * 
         * @param value
         *            The email to set.
         * @return This builder for chaining.
         */
        public Builder setEmail(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            email_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string email = 1;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearEmail() {

            email_ = getDefaultInstance().getEmail();
            onChanged();
            return this;
        }

        /**
         * <code>string email = 1;</code>
         * 
         * @param value
         *            The bytes for email to set.
         * @return This builder for chaining.
         */
        public Builder setEmailBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            email_ = value;
            onChanged();
            return this;
        }

        private java.lang.Object name_ = "";

        /**
         * <code>string name = 2;</code>
         * 
         * @return The name.
         */
        public java.lang.String getName() {
            java.lang.Object ref = name_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                name_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string name = 2;</code>
         * 
         * @return The bytes for name.
         */
        public com.google.protobuf.ByteString getNameBytes() {
            java.lang.Object ref = name_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                name_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string name = 2;</code>
         * 
         * @param value
         *            The name to set.
         * @return This builder for chaining.
         */
        public Builder setName(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            name_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string name = 2;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearName() {

            name_ = getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /**
         * <code>string name = 2;</code>
         * 
         * @param value
         *            The bytes for name to set.
         * @return This builder for chaining.
         */
        public Builder setNameBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            name_ = value;
            onChanged();
            return this;
        }

        private java.lang.Object password_ = "";

        /**
         * <code>string password = 3;</code>
         * 
         * @return The password.
         */
        public java.lang.String getPassword() {
            java.lang.Object ref = password_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                password_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string password = 3;</code>
         * 
         * @return The bytes for password.
         */
        public com.google.protobuf.ByteString getPasswordBytes() {
            java.lang.Object ref = password_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                password_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string password = 3;</code>
         * 
         * @param value
         *            The password to set.
         * @return This builder for chaining.
         */
        public Builder setPassword(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            password_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string password = 3;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearPassword() {

            password_ = getDefaultInstance().getPassword();
            onChanged();
            return this;
        }

        /**
         * <code>string password = 3;</code>
         * 
         * @param value
         *            The bytes for password to set.
         * @return This builder for chaining.
         */
        public Builder setPasswordBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            password_ = value;
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

        // @@protoc_insertion_point(builder_scope:io.scyna.account.proto.CreateAccountRequest)
    }

    // @@protoc_insertion_point(class_scope:io.scyna.account.proto.CreateAccountRequest)
    private static final scyna.ex.script.proto.CreateAccountRequest DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new scyna.ex.script.proto.CreateAccountRequest();
    }

    public static scyna.ex.script.proto.CreateAccountRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CreateAccountRequest> PARSER = new com.google.protobuf.AbstractParser<CreateAccountRequest>() {
        @java.lang.Override
        public CreateAccountRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new CreateAccountRequest(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<CreateAccountRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CreateAccountRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public scyna.ex.script.proto.CreateAccountRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
