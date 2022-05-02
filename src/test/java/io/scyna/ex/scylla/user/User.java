package io.scyna.ex.scylla.user;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

@Table(keyspace = "ex", name = "user", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class User {
    private static IRepository repository;

    public static IRepository repository() {
        return repository;
    }

    public static void initScyllaRepository() {
        repository = new ScyllaRepository();
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

    public User(io.scyna.ex.scylla.proto.User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
        this.password = user.getPassword();
    }

    public io.scyna.ex.scylla.proto.User toProto() {
        return io.scyna.ex.scylla.proto.User.newBuilder()
                .setId(id)
                .setEmail(email)
                .setName(name)
                .setPassword(password)
                .build();
    }

}
