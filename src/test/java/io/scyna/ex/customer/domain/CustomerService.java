package io.scyna.ex.customer.domain;

import io.scyna.ex.customer.model.Error;
import io.scyna.ex.customer.model.Identity;

public class CustomerService {
    public static void assureIdentityNotExists(IRepository repository, Identity identity) throws io.scyna.Error {
        if (repository.getCustomer(identity) != null) {
            throw Error.IDENTITY_EXISTS;
        }
    }
}
