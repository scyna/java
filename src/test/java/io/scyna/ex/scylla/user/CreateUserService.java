package io.scyna.ex.scylla.user;

import io.scyna.Service;
import io.scyna.ex.scylla.proto.*;

public class CreateUserService extends Service.Handler<CreateUserRequest> {

    @Override
    public void execute() {
        LOG.info("Receive CreateUserRequest");
        var repository = User.repository();

        if (repository.get(request.getUser().getEmail()) != null) {
            error(io.scyna.ex.scylla.user.Error.ACCOUNT_EXISTED);
            return;
        }

        var user = new User(request.getUser());
        var id = repository.create(user);
        done(CreateUserResponse.newBuilder().setId(id).build());
    }
}
