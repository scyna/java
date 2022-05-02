package io.scyna.ex.scylla.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.After;
import org.junit.Before;

import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ex.scylla.proto.CreateUserRequest;
import io.scyna.ex.scylla.user.CreateUserService;
import io.scyna.ex.scylla.user.Path;
import io.scyna.ex.scylla.user.User;

public class TestCreateUser {

    @Before
    public void setup() throws URISyntaxException, IOException, InterruptedException {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

        Service.register(Path.CREATE_USER_URL, new CreateUserService(), CreateUserRequest.parser(),
                CreateUserRequest.newBuilder());

        // Service.register(Path.GET_USER_URL, new CreateUserService(),
        // GetUserRequest.parser(),
        // CreateUserRequest.newBuilder());

        User.initScyllaRepository();
    }

    @After
    public void teardown() {
        Engine.release();
        cleanUp();
    }

    public void cleanUp() {
        var session = Engine.DB().session();
        var query = session.prepare("TRUNCATE ex.user").bind();
        session.execute(query);
    }

}
