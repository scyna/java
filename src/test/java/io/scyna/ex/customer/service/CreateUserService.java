package io.scyna.ex.customer.service;

import io.scyna.Endpoint;
import io.scyna.ex.customer.domain.CustomerService;
import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Identity;
import io.scyna.ex.customer.proto.*;

public class CreateUserService extends Endpoint.Handler<CreateCustomerRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        var repository = CustomerService.loadRepository(context);

        var customer = new Customer();
        customer.ID = CustomerService.nextCustomerID();
        customer.identity = Identity.newIdentity(request.getIDType(), request.getIDNumber());

        CustomerService.assureIdentityNotExists(repository, customer.identity);
        repository.createCustomer(customer);
        response(CreateCustomerResponse.newBuilder().setID(customer.ID).build());
    }
}
