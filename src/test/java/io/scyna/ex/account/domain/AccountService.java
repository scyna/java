package io.scyna.ex.account.domain;

import io.scyna.Logger;
import io.scyna.ex.account.model.EmailAddress;
import io.scyna.ex.account.repository.Repository;
import io.scyna.ex.account.model.Error;

public class AccountService {

    public static IRepository loadRepository(Logger logger) {
        return Repository.load(logger);
    }

    public static void assureAccountNotExists(IRepository repository, EmailAddress email) throws io.scyna.Error {
        try {
            repository.getAccountByEmail(email);
            throw Error.ACCOUNT_EXISTS;
        } catch (io.scyna.Error e) {
            if (e != Error.ACCOUNT_NOT_FOUND) {
                throw e;
            }
        }
    }
}
