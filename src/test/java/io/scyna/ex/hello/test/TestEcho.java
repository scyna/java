package io.scyna.ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.ex.hello.proto.EchoRequest;
import io.scyna.ex.hello.proto.EchoResponse;
import io.scyna.ex.hello.service.EchoService;
import io.scyna.ex.hello.service.Path;
import io.scyna.Endpoint;
import io.scyna.EndpointTest;

public class TestEcho {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Endpoint.register(Path.ECHO_URL, new EchoService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testEchoShouldSuccess() {
        EndpointTest.create(Path.ECHO_URL)
                .withRequest(EchoRequest.newBuilder().setText("Hello").build())
                .expectResponse(EchoResponse.newBuilder().setText("Hello").build())
                .run();
    }
}