package io.scyna.ex.account.repository;

import io.scyna.Error;
import io.scyna.Logger;
import io.scyna.ex.account.domain.IRepository;
import io.scyna.ex.account.model.Account;
import io.scyna.ex.account.model.EmailAddress;

public class Repository implements IRepository {

    final String TABLE_NAME = "account";
    final String KEYSPACE = "ex_account";
    private Logger logger;

    private Repository(Logger logger) {
        this.logger = logger;
    }

    public static IRepository load(Logger logger) {
        return new Repository(logger);
    }

    @Override
    public void createAccount(Account account) throws Error {
        // TODO Auto-generated method stub
    }

    @Override
    public Account getAccountByEmail(EmailAddress email) throws Error {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Account getCustomerByID(long ID) throws Error {
        // TODO Auto-generated method stub
        return null;
    }

}
