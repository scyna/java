package scyna.ex.account.build;

import scyna.Endpoint;
import scyna.Engine;
import scyna.ex.account.service.GetAccountByEmailService;
import scyna.ex.account.service.Path;

public class Reader {
    public static void main(String[] args) throws Exception {
        Engine.init("http://127.0.0.1:8081", "ex_account", "123456");
        Endpoint.register(Path.GET_ACCOUNT_BY_EMAIl_URL, new GetAccountByEmailService());
    }
}
