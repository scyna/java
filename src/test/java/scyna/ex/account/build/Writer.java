package scyna.ex.account.build;

import scyna.Command;
import scyna.Endpoint;
import scyna.Engine;
import scyna.ex.account.service.CreateAccountService;
import scyna.ex.account.service.Path;

public class Writer {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "ex_account", "123456");
        Endpoint.register(Path.CREATE_ACCOUNT_URL, new CreateAccountService());
        Command.initSingleWriter("ex_account");
    }
}
