package io.scyna.ex.customer.service;

import io.scyna.Endpoint;
import io.scyna.ex.customer.domain.CustomerService;
import io.scyna.ex.customer.model.Identity;
import io.scyna.ex.customer.proto.GetCustomerByIdentityRequest;
import io.scyna.ex.customer.proto.GetCustomerResponse;

public class GetCustomerByIdentityService extends Endpoint.Handler<GetCustomerByIdentityRequest> {
    @Override
    public void execute() throws io.scyna.Error {
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
