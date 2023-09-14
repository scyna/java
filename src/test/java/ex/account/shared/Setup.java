package ex.account.shared;

import ex.account.features.*;
import ex.account.proto.*;
import scyna.registration.R;

public class Setup {
    public static void Init() throws Exception {
        R.Command(Path.CREATE_ACCOUNT)
                .Given(CreateAccountRequest.class)
                .When(CreateAccount.class)
                .Then(AccountCreated.class, ProjectAccountCreated.class);

        R.Command(Path.CREATE_ACCOUNT)
                .Given(CreateAccountRequest.class)
                .When(CreateAccount.class)
                .Then(AccountCreated.class);
    }

}
