package io.scyna.ex.user.user;

public class Error {
        public static final io.scyna.proto.Error USER_EXISTED = io.scyna.proto.Error.newBuilder()
                        .setCode(100).setMessage("Account existed").build();

        public static final io.scyna.proto.Error USER_NOT_EXISTED = io.scyna.proto.Error.newBuilder()
                        .setCode(101).setMessage("Account existed").build();

}
