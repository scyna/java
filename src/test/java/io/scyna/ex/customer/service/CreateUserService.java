package io.scyna.ex.customer.service;

import io.scyna.Endpoint;
import io.scyna.ex.customer.proto.*;

public class CreateUserService extends Endpoint.Handler<CreateCustomerRequest> {

    @Override
    public void execute() {
        context.info("Receive CreateUserRequest");
        // var repository = User.repository();
        // if (repository.get(request.getUser().getEmail()) != null) {
        // error(io.scyna.ex.customer.service.Error.USER_EXISTED);
        // return;
        // } else {
        // var user = User.fromProto(request.getUser());
        // var id = repository.create(user);
        // done(CreateUserResponse.newBuilder().setId(id).build());
        // }
    }
}
