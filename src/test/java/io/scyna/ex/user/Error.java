package io.scyna.ex.user;

public class Error {
    public static final io.scyna.proto.Error ACCOUNT_EXISTED = io.scyna.proto.Error.newBuilder()
            .setCode(0).setMessage("Account existed").build();
}
