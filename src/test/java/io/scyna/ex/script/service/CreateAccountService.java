package io.scyna.ex.script.service;

import io.scyna.Endpoint;
import io.scyna.Engine;
import io.scyna.ex.script.proto.CreateAccountRequest;
import io.scyna.ex.script.proto.CreateAccountResponse;
import io.scyna.ex.script.repository.Account;
import io.scyna.ex.script.repository.Repository;

public class CreateAccountService extends Endpoint.Handler<CreateAccountRequest> {
    @Override
    public void execute() throws io.scyna.Error {
        var repository = Repository.load(context);
        validateRequest(request);

        if (repository.getAccountByEmail(request.getEmail()) != null) {
            throw Error.ACCOUNT_EXISTS;
        }

        var account = new Account();
        account.ID = Engine.ID().next();
        account.name = request.getName();
        account.email = request.getEmail();
        account.password = request.getPassword();

        repository.createAccount(account);

        response(CreateAccountResponse.newBuilder().setId(account.ID).build());
    }

    private void validateRequest(CreateAccountRequest request) throws io.scyna.Error {
        /* TODO */
    }
}
