package ex.account.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.account.proto.AccountCreated;
import ex.account.proto.CreateAccountRequest;
import ex.account.shared.Path;
import ex.account.shared.Registration;
import ex.account.shared.Table;
import scyna.Engine;
import scyna.testing.Testing;

public class TestCreateAccount {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        Engine.DB().execute("TRUNCATE " + Table.ACCOUNT_EVENTS);
        Engine.DB().execute("TRUNCATE " + Table.ACCOUNT);
        new Registration().testInit();
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void GivenGoodRequest_ShouldReturnSuccess() {
        Testing.Endpoint(Path.CREATE_ACCOUNT)
                .withRequest(CreateAccountRequest.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456")
                        .build())
                .expectDomainEvent(AccountCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456")
                        .build())
                .expectEvent("AccountCreated", AccountCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456")
                        .build())
                .run();
    }
}
