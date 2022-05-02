package io.scyna.ex.scylla.user;

public interface IRepository {
    long create(User user);

    User get(String email);
}
