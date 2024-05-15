create database bd_internet;

use bd_internet;

create table estudiantes (
    id int auto_increment primary key,
    nombre varchar(200),
    apellidos varchar(200),
    seminario varchar(200),
    confirmado boolean,
    fecha_inscripcion date
);
