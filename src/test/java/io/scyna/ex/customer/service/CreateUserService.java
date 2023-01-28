package io.scyna.ex.customer.service;

import io.scyna.Endpoint;
import io.scyna.ex.customer.domain.CustomerService;
import io.scyna.ex.customer.domain.IRepository;
import io.scyna.ex.customer.domain.RepositoryCreator;
import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Identity;
import io.scyna.ex.customer.proto.*;

public class CreateUserService extends Endpoint.Handler<CreateCustomerRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        context.info("Receive CreateUserRequest");
        var repository = RepositoryCreator.create();

        var customer = new Customer();
        customer.identity = Identity.newIdentity(request.getIDType(), request.getIDNumber());
        CustomerService.assureIdentityNotExists(repository, customer.identity);
        repository.createCustomer(customer);
    }
}
