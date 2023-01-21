package io.scyna.ex.user.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.Endpoint;
import io.scyna.EndpointTest;
import io.scyna.ex.user.proto.CreateUserRequest;
import io.scyna.ex.user.proto.CreateUserResponse;
import io.scyna.ex.user.proto.GetUserRequest;
import io.scyna.ex.user.proto.GetUserResponse;
import io.scyna.ex.user.user.CreateUserService;
import io.scyna.ex.user.user.GetUserService;
import io.scyna.ex.user.user.Path;

public class TestCreateUser {

        @BeforeClass
        public static void setup() throws Exception {
                Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");

                Endpoint.register(Path.CREATE_USER_URL, new CreateUserService());
                Endpoint.register(Path.GET_USER_URL, new GetUserService());
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
                EndpointTest.New(Path.CREATE_USER_URL)
                                .withRequest(CreateUserRequest.newBuilder().setUser(
                                                io.scyna.ex.user.proto.User.newBuilder()
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
                EndpointTest.New(Path.CREATE_USER_URL)
                                .withRequest(CreateUserRequest.newBuilder().setUser(
                                                io.scyna.ex.user.proto.User.newBuilder()
                                                                .setEmail("a@gmail.com")
                                                                .setName("Nguyen Van A")
                                                                .setPassword("123456")
                                                                .build())
                                                .build())
                                .expectSuccess()
                                .run();

                EndpointTest.New(Path.CREATE_USER_URL)
                                .withRequest(CreateUserRequest.newBuilder().setUser(
                                                io.scyna.ex.user.proto.User.newBuilder()
                                                                .setEmail("a@gmail.com")
                                                                .setName("Nguyen Van A")
                                                                .setPassword("123456")
                                                                .build())
                                                .build())
                                .expectError(io.scyna.ex.user.user.Error.USER_EXISTED)
                                .run();

        }

        @Test
        public void testCreateThenGet() {
                var u = EndpointTest.New(Path.CREATE_USER_URL)
                                .withRequest(CreateUserRequest.newBuilder().setUser(
                                                io.scyna.ex.user.proto.User.newBuilder()
                                                                .setEmail("a@gmail.com")
                                                                .setName("Nguyen Van A")
                                                                .setPassword("123456")
                                                                .build())
                                                .build())
                                .expectSuccess()
                                .run(CreateUserResponse.parser());

                EndpointTest.New(Path.GET_USER_URL)
                                .withRequest(GetUserRequest.newBuilder().setEmail("a@gmail.com").build())
                                .expectResponse(GetUserResponse.newBuilder().setUser(
                                                io.scyna.ex.user.proto.User.newBuilder()
                                                                .setId(u.getId())
                                                                .setEmail("a@gmail.com")
                                                                .setName("Nguyen Van A")
                                                                .build())
                                                .build())
                                .run();

        }
}
