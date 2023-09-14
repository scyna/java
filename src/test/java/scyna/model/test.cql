DROP KEYSPACE IF EXISTS scyna_test;
CREATE KEYSPACE scyna_test WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE scyna_test;

DROP TABLE IF EXISTS test_table;
CREATE TABLE test_table (
    key            text,
    value          text,
    PRIMARY KEY(key, value)
);