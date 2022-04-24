package io.scyna.ex.user;

import io.scyna.ServiceHandler;
import io.scyna.ex.user.proto.ListFriendRequest;

public class ListFriendService extends ServiceHandler<ListFriendRequest> {

    @Override
    public void execute(ListFriendRequest request) {
        System.out.println("Receive ListFriendRequest");
        /* TODO */
    }
}