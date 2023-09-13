package ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.hello.proto.EchoRequest;
import ex.hello.proto.EchoResponse;
import ex.hello.services.EchoService;
import ex.hello.shared.Path;
import scyna.Endpoint;
import scyna.Engine;
import scyna.testing.Testing;

public class TestEcho {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.Register(Path.ECHO, new EchoService());
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void testEchoShouldSuccess() {
        Testing.Endpoint(Path.ECHO)
                .withRequest(EchoRequest.newBuilder().setText("Hello").build())
                .expectResponse(EchoResponse.newBuilder().setText("Hello").build())
                .run();
    }
}