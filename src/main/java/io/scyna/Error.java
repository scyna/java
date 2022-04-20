package io.scyna;

public class Error {
        public static final io.scyna.proto.Error OK = io.scyna.proto.Error.newBuilder()
                        .setCode(0).setMessage("Success").build();
        public static final io.scyna.proto.Error SERVER_ERROR = io.scyna.proto.Error.newBuilder()
                        .setCode(1).setMessage("Server Error").build();
        public static final io.scyna.proto.Error BAD_REQUEST = io.scyna.proto.Error.newBuilder()
                        .setCode(2).setMessage("Bad Request").build();
        public static final io.scyna.proto.Error PERMISSION_ERROR = io.scyna.proto.Error.newBuilder()
                        .setCode(4).setMessage("Permission Error").build();
        public static final io.scyna.proto.Error REQUEST_INVALID = io.scyna.proto.Error.newBuilder()
                        .setCode(5).setMessage("Request Invalid").build();
        public static final io.scyna.proto.Error MODULE_NOT_EXIST = io.scyna.proto.Error.newBuilder()
                        .setCode(6).setMessage("Module Not Exist").build();
}