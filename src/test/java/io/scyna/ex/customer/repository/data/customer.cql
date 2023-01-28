
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
