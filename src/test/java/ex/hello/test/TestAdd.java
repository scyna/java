package ex.hello.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import ex.hello.proto.AddRequest;
import ex.hello.proto.AddResponse;
import ex.hello.services.AddService;
import ex.hello.shared.Path;
import scyna.Endpoint;
import scyna.EndpointTest;
import scyna.Engine;

public class TestAdd {

    @BeforeClass
    public static void setup() throws Exception {
        Engine.Init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.ADD, new AddService());
    }

    @AfterClass
    public static void teardown() {
        Engine.Release();
    }

    @Test
    public void testAddShouldSuccess() {
        EndpointTest.create(Path.ADD)
                .withRequest(AddRequest.newBuilder().setA(5).setB(34).build())
                .expectResponse(AddResponse.newBuilder().setSum(39).build())
                .run();

        EndpointTest.create(Path.ADD)
                .withRequest(AddRequest.newBuilder().setA(82).setB(18).build())
                .expectResponse(AddResponse.newBuilder().setSum(100).build())
                .run();

    }

    @Test
    public void testAddTooBig() {
        EndpointTest.create(Path.ADD)
                .withRequest(AddRequest.newBuilder().setA(95).setB(34).build())
                .expectError(scyna.Error.REQUEST_INVALID)
                .run();
    }
}
