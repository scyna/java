package scyna.ex.script.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;
import scyna.ex.script.proto.CreateAccountRequest;
import scyna.ex.script.service.CreateAccountService;
import scyna.ex.script.service.Error;
import scyna.ex.script.service.Path;

public class CreateAccountTest {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.CREATE_ACCOUNT_URL, new CreateAccountService());
    }

    @AfterClass
    public static void teardown() {
        cleanup();
        Engine.release();
    }

    @Test
    public void testCreateCustomer() {
        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectSuccess()
                .run();

        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
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
        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("a+gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(scyna.Error.REQUEST_INVALID)
                .run();

        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(scyna.Error.REQUEST_INVALID)
                .run();

        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(scyna.Error.REQUEST_INVALID)
                .run();
    }

    private static void cleanup() {
        var truncate = QueryBuilder.truncate("ex_account", "account");
        Engine.DB().session().execute(truncate);
    }
}
