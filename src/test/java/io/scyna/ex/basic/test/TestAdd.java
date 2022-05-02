package io.scyna.ex.basic.test;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import io.scyna.Engine;
import io.scyna.Error;
import io.scyna.Service;
import io.scyna.ServiceTest;
import io.scyna.ex.basic.AddService;
import io.scyna.ex.basic.Path;
import io.scyna.ex.basic.proto.AddRequest;
import io.scyna.ex.basic.proto.AddResponse;

public class TestAdd {

    @Before
    public void setup() throws URISyntaxException, IOException, InterruptedException {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Service.register(Path.ADD_USER_URL, new AddService(), AddRequest.parser(), AddRequest.newBuilder());
    }

    @Test
    public void testAddShouldSuccess() {
        ServiceTest.New(Path.ADD_USER_URL)
                .withRequest(AddRequest.newBuilder().setA(5).setB(34).build())
                .expectResponse(AddResponse.newBuilder().setSum(39).build())
                .run();

        ServiceTest.New(Path.ADD_USER_URL)
                .withRequest(AddRequest.newBuilder().setA(82).setB(18).build())
                .expectResponse(AddResponse.newBuilder().setSum(100).build())
                .run();

    }

    @Test
    public void testAddTooBig() {
        ServiceTest.New(Path.ADD_USER_URL)
                .withRequest(AddRequest.newBuilder().setA(95).setB(34).build())
                .expectError(Error.REQUEST_INVALID)
                .run();
    }
}
