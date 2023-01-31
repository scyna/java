package io.scyna.ex.account.model;

import java.util.regex.Pattern;

public class EmailAddress {
    static final String regexPattern = "^(.+)@(\\S+)$";
    String value;

    private EmailAddress(String email) {
        this.value = email;
    }

    public static EmailAddress parse(String email) throws io.scyna.Error {
        if (email == null || email.length() == 0) {
            throw Error.EMAIL_INVALID;
        }

        if (!Pattern.compile(regexPattern).matcher(email).matches()) {
            throw Error.EMAIL_INVALID;
        }

        return new EmailAddress(email);
    }

    public String toString() {
        return value;
    }
}
