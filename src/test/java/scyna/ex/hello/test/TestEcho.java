package scyna.ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;
import scyna.ex.hello.proto.EchoRequest;
import scyna.ex.hello.proto.EchoResponse;
import scyna.ex.hello.services.EchoService;
import scyna.ex.hello.shared.Path;

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