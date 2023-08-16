package scyna.ex.account.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.datastax.driver.core.querybuilder.QueryBuilder;

import scyna.Command;
import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;
import scyna.ex.account.model.Error;
import scyna.ex.account.proto.AccountCreated;
import scyna.ex.account.proto.CreateAccountRequest;
import scyna.ex.account.service.CreateAccountService;
import scyna.ex.account.service.GetAccountByEmailService;
import scyna.ex.account.service.Path;

public class CreateAccountTest {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.CREATE_ACCOUNT_URL, new CreateAccountService());
        Endpoint.register(Path.GET_ACCOUNT_BY_EMAIl_URL, new GetAccountByEmailService());
        Command.initSingleWriter("ex_account");
    }

    @AfterClass
    public static void teardown() {
        cleanup();
        Engine.release();
    }

    @Test
    public void testCreateAccount() {
        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .publishEventTo(Path.ACCOUNT_CREATED_CHANNEL)
                .matchEvent(AccountCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
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
    public void testCreateAccountBadEmail() {
        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("a+gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(Error.BAD_EMAIL)
                .run();

        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(Error.BAD_EMAIL)
                .run();

        EndpointTest.create(Path.CREATE_ACCOUNT_URL)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("")
                        .setName("Nguyen Van A")
                        .setPassword("12345678")
                        .build())
                .expectError(Error.BAD_EMAIL)
                .run();
    }

    private static void cleanup() {
        var truncate = QueryBuilder.truncate("ex_account", "account");
        Engine.DB().session().execute(truncate);
    }
}