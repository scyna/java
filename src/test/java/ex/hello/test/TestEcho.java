package ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.hello.proto.EchoRequest;
import ex.hello.proto.EchoResponse;
import ex.hello.services.EchoService;
import ex.hello.shared.Path;
import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;

public class TestEcho {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.ECHO, new EchoService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testEchoShouldSuccess() {
        EndpointTest.create(Path.ECHO)
                .withRequest(EchoRequest.newBuilder().setText("Hello").build())
                .expectResponse(EchoResponse.newBuilder().setText("Hello").build())
                .run();
    }
}