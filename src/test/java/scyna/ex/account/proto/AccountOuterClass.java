// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: account.proto

package scyna.ex.account.proto;

public final class AccountOuterClass {
    private AccountOuterClass() {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(
            com.google.protobuf.ExtensionRegistry registry) {
        registerAllExtensions(
                (com.google.protobuf.ExtensionRegistryLite) registry);
    }

    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_Account_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_Account_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_CreateAccountRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_CreateAccountRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_CreateAccountResponse_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_CreateAccountResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_AccountCreated_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_AccountCreated_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_GetAccountByEmailRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_GetAccountByEmailRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_GetAccountByIDRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_GetAccountByIDRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_ChangePasswordRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_ChangePasswordRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_PasswordChanged_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_PasswordChanged_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_AuthenticateRequest_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_AuthenticateRequest_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_AuthenticateResponse_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_AuthenticateResponse_fieldAccessorTable;
    static final com.google.protobuf.Descriptors.Descriptor internal_static_io_scyna_customer_proto_SendEmailTask_descriptor;
    static final com.google.protobuf.GeneratedMessageV3.FieldAccessorTable internal_static_io_scyna_customer_proto_SendEmailTask_fieldAccessorTable;

    public static com.google.protobuf.Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    private static com.google.protobuf.Descriptors.FileDescriptor descriptor;
    static {
        java.lang.String[] descriptorData = {
                "\n\raccount.proto\022\027io.scyna.customer.proto" +
                        "\"2\n\007Account\022\n\n\002id\030\001 \001(\004\022\r\n\005email\030\002 \001(\t\022\014" +
                        "\n\004name\030\003 \001(\t\"E\n\024CreateAccountRequest\022\r\n\005" +
                        "email\030\001 \001(\t\022\014\n\004name\030\002 \001(\t\022\020\n\010password\030\003 " +
                        "\001(\t\"#\n\025CreateAccountResponse\022\n\n\002id\030\001 \001(\004" +
                        "\"9\n\016AccountCreated\022\n\n\002id\030\001 \001(\004\022\r\n\005email\030" +
                        "\002 \001(\t\022\014\n\004name\030\003 \001(\t\")\n\030GetAccountByEmail" +
                        "Request\022\r\n\005email\030\001 \001(\t\"#\n\025GetAccountByID" +
                        "Request\022\n\n\002id\030\001 \001(\004\"D\n\025ChangePasswordReq" +
                        "uest\022\n\n\002id\030\001 \001(\004\022\017\n\007current\030\002 \001(\t\022\016\n\006fut" +
                        "ure\030\003 \001(\t\">\n\017PasswordChanged\022\n\n\002id\030\001 \001(\004" +
                        "\022\017\n\007current\030\002 \001(\t\022\016\n\006future\030\003 \001(\t\"6\n\023Aut" +
                        "henticateRequest\022\r\n\005email\030\001 \001(\t\022\020\n\010passw" +
                        "ord\030\002 \001(\t\"2\n\024AuthenticateResponse\022\014\n\004hos" +
                        "t\030\001 \001(\t\022\014\n\004port\030\002 \001(\r\"/\n\rSendEmailTask\022\r" +
                        "\n\005email\030\001 \001(\t\022\017\n\007content\030\002 \001(\tB\035\n\031io.scy" +
                        "na.ex.account.protoP\001b\006proto3"
        };
        descriptor = com.google.protobuf.Descriptors.FileDescriptor
                .internalBuildGeneratedFileFrom(descriptorData,
                        new com.google.protobuf.Descriptors.FileDescriptor[] {
                        });
        internal_static_io_scyna_customer_proto_Account_descriptor = getDescriptor().getMessageTypes().get(0);
        internal_static_io_scyna_customer_proto_Account_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_Account_descriptor,
                new java.lang.String[] { "Id", "Email", "Name", });
        internal_static_io_scyna_customer_proto_CreateAccountRequest_descriptor = getDescriptor().getMessageTypes()
                .get(1);
        internal_static_io_scyna_customer_proto_CreateAccountRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_CreateAccountRequest_descriptor,
                new java.lang.String[] { "Email", "Name", "Password", });
        internal_static_io_scyna_customer_proto_CreateAccountResponse_descriptor = getDescriptor().getMessageTypes()
                .get(2);
        internal_static_io_scyna_customer_proto_CreateAccountResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_CreateAccountResponse_descriptor,
                new java.lang.String[] { "Id", });
        internal_static_io_scyna_customer_proto_AccountCreated_descriptor = getDescriptor().getMessageTypes().get(3);
        internal_static_io_scyna_customer_proto_AccountCreated_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_AccountCreated_descriptor,
                new java.lang.String[] { "Id", "Email", "Name", });
        internal_static_io_scyna_customer_proto_GetAccountByEmailRequest_descriptor = getDescriptor().getMessageTypes()
                .get(4);
        internal_static_io_scyna_customer_proto_GetAccountByEmailRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_GetAccountByEmailRequest_descriptor,
                new java.lang.String[] { "Email", });
        internal_static_io_scyna_customer_proto_GetAccountByIDRequest_descriptor = getDescriptor().getMessageTypes()
                .get(5);
        internal_static_io_scyna_customer_proto_GetAccountByIDRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_GetAccountByIDRequest_descriptor,
                new java.lang.String[] { "Id", });
        internal_static_io_scyna_customer_proto_ChangePasswordRequest_descriptor = getDescriptor().getMessageTypes()
                .get(6);
        internal_static_io_scyna_customer_proto_ChangePasswordRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_ChangePasswordRequest_descriptor,
                new java.lang.String[] { "Id", "Current", "Future", });
        internal_static_io_scyna_customer_proto_PasswordChanged_descriptor = getDescriptor().getMessageTypes().get(7);
        internal_static_io_scyna_customer_proto_PasswordChanged_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_PasswordChanged_descriptor,
                new java.lang.String[] { "Id", "Current", "Future", });
        internal_static_io_scyna_customer_proto_AuthenticateRequest_descriptor = getDescriptor().getMessageTypes()
                .get(8);
        internal_static_io_scyna_customer_proto_AuthenticateRequest_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_AuthenticateRequest_descriptor,
                new java.lang.String[] { "Email", "Password", });
        internal_static_io_scyna_customer_proto_AuthenticateResponse_descriptor = getDescriptor().getMessageTypes()
                .get(9);
        internal_static_io_scyna_customer_proto_AuthenticateResponse_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_AuthenticateResponse_descriptor,
                new java.lang.String[] { "Host", "Port", });
        internal_static_io_scyna_customer_proto_SendEmailTask_descriptor = getDescriptor().getMessageTypes().get(10);
        internal_static_io_scyna_customer_proto_SendEmailTask_fieldAccessorTable = new com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
                internal_static_io_scyna_customer_proto_SendEmailTask_descriptor,
                new java.lang.String[] { "Email", "Content", });
    }

    // @@protoc_insertion_point(outer_class_scope)
}
