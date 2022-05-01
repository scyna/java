package io.scyna.ex.user;

import io.scyna.Service;
import io.scyna.ex.user.proto.GetUserRequest;

public class GetUserService extends Service.Handler<GetUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive GetUserRequest");
        /* TODO */
    }
}
