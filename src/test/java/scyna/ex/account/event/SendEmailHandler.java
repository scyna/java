package scyna.ex.account.event;

import scyna.Task;
import scyna.ex.account.proto.SendEmailTask;

public class SendEmailHandler extends Task.Handler<SendEmailTask> {

    @Override
    public void execute() {
        context.info("Receive SendEmailTask");
        System.out.println(data);
        /* TODO */
    }
}