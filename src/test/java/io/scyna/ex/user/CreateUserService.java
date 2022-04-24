package io.scyna.ex.user;

import io.scyna.ServiceHandler;
import io.scyna.ex.user.dao.User;
import io.scyna.ex.user.proto.*;

public class CreateUserService extends ServiceHandler<CreateUserRequest> {

    @Override
    public void execute(CreateUserRequest request) {
        System.out.println("Receive CreateUserRequest");

        if (User.get(request.getUser().getEmail()) != null) {
            error(io.scyna.ex.user.Error.ACCOUNT_EXISTED);
            return;
        }

        var user = new User(request.getUser());
        var id = User.create(user);
        done(CreateUserResponse.newBuilder().setId(id).build());
    }
}
