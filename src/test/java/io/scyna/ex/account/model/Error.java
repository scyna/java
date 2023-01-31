package io.scyna.ex.account.model;

public class Error {
        public static final io.scyna.Error ACCOUNT_EXISTS = io.scyna.Error.New(100, "Account Exists");
        public static final io.scyna.Error EMAIL_INVALID = io.scyna.Error.New(100, "Email Invalid");
        public static final io.scyna.Error ACCOUNT_NOT_FOUND = io.scyna.Error.New(101, "Account Not Found");
}
