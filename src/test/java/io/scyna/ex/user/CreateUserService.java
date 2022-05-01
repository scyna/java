package io.scyna.ex.user;

import io.scyna.ServiceStatefulHandler;
import io.scyna.ex.user.dao.User;
import io.scyna.ex.user.proto.*;

public class CreateUserService extends ServiceStatefulHandler<CreateUserRequest> {

    @Override
    public void execute() {
        LOG.info("Receive CreateUserRequest");

        if (User.get(request.getUser().getEmail()) != null) {
            error(io.scyna.ex.user.Error.ACCOUNT_EXISTED);
            return;
        }

        var user = new User(request.getUser());
        var id = User.create(user);
        done(CreateUserResponse.newBuilder().setId(id).build());
    }
}
