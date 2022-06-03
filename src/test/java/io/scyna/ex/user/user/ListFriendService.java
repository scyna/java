package io.scyna.ex.user.user;

import io.scyna.Service;
import io.scyna.ex.user.proto.ListFriendRequest;

public class ListFriendService extends Service.Handler<ListFriendRequest> {

    @Override
    public void execute() {
        System.out.println("Receive ListFriendRequest");
        /* TODO */
    }
}