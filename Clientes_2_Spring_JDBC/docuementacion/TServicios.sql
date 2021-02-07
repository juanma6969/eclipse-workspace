
USE Gestiones;

CREATE TABLE TServicios  (
IdServicio   INT  NOT NULL AUTO_INCREMENT PRIMARY KEY ,
Descripcion   VARCHAR(100)   NOT NULL,
Fecha        DATE   NOT NULL,
Importe      DOUBLE    NOT NULL,
IdCliente INT  NOT NULL FOREIGN KEY REFERENCES TClientes2(IdCliente)

);