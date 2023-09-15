package ex.account.features;

import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import scyna.Engine;
import scyna.eventstore.Projection;

public class ProjectAccountCreated extends Projection<AccountCreated, AccountModel> {
    @Override
    protected void execute(AccountCreated event, AccountModel data) throws Error {
        Engine.LOG().info("Account created: " + data.getEmail());
    }
}