// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: user.proto

package io.scyna.ex.user.proto;

public interface ListFriendResponseOrBuilder extends
                // @@protoc_insertion_point(interface_extends:io.scyna.user.proto.ListFriendResponse)
                com.google.protobuf.MessageOrBuilder {

        /**
         * <code>repeated .io.scyna.user.proto.User friends = 1;</code>
         */
        java.util.List<io.scyna.ex.user.proto.User> getFriendsList();

        /**
         * <code>repeated .io.scyna.user.proto.User friends = 1;</code>
         */
        io.scyna.ex.user.proto.User getFriends(int index);

        /**
         * <code>repeated .io.scyna.user.proto.User friends = 1;</code>
         */
        int getFriendsCount();

        /**
         * <code>repeated .io.scyna.user.proto.User friends = 1;</code>
         */
        java.util.List<? extends io.scyna.ex.user.proto.UserOrBuilder> getFriendsOrBuilderList();

        /**
         * <code>repeated .io.scyna.user.proto.User friends = 1;</code>
         */
        io.scyna.ex.user.proto.UserOrBuilder getFriendsOrBuilder(
                        int index);
}
