package io.scyna.ex.customer.repository;

import io.scyna.ex.customer.domain.IRepository;

public class Repository implements IRepository {

    @Override
    public void createCustomer() throws io.scyna.Error {

    }

    // @Override
    // public long create(User user) {
    // var id = Engine.ID().next();
    // user.id = id;
    // mapper.save(user);
    // return id;
    // }

    // @Override
    // public User get(String email) {
    // try {
    // var session = Engine.DB().session();
    // var result = session.execute(QueryBuilder
    // .select("id", "email", "name")
    // .from("ex", "user")
    // .where(QueryBuilder.eq("email", email))
    // .limit(1));
    // return mapper.map(result).one();
    // } catch (Exception e) {
    // e.printStackTrace();
    // return null;
    // }
    // }
}
