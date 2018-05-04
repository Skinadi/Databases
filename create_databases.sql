drop table if exists client;
create table Client (
	email varchar (80) primary key,
	password varchar (80),
	name varchar (80),
	surname varchar (80)
);
drop table if exists friends;
create table Friends (
	email1 varchar (80),
	email2 varchar (80)
);
drop table if exists transactions;
create table Transactions (
	email1 varchar (80),
	email2 varchar (80),
	product varchar (80),
	data date not null default now(),
	price float(8)
);

