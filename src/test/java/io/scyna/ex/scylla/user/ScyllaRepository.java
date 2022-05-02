package io.scyna.ex.scylla.user;

import com.datastax.driver.mapping.Mapper;

import io.scyna.Engine;

public class ScyllaRepository implements IRepository {
    private Mapper<User> mapper = Engine.DB().mapping().mapper(io.scyna.ex.scylla.user.User.class);;

    @Override
    public long create(User user) {
        var id = Engine.ID().next();
        user.id = id;
        mapper.save(user);
        return id;
    }

    @Override
    public User get(String email) {
        return mapper.get(email);
    }
}
