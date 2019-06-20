create table customer (
    id identity primary key,
    name varchar(100) not null,
    lastname varchar(100) not null,
    address varchar(100) not null,
    phoneNumber varchar(100) not null,
    user varchar(100) not null,
    password varchar(100) not null

);
create table product (
    id identity primary key,
    description varchar(100) not null,
    type varchar(100) not null,
    price float not null,


);