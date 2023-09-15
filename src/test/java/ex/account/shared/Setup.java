package ex.account.shared;

import ex.account.features.*;
import ex.account.proto.*;
import scyna.registration.Regitration;

public class Setup extends Regitration {
    private static Setup instance = new Setup();

    public static void Init() throws Exception {
        instance.execute();
    }

    public static void TestInit() throws Exception {
        testMode = true;
        instance.execute();
    }

    private void execute() throws Exception {
        Command(Path.CREATE_ACCOUNT)
                .Given(CreateAccountRequest.class)
                .When(CreateAccountHandler.class)
                .Then(AccountCreated.class);

        DomainEvent().Given(AccountCreated.class).When(AccountCreatedHandler.class);
    }
}
