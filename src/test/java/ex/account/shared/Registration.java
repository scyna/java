package ex.account.shared;

import ex.account.features.*;
import ex.account.proto.*;
import scyna.eventstore.EventStore;
import scyna.registration.BaseRegistration;

public class Registration extends BaseRegistration<AccountModel> {
    private static Registration instance = new Registration();

    public static void Init() throws Exception {
        instance.init();
    }

    public static void TestInit() throws Exception {
        instance.testInit();
    }

    @Override
    protected void setup() throws Exception {
        Command(Path.CREATE_ACCOUNT)
                .Given(CreateAccountRequest.class)
                .When(CreateAccountHandler.class)
                .Then(AccountCreated.class);

        DomainEvent().Given(AccountCreated.class).When(AccountCreatedHandler.class);
    }

    @Override
    protected EventStore<AccountModel> initEventStore() throws Exception {
        AccountStore.Init();
        return AccountStore.store;
    }
}
