package ex.registering.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ex.registering.proto.RegistrationCreated;
import scyna.DomainEvent;
import scyna.Engine;
import scyna.testing.Testing;

public class TestRegistrationCreated {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void testGivenGoodRequest_ShouldSuccess() throws InterruptedException {
        Testing.DomainEvent(new RegistrationCreatedHandler())
                .withData(RegistrationCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van A")
                        .setPassword("123456").build())
                .expectDomainEvent(RegistrationCreated.newBuilder()
                        .setEmail("a@gmail.com")
                        .setName("Nguyen Van Axxx")
                        .setPassword("123456").build())
                .run();
    }

    public class RegistrationCreatedHandler extends DomainEvent.Handler<RegistrationCreated> {

        @Override
        public void execute() throws Error {
            System.out.println("Receive RegistrationCreated: " + data.toString());
            context.raiseDomainEvent(RegistrationCreated.newBuilder()
                    .setEmail(data.getEmail())
                    .setName(data.getName() + "xxx")
                    .setPassword(data.getPassword())
                    .build());
        }
    }
}
