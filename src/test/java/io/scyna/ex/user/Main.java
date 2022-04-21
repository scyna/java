package io.scyna.ex.user;

import io.scyna.Engine;
import io.scyna.Service;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

        Service.register("/ex/user/create", new CreateUserService());
        Service.register("/ex/user/get", new GetUserService());
        Service.register("/ex/user/list-friend", new ListFriendService());
    }
}
