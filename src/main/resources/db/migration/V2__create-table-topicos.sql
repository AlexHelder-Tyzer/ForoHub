create table topicos(
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(500) not null,
    fecha_creacion datetime not null,
    autor_id bigint not null,

    primary key(id),

    constraint fk_topicos_autor_id foreign key(autor_id) references usuarios(id)
);