CREATE KEYSPACE IF NOT EXISTS project_demo WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };


CREATE TABLE IF NOT EXISTS project_demo.users (
    user_id uuid,
    first_name text,
    last_name text,
    email text,
    password text,
    created_ts timestamp,
    birthday date,
    PRIMARY KEY((user_id))
);