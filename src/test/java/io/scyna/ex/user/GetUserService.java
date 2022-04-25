package io.scyna.ex.user;

import io.scyna.ServiceHandler;
import io.scyna.ex.user.proto.GetUserRequest;

public class GetUserService extends ServiceHandler<GetUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive GetUserRequest");
        /* TODO */
    }
}
