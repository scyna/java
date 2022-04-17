package io.scyna.ex.user.dao;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "ex", name = "user", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class User {

    @PartitionKey
    @Column(name = "id")
    private final long id;

    @Column(name = "email")
    private final String email;

    @Column(name = "name")
    private final String name;

    @Column(name = "password")
    private String password;

    public User(long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
