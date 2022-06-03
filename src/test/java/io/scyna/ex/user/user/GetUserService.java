package io.scyna.ex.user.user;

import io.scyna.Service;
import io.scyna.ex.user.proto.GetUserRequest;
import io.scyna.ex.user.proto.GetUserResponse;

public class GetUserService extends Service.Handler<GetUserRequest> {

    @Override
    public void execute() {
        context.info("Receive GetUserRequest");
        var repository = User.repository();
        var user = repository.get(request.getEmail());
        if (user == null) {
            error(io.scyna.ex.user.user.Error.USER_NOT_EXISTED);
            return;
        }
        done(GetUserResponse.newBuilder().setUser(user.toProto()).build());
    }
}
