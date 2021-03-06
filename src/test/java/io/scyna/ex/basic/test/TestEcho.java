package io.scyna.ex.basic.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ServiceTest;
import io.scyna.ex.basic.EchoService;
import io.scyna.ex.basic.Path;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class TestEcho {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Service.register(Path.ECHO_URL, new EchoService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testEchoShouldSuccess() {
        ServiceTest.New(Path.ECHO_URL)
                .withRequest(EchoRequest.newBuilder().setText("Hello").build())
                .expectResponse(EchoResponse.newBuilder().setText("Hello").build())
                .run();
    }
}