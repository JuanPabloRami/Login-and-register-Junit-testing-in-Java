create database login_register_Test;

use almacen;


create table personas(

id INT PRIMARY KEY ,
nombre char(30),
apellido char(30),
email char(60),
pw char(60),
edad INT
);
