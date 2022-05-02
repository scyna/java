package io.scyna.ex.basic.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ServiceTest;
import io.scyna.ex.basic.EchoService;
import io.scyna.ex.basic.Path;
import io.scyna.ex.basic.proto.EchoRequest;
import io.scyna.ex.basic.proto.EchoResponse;

public class TestEcho {

    @Before
    public void setup() throws URISyntaxException, IOException, InterruptedException {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Service.register(Path.ECHO_USER_URL, new EchoService(), EchoRequest.parser(), EchoRequest.newBuilder());
    }

    @Test
    public void testEchoShouldSuccess() {
        ServiceTest.New(Path.ECHO_USER_URL)
                .withRequest(EchoRequest.newBuilder().setText("Hello").build())
                .expectResponse(EchoResponse.newBuilder().setText("Hello").build())
                .run();
    }
}
