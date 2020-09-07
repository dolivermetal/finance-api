create table `user` (
    user_id bigint(20) not null,
    name varchar(100) not null,
    login varchar(100) not null,
    password varchar(100) not null,
    status tinyint(1) not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (user_id)
);

create table account (
    account_id bigint(20) not null,
    alias varchar(100) not null,
    account_type enum('BANK','CREDIT_CARD') not null,
    balance decimal(10,2) not null,
    created_at timestamp null,
    updated_at timestamp  null,
    primary key (account_id)
);

create table statement (
    statement_id bigint(20) not null,
    account_id bigint(20) not null,
    description varchar(100) not null,
    amount decimal(10,2) not null,
    category enum('AUTOMOBILE',
        'BAR',
        'BILLS',
        'BUY',
        'FOOD',
        'FUEL',
        'INVESTMENT',
        'HEALTH CARE',
        'HOME',
        'OTHERS',
        'PET CARE',
        'TAXES',
        'TRANSFER',
        'TRANSPORT',
        'TRAVEL',
        'PERSONAL CARE') not null,
    created_at timestamp null,
    primary key (statement_id),
    foreign key fk_statement_account (account_id) references account (account_id)
);
