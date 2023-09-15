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
        System.out.println("1");
        var model = AccountStore.Create(request.getEmail());
        System.out.println("2");
        var data = model.getData().toBuilder()
                .setEmail(request.getEmail())
                .setPassword(request.getPassword())
                .setName(request.getName());
        System.out.println("3");

        model.commitAndProject(data.build(), AccountCreated.newBuilder()
                .setEmail(request.getEmail())
                .setName(request.getName())
                .setPassword(request.getPassword())
                .build());
        System.out.println("4");
        context.raiseDomainEvent(model.getEvent());
        System.out.println("5");
    }
}
