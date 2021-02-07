CREATE DATABASE Gestiones;
USE Gestiones;

CREATE TABLE TClientes2  (
IdCliente    INT  NOT NULL AUTO_INCREMENT PRIMARY KEY ,
Provincia    VARCHAR(12)   NOT NULL,
Email        VARCHAR(20)   NOT NULL,
Nombre      VARCHAR(20)   NOT NULL
);
