package io.scyna.ex.scylla.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ServiceTest;
import io.scyna.ex.scylla.proto.CreateUserRequest;
import io.scyna.ex.scylla.proto.GetUserRequest;
import io.scyna.ex.scylla.user.CreateUserService;
import io.scyna.ex.scylla.user.GetUserService;
import io.scyna.ex.scylla.user.Path;
import io.scyna.ex.scylla.user.User;

public class TestCreateUser {

    @BeforeClass
    public static void setup() throws URISyntaxException, IOException, InterruptedException {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

        Service.register(Path.CREATE_USER_URL, new CreateUserService(), CreateUserRequest.parser(),
                CreateUserRequest.newBuilder());
        Service.register(Path.GET_USER_URL, new GetUserService(), GetUserRequest.parser(),
                GetUserRequest.newBuilder());

        User.initScyllaRepository();
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
        // cleanUp();
    }

    @Before
    public void cleanUp() {
        var session = Engine.DB().session();
        var query = session.prepare("TRUNCATE ex.user").bind();
        session.execute(query);
    }

    @Test
    public void testCreateUserShouldSuccess() {
        ServiceTest.New(Path.CREATE_USER_URL)
                .withRequest(CreateUserRequest.newBuilder().setUser(
                        io.scyna.ex.scylla.proto.User.newBuilder()
                                .setEmail("a@gmail.com")
                                .setName("Nguyen Van A")
                                .setPassword("123456")
                                .build())
                        .build())
                .expectSuccess()
                .run();
    }
}
