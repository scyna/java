package io.scyna.ex.account.event;

import io.scyna.Event;
import io.scyna.ex.account.proto.AccountCreated;

public class AccountCreatedHandler extends Event.Handler<AccountCreated> {

    @Override
    public void execute() {
        context.info("Receive AccountCreated event");
        System.out.println(data);
        /* TODO */
    }
}
