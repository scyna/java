package io.scyna.ex.customer.model;

public class Identity {
    private String type;

    public String getType() {
        return type;
    }

    private String number;

    public String getNumber() {
        return number;
    }

    private Identity(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public static Identity newIdentity(String type, String number) throws io.scyna.Error {
        /* TODO: validate */
        return new Identity(type, number);
    }
}
