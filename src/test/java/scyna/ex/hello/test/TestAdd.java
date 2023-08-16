package scyna.ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;
import scyna.ex.hello.proto.AddRequest;
import scyna.ex.hello.proto.AddResponse;
import scyna.ex.hello.service.AddService;
import scyna.ex.hello.service.Path;

public class TestAdd {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.ADD_URL, new AddService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testAddShouldSuccess() {
        EndpointTest.create(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(5).setB(34).build())
                .expectResponse(AddResponse.newBuilder().setSum(39).build())
                .run();

        EndpointTest.create(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(82).setB(18).build())
                .expectResponse(AddResponse.newBuilder().setSum(100).build())
                .run();

    }

    @Test
    public void testAddTooBig() {
        EndpointTest.create(Path.ADD_URL)
                .withRequest(AddRequest.newBuilder().setA(95).setB(34).build())
                .expectError(scyna.Error.REQUEST_INVALID)
                .run();
    }
}
