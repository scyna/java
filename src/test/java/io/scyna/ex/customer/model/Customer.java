package io.scyna.ex.customer.model;

import io.scyna.Context;

public class Customer {
    private Context context;

    public Customer(Context context) {
        this.context = context;
    }

    public String ID;
    public Identity identity;
    public String name;
    public EmailAddress email;
    public PhoneNumber phone;
    public Gender gender;
    public StreetAddress address;
}
