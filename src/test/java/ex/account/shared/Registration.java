package ex.account.shared;

import ex.account.features.*;
import ex.account.proto.*;
import scyna.eventstore.EventStore;
import scyna.registration.BaseRegistration;

public class Registration extends BaseRegistration<AccountModel> {
    @Override
    protected EventStore<AccountModel> initEventStore() throws Exception {
        AccountStore.Init();
        return AccountStore.store;
    }

    @Override
    protected void setup() throws Exception {
        Command(Path.CREATE_ACCOUNT)
                .Given(CreateAccountRequest.class)
                .When(CreateAccountHandler.class)
                .Then(AccountCreated.class, ProjectAccountCreated.class);

        DomainEvent().Given(AccountCreated.class).When(AccountCreatedHandler.class);
    }
}
