package io.scyna.ex.user;

import io.scyna.Service;
import io.scyna.ex.user.proto.ListFriendRequest;

public class ListFriendService extends Service.Base<ListFriendRequest> {

    @Override
    public void execute() {
        System.out.println("Receive ListFriendRequest");
        var request = (ListFriendRequest) parse(ListFriendRequest.parser(), ListFriendRequest.newBuilder());
        if (request == null)
            return;

        /* TODO */
    }
}