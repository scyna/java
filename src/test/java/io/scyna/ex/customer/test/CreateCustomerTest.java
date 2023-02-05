package io.scyna.ex.customer.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import io.scyna.Endpoint;
import io.scyna.EndpointTest;
import io.scyna.Engine;
import io.scyna.ex.customer.proto.CreateCustomerRequest;
import io.scyna.ex.customer.service.CreateCustomerService;
import io.scyna.ex.customer.service.GetCustomerByIdentityService;
import io.scyna.ex.customer.service.Path;

public class CreateCustomerTest {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna_test", "123456");
        Endpoint.register(Path.CREATE_CUSTOMER_URL, new CreateCustomerService());
        Endpoint.register(Path.GET_CUSTOMER_BY_IDENTITY_URL, new GetCustomerByIdentityService());
    }

    @AfterClass
    public static void teardown() {
        cleanup();
        Engine.release();
    }

    @Test
    public void testCreateCustomer() {
        EndpointTest.create(Path.CREATE_CUSTOMER_URL)
                .withRequest(CreateCustomerRequest.newBuilder()
                        .setIDType("CMND")
                        .setIDNumber("123456789")
                        .setName("Nguyen Van A")
                        .build())
                .expectSuccess()
                .run();

        EndpointTest.create(Path.CREATE_CUSTOMER_URL)
                .withRequest(CreateCustomerRequest.newBuilder()
                        .setIDType("CMND")
                        .setIDNumber("123456789")
                        .setName("Nguyen Van A")
                        .build())
                .expectError(io.scyna.ex.customer.model.Error.CUSTOMER_EXISTS)
                .run();
    }

    private static void cleanup() {
        var truncate = QueryBuilder.truncate("ex_customer", "customer");
        Engine.DB().session().execute(truncate);
    }
}