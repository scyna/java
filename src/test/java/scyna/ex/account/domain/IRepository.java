package scyna.ex.account.domain;

import scyna.Command;
import scyna.ex.account.model.Account;
import scyna.ex.account.model.EmailAddress;

public interface IRepository {

    void createAccount(Command command, Account account) throws scyna.Error;

    Account getAccountByEmail(EmailAddress email) throws scyna.Error;

    Account getAccountByID(long ID) throws scyna.Error;

}
