package ex.account.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.account.features.CreateAccount;
import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import ex.account.proto.CreateAccountRequest;
import ex.account.shared.Path;
import scyna.Endpoint;
import scyna.Engine;
import scyna.eventstore.EventStore;
import scyna.testing.Testing;

public class TestCreateAccount {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        EventStore.Init("account_events", AccountModel.class);
        Endpoint.Register(Path.CREATE_ACCOUNT, new CreateAccount());
        EventStore.RegisterProjection(new CreateAccount.ProjectAccountCreated());
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
                .run();
    }
}
