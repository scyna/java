package io.scyna.ex.scylla.user;

import io.scyna.Service;
import io.scyna.ex.scylla.proto.GetUserRequest;

public class GetUserService extends Service.Handler<GetUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive GetUserRequest");
        /* TODO */
    }
}
