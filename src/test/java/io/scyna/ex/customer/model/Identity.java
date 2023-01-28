package io.scyna.ex.customer.model;

import java.util.Arrays;

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

    public static Identity parse(String value) throws io.scyna.Error {
        var items = Arrays.asList(value.split(":"));
        if (items.size() != 2) {
            throw Error.IDENTITY_INVALID;
        }
        return new Identity(items.get(0), items.get(1));
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
