package io.scyna.ex.customer.service;

import io.scyna.Endpoint;
import io.scyna.ex.customer.domain.CustomerService;
import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Identity;
import io.scyna.ex.customer.proto.*;

public class CreateUserService extends Endpoint.Handler<CreateCustomerRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        var domain = CustomerService.load(context);

        var customer = new Customer();
        customer.ID = domain.nextCustomerID();
        customer.name = request.getName();
        customer.identity = Identity.create(request.getIDType(), request.getIDNumber());

        domain.assureIdentityNotExists(customer.identity);
        domain.repository().createCustomer(customer);
        response(CreateCustomerResponse.newBuilder().setID(customer.ID).build());
    }
}
