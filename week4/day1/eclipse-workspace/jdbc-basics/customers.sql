create table customers(
	id int primary key,
	name varchar(50) not null,
	email varchar(100) unique,
	phone varchar(50) unique,
	city varchar(50) default 'Bangalore',
	state varchar(50) default 'Karnataka'
);