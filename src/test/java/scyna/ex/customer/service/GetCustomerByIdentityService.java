package scyna.ex.customer.service;

import scyna.Endpoint;
import scyna.ex.customer.domain.CustomerService;
import scyna.ex.customer.model.Identity;
import scyna.ex.customer.proto.GetCustomerByIdentityRequest;
import scyna.ex.customer.proto.GetCustomerResponse;

public class GetCustomerByIdentityService extends Endpoint.Handler<GetCustomerByIdentityRequest> {
    @Override
    public void execute() throws scyna.Error {
        var repository = CustomerService.loadRepository(context);
        var customer = repository.getCustomerByIdentity(Identity.create(request.getIDType(), request.getIDNumber()));
        response(GetCustomerResponse.newBuilder()
                .setID(customer.ID)
                .setName(customer.name)
                .setIDType(customer.identity.getType())
                .setIDNumber(customer.identity.getNumber())
                .build());
    }
}
