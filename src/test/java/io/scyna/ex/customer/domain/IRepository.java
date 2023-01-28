package io.scyna.ex.customer.domain;

import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Identity;

public interface IRepository {
    void createCustomer(Customer customer) throws io.scyna.Error;

    Customer getCustomer(Identity identity) throws io.scyna.Error;

}
