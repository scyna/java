package io.scyna.ex.script.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import io.scyna.Endpoint;
import io.scyna.EndpointTest;
import io.scyna.Engine;
import io.scyna.ex.script.proto.CreateAccountRequest;
import io.scyna.ex.script.service.CreateAccountService;
import io.scyna.ex.script.service.Error;
import io.scyna.ex.script.service.Path;

public class CreateAccountTest {

        @BeforeClass
        public static void setup() throws Exception {
                Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
                Endpoint.register(Path.CREATE_ACCOUNT_URL, new CreateAccountService());
        }

        @AfterClass
        public static void teardown() {
                cleanup();
                Engine.release();
        }

        @Test
        public void testCreateCustomer() {
                EndpointTest.New(Path.CREATE_ACCOUNT_URL)
                                .withRequest(CreateAccountRequest.newBuilder()
                                                .setEmail("a@gmail.com")
                                                .setName("Nguyen Van A")
                                                .setPassword("12345678")
                                                .build())
                                .expectSuccess()
                                .run();

                EndpointTest.New(Path.CREATE_ACCOUNT_URL)
                                .withRequest(CreateAccountRequest.newBuilder()
                                                .setEmail("a@gmail.com")
                                                .setName("Nguyen Van A")
                                                .setPassword("12345678")
                                                .build())
                                .expectError(Error.ACCOUNT_EXISTS)
                                .run();
        }

        @Test
        public void testCreateCustomerBadEmail() {
                EndpointTest.New(Path.CREATE_ACCOUNT_URL)
                                .withRequest(CreateAccountRequest.newBuilder()
                                                .setEmail("a+gmail.com")
                                                .setName("Nguyen Van A")
                                                .setPassword("12345678")
                                                .build())
                                .expectError(io.scyna.Error.REQUEST_INVALID)
                                .run();

                EndpointTest.New(Path.CREATE_ACCOUNT_URL)
                                .withRequest(CreateAccountRequest.newBuilder()
                                                .setName("Nguyen Van A")
                                                .setPassword("12345678")
                                                .build())
                                .expectError(io.scyna.Error.REQUEST_INVALID)
                                .run();

                EndpointTest.New(Path.CREATE_ACCOUNT_URL)
                                .withRequest(CreateAccountRequest.newBuilder()
                                                .setEmail("")
                                                .setName("Nguyen Van A")
                                                .setPassword("12345678")
                                                .build())
                                .expectError(io.scyna.Error.REQUEST_INVALID)
                                .run();
        }

        private static void cleanup() {
                var truncate = QueryBuilder.truncate("ex_account", "account");
                Engine.DB().session().execute(truncate);
        }
}
