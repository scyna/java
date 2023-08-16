package scyna.ex.customer.service;

import scyna.Endpoint;
import scyna.ex.customer.domain.CustomerService;
import scyna.ex.customer.model.Customer;
import scyna.ex.customer.model.Identity;
import scyna.ex.customer.proto.*;

public class CreateCustomerService extends Endpoint.Handler<CreateCustomerRequest> {
    @Override
    public void execute() throws scyna.Error {
        var repository = CustomerService.loadRepository(context);

        var customer = new Customer(context);
        customer.ID = CustomerService.nextCustomerID();
        customer.name = request.getName();
        customer.identity = Identity.create(request.getIDType(), request.getIDNumber());

        CustomerService.assureIdentityNotExists(repository, customer.identity);
        repository.createCustomer(customer);
        response(CreateCustomerResponse.newBuilder().setID(customer.ID).build());
    }
}
