create database evaluacion2;
use evaluacion2;
create table tb_postulante
(
 cod_postulante int primary key auto_increment,
 nom_postulante varchar(20),
 ape_postulante varchar(20),
 dni_postulante int,
 num_hijos int
);