create database tqi_evolution;

grant all privilegies on database tqi_evolution to postgres;

create schema tqi_evolution;

create table tqi_evolution.endereco (
    id serial primary key not null,
    logradouro varchar(30) not null,
    numero integer,
    complemento varchar(30),
    cidade varchar(30) not null,
    estado varchar(30) not null,
    pais varchar(30) not null
);

create table tqi_evolution.cliente (
    id serial primary key not null,
    nome varchar(100),
    email varchar(100),
    CPF varchar(11),
    RG varchar(20),
    id_endereco integer,
    renda float,
    senha varchar(100),
    FOREIGN KEY(id_endereco) REFERENCES tqi_evolution.endereco(id)
);

create table tqi_evolution.emprestimo (
    id serial primary key not null,
    valor float,
    qtd_parcelas integer,
    dat_primeira_parcela date,
    id_cliente integer,
    foreign key(id_cliente) references tqi_evolution.cliente(id)
);