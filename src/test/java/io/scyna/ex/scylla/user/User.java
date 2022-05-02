package io.scyna.ex.scylla.user;

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

    public static User fromProto(io.scyna.ex.scylla.proto.User user) {
        var u = new User();
        u.id = user.getId();
        u.email = user.getEmail();
        u.name = user.getName();
        u.password = user.getPassword();
        return u;
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
