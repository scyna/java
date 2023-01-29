package io.scyna.ex.customer.model;

public class Error {
        public static final io.scyna.Error CUSTOMER_EXISTS = io.scyna.Error.New(100, "Identity Exists");
        public static final io.scyna.Error IDENTITY_INVALID = io.scyna.Error.New(100, "Identity Exists");
        public static final io.scyna.Error CUSTOMER_NOT_FOUND = io.scyna.Error.New(101, "Customer Not Found");
}
