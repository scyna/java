package ex.registering.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.registering.proto.CreateRegistrationRequest;
import ex.registering.proto.RegistrationCreated;
import ex.registering.services.CreateRegistrationHandler;
import ex.registering.shared.Path;
import scyna.Endpoint;
import scyna.Engine;
import scyna.testing.Testing;

public class TestCreateRegistration {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.Register(Path.CREATE_REGISTRATION, new CreateRegistrationHandler());
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void testGivenGoodRequest_ShouldSuccess() throws InterruptedException {
        Testing.Endpoint(Path.CREATE_REGISTRATION)
                .withRequest(CreateRegistrationRequest.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456").build())
                .expectDomainEvent(RegistrationCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456").build())
                .run();
    }
}
