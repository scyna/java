package scyna.ex.customer.domain;

import scyna.ex.customer.model.Customer;
import scyna.ex.customer.model.Identity;

public interface IRepository {

    void createCustomer(Customer customer) throws scyna.Error;

    Customer getCustomerByIdentity(Identity identity) throws scyna.Error;

    Customer getCustomerByID(String ID) throws scyna.Error;

}
