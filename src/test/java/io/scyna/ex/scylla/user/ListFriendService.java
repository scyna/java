package io.scyna.ex.scylla.user;

import io.scyna.Service;
import io.scyna.ex.scylla.proto.ListFriendRequest;

public class ListFriendService extends Service.Handler<ListFriendRequest> {

    @Override
    public void execute() {
        System.out.println("Receive ListFriendRequest");
        /* TODO */
    }
}