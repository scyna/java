package io.scyna.ex.user;

import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ex.user.proto.CreateUserRequest;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

        Service.register("/ex/user/create", new CreateUserService(), CreateUserRequest.parser(),
                CreateUserRequest.newBuilder());
    }
}
