create table `user` (
    user_id bigint(20) not null,
    name varchar(100) not null,
    login varchar(100) not null,
    password varchar(100) not null,
    status tinyint(1) not null,
    primary key (user_id)
);

create table account_type (
    account_type_id bigint(20) not null,
    name varchar(100) not null,
    primary key (account_type_id)
);

create table category (
    category_id bigint(20) not null,
    name varchar(100) not null,
    primary key (category_id)
);

create table account (
    account_id bigint(20) not null,
    alias varchar(100) not null,
    account_type enum('BANK','CREDIT_CARD') not null,
    balance decimal(10,2) not null,
    primary key (account_id)
);

create table statement (
    statement_id bigint(20) not null,
    account_id bigint(20) not null,
    amount decimal(10,2) not null,
    created_at date not null,
    description varchar(100) not null,
    category enum('FOOD','BILLS') not null,
    primary key (statement_id),
    foreign key fk_statement_account (account_id) references account (account_id)
);