package ex.account.shared;

import ex.account.features.*;
import ex.account.proto.*;
import scyna.eventstore.EventStore;
import scyna.registration.Registration;

public class Setup extends Registration<AccountModel> {
    private static Setup instance = new Setup();

    public static void Init() throws Exception {
        instance.init();
    }

    public static void TestInit() throws Exception {
        instance.testInit();
    }

    @Override
    protected void execute() throws Exception {
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
