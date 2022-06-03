package io.scyna.ex.scylla.user;

import io.scyna.Service;
import io.scyna.ex.scylla.proto.*;

public class CreateUserService extends Service.Handler<CreateUserRequest> {

    @Override
    public void execute() {
        context.info("Receive CreateUserRequest");
        var repository = User.repository();

        if (repository.get(request.getUser().getEmail()) != null) {
            error(io.scyna.ex.scylla.user.Error.USER_EXISTED);
            return;
        } else {
            var user = User.fromProto(request.getUser());
            var id = repository.create(user);
            done(CreateUserResponse.newBuilder().setId(id).build());
        }
    }
}
