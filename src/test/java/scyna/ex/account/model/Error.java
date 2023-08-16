package scyna.ex.account.model;

public class Error {
    public static final scyna.Error ACCOUNT_EXISTS = scyna.Error.New(100, "Account Exists");
    public static final scyna.Error ACCOUNT_NOT_FOUND = scyna.Error.New(101, "Account Not Found");
    public static final scyna.Error BAD_EMAIL = scyna.Error.New(102, "Bad Email");
    public static final scyna.Error BAD_NAME = scyna.Error.New(103, "Bad Name");
    public static final scyna.Error BAD_PASSWORD = scyna.Error.New(104, "Bad Password");
}
