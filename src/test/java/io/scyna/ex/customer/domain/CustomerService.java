package io.scyna.ex.customer.domain;

import io.scyna.SerialNumber;
import io.scyna.ex.customer.model.Error;
import io.scyna.ex.customer.model.Identity;

public class CustomerService {
    private static SerialNumber oneid = new SerialNumber("CUSTOMER");

    public static String nextCustomerID() throws io.scyna.Error {
        return oneid.next();
    }

    public static IRepository createRepository() {
        /* TODO */
        return null;
    }

    public static void assureIdentityNotExists(IRepository repository, Identity identity) throws io.scyna.Error {
        if (repository.getCustomer(identity) != null) {
            throw Error.IDENTITY_EXISTS;
        }
    }
}
