package io.scyna.ex.account.model;

public class Password {
    String value;

    private Password(String password) {
        this.value = password;
    }

    public static Password create(String password) {
        /* TODO: validation */
        return new Password(password);
    }

    public String toString() {
        return value;
    }
}
