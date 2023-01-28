package io.scyna.ex.basic.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import io.scyna.Engine;
import io.scyna.Endpoint;
import io.scyna.EndpointTest;
import io.scyna.ex.basic.AddService;
import io.scyna.ex.basic.Path;
import io.scyna.ex.basic.proto.AddRequest;
import io.scyna.ex.basic.proto.AddResponse;

public class TestAdd {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Endpoint.register(Path.ADD_URL, new AddService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testAddShouldSuccess() {
        EndpointTest.New(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(5).setB(34).build())
                .expectResponse(AddResponse.newBuilder().setSum(39).build())
                .run();

        EndpointTest.New(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(82).setB(18).build())
                .expectResponse(AddResponse.newBuilder().setSum(100).build())
                .run();

    }

    @Test
    public void testAddTooBig() {
        EndpointTest.New(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(95).setB(34).build())
                .expectError(io.scyna.Error.REQUEST_INVALID)
                .run();
    }
}
