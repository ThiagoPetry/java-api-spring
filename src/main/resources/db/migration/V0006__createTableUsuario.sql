CREATE TABLE usuario (
    id bigint not null auto_increment,
    email varchar(100) not null,
    senha varchar(60) not null,
    primary key (id)
);