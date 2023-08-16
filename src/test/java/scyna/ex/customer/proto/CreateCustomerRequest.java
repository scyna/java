// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer.proto

package scyna.ex.customer.proto;

/**
 * Protobuf type {@code io.scyna.customer.proto.CreateCustomerRequest}
 */
public final class CreateCustomerRequest extends
        com.google.protobuf.GeneratedMessageV3 implements
        // @@protoc_insertion_point(message_implements:io.scyna.customer.proto.CreateCustomerRequest)
        CreateCustomerRequestOrBuilder {
    private static final long serialVersionUID = 0L;

    // Use CreateCustomerRequest.newBuilder() to construct.
    private CreateCustomerRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
        super(builder);
    }

    private CreateCustomerRequest() {
        iDType_ = "";
        iDNumber_ = "";
        name_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({ "unused" })
    protected java.lang.Object newInstance(
            UnusedPrivateParameter unused) {
        return new CreateCustomerRequest();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
        return this.unknownFields;
    }

    private CreateCustomerRequest(
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

                        iDType_ = s;
                        break;
                    }
                    case 18: {
                        java.lang.String s = input.readStringRequireUtf8();

                        iDNumber_ = s;
                        break;
                    }
                    case 26: {
                        java.lang.String s = input.readStringRequireUtf8();

                        name_ = s;
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
        return scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_CreateCustomerRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
        return scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_CreateCustomerRequest_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        scyna.ex.customer.proto.CreateCustomerRequest.class,
                        scyna.ex.customer.proto.CreateCustomerRequest.Builder.class);
    }

    public static final int IDTYPE_FIELD_NUMBER = 1;
    private volatile java.lang.Object iDType_;

    /**
     * <code>string IDType = 1;</code>
     * 
     * @return The iDType.
     */
    @java.lang.Override
    public java.lang.String getIDType() {
        java.lang.Object ref = iDType_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            iDType_ = s;
            return s;
        }
    }

    /**
     * <code>string IDType = 1;</code>
     * 
     * @return The bytes for iDType.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getIDTypeBytes() {
        java.lang.Object ref = iDType_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
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
     * 
     * @return The iDNumber.
     */
    @java.lang.Override
    public java.lang.String getIDNumber() {
        java.lang.Object ref = iDNumber_;
        if (ref instanceof java.lang.String) {
            return (java.lang.String) ref;
        } else {
            com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
            java.lang.String s = bs.toStringUtf8();
            iDNumber_ = s;
            return s;
        }
    }

    /**
     * <code>string IDNumber = 2;</code>
     * 
     * @return The bytes for iDNumber.
     */
    @java.lang.Override
    public com.google.protobuf.ByteString getIDNumberBytes() {
        java.lang.Object ref = iDNumber_;
        if (ref instanceof java.lang.String) {
            com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                    (java.lang.String) ref);
            iDNumber_ = b;
            return b;
        } else {
            return (com.google.protobuf.ByteString) ref;
        }
    }

    public static final int NAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object name_;

    /**
     * <code>string Name = 3;</code>
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
     * <code>string Name = 3;</code>
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
        if (!getIDTypeBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 1, iDType_);
        }
        if (!getIDNumberBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 2, iDNumber_);
        }
        if (!getNameBytes().isEmpty()) {
            com.google.protobuf.GeneratedMessageV3.writeString(output, 3, name_);
        }
        unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
        int size = memoizedSize;
        if (size != -1)
            return size;

        size = 0;
        if (!getIDTypeBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, iDType_);
        }
        if (!getIDNumberBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, iDNumber_);
        }
        if (!getNameBytes().isEmpty()) {
            size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, name_);
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
        if (!(obj instanceof scyna.ex.customer.proto.CreateCustomerRequest)) {
            return super.equals(obj);
        }
        scyna.ex.customer.proto.CreateCustomerRequest other = (scyna.ex.customer.proto.CreateCustomerRequest) obj;

        if (!getIDType()
                .equals(other.getIDType()))
            return false;
        if (!getIDNumber()
                .equals(other.getIDNumber()))
            return false;
        if (!getName()
                .equals(other.getName()))
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
        hash = (37 * hash) + IDTYPE_FIELD_NUMBER;
        hash = (53 * hash) + getIDType().hashCode();
        hash = (37 * hash) + IDNUMBER_FIELD_NUMBER;
        hash = (53 * hash) + getIDNumber().hashCode();
        hash = (37 * hash) + NAME_FIELD_NUMBER;
        hash = (53 * hash) + getName().hashCode();
        hash = (29 * hash) + unknownFields.hashCode();
        memoizedHashCode = hash;
        return hash;
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            java.nio.ByteBuffer data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            java.nio.ByteBuffer data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
        return PARSER.parseFrom(data, extensionRegistry);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
        return com.google.protobuf.GeneratedMessageV3
                .parseWithIOException(PARSER, input);
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest parseFrom(
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

    public static Builder newBuilder(scyna.ex.customer.proto.CreateCustomerRequest prototype) {
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
     * Protobuf type {@code io.scyna.customer.proto.CreateCustomerRequest}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:io.scyna.customer.proto.CreateCustomerRequest)
            scyna.ex.customer.proto.CreateCustomerRequestOrBuilder {
        public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
            return scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_CreateCustomerRequest_descriptor;
        }

        @java.lang.Override
        protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_CreateCustomerRequest_fieldAccessorTable
                    .ensureFieldAccessorsInitialized(
                            scyna.ex.customer.proto.CreateCustomerRequest.class,
                            scyna.ex.customer.proto.CreateCustomerRequest.Builder.class);
        }

        // Construct using io.scyna.ex.customer.proto.CreateCustomerRequest.newBuilder()
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
            iDType_ = "";

            iDNumber_ = "";

            name_ = "";

            return this;
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
            return scyna.ex.customer.proto.Customer.internal_static_io_scyna_customer_proto_CreateCustomerRequest_descriptor;
        }

        @java.lang.Override
        public scyna.ex.customer.proto.CreateCustomerRequest getDefaultInstanceForType() {
            return scyna.ex.customer.proto.CreateCustomerRequest.getDefaultInstance();
        }

        @java.lang.Override
        public scyna.ex.customer.proto.CreateCustomerRequest build() {
            scyna.ex.customer.proto.CreateCustomerRequest result = buildPartial();
            if (!result.isInitialized()) {
                throw newUninitializedMessageException(result);
            }
            return result;
        }

        @java.lang.Override
        public scyna.ex.customer.proto.CreateCustomerRequest buildPartial() {
            scyna.ex.customer.proto.CreateCustomerRequest result = new scyna.ex.customer.proto.CreateCustomerRequest(
                    this);
            result.iDType_ = iDType_;
            result.iDNumber_ = iDNumber_;
            result.name_ = name_;
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
            if (other instanceof scyna.ex.customer.proto.CreateCustomerRequest) {
                return mergeFrom((scyna.ex.customer.proto.CreateCustomerRequest) other);
            } else {
                super.mergeFrom(other);
                return this;
            }
        }

        public Builder mergeFrom(scyna.ex.customer.proto.CreateCustomerRequest other) {
            if (other == scyna.ex.customer.proto.CreateCustomerRequest.getDefaultInstance())
                return this;
            if (!other.getIDType().isEmpty()) {
                iDType_ = other.iDType_;
                onChanged();
            }
            if (!other.getIDNumber().isEmpty()) {
                iDNumber_ = other.iDNumber_;
                onChanged();
            }
            if (!other.getName().isEmpty()) {
                name_ = other.name_;
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
            scyna.ex.customer.proto.CreateCustomerRequest parsedMessage = null;
            try {
                parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
            } catch (com.google.protobuf.InvalidProtocolBufferException e) {
                parsedMessage = (scyna.ex.customer.proto.CreateCustomerRequest) e.getUnfinishedMessage();
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
         * 
         * @return The iDType.
         */
        public java.lang.String getIDType() {
            java.lang.Object ref = iDType_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                iDType_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string IDType = 1;</code>
         * 
         * @return The bytes for iDType.
         */
        public com.google.protobuf.ByteString getIDTypeBytes() {
            java.lang.Object ref = iDType_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                iDType_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string IDType = 1;</code>
         * 
         * @param value
         *            The iDType to set.
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
         * 
         * @return This builder for chaining.
         */
        public Builder clearIDType() {

            iDType_ = getDefaultInstance().getIDType();
            onChanged();
            return this;
        }

        /**
         * <code>string IDType = 1;</code>
         * 
         * @param value
         *            The bytes for iDType to set.
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
         * 
         * @return The iDNumber.
         */
        public java.lang.String getIDNumber() {
            java.lang.Object ref = iDNumber_;
            if (!(ref instanceof java.lang.String)) {
                com.google.protobuf.ByteString bs = (com.google.protobuf.ByteString) ref;
                java.lang.String s = bs.toStringUtf8();
                iDNumber_ = s;
                return s;
            } else {
                return (java.lang.String) ref;
            }
        }

        /**
         * <code>string IDNumber = 2;</code>
         * 
         * @return The bytes for iDNumber.
         */
        public com.google.protobuf.ByteString getIDNumberBytes() {
            java.lang.Object ref = iDNumber_;
            if (ref instanceof String) {
                com.google.protobuf.ByteString b = com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
                iDNumber_ = b;
                return b;
            } else {
                return (com.google.protobuf.ByteString) ref;
            }
        }

        /**
         * <code>string IDNumber = 2;</code>
         * 
         * @param value
         *            The iDNumber to set.
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
         * 
         * @return This builder for chaining.
         */
        public Builder clearIDNumber() {

            iDNumber_ = getDefaultInstance().getIDNumber();
            onChanged();
            return this;
        }

        /**
         * <code>string IDNumber = 2;</code>
         * 
         * @param value
         *            The bytes for iDNumber to set.
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

        private java.lang.Object name_ = "";

        /**
         * <code>string Name = 3;</code>
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
         * <code>string Name = 3;</code>
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
         * <code>string Name = 3;</code>
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
         * <code>string Name = 3;</code>
         * 
         * @return This builder for chaining.
         */
        public Builder clearName() {

            name_ = getDefaultInstance().getName();
            onChanged();
            return this;
        }

        /**
         * <code>string Name = 3;</code>
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

        // @@protoc_insertion_point(builder_scope:io.scyna.customer.proto.CreateCustomerRequest)
    }

    // @@protoc_insertion_point(class_scope:io.scyna.customer.proto.CreateCustomerRequest)
    private static final scyna.ex.customer.proto.CreateCustomerRequest DEFAULT_INSTANCE;
    static {
        DEFAULT_INSTANCE = new scyna.ex.customer.proto.CreateCustomerRequest();
    }

    public static scyna.ex.customer.proto.CreateCustomerRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<CreateCustomerRequest> PARSER = new com.google.protobuf.AbstractParser<CreateCustomerRequest>() {
        @java.lang.Override
        public CreateCustomerRequest parsePartialFrom(
                com.google.protobuf.CodedInputStream input,
                com.google.protobuf.ExtensionRegistryLite extensionRegistry)
                throws com.google.protobuf.InvalidProtocolBufferException {
            return new CreateCustomerRequest(input, extensionRegistry);
        }
    };

    public static com.google.protobuf.Parser<CreateCustomerRequest> parser() {
        return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<CreateCustomerRequest> getParserForType() {
        return PARSER;
    }

    @java.lang.Override
    public scyna.ex.customer.proto.CreateCustomerRequest getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }

}
