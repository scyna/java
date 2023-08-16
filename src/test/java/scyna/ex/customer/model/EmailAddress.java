package scyna.ex.customer.model;

public class EmailAddress {
    String value;

    private EmailAddress(String email) {
        this.value = email;
    }

    public static EmailAddress parse(String email) {
        /* TODO: validation */
        return new EmailAddress(email);
    }

    public String toString() {
        return value;
    }
}
