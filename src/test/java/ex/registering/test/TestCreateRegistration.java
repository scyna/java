package ex.registering.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.registering.proto.CreateRegistrationRequest;
import ex.registering.proto.RegistrationCreated;
import ex.registering.services.CreateRegistrationHandler;
import ex.registering.shared.Path;
import scyna.DomainEvent;
import scyna.Endpoint;
import scyna.Engine;
import scyna.Error;
import scyna.testing.EndpointTest;

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
        DomainEvent.Register(new RegistrationCreatedHandler());
        DomainEvent.Instance().start();

        EndpointTest.create(Path.CREATE_REGISTRATION)
                .withRequest(CreateRegistrationRequest.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456").build())
                // .expectDomainEvent(RegistrationCreated.newBuilder()
                // .setEmail("a@gmail.com")
                // .setName("Nguyen Van A")
                // .setPassword("123456").build())
                .expectSuccess().run();

        Thread.sleep(100);
        var event = (RegistrationCreated) DomainEvent.Instance().nextEvent();
        assertEquals("Nguyen Van Axxx", event.getName());
    }

    public class RegistrationCreatedHandler extends DomainEvent.Handler<RegistrationCreated> {

        @Override
        public void Execute() throws Error {
            System.out.println("Receive RegistrationCreated: " + data.toString());
            context.raiseDomainEvent(RegistrationCreated.newBuilder()
                    .setEmail(data.getEmail())
                    .setName(data.getName() + "xxx")
                    .setPassword(data.getPassword())
                    .build());
        }
    }
}
