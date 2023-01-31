package io.scyna.ex.account.domain;

import com.datastax.driver.core.querybuilder.Batch;
import io.scyna.ex.account.model.Account;
import io.scyna.ex.account.model.EmailAddress;

public interface IRepository {

    void createAccount(Account account, Batch batch) throws io.scyna.Error;

    Account getAccountByEmail(EmailAddress email) throws io.scyna.Error;

    Account getAccountByID(long ID) throws io.scyna.Error;

}
