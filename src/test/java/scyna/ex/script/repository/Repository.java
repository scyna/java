package scyna.ex.script.repository;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import scyna.Context;
import scyna.Engine;

public class Repository {

    final String TABLE_NAME = "account";
    final String KEYSPACE = "ex_account";
    private Context context;

    private Repository(Context context) {
        this.context = context;
    }

    public static Repository load(Context context) {
        return new Repository(context);
    }

    public void createAccount(Account account) throws scyna.Error {
        var insertInto = QueryBuilder.insertInto(KEYSPACE, TABLE_NAME)
                .value("id", account.ID)
                .value("email", account.email)
                .value("name", account.name)
                .value("password", account.password);

        try {
            Engine.DB().session().execute(insertInto);
        } catch (DriverException e) {
            e.printStackTrace();
            throw scyna.Error.SERVER_ERROR;
        }
    }

    public Account getAccountByEmail(String email) throws scyna.Error {
        var select = QueryBuilder.select("id", "email", "name")
                .from(KEYSPACE, TABLE_NAME)
                .where(QueryBuilder.eq("email", email))
                .limit(1);
        return queryAccount(select);
    }

    public Account getAccountByID(long ID) throws scyna.Error {
        var select = QueryBuilder.select("id", "email", "name")
                .from(KEYSPACE, TABLE_NAME)
                .where(QueryBuilder.eq("id", ID))
                .limit(1);
        return queryAccount(select);
    }

    private Account queryAccount(Select select) throws scyna.Error {
        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            if (row == null) {
                return null;
            }

            var account = new Account();
            account.ID = row.getLong("id");
            account.email = row.getString("email");
            account.name = row.getString("name");
            return account;
        } catch (DriverException e) {
            context.error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }
}
