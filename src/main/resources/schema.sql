create table CUSTOMERS
(
    id int primary key auto_increment,
    name           varchar(255)                      not null,
    surname        varchar(255)                      not null,
    age            int check (age > 0 and age < 120) not null,
    phone_number   varchar(30)
);

insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('alexey', 'Ivanov', 20, '89112223399');
insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('Andrey', 'Petrov', 29, '89114443399');
insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('Alexey', 'Sidorov', 45, '89112223300');
insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('Mihail', 'Karpov', 37, '89112221299');
insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('Anton', 'Kasparov', 70, '89112221399');
insert into CUSTOMERS (name, surname, age, phone_number)
    VALUE ('alexey', 'Sviridov', 52, '89212221299');

create table ORDERS
(
    id             int primary key          auto_increment,
    date           TIMESTAMP not null default now(),
    customer_id    int                      not null,
    product_name   varchar(255)             not null,
    amount         int check (amount > 0)   not null,
    foreign key (customer_id) REFERENCES CUSTOMERS (id)
);

insert into ORDERS (customer_id, product_name, amount)
    VALUE (1, 'pizza', 2);
insert into ORDERS (customer_id, product_name, amount)
    VALUE (4, 'sushi', 3);
insert into ORDERS (customer_id, product_name, amount)
    VALUE (6, 'steak', 1);
insert into ORDERS (customer_id, product_name, amount)
    VALUE (2, 'pasta', 2);
insert into ORDERS (customer_id, product_name, amount)
    VALUE (5, 'pizza', 1);
insert into ORDERS (customer_id, product_name, amount)
    VALUE (3, 'sushi', 3);