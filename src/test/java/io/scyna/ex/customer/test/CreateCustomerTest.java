package io.scyna.ex.customer.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.scyna.Endpoint;
import io.scyna.Engine;
import io.scyna.ex.customer.service.CreateCustomerService;
import io.scyna.ex.customer.service.GetCustomerByIdentityService;
import io.scyna.ex.customer.service.Path;

public class CreateCustomerTest {
    @BeforeClass
    public static void setup() throws Exception {
        Engine.init("http://127.0.0.1:8081", "scyna.test", "123456");
        Endpoint.register(Path.CREATE_CUSTOMER_URL, new CreateCustomerService());
        Endpoint.register(Path.GET_CUSTOMER_BY_IDENTITY_URL, new GetCustomerByIdentityService());
    }

    @AfterClass
    public static void teardown() {
        Engine.release();
    }

    @Test
    public void testCreateShouldSuccess() {
        /* TODO */
    }
}
