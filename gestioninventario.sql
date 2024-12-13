CREATE DATABASE gestioninventario;

USE gestioninventario;

CREATE TABLE EntidadBase (
  id INT PRIMARY KEY AUTO_INCREMENT,
  creadoPor VARCHAR(255),
  fechaCreacion DATE,
  fechaModificacion DATE,
  modificadoPor VARCHAR(255),
  estado VARCHAR(255)CHECK (estado IN ('Habilitado', 'Deshabilitado'))
);

CREATE TABLE Persona (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombres VARCHAR(255),
  apellidoPaterno VARCHAR(255),
  apellidoMaterno VARCHAR(255),
  dni VARCHAR(255),
  telefono VARCHAR(255),
  correo VARCHAR(255),
  direccion VARCHAR(255),
  estado VARCHAR(255) CHECK (estado IN ('Habilitado', 'Deshabilitado')),
  FOREIGN KEY (id) REFERENCES EntidadBase(id)
);

CREATE TABLE Usuario (
  idPersona INT PRIMARY KEY,
  tipoUsuario VARCHAR(255),
  usuario VARCHAR(255),
  clave VARCHAR(255),
  estado VARCHAR(255) CHECK (estado IN ('Habilitado', 'Deshabilitado')),
  FOREIGN KEY (idPersona) REFERENCES Persona(id)
);

CREATE TABLE Cliente (
  idPersona INT PRIMARY KEY,
  ruc VARCHAR(255),
  razonSocial VARCHAR(255),
  estado VARCHAR(255) CHECK (estado IN ('Habilitado', 'Deshabilitado')),
  FOREIGN KEY (idPersona) REFERENCES Persona(id)
);

CREATE TABLE Proveedor (
  idPersona INT PRIMARY KEY,
  ruc VARCHAR(255),
  razonSocial VARCHAR(255),
  estado VARCHAR(255)CHECK (estado IN ('Habilitado', 'Deshabilitado')),
  FOREIGN KEY (idPersona) REFERENCES Persona(id)
);

CREATE TABLE Orden (
  id INT PRIMARY KEY AUTO_INCREMENT,
  numeroOrden INT,
  fechaCreacion DATE,
  estado VARCHAR(255)CHECK (estado IN ('Pendiente', 'Aprobada', 'Rechazada', 'Cancelada')),
  total DOUBLE,
  idCliente INT,
  FOREIGN KEY (idCliente) REFERENCES Cliente(idPersona)
);

CREATE TABLE Producto (
  id INT PRIMARY KEY AUTO_INCREMENT,
  codigo VARCHAR(255),
  nombre VARCHAR(255),
  descripcion VARCHAR(255),
  precio DOUBLE,
  stock INT,
  categoria VARCHAR(255),
  marca VARCHAR(255),
  estado VARCHAR(255) CHECK (estado IN ('Disponible', 'No disponible', 'En stock', 'Agotado'))
);

CREATE TABLE DetalleOrden (
  id INT PRIMARY KEY AUTO_INCREMENT,
  idOrden INT,
  idProducto INT,
  cantidad INT,
  precioUnitario DOUBLE,
  FOREIGN KEY (idOrden) REFERENCES Orden(id),
  FOREIGN KEY (idProducto) REFERENCES Producto(id)
);

CREATE TABLE Transaccion (
  id INT PRIMARY KEY AUTO_INCREMENT,
  fechaTransaccion DATE,
  monto DOUBLE,
  tipoTransaccion VARCHAR(255),
  estado VARCHAR(255) CHECK (estado IN ('Pendiente', 'Aprobada', 'Rechazada', 'Cancelada')),
  idOrden INT,
  idCliente INT,
  FOREIGN KEY (idOrden) REFERENCES Orden(id),
  FOREIGN KEY (idCliente) REFERENCES Cliente(idPersona)
);