package io.scyna.ex.account.model;

public class Name {
    String value;

    private Name(String name) {
        this.value = name;
    }

    public static Name create(String name) {
        /* TODO: validation */
        return new Name(name);
    }

    public String toString() {
        return value;
    }
}
