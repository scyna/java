package ex.account.features;

import ex.account.proto.AccountCreated;
import scyna.DomainEvent;
import scyna.Error;

public class AccountCreatedHandler extends DomainEvent.Handler<AccountCreated> {

    @Override
    public void Execute() throws Error {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Execute'");
    }

}
