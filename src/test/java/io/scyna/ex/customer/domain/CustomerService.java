package io.scyna.ex.customer.domain;

import io.scyna.Logger;
import io.scyna.SerialNumber;
import io.scyna.ex.customer.model.Error;
import io.scyna.ex.customer.model.Identity;
import io.scyna.ex.customer.repository.Repository;

public class CustomerService {
    private static SerialNumber oneid = new SerialNumber("ddd.customer.oneid");
    private IRepository repository_;

    private CustomerService(Logger logger) {
        repository_ = Repository.load(logger);
    }

    public static CustomerService load(Logger logger) {
        return new CustomerService(logger);
    }

    public String nextCustomerID() throws io.scyna.Error {
        return oneid.next();
    }

    public IRepository repository() {
        return repository_;
    }

    public void assureIdentityNotExists(Identity identity) throws io.scyna.Error {
        if (repository_.getCustomer(identity) != null) {
            throw Error.IDENTITY_EXISTS;
        }
    }
}
