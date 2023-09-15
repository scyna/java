package ex.account.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.account.features.CreateAccountHandler;
import ex.account.features.ProjectAccountCreated;
import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import ex.account.proto.CreateAccountRequest;
import ex.account.shared.AccountStore;
import ex.account.shared.Path;
import scyna.Endpoint;
import scyna.Engine;
import scyna.testing.Testing;

public class TestCreateAccount {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        AccountStore.Init();
        Endpoint.Register(Path.CREATE_ACCOUNT, new CreateAccountHandler());
        AccountStore.RegisterProjection(new ProjectAccountCreated());
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
