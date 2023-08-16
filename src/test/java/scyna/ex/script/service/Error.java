package scyna.ex.script.service;

public class Error {
    public static final scyna.Error ACCOUNT_EXISTS = scyna.Error.New(100, "Account Exists");
    public static final scyna.Error ACCOUNT_NOT_FOUND = scyna.Error.New(101, "Account Not Found");
}
