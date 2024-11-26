drop schema if exists spring;
drop user if exists 'user' @'localhost';
create schema spring;
create user 'user' @'localhost' identified by 'pass123';
grant select,
    insert,
    delete,
    update on spring.* to user @'localhost';
use spring;
create table usr_usuario (
    usr_id bigint unsigned not null auto_increment,
    usr_nome varchar(20) not null,
    usr_senha varchar(150) not null,
    primary key (usr_id),
    unique key uni_usuario_nome (usr_nome)
);
create table aut_autorizacao (
    aut_id bigint unsigned not null auto_increment,
    aut_nome varchar(20) not null,
    primary key (aut_id),
    unique key uni_aut_nome (aut_nome)
);
create table uau_usuario_autorizacao (
    usr_id bigint unsigned not null,
    aut_id bigint unsigned not null,
    primary key (usr_id, aut_id),
    foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
    foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);
create table ant_anotacao (
    ant_id bigint unsigned not null auto_increment,
    ant_texto varchar(256) not null,
    ant_data_hora datetime not null,
    ant_usr_id bigint unsigned not null,
    primary key (ant_id),
    foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);
insert into usr_usuario (usr_nome, usr_senha)
values (
        'admin',
        '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C'
    );
insert into aut_autorizacao (aut_nome)
values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id)
values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
values('Meu novo projeto', '2023-08-01 19:10', 1);

create table alt_alerta (
alt_id bigint primary key auto_increment,
alt_mensagem varchar(100) not null,
alt_detalhe varchar(255),
alt_data_hora_geracao datetime not null,
alt_data_hora_verificacao datetime,
alt_nivel int
);
insert into alt_alerta (alt_mensagem, alt_data_hora_geracao, alt_data_hora_verificacao, alt_nivel)
values ('Estouro de memória', '2024-03-15 23:59:59', '2024-03-16 00:00:51', 5),
('Espaço em disco', current_timestamp(), current_timestamp(), null);

create table anc_anuncio (
  anc_id bigint primary key auto_increment,
  anc_nome_produto varchar(100) not null,
  anc_descricao varchar(200),
  anc_data_hora_cadastro datetime not null,
  anc_preco float not null,
  anc_peso float
);

insert into anc_anuncio (anc_nome_produto, anc_data_hora_cadastro, anc_preco, anc_peso)
  values ('Resistência 6800w', '2024-03-15 23:59:59', 41.5, 0.2),
         ('Liquidificador', current_timestamp(), 240, null);

create table alu_aluno (
  alu_id bigint primary key auto_increment,
  alu_nome_completo varchar(100) not null,
  alu_email_institucional varchar(100),
  alu_data_matricula date not null,
  alu_data_termino date,
  alu_ra bigint
);

insert into alu_aluno (alu_nome_completo, alu_data_matricula, alu_data_termino, alu_ra)
  values ('Charles Smith', curdate(), null, 123457),
    ('Ann Doe', '2024-02-15', curdate(), 123456);

create table pro_produto (
  pro_id bigint primary key auto_increment,
  pro_nome varchar(100) not null,
  pro_descricao varchar(100),
  pro_data_cadastro date,
  pro_data_hora_ultima_compra datetime not null,
  pro_lote bigint
);

insert into pro_produto (pro_nome, pro_data_cadastro, pro_data_hora_ultima_compra, pro_lote)
  values ('Sabonete', '2024-06-12', current_timestamp(), 234561),
    ('Vassoura', '2024-06-10', '2024-07-21 10:00:53', 444333);

create table cha_chamado (
  cha_id bigint primary key auto_increment,
  cha_titulo varchar(100) not null,
  cha_descricao varchar(100),
  cha_data_hora_cadastro datetime not null,
  cha_data_hora_finalizacao datetime,
  cha_estimativa float
);

insert into cha_chamado (cha_titulo, cha_data_hora_cadastro, cha_data_hora_finalizacao, cha_estimativa)
  values ('Login não funciona', '2024-06-12 09:30:17', current_timestamp(), 4.6),
    ('Erro na prova', current_timestamp(), null, null),
    ('Erro SQL', current_timestamp(), null, 3.5);