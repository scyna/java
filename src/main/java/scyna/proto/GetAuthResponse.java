// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package scyna.proto;

/**
 * Protobuf type {@code scyna.GetAuthResponse}
 */
public final class GetAuthResponse extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:scyna.GetAuthResponse)
        GetAuthResponseOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use GetAuthResponse.newBuilder() to construct.
    private GetAuthResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private GetAuthResponse() {
        token_ = "";
        userID_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new GetAuthResponse();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
        return scyna.proto.Engine.internal_static_scyna_GetAuthResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return scyna.proto.Engine.internal_static_scyna_GetAuthResponse_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        scyna.proto.GetAuthResponse.class, scyna.proto.GetAuthResponse.Builder.class);
    }

    public static final int TOKEN_FIELD_NUMBER = 1;
    private volatile java.lang.Object token_;

    /**
     * <code>string Token = 1;</code>
     * 
     * @return The token.
     */
    @java.lang.Override
    public java.lang.String getToken() {
        java.lang.Object ref = token_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            token_ = s;
            return s;
        }
    }

    /**
     * <code>string Token = 1;</code>
     * 
     * @return The bytes for token.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getTokenBytes() {
        java.lang.Object ref = token_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            token_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int EXPIRED_FIELD_NUMBER = 2;
    private long expired_;

    /**
     * <code>uint64 Expired = 2;</code>
     * 
     * @return The expired.
     */
    @java.lang.Override
    public long getExpired() {
        return expired_;
    }

    public static final int USERID_FIELD_NUMBER = 3;
    private volatile java.lang.Object userID_;

    /**
     * <code>string UserID = 3;</code>
     * 
     * @return The userID.
     */
    @java.lang.Override
    public java.lang.String getUserID() {
        java.lang.Object ref = userID_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            userID_ = s;
            return s;
        }
    }

    /**
     * <code>string UserID = 3;</code>
     * 
     * @return The bytes for userID.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getUserIDBytes() {
        java.lang.Object ref = userID_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            userID_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.proto.GetAuthResponse parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.proto.GetAuthResponse parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.proto.GetAuthResponse parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static scyna.proto.GetAuthResponse parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.proto.GetAuthResponse parseFrom(
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

    public static Builder newBuilder(scyna.proto.GetAuthResponse prototype) {
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
     * Protobuf type {@code scyna.GetAuthResponse}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:scyna.GetAuthResponse)
            scyna.proto.GetAuthResponseOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return scyna.proto.Engine.internal_static_scyna_GetAuthResponse_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return scyna.proto.Engine.internal_static_scyna_GetAuthResponse_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            scyna.proto.GetAuthResponse.class, scyna.proto.GetAuthResponse.Builder.class);
        }

        // Construct using io.scyna.proto.GetAuthResponse.newBuilder()
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
            token_ = "";

            expired_ = 0L;

            userID_ = "";

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return scyna.proto.Engine.internal_static_scyna_GetAuthResponse_descriptor;
        }

        @java.lang.Override
        public scyna.proto.GetAuthResponse getDefaultInstanceForType() {
            return scyna.proto.GetAuthResponse.getDefaultInstance();
        }

        @java.lang.Override
        public scyna.proto.GetAuthResponse build() {
            scyna.proto.GetAuthResponse result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public scyna.proto.GetAuthResponse buildPartial() {
            scyna.proto.GetAuthResponse result = new scyna.proto.GetAuthResponse(this);
            result.token_ = token_;
            result.expired_ = expired_;
            result.userID_ = userID_;
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

        private java.lang.Object token_ = "";

        /**
         * <code>string Token = 1;</code>
         * 
         * @return The token.
         */
        public java.lang.String getToken() {
            java.lang.Object ref = token_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                token_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string Token = 1;</code>
         * 
         * @return The bytes for token.
         */
        public com.google.protobuf.ByteString getTokenBytes() {
            java.lang.Object ref = token_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                token_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string Token = 1;</code>
         * 
         * @param value
         *            The token to set.
         * @return This builder for chaining.
         */
        public Builder setToken(
                java.lang.String value) {
            if (value == null) {
                throw new NullPointerException();
            }

            token_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>string Token = 1;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearToken() {

            token_ = getDefaultInstance().getToken();
            onChanged();
            return this;
        }

        /**
         * <code>string Token = 1;</code>
         * 
         * @param value
         *            The bytes for token to set.
         * @return This builder for chaining.
         */
        public Builder setTokenBytes(
                com.google.protobuf.ByteString value) {
            if (value == null) {
                throw new NullPointerException();
            }
            checkByteStringIsUtf8(value);

            token_ = value;
            onChanged();
            return this;
        }

        private long expired_;

        /**
         * <code>uint64 Expired = 2;</code>
         * 
         * @return The expired.
         */
        @java.lang.Override
        public long getExpired() {
            return expired_;
        }

        /**
         * <code>uint64 Expired = 2;</code>
         * 
         * @param value
         *            The expired to set.
         * @return This builder for chaining.
         */
        public Builder setExpired(long value) {

            expired_ = value;
            onChanged();
            return this;
        }

        /**
         * <code>uint64 Expired = 2;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearExpired() {

            expired_ = 0L;
            onChanged();
            return this;
        }

        private java.lang.Object userID_ = "";

        /**
         * <code>string UserID = 3;</code>
         * 
         * @return The userID.
         */
        public java.lang.String getUserID() {
            java.lang.Object ref = userID_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                userID_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string UserID = 3;</code>
         * 
         * @return The bytes for userID.
         */
        public com.google.protobuf.ByteString getUserIDBytes() {
            java.lang.Object ref = userID_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                userID_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string UserID = 3;</code>
         * 
         * @param value
         *            The userID to set.
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
         * 
         * @return This builder for chaining.
         */
        public Builder clearUserID() {

            userID_ = getDefaultInstance().getUserID();
            onChanged();
            return this;
        }

        /**
         * <code>string UserID = 3;</code>
         * 
         * @param value
         *            The bytes for userID to set.
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

        // @@protoc_insertion_point(builder_scope:scyna.GetAuthResponse)
    }

    // @@protoc_insertion_point(class_scope:scyna.GetAuthResponse)
    private static final scyna.proto.GetAuthResponse DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new scyna.proto.GetAuthResponse();
    }

    public static scyna.proto.GetAuthResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<GetAuthResponse> PARSER = new com.google.protobuf.AbstractParser<GetAuthResponse>() {
        @java.lang.Override
        public GetAuthResponse parsePartialFrom(
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

    public static com.google.protobuf.Parser<GetAuthResponse> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<GetAuthResponse> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public scyna.proto.GetAuthResponse getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
