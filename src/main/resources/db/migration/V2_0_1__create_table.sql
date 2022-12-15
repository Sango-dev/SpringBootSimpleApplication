DROP TABLE IF EXISTS persons;
create table persons (
    id varchar(255) not null,
    first_name varchar(255),
    last_name varchar(255),
    birth_date date,
    primary key (id)
);