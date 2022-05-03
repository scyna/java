package io.scyna.ex.scylla.user;

import io.scyna.Service;
import io.scyna.ex.scylla.proto.GetUserRequest;
import io.scyna.ex.scylla.proto.GetUserResponse;

public class GetUserService extends Service.Handler<GetUserRequest> {

    @Override
    public void execute() {
        LOG.info("Receive GetUserRequest");
        var repository = User.repository();
        var user = repository.get(request.getEmail());
        if (user == null) {
            error(io.scyna.ex.scylla.user.Error.USER_NOT_EXISTED);
            return;
        }
        done(GetUserResponse.newBuilder().setUser(user.toProto()).build());
    }
}
