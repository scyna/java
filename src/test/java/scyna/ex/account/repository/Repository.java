package scyna.ex.account.repository;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import scyna.Command;
import scyna.Context;
import scyna.Engine;
import scyna.ex.account.domain.IRepository;
import scyna.ex.account.model.Account;
import scyna.ex.account.model.EmailAddress;
import scyna.ex.account.model.Name;

public class Repository implements IRepository {

    final String TABLE_NAME = "account";
    final String KEYSPACE = "ex_account";
    private Context context;

    private Repository(Context context) {
        this.context = context;
    }

    public static IRepository load(Context context) {
        return new Repository(context);
    }

    @Override
    public void createAccount(Command command, Account account) throws scyna.Error {
        command.getBatch().add(QueryBuilder.insertInto(KEYSPACE, TABLE_NAME)
                .value("id", account.ID)
                .value("email", account.email.toString())
                .value("name", account.name.toString()));
    }

    @Override
    public Account getAccountByEmail(EmailAddress email) throws scyna.Error {
        var select = QueryBuilder.select("id", "email", "name")
                .from(KEYSPACE, TABLE_NAME)
                .where(QueryBuilder.eq("email", email.toString()))
                .limit(1);
        return queryAccount(select);
    }

    @Override
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
                throw scyna.ex.account.model.Error.ACCOUNT_NOT_FOUND;
            }

            var account = new Account(context);
            account.ID = row.getLong("id");
            account.email = EmailAddress.parse(row.getString("email"));
            account.name = Name.create(row.getString("name"));
            return account;
        } catch (DriverException e) {
            context.error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }
    }
}
