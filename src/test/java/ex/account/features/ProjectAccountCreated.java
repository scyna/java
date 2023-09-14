package ex.account.features;

import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import scyna.eventstore.Projection;

public class ProjectAccountCreated extends Projection<AccountCreated, AccountModel> {
    @Override
    protected void execute(AccountCreated event, AccountModel data) throws Error {
        /* do nothing */
    }
}