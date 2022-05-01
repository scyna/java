package io.scyna.ex.user.dao;

import com.datastax.driver.mapping.Mapper;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.scyna.Engine;

@Table(keyspace = "ex", name = "user", caseSensitiveKeyspace = false, caseSensitiveTable = false)
public class User {
    @PartitionKey
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    private static Mapper<User> mapper = null;

    public User(io.scyna.ex.user.proto.User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.name = user.getName();
    }

    public static Mapper<User> mapper() {
        if (mapper == null) {
            mapper = Engine.DB().mapping().mapper(io.scyna.ex.user.dao.User.class);
        }
        return mapper;
    }

    public static long create(User user) {
        var id = Engine.ID().next();
        user.id = id;
        mapper().save(user);
        return id;
    }

    public static User get(String email) {
        return mapper().get(email);
    }
}
