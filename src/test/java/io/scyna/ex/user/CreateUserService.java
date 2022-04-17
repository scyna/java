package io.scyna.ex.user;

import io.scyna.Engine;
import io.scyna.Service;
import io.scyna.ex.user.proto.*;

public class CreateUserService extends Service.Base<CreateUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive CreateUserRequest");
        var request = (CreateUserRequest) parse(CreateUserRequest.parser(), CreateUserRequest.newBuilder());
        if (request == null)
            return;

        var id = Engine.id().next();
        var mapper = Engine.mapping().mapper(io.scyna.ex.user.dao.User.class);
        var user = new io.scyna.ex.user.dao.User(id, request.getUser().getEmail(), request.getUser().getName());
        if (mapper.get(user.getEmail()) != null) {
            error(io.scyna.ex.user.Error.ACCOUNT_EXISTED);
            return;
        }
        mapper.save(user);
        done(CreateUserResponse.newBuilder().setId(id).build());
    }

}
