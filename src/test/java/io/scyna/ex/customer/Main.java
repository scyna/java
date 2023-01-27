package io.scyna.ex.customer;

import io.scyna.Engine;
import io.scyna.ex.customer.service.CreateUserService;
import io.scyna.Endpoint;

public class Main {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Endpoint.register("/ex/user/create", new CreateUserService());
    }
}
