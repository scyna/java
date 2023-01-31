package io.scyna.ex.script.service;

public class Error {
        public static final io.scyna.Error ACCOUNT_EXISTS = io.scyna.Error.New(100, "Account Exists");
        public static final io.scyna.Error ACCOUNT_NOT_FOUND = io.scyna.Error.New(101, "Account Not Found");
}
