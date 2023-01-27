package io.scyna;

public class Error {
        public static final io.scyna.proto.Error OK = New(0, "Success");
        public static final io.scyna.proto.Error SERVER_ERROR = New(1, "Server Error");
        public static final io.scyna.proto.Error BAD_REQUEST = New(2, "Bad Request");
        public static final io.scyna.proto.Error PERMISSION_ERROR = New(4, "Permission Error");
        public static final io.scyna.proto.Error REQUEST_INVALID = New(5, "Request Invalid");
        public static final io.scyna.proto.Error MODULE_NOT_EXIST = New(6, "Module Not Exist");

        public static final io.scyna.proto.Error New(int code, String message) {
                return io.scyna.proto.Error.newBuilder().setCode(0).setMessage("Success").build();
        }
}