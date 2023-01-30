package io.scyna.ex.account.model;

import io.scyna.Logger;

public class Account {
    private Logger logger;

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public long ID;
    public Name name;
    public EmailAddress email;
    public Password password;
}
