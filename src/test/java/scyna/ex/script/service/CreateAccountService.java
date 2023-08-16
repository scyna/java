package scyna.ex.script.service;

import java.util.regex.Pattern;

import scyna.Endpoint;
import scyna.Engine;
import scyna.ex.script.proto.CreateAccountRequest;
import scyna.ex.script.proto.CreateAccountResponse;
import scyna.ex.script.repository.Account;
import scyna.ex.script.repository.Repository;

public class CreateAccountService extends Endpoint.Handler<CreateAccountRequest> {
    static final String EMAIL_PATTERN = "^(.+)@(\\S+)$"; // FIXME: do not use this pattern in production

    @Override
    public void execute() throws scyna.Error {
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

    private void validateRequest(CreateAccountRequest request) throws scyna.Error {
        if (request.getEmail() == null || request.getName() == null || request.getPassword() == null) {
            throw scyna.Error.REQUEST_INVALID;
        }

        if (request.getEmail().length() + request.getName().length() + request.getPassword().length() == 0) {
            throw scyna.Error.REQUEST_INVALID;
        }

        if (!Pattern.compile(EMAIL_PATTERN).matcher(request.getEmail()).matches()) {
            throw scyna.Error.REQUEST_INVALID;
        }
    }
}
