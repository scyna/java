package ex.account.features;

import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import ex.account.proto.CreateAccountRequest;
import ex.account.shared.AccountStore;
import scyna.Endpoint;
import scyna.Engine;
import scyna.Error;
import scyna.eventstore.Projection;

public class CreateAccount extends Endpoint.Handler<CreateAccountRequest> {
    @Override
    protected void execute() throws Error {

        Engine.DB().assureNotExists("SELECT * FROM accounts WHERE email = ?");
        var model = AccountStore.Create(request.getEmail());
        var data = model.getData().toBuilder()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setName(request.getName());

        model.commitAndProject(data.build(), AccountCreated.newBuilder()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setPassword(request.getPassword())
                .build());
        context.raiseDomainEvent(model.getEvent());
    }

    public static class ProjectAccountCreated extends Projection<AccountCreated, AccountModel> {
        @Override
        protected void execute(AccountCreated event, AccountModel data) throws Error {
            /* do nothing */
        }
    }
}
