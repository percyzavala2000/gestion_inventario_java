CREATE DATABASE  IF NOT EXISTS `gestioninventario` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `gestioninventario`;
-- MySQL dump 10.13  Distrib 8.0.40, for macos14 (x86_64)
--
-- Host: 127.0.0.1    Database: gestioninventario
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Categoria`
--

DROP TABLE IF EXISTS `Categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categoria`
--

LOCK TABLES `Categoria` WRITE;
/*!40000 ALTER TABLE `Categoria` DISABLE KEYS */;
INSERT INTO `Categoria` VALUES (12,'Urbano','Habilitado','2024-12-09',NULL),(25,'Running','Habilitado','2024-12-13',NULL),(26,'Tenis','Habilitado','2024-12-13',NULL),(27,'Training','Habilitado','2024-12-13',NULL),(28,'Senderismo','Habilitado','2024-12-13',NULL);
/*!40000 ALTER TABLE `Categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cliente`
--

DROP TABLE IF EXISTS `Cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cliente` (
  `idPersona` int NOT NULL,
  `ruc` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  CONSTRAINT `Cliente_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`id`),
  CONSTRAINT `Cliente_chk_1` CHECK ((`estado` in (_utf8mb4'Habilitado',_utf8mb4'Deshabilitado')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cliente`
--

LOCK TABLES `Cliente` WRITE;
/*!40000 ALTER TABLE `Cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `Cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetalleOrden`
--

DROP TABLE IF EXISTS `DetalleOrden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DetalleOrden` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idOrden` int DEFAULT NULL,
  `idProducto` int DEFAULT NULL,
  `cantidad` int DEFAULT NULL,
  `precioUnitario` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idOrden` (`idOrden`),
  KEY `idProducto` (`idProducto`),
  CONSTRAINT `DetalleOrden_ibfk_1` FOREIGN KEY (`idOrden`) REFERENCES `Orden` (`id`),
  CONSTRAINT `DetalleOrden_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `Producto` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetalleOrden`
--

LOCK TABLES `DetalleOrden` WRITE;
/*!40000 ALTER TABLE `DetalleOrden` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetalleOrden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EntidadBase`
--

DROP TABLE IF EXISTS `EntidadBase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EntidadBase` (
  `id` int NOT NULL AUTO_INCREMENT,
  `creadoPor` varchar(255) DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  `modificadoPor` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `EntidadBase_chk_1` CHECK ((`estado` in (_utf8mb4'Habilitado',_utf8mb4'Deshabilitado')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EntidadBase`
--

LOCK TABLES `EntidadBase` WRITE;
/*!40000 ALTER TABLE `EntidadBase` DISABLE KEYS */;
/*!40000 ALTER TABLE `EntidadBase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Orden`
--

DROP TABLE IF EXISTS `Orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Orden` (
  `id` int NOT NULL AUTO_INCREMENT,
  `numeroOrden` int DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `Orden_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idPersona`),
  CONSTRAINT `Orden_chk_1` CHECK ((`estado` in (_utf8mb4'Pendiente',_utf8mb4'Aprobada',_utf8mb4'Rechazada',_utf8mb4'Cancelada')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Orden`
--

LOCK TABLES `Orden` WRITE;
/*!40000 ALTER TABLE `Orden` DISABLE KEYS */;
/*!40000 ALTER TABLE `Orden` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Persona` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidoPaterno` varchar(255) DEFAULT NULL,
  `apellidoMaterno` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Persona_chk_1` CHECK ((`estado` in (_utf8mb4'Habilitado',_utf8mb4'Deshabilitado')))
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (3,'Percy','Zavala','Muñoz','42657396','976789640',' percyzavala@gmail.com ','Av. Los Pinos 123','Habilitado','2024-12-06','2024-12-06'),(8,'Carmen','chanchari','Fernandez','987456321','123456789','carmen@carmen.com','santa anita','Deshabilitado',NULL,'2024-12-13'),(9,'yina','rivera','balta','45875258','98574525','yina@gmail.com','los olivos','Habilitado',NULL,NULL),(10,'Juan','Perez','Garcia','58458574','96587458','juan@gmail.com','comas','Habilitado',NULL,NULL),(11,'Jhon','Davila','Falcon','65421587','985471426','jhon@gmail.com','lince','Habilitado',NULL,NULL);
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Producto`
--

DROP TABLE IF EXISTS `Producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Producto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `cantidad` int NOT NULL DEFAULT '0',
  `stock` int DEFAULT NULL,
  `categoria` varchar(255) DEFAULT NULL,
  `marca` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `Producto_chk_1` CHECK ((`estado` in (_utf8mb4'Disponible',_utf8mb4'No disponible',_utf8mb4'En stock',_utf8mb4'Agotado')))
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Producto`
--

LOCK TABLES `Producto` WRITE;
/*!40000 ALTER TABLE `Producto` DISABLE KEYS */;
INSERT INTO `Producto` VALUES (1,NULL,'Adizero boston','Hombre • Running',120,15,NULL,'Urbano','Adidas','Disponible'),(2,NULL,'cortes','parara correr',110,12,NULL,'Urbano','Adidas','Disponible'),(4,NULL,'Duramo RC','para atletissmo',200,12,NULL,'Futbol','Adidas','Disponible');
/*!40000 ALTER TABLE `Producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Proveedor`
--

DROP TABLE IF EXISTS `Proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Proveedor` (
  `idPersona` int NOT NULL,
  `ruc` varchar(255) DEFAULT NULL,
  `razonSocial` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  CONSTRAINT `Proveedor_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`id`),
  CONSTRAINT `Proveedor_chk_1` CHECK ((`estado` in (_utf8mb4'Habilitado',_utf8mb4'Deshabilitado')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Proveedor`
--

LOCK TABLES `Proveedor` WRITE;
/*!40000 ALTER TABLE `Proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Transaccion`
--

DROP TABLE IF EXISTS `Transaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Transaccion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fechaTransaccion` date DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `tipoTransaccion` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `idOrden` int DEFAULT NULL,
  `idCliente` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idOrden` (`idOrden`),
  KEY `idCliente` (`idCliente`),
  CONSTRAINT `Transaccion_ibfk_1` FOREIGN KEY (`idOrden`) REFERENCES `Orden` (`id`),
  CONSTRAINT `Transaccion_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `Cliente` (`idPersona`),
  CONSTRAINT `Transaccion_chk_1` CHECK ((`estado` in (_utf8mb4'Pendiente',_utf8mb4'Aprobada',_utf8mb4'Rechazada',_utf8mb4'Cancelada')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Transaccion`
--

LOCK TABLES `Transaccion` WRITE;
/*!40000 ALTER TABLE `Transaccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `Transaccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idPersona` int NOT NULL,
  `tipoUsuario` varchar(255) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `fechaCreacion` date DEFAULT NULL,
  `fechaModificacion` date DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  UNIQUE KEY `idUsuario` (`id`),
  CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`idPersona`) REFERENCES `Persona` (`id`),
  CONSTRAINT `Usuario_chk_1` CHECK ((`estado` in (_utf8mb4'Habilitado',_utf8mb4'Deshabilitado')))
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (4,3,'Administrador','Percy','admin','Habilitado','2024-12-06',NULL),(6,10,NULL,'Juan','admin','Deshabilitado','2024-12-13',NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'gestioninventario'
--

--
-- Dumping routines for database 'gestioninventario'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-13 22:39:21
