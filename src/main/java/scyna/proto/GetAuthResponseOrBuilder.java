// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: engine.proto

package scyna.proto;

public interface GetAuthResponseOrBuilder extends
        // @@protoc_insertion_point(interface_extends:scyna.GetAuthResponse)
        com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string Token = 1;</code>
     * 
     * @return The token.
     */
    java.lang.String getToken();

    /**
     * <code>string Token = 1;</code>
     * 
     * @return The bytes for token.
     */
    com.google.protobuf.ByteString getTokenBytes();

    /**
     * <code>uint64 Expired = 2;</code>
     * 
     * @return The expired.
     */
    long getExpired();

    /**
     * <code>string UserID = 3;</code>
     * 
     * @return The userID.
     */
    java.lang.String getUserID();

    /**
     * <code>string UserID = 3;</code>
     * 
     * @return The bytes for userID.
     */
    com.google.protobuf.ByteString getUserIDBytes();
}
