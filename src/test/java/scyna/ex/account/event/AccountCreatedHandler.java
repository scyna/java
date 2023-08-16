package scyna.ex.account.event;

import scyna.Error;
import scyna.Event;
import scyna.ex.account.proto.AccountCreated;
import scyna.ex.account.proto.SendEmailTask;
import scyna.ex.account.service.Path;

public class AccountCreatedHandler extends Event.Handler<AccountCreated> {

    @Override
    public void execute() {
        context.info("Receive AccountCreated event");
        System.out.println(data);

        try {
            context.scheduleTask(Path.SEND_EMAIL_CHANNEL, System.currentTimeMillis() / 1000, 61,
                    SendEmailTask.newBuilder()
                            .setEmail(data.getEmail())
                            .setContent("Just say hello")
                            .build(),
                    2);
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
