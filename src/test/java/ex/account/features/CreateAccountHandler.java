package ex.account.features;

import ex.account.proto.AccountCreated;
import ex.account.proto.CreateAccountRequest;
import ex.account.shared.AccountStore;
import ex.account.shared.Table;
import scyna.Endpoint;
import scyna.Engine;
import scyna.Error;

public class CreateAccountHandler extends Endpoint.Handler<CreateAccountRequest> {
    @Override
    protected void execute() throws Error {
        context.info("Create account: " + request.getEmail());

        Engine.DB().assureNotExists("SELECT * FROM " + Table.ACCOUNT + " WHERE email = ?", request.getEmail());
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
}
