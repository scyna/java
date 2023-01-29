DROP KEYSPACE IF EXISTS ddd_ex;
CREATE KEYSPACE ddd_ex WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

DROP TABLE IF EXISTS ddd_ex.customer;
CREATE TABLE ddd_ex.customer
(
    id           text PRIMARY KEY,
    name         text,
    identity     text,
    email        text,
    phone        text,
    dob          text,
    gender       text,
);
CREATE INDEX ON ddd_ex.customer (identity);
