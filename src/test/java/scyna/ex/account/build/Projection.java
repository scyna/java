package scyna.ex.account.build;

import scyna.Engine;
import scyna.Event;
import scyna.Task;
import scyna.ex.account.event.AccountCreatedHandler;
import scyna.ex.account.event.SendEmailHandler;
import scyna.ex.account.service.Path;

public class Projection {

    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "ex_account", "123456");
        Event.register("ex_account", Path.ACCOUNT_CREATED_CHANNEL, new AccountCreatedHandler());
        Task.register("ex_account", Path.SEND_EMAIL_CHANNEL, new SendEmailHandler());
        Event.startListening();
    }
}
