package io.scyna.ex.user;

import io.scyna.Service;
import io.scyna.ex.user.dao.User;
import io.scyna.ex.user.proto.*;

public class CreateUserService extends Service.Base<CreateUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive CreateUserRequest");
        var request = (CreateUserRequest) parse(CreateUserRequest.parser(), CreateUserRequest.newBuilder());
        if (request == null)
            return;

        if (!User.exist(request.getUser().getEmail())) {
            error(io.scyna.ex.user.Error.ACCOUNT_EXISTED);
            return;
        }

        var user = new User(request.getUser());
        var id = User.create(user);
        done(CreateUserResponse.newBuilder().setId(id).build());
    }
}
