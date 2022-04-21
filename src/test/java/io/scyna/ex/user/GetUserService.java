package io.scyna.ex.user;

import io.scyna.Service;
import io.scyna.ex.user.proto.GetUserRequest;

public class GetUserService extends Service.Base<GetUserRequest> {

    @Override
    public void execute() {
        System.out.println("Receive GetUserRequest");
        var request = (GetUserRequest) parse(GetUserRequest.parser(), GetUserRequest.newBuilder());
        if (request == null)
            return;

        /* TODO */
    }
}
