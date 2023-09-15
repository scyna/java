DROP KEYSPACE IF EXISTS ex_account;
CREATE KEYSPACE ex_account WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

USE ex_account;

DROP TABLE IF EXISTS account_events;
CREATE TABLE account_events (
    id              text,
    version         bigint,
    type            text,
    data            blob, 
    event           blob,
    created         timestamp,
    locked          timestamp,
    state           smallint,
    PRIMARY KEY(id, version)
) WITH CLUSTERING ORDER BY (version DESC);
CREATE INDEX ON account_events (state);

DROP TABLE IF EXISTS account;
CREATE TABLE account
(
    id                      bigint PRIMARY KEY,
    name                    text,
    email                   text,
    password                text,
    data                    text,
);
CREATE INDEX ON account (email);

