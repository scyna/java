package ex.account.features;

import ex.account.proto.AccountCreated;
import ex.account.proto.AccountModel;
import ex.account.proto.CreateAccountRequest;
import scyna.Endpoint;
import scyna.Engine;
import scyna.Error;
import scyna.eventstore.EventStore;
import scyna.eventstore.Projection;

public class CreateAccountHandler extends Endpoint.Handler<CreateAccountRequest> {
    @Override
    protected void execute() throws Error {

        Engine.DB().assureNotExists("SELECT * FROM accounts WHERE email = ?");
        var model = EventStore.<AccountModel>CreateModel(request.getEmail());
        var data = model.getData().toBuilder()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setName(request.getName());

        model.CommitAndProject(data.build(), AccountCreated.newBuilder()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setPassword(request.getPassword())
                .build());
    }

    public static class ProjectAccountCreated extends Projection<AccountCreated, AccountModel> {
        @Override
        protected void execute(AccountCreated event, AccountModel data) throws Error {
            Engine.DB().execute("INSERT INTO accounts (email, password, name) VALUES (?, ?, ?)",
                    data.getEmail(), data.getPassword(), data.getName());
        }
    }
}
