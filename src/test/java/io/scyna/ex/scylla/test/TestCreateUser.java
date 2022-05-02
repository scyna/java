package io.scyna.ex.scylla.test;

import java.io.IOException;
import java.net.URISyntaxException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ServiceTest;
import io.scyna.ex.scylla.proto.CreateUserRequest;
import io.scyna.ex.scylla.proto.CreateUserResponse;
import io.scyna.ex.scylla.proto.GetUserRequest;
import io.scyna.ex.scylla.proto.GetUserResponse;
import io.scyna.ex.scylla.user.CreateUserService;
import io.scyna.ex.scylla.user.GetUserService;
import io.scyna.ex.scylla.user.Path;
import io.scyna.ex.scylla.user.User;

public class TestCreateUser {

    @BeforeClass
    public static void setup() throws URISyntaxException, IOException, InterruptedException {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

        Service.register(Path.CREATE_USER_URL, new CreateUserService(), CreateUserRequest.newBuilder());
        Service.register(Path.GET_USER_URL, new GetUserService(), GetUserRequest.newBuilder());

        User.initScyllaRepository();
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Before
    @After
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

    @Test
    public void testCreateDuplicate() {
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

        ServiceTest.New(Path.CREATE_USER_URL)
                .withRequest(CreateUserRequest.newBuilder().setUser(
                        io.scyna.ex.scylla.proto.User.newBuilder()
                                .setEmail("a@gmail.com")
                                .setName("Nguyen Van A")
                                .setPassword("123456")
                                .build())
                        .build())
                .expectError(io.scyna.ex.scylla.user.Error.USER_EXISTED)
                .run();

    }

    @Test
    public void testCreateThenGet() {
        var u = ServiceTest.New(Path.CREATE_USER_URL)
                .withRequest(CreateUserRequest.newBuilder().setUser(
                        io.scyna.ex.scylla.proto.User.newBuilder()
                                .setEmail("a@gmail.com")
                                .setName("Nguyen Van A")
                                .setPassword("123456")
                                .build())
                        .build())
                .expectSuccess()
                .run(CreateUserResponse.parser());

        ServiceTest.New(Path.GET_USER_URL)
                .withRequest(GetUserRequest.newBuilder().setEmail("a@gmail.com").build())
                .expectResponse(GetUserResponse.newBuilder().setUser(
                        io.scyna.ex.scylla.proto.User.newBuilder()
                                .setId(u.getId())
                                .setEmail("a@gmail.com")
                                .setName("Nguyen Van A")
                                .build())
                        .build())
                .run();

    }
}
