package io.scyna.ex.customer.repository;

import com.datastax.driver.core.exceptions.QueryExecutionException;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import io.scyna.Engine;
import io.scyna.ex.customer.domain.IRepository;
import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Error;
import io.scyna.ex.customer.model.Identity;

public class Repository implements IRepository {
    final String TABLE_NAME = "ddd_ex.customer";

    @Override
    public void createCustomer(Customer customer) throws io.scyna.Error {
        var insertInto = QueryBuilder.insertInto(TABLE_NAME)
                .value("id", customer.ID)
                .value("name", customer.name)
                .value("identity", customer.identity.toString());
        try {
            Engine.DB().session().execute(insertInto);
        } catch (QueryExecutionException e) {
            throw io.scyna.Error.SERVER_ERROR;
        }
    }

    @Override
    public Customer getCustomer(Identity identity) throws io.scyna.Error {
        var select = QueryBuilder.select("id", "name", "identity")
                .from(TABLE_NAME)
                .where(QueryBuilder.eq("identity", identity.toString()))
                .limit(1);

        try {
            var rs = Engine.DB().session().execute(select);
            var row = rs.one();

            if (row == null) {
                throw Error.CUSTOMER_NOT_FOUND;
            }

            var customer = new Customer();
            customer.ID = row.getString("id");
            customer.identity = Identity.parse(row.getString("identity"));
            customer.name = row.getString("name");

            return customer;
        } catch (QueryExecutionException e) {
            throw io.scyna.Error.SERVER_ERROR;
        }
    }
}
