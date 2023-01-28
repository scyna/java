package io.scyna.ex.customer.model;

public class Identity {

    private String type;
    private String number;

    private Identity(String type, String number) {
        this.type = type;
        this.number = number;
    }

    public static Identity create(String type, String number) throws io.scyna.Error {
        /* TODO: validate */
        return new Identity(type, number);
    }

    public static Identity parse(String value) {
        /* TODO */
        return new Identity("", "");
    }

    public String getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public String toString() {
        return type + ":" + number;
    }
}
