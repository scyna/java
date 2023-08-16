package scyna.ex.account.service;

import scyna.Command;
import scyna.Endpoint;
import scyna.Engine;
import scyna.ex.account.domain.AccountService;
import scyna.ex.account.model.Account;
import scyna.ex.account.model.EmailAddress;
import scyna.ex.account.model.Name;
import scyna.ex.account.model.Password;
import scyna.ex.account.proto.AccountCreated;
import scyna.ex.account.proto.CreateAccountRequest;
import scyna.ex.account.proto.CreateAccountResponse;

public class CreateAccountService extends Endpoint.Handler<CreateAccountRequest> {
    @Override
    public void execute() throws scyna.Error {
        context.info("Receive CreateAccountRequest");
        var repository = AccountService.loadRepository(context);

        var account = new Account(context);
        account.ID = Engine.ID().next();
        account.name = Name.create(request.getName());
        account.email = EmailAddress.parse(request.getEmail());
        account.password = Password.create(request.getPassword());

        AccountService.assureAccountNotExists(repository, account.email);

        var command = Command.create(context)
                .setEntity(account.ID)
                .setChannel(Path.ACCOUNT_CREATED_CHANNEL)
                .setEvent(AccountCreated.newBuilder()
                        .setId(account.ID)
                        .setEmail(account.email.toString())
                        .setName(account.name.toString())
                        .build());

        repository.createAccount(command, account);
        command.commit();

        response(CreateAccountResponse.newBuilder().setId(account.ID).build());
    }
}