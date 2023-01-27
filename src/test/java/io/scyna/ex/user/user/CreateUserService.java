package io.scyna.ex.user.user;

import io.scyna.Endpoint;
import io.scyna.ex.user.proto.*;

public class CreateUserService extends Endpoint.Handler<CreateUserRequest> {

    @Override
    public void execute() {
        context.info("Receive CreateUserRequest");
        var repository = User.repository();

        if (repository.get(request.getUser().getEmail()) != null) {
            error(io.scyna.ex.user.user.Error.USER_EXISTED);
            return;
        } else {
            var user = User.fromProto(request.getUser());
            var id = repository.create(user);
            done(CreateUserResponse.newBuilder().setId(id).build());
        }
    }
}
