package io.scyna.ex.customer.repository;

import io.scyna.Error;
import io.scyna.ex.customer.domain.IRepository;
import io.scyna.ex.customer.model.Customer;
import io.scyna.ex.customer.model.Identity;

public class Repository implements IRepository {

    @Override
    public void createCustomer(Customer customer) throws io.scyna.Error {

    }

    @Override
    public Customer getCustomer(Identity identity) throws Error {
        /* TODO */
        return null;
    }
}
