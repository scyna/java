package io.scyna.ex.customer.domain;

import io.scyna.Logger;
import io.scyna.SerialNumber;
import io.scyna.ex.customer.model.Error;
import io.scyna.ex.customer.model.Identity;

public class CustomerService {
    private static SerialNumber oneid = new SerialNumber("ddd.customer.oneid");

    public static String nextCustomerID() throws io.scyna.Error {
        return oneid.next();
    }

    public static IRepository loadRepository(Logger logger) {
        /* TODO */
        return null;
    }

    public static void assureIdentityNotExists(IRepository repository, Identity identity) throws io.scyna.Error {
        if (repository.getCustomer(identity) != null) {
            throw Error.IDENTITY_EXISTS;
        }
    }
}