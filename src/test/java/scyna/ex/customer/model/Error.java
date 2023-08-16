package scyna.ex.customer.model;

public class Error {
    public static final scyna.Error CUSTOMER_EXISTS = scyna.Error.New(100, "Identity Exists");
    public static final scyna.Error IDENTITY_INVALID = scyna.Error.New(100, "Identity Exists");
    public static final scyna.Error CUSTOMER_NOT_FOUND = scyna.Error.New(101, "Customer Not Found");
}
