package io.scyna.ex.user;

import io.scyna.ServiceStatefulHandler;
import io.scyna.ex.user.proto.GetUserRequest;

public class GetUserService extends ServiceStatefulHandler<GetUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive GetUserRequest");
        /* TODO */
    }
}
