package scyna.ex.customer.domain;

import scyna.Context;
import scyna.SerialNumber;
import scyna.ex.customer.model.Error;
import scyna.ex.customer.model.Identity;
import scyna.ex.customer.repository.Repository;

public class CustomerService {
    private static SerialNumber oneid = SerialNumber.create("ddd.customer.oneid");

    public static String nextCustomerID() throws scyna.Error {
        return oneid.next();
    }

    public static IRepository loadRepository(Context context) {
        return Repository.load(context);
    }

    public static void assureIdentityNotExists(IRepository repository, Identity identity) throws scyna.Error {
        try {
            repository.getCustomerByIdentity(identity);
            throw Error.CUSTOMER_EXISTS;
        } catch (scyna.Error e) {
            if (e != Error.CUSTOMER_NOT_FOUND) {
                throw e;
            }
        }
    }
}
