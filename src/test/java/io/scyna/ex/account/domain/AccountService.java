package io.scyna.ex.account.domain;

import io.scyna.Logger;
import io.scyna.ex.account.model.EmailAddress;
import io.scyna.ex.account.repository.Repository;

public class AccountService {

    public static IRepository loadRepository(Logger logger) {
        return Repository.load(logger);
    }

    public static void assureAccountNotExists(IRepository repository, EmailAddress email) throws io.scyna.Error {
        /* TODO */
    }
}
