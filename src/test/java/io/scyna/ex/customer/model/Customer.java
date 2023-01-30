package io.scyna.ex.customer.model;

import io.scyna.Logger;

public class Customer {
    private Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public String ID;
    public Identity identity;
    public String name;
    public EmailAddress email;
    public PhoneNumber phone;
    public Gender gender;
    public StreetAddress address;
}
