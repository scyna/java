package scyna.ex.account.domain;

import scyna.Context;
import scyna.ex.account.model.EmailAddress;
import scyna.ex.account.model.Error;
import scyna.ex.account.repository.Repository;

public class AccountService {

    public static IRepository loadRepository(Context context) {
        return Repository.load(context);
    }

    public static void assureAccountNotExists(IRepository repository, EmailAddress email) throws scyna.Error {
        try {
            repository.getAccountByEmail(email);
            throw Error.ACCOUNT_EXISTS;
        } catch (scyna.Error e) {
            if (e != Error.ACCOUNT_NOT_FOUND) {
                throw e;
            }
        }
    }
}
