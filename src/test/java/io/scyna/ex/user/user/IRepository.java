package io.scyna.ex.user.user;

public interface IRepository {
    long create(User user);

    User get(String email);
}
