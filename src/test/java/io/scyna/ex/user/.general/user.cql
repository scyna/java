
DROP TABLE IF EXISTS ex.user;
CREATE TABLE ex.user
(
    id           bigint PRIMARY KEY,
    email        text ,
    name         text,
    password     text,
);
CREATE INDEX ON ex.user (email);

DROP TABLE IF EXISTS ex.has_friend;
CREATE TABLE ex.has_friend
(
    user_id        bigint,
    friend_id      bigint,
    PRIMARY KEY(user_id, friend_id)
);