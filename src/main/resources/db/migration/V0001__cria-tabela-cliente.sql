create table cliente
(
	id bigint auto_increment,
	nome varchar(60) not null,
	email varchar(255) null,
	telefone varchar(20) null,
	constraint clientes_pk
		primary key (id)
);