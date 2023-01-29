DROP KEYSPACE IF EXISTS ts_ex;
CREATE KEYSPACE ts_ex WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

DROP TABLE IF EXISTS ts_ex.account;
CREATE TABLE ts_ex.account
(
    id           bigint PRIMARY KEY,
    name         text,
    email        text,
    phone        text,
    dob          text,
    gender       text,
);
CREATE INDEX ON ts_ex.account (email);
