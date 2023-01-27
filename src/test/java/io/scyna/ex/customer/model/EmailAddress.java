package io.scyna.ex.customer.model;

public class EmailAddress {
    String value;

    public static EmailAddress parse(String email) {
        /* TODO: validation */
        return new EmailAddress(email);
    }

    private EmailAddress(String email) {
        this.value = email;
    }

    public String ToString() {
        return value;
    }
}
