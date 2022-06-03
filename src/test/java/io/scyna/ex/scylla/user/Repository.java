package io.scyna.ex.scylla.user;

import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.mapping.Mapper;

import io.scyna.Engine;

public class Repository implements IRepository {
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
        try {
            var session = Engine.DB().session();
            var result = session.execute(QueryBuilder
                    .select("id", "email", "name")
                    .from("ex", "user")
                    .where(QueryBuilder.eq("email", email))
                    .limit(1));
            return mapper.map(result).one();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
