package io.scyna.ex.user;

import io.scyna.ServiceStatefulHandler;
import io.scyna.ex.user.proto.ListFriendRequest;

public class ListFriendService extends ServiceStatefulHandler<ListFriendRequest> {

    @Override
    public void execute() {
        System.out.println("Receive ListFriendRequest");
        /* TODO */
    }
}