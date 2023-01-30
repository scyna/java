package io.scyna.ex.account.service;

import io.scyna.Command;
import io.scyna.Engine;
import io.scyna.ex.account.domain.AccountService;
import io.scyna.ex.account.model.Account;
import io.scyna.ex.account.model.EmailAddress;
import io.scyna.ex.account.model.Password;
import io.scyna.ex.account.proto.AccountCreated;
import io.scyna.ex.account.proto.CreateAccountRequest;
import io.scyna.ex.account.proto.CreateAccountResponse;

public class CreateAccountService extends Command.Handler<CreateAccountRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        var repository = AccountService.loadRepository(context);

        var account = new Account();
        account.ID = Engine.ID().next();
        account.name = request.getName();
        account.email = EmailAddress.parse(request.getEmail());
        account.password = Password.create(request.getPassword());

        AccountService.assureEmailNotExists(repository, account.email);

        repository.createAccount(account);

        storeEvent(account.ID, "something here", AccountCreated.newBuilder()
                .setId(account.ID)
                .setEmail(account.email.toString())
                .setName(account.name)
                .build());

        response(CreateAccountResponse.newBuilder().setId(account.ID).build());
    }
}