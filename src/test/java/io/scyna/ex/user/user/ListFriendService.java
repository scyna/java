package io.scyna.ex.user.user;

import io.scyna.Endpoint;
import io.scyna.ex.user.proto.ListFriendRequest;

public class ListFriendService extends Endpoint.Handler<ListFriendRequest> {

    @Override
    public void execute() {
        System.out.println("Receive ListFriendRequest");
        /* TODO */
    }
}