create database Proyecto_DAW_BD;
use Proyecto_DAW_BD;
/*****TABLAS*****/
create table tb_departamento(
	id int auto_increment primary key,
	nombre varchar(30)
);
--
insert into tb_departamento values(null,'LIMA');
insert into tb_departamento values(null,'CUSCO');
insert into tb_departamento values(null,'ANCASH');
insert into tb_departamento values(null,'CAJAMARCA');
insert into tb_departamento values(null,'AYACUCHO');
insert into tb_departamento values(null,'LA LIBERTAD');
insert into tb_departamento values(null,'LORETO');
insert into tb_departamento values(null,'AMAZONAS');

--
create table tb_ciudad(
	id int auto_increment primary key,
	nombre varchar(30),
    id_dep int references tb_departamento(id) 
);
--
insert into tb_ciudad values(null,'LIMA',1);
insert into tb_ciudad values(null,'BARRANCA',1);
insert into tb_ciudad values(null,'CAJATAMBO',1);
insert into tb_ciudad values(null,'CANTA',1);
insert into tb_ciudad values(null,'CAÑETE',1);
insert into tb_ciudad values(null,'CUSCO',2);
insert into tb_ciudad values(null,'ESPINAR',2);
insert into tb_ciudad values(null,'PAUCARTAMBO',2);
insert into tb_ciudad values(null,'HUARAZ',3);
insert into tb_ciudad values(null,'HUARMEY',3);
insert into tb_ciudad values(null,'OCROS',3);
insert into tb_ciudad values(null,'CAJABAMBA',4);
insert into tb_ciudad values(null,'CAJAMARCA',4);
insert into tb_ciudad values(null,'CELENDIN',4);
insert into tb_ciudad values(null,'SUCRE',5);
insert into tb_ciudad values(null,'PARINACOCHAS',5);
insert into tb_ciudad values(null,'LUCANAS',5);
insert into tb_ciudad values(null,'TRUJILLO',6);
insert into tb_ciudad values(null,'VIRU',6);
insert into tb_ciudad values(null,'CHUCO',6);
insert into tb_ciudad values(null,'LORETO',7);
insert into tb_ciudad values(null,'MAYNAS',7);
insert into tb_ciudad values(null,'PUTUMAYO',7);
insert into tb_ciudad values(null,'CHACHAPOYAS',8);
insert into tb_ciudad values(null,'BAGUA',8);
insert into tb_ciudad values(null,'BONGARA',8);
--
create table tb_distrito(
	id int auto_increment primary key,
	nombre varchar(30),
    id_ciu int references tb_ciudad(id) 
);
--
insert into tb_distrito values(null,'EL AGUSTINO',1);
insert into tb_distrito values(null,'LIMA',1);
insert into tb_distrito values(null,'SAN MIGUEL',1);
insert into tb_distrito values(null,'SURQUILLO',1);
insert into tb_distrito values(null,'BARRANCA',2);
insert into tb_distrito values(null,'PARAMONGA',2);
insert into tb_distrito values(null,'PATIVILCA',2);
insert into tb_distrito values(null,'CAJATAMBO',3);
insert into tb_distrito values(null,'COPA',3);
insert into tb_distrito values(null,'MANAS',3);
insert into tb_distrito values(null,'HUAROS',4);
insert into tb_distrito values(null,'CANTA',4);
insert into tb_distrito values(null,'HUAMANTANGA',4);
insert into tb_distrito values(null,'COAYLLO',5);
insert into tb_distrito values(null,'ASIA',5);
insert into tb_distrito values(null,'CERRO AZUL',5);
insert into tb_distrito values(null,'CHILCA',5);
insert into tb_distrito values(null,'CUSCO',6);
insert into tb_distrito values(null,'POROY',6);
insert into tb_distrito values(null,'SAN JERÓNIMO',6);
insert into tb_distrito values(null,'ESPINAR',7);
insert into tb_distrito values(null,'OCORURO',7);
insert into tb_distrito values(null,'ALTO PICHIGUA',7);
insert into tb_distrito values(null,'CAICAY',8);
insert into tb_distrito values(null,'HUANCARANI',8);
insert into tb_distrito values(null,'COLQUEPATA',8);
insert into tb_distrito values(null,'HUARAZ',9);
insert into tb_distrito values(null,'COHABAMBA',9);
insert into tb_distrito values(null,'TARICA',9);
insert into tb_distrito values(null,'COCHAPETI',10);
insert into tb_distrito values(null,'HUARMEY',10);
insert into tb_distrito values(null,'HUAYAN',10);
insert into tb_distrito values(null,'ACAS',11);
insert into tb_distrito values(null,'COCHAS',11);
insert into tb_distrito values(null,'SAN PEDRO',11);
insert into tb_distrito values(null,'CAJABAMBA',12);
insert into tb_distrito values(null,'SITACOCHA',12);
insert into tb_distrito values(null,'CACHACHI',12);
insert into tb_distrito values(null,'CAJAMARCA',13);
insert into tb_distrito values(null,'ASUNCION',13);
insert into tb_distrito values(null,'MATARA',13);
insert into tb_distrito values(null,'CELENDIN',14);
insert into tb_distrito values(null,'HUASMIN',14);
insert into tb_distrito values(null,'JOSE GALVEZ',14);
insert into tb_distrito values(null,'BELEN',15);
insert into tb_distrito values(null,'HUACAÑA',15);
insert into tb_distrito values(null,'QUEROBAMBA',15);
insert into tb_distrito values(null,'CHIMPI',16);
insert into tb_distrito values(null,'CORACORA',16);
insert into tb_distrito values(null,'PACAPAUSA',16);
insert into tb_distrito values(null,'AUCARA',17);
insert into tb_distrito values(null,'OCAÑA',17);
insert into tb_distrito values(null,'SAN JUAN',17);
insert into tb_distrito values(null,'SIMBAL',18);
insert into tb_distrito values(null,'TRUJILLO',18);
insert into tb_distrito values(null,'POROTO',18);
insert into tb_distrito values(null,'VIRU',19);
insert into tb_distrito values(null,'CHAO',19);
insert into tb_distrito values(null,'GUADALUPITO',19);
insert into tb_distrito values(null,'QUIRUVILCA',20);
insert into tb_distrito values(null,'SITABAMBA',20);
insert into tb_distrito values(null,'ANGASMARCA',20);
insert into tb_distrito values(null,'NAUTA',21);
insert into tb_distrito values(null,'TROMPETEROS',21);
insert into tb_distrito values(null,'EL TIGRE',21);
insert into tb_distrito values(null,'BELEN',22);
insert into tb_distrito values(null,'IQUITOS',22);
insert into tb_distrito values(null,'LAS AMAZONAS',22);
insert into tb_distrito values(null,'PUTUMAYO',23);
insert into tb_distrito values(null,'YAGUAS',23);
insert into tb_distrito values(null,'ROSA PANDURO',23);
insert into tb_distrito values(null,'ASUNCION',24);
insert into tb_distrito values(null,'CHACHAPOYAS',24);
insert into tb_distrito values(null,'BALSAS',24);
insert into tb_distrito values(null,'BAGUA',25);
insert into tb_distrito values(null,'IMAZA',25);
insert into tb_distrito values(null,'COPALLIN',25);
insert into tb_distrito values(null,'VALERA',26);
insert into tb_distrito values(null,'CHISQUILLA',26);
insert into tb_distrito values(null,'FLORIDA',26);
--
create table tb_tipo_usuario(
	id int auto_increment primary key,
	nombre varchar(30)
);
--
insert into tb_tipo_usuario values(null,'ADMINISTRADOR'),
									(null,'EMPLEADO');
--
create table tb_rol(
	id int auto_increment primary key,
	nombre varchar(30),
    descripcion varchar(255)
);
--
insert into tb_rol values (null,'ADMINISTRADOR', 'Realiza todas las acciones'),
									(null,'RRHH', 'Mantenimiento empleados, postulante, reportes'),
									(null,'VENTAS', 'Mantenimiento productos, pedidos,ventas, reportes'),
									(null,'GERENTE', 'Reportes, mantenimiento pedidos'),
									(null,'ATENCION CLIENTE','Mantenimiento clientes, mantenimiento reclamos, reportes'),
									(null,'ALMACEN', 'Mantenimiento productos, pedidos, reportes');
--
create table tb_usuario(
	id int auto_increment primary key,
	nombre varchar(50),
	apellido varchar(50),
	correo varchar(30),
	contrasenia varchar(100),
	celular varchar(9),
    dni varchar(8),
	direccion varchar(255),
	fecha_nac datetime,
	estado tinyint,
	id_tip_usu int references tb_tipo_usuario(id),
	id_rol int references tb_rol(id),
    id_dep int references tb_departamento(id),
	id_ciu int references tb_ciudad(id),
	id_dis int references tb_distrito(id)
);
insert into tb_usuario values (null,'Henry','Galvez','henry@gmail.com','$2a$10$YZqCv3npeTk2SMwrYbMeferx32tvvwvkuge..xc3d3l6N.Zrp8gha',null,null,null,null,1,1,1,1,1,1);
insert into tb_usuario values (null,'Angel','Marin','angel@gmail.com','$2a$10$YZqCv3npeTk2SMwrYbMeferx32tvvwvkuge..xc3d3l6N.Zrp8gha','993124712','70559001',null,null,1,1,1,1,1,1);
--
create table tb_enlace(
	id int auto_increment primary key,
    descripcion varchar(50),
    ruta varchar(50)
);
insert into tb_enlace values (null,"Producto","/Productos/Lista");
insert into tb_enlace values (null,"Usuarios","/Usuarios/Lista");
insert into tb_enlace values (null,"Categorias y Marcas","/CategoriasMarcas/Lista");
--
create table tb_rol_enlace (
  idrol int not null,
  idenlace int not null,
  PRIMARY KEY (idrol,idenlace), KEY fk25 (idenlace),
  CONSTRAINT fk24 FOREIGN KEY (idrol) REFERENCES tb_rol (id),
  CONSTRAINT fk25 FOREIGN KEY (idenlace) REFERENCES tb_enlace (id)
);
-- drop table tb_rol_enlace;
insert into tb_rol_enlace values (1,1);
insert into tb_rol_enlace values (1,2);
insert into tb_rol_enlace values (1,3);
--
create table tb_cliente(
	id int auto_increment primary key,
	nombre varchar(50),
	apellido varchar(50),
	correo varchar(30),
	celular varchar(9),
	direccion varchar(255),
	fecha_nac datetime,
	estado tinyint,
    id_dep int references tb_departamento(id),
	id_ciu int references tb_ciudad(id),
	id_dis int references tb_distrito(id)
);
--
insert into tb_cliente values (null,'Henry','Galvez','henry@gmail.com',null,null,null,1,1,1,1);
--
create table tb_postulante(
	id int auto_increment primary key,
	nombre varchar(50),
	apellido varchar(50),
	correo varchar(30),
	celular varchar(9),
	direccion varchar(255),
	fecha_nac datetime,
    experiencia varchar(255),
    cursos varchar(255),
    idioma varchar(255),
	estado tinyint,
    id_dep int references tb_departamento(id),
	id_ciu int references tb_ciudad(id),
	id_dis int references tb_distrito(id)
);
--
insert into tb_postulante values (null,'Henry','Galvez','henry@gmail.com',null,null,null,null,null,null,1,1,1,1);
--
create table tb_categoria(
	id int auto_increment primary key,
	nombre varchar(30)
);
--
insert into tb_categoria values(null,'HERRAMIENTAS'),
								(null,'ROPA DE VERANO'),
								(null,'ROPA DE INVIERNO'),
								(null,'CALZADO DEPORTIVO'),
								(null,'CALZADO DE VESTIR');
--
create table tb_marca(
	id int auto_increment primary key,
	nombre varchar(30)
);
--
insert into tb_marca values(null,'NIKE'),
							(null,'PUMA'),
							(null,'VANS'),
							(null,'LACOSTE');
--
create table tb_producto(
	id int auto_increment primary key,
	nombre varchar(30),
    descripcion varchar(255),
	precio double,
    stock int,
    estado tinyint,
    id_cat int references tb_categoria(id),
    id_mar int references tb_marca(id)
);
--
insert into tb_producto values(null,'CORTEZ OG BASC SL', 'ZAPATILLA BLANCA TALLA 41', 120.50, 5, 1, 1,1),
		(null,'WMNS AIR WINFLO 9', 'ZAPATILLA TRAINING PARA MUJER', 290.50, 10, 0, 1,1),
		(null,'OLD SKOOL VN05KRSMUL', 'ZAPATILLA URBANAS HOMBRE', 209, 8, 1, 3,1);
--
create table tb_reclamo(
	id int auto_increment primary key,
    descripcion varchar(255),
	fecha datetime,
    estado tinyint,
    id_cli int references tb_cliente(id)
);
--
insert into tb_reclamo values(null,'DESCRIPCION DEL RECLAMO PRUEBA',null,1,1);
--
create table tb_pedido(
	id int auto_increment primary key,
    fecha datetime,
	fecha_entrega datetime,
	precio_envio double,
    estado tinyint,
    id_usu int references tb_usuario(id),
	id_cli int references tb_cliente(id)
);
--
insert into tb_pedido values(null,'2022/06/06','2022/08/06',1500,1,1,1);
--
create table tb_detalle_pedido(
	id int auto_increment primary key,
    cantidad int,
	precio_uni double,
    descuento double,
    estado char(1),
    id_ped int references tb_pedido(id),
	id_pro int references tb_producto(id)
);
--
insert into tb_detalle_pedido values(null,12,1500,10,1,1,1);
--
ALTER TABLE tb_usuario
modify correo varchar(255) unique;
--

use Proyecto_DAW_BD;
select*from tb_usuario;
/*******************************/
drop database proyecto_daw_bd;