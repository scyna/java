package io.scyna.ex.customer.repository;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.scyna.ex.customer.domain.IRepository;

@Table(keyspace = "ex", name = "user", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class User {
    private static IRepository repository = new Repository();

    public static IRepository repository() {
        return repository;
    }

    @PartitionKey
    @Column(name = "id")
    public long id;

    @Column(name = "email")
    public String email;

    @Column(name = "name")
    public String name;

    @Column(name = "password")
    public String password;
}
