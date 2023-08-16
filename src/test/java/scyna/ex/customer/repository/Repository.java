package scyna.ex.customer.repository;

import com.datastax.driver.core.exceptions.DriverException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import scyna.Context;
import scyna.Engine;
import scyna.ex.customer.domain.IRepository;
import scyna.ex.customer.model.Customer;
import scyna.ex.customer.model.Error;
import scyna.ex.customer.model.Identity;

public class Repository implements IRepository {
    final String TABLE_NAME = "customer";
    final String KEYSPACE = "ex_customer";
    private Context context;

    private Repository(Context context) {
        this.context = context;
    }

    public static IRepository load(Context context) {
        return new Repository(context);
    }

    @Override
    public void createCustomer(Customer customer) throws scyna.Error {
        var insertInto = QueryBuilder.insertInto(KEYSPACE, TABLE_NAME)
                .value("id", customer.ID)
                .value("name", customer.name)
                .value("identity", customer.identity.toString());
        try {
            Engine.DB().session().execute(insertInto);
        } catch (DriverException e) {
            context.info(e.getMessage());
            throw scyna.Error.SERVER_ERROR;
        }
    }

    @Override
    public Customer getCustomerByIdentity(Identity identity) throws scyna.Error {
        var select = QueryBuilder.select("id", "name", "identity")
                .from(KEYSPACE, TABLE_NAME)
                .where(QueryBuilder.eq("identity", identity.toString()))
                .limit(1);
        return queryCustomer(select);
    }

    @Override
    public Customer getCustomerByID(String ID) throws scyna.Error {
        var select = QueryBuilder.select("id", "name", "identity")
                .from(KEYSPACE, TABLE_NAME)
                .where(QueryBuilder.eq("id", ID))
                .limit(1);
        return queryCustomer(select);
    }

    private Customer queryCustomer(Select select) throws scyna.Error {
        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            if (row == null) {
                throw Error.CUSTOMER_NOT_FOUND;
            }

            var customer = new Customer(context);
            customer.ID = row.getString("id");
            customer.identity = Identity.parse(row.getString("identity"));
            customer.name = row.getString("name");
            return customer;
        } catch (DriverException e) {
            context.error(e.toString());
            throw scyna.Error.SERVER_ERROR;
        }

    }
}
