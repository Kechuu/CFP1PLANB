-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: datoscfp
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `acciones`
--

DROP TABLE IF EXISTS `acciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `acciones` (
  `idAcciones` int NOT NULL AUTO_INCREMENT,
  `desde` date DEFAULT NULL,
  `hasta` date DEFAULT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  PRIMARY KEY (`idAcciones`),
  KEY `fk_Acciones_Empleado` (`Empleado_idEmpleado`),
  CONSTRAINT `fk_Acciones_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acciones`
--

LOCK TABLES `acciones` WRITE;
/*!40000 ALTER TABLE `acciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `acciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alumno`
--

DROP TABLE IF EXISTS `alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumno` (
  `idAlumno` int NOT NULL AUTO_INCREMENT,
  `borrado` tinyint NOT NULL DEFAULT '0',
  `idPersona` int NOT NULL,
  PRIMARY KEY (`idAlumno`),
  KEY `fk_Alumno_Persona` (`idPersona`),
  CONSTRAINT `fk_Alumno_Persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumno`
--

LOCK TABLES `alumno` WRITE;
/*!40000 ALTER TABLE `alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `barrio`
--

DROP TABLE IF EXISTS `barrio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `barrio` (
  `idBarrio` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idBarrio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barrio`
--

LOCK TABLES `barrio` WRITE;
/*!40000 ALTER TABLE `barrio` DISABLE KEYS */;
/*!40000 ALTER TABLE `barrio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calles`
--

DROP TABLE IF EXISTS `calles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calles` (
  `idCalles` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idCalles`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calles`
--

LOCK TABLES `calles` WRITE;
/*!40000 ALTER TABLE `calles` DISABLE KEYS */;
/*!40000 ALTER TABLE `calles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `caracter`
--

DROP TABLE IF EXISTS `caracter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `caracter` (
  `idCaracter` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idCaracter`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `caracter`
--

LOCK TABLES `caracter` WRITE;
/*!40000 ALTER TABLE `caracter` DISABLE KEYS */;
INSERT INTO `caracter` VALUES (1,'Titular'),(2,'Suplente'),(3,'Interino');
/*!40000 ALTER TABLE `caracter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `idCargo` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `codigopostal`
--

DROP TABLE IF EXISTS `codigopostal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `codigopostal` (
  `idCodigoPostal` int NOT NULL AUTO_INCREMENT,
  `codigoPostal` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Lugar_idLugar` int NOT NULL,
  PRIMARY KEY (`idCodigoPostal`),
  KEY `fk_CodigoPostal_Lugar` (`Lugar_idLugar`),
  CONSTRAINT `fk_CodigoPostal_Lugar` FOREIGN KEY (`Lugar_idLugar`) REFERENCES `lugar` (`idLugar`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `codigopostal`
--

LOCK TABLES `codigopostal` WRITE;
/*!40000 ALTER TABLE `codigopostal` DISABLE KEYS */;
/*!40000 ALTER TABLE `codigopostal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conexionacciones`
--

DROP TABLE IF EXISTS `conexionacciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conexionacciones` (
  `idConexionAcciones` int NOT NULL AUTO_INCREMENT,
  `detalle` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  PRIMARY KEY (`idConexionAcciones`),
  KEY `fk_ConexionAcciones_Empleado` (`Empleado_idEmpleado`),
  CONSTRAINT `fk_ConexionAcciones_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conexionacciones`
--

LOCK TABLES `conexionacciones` WRITE;
/*!40000 ALTER TABLE `conexionacciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `conexionacciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `idCurso` int NOT NULL AUTO_INCREMENT,
  `cicloLectivo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `turno` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `costo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `cupo` int DEFAULT NULL,
  `fechaInicio` date DEFAULT NULL,
  `fechaFinalizacion` date DEFAULT NULL,
  `borraro` tinyint NOT NULL DEFAULT '0',
  `TipoCurso_idTipoCurso` int NOT NULL,
  `LugarCurso_idLugarCurso` int NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_Curso_TipoCurso` (`TipoCurso_idTipoCurso`),
  KEY `fk_Curso_LugarCurso` (`LugarCurso_idLugarCurso`),
  CONSTRAINT `fk_Curso_LugarCurso` FOREIGN KEY (`LugarCurso_idLugarCurso`) REFERENCES `lugarcurso` (`idLugarCurso`),
  CONSTRAINT `fk_Curso_TipoCurso` FOREIGN KEY (`TipoCurso_idTipoCurso`) REFERENCES `tipocurso` (`idTipoCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursoalumno`
--

DROP TABLE IF EXISTS `cursoalumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursoalumno` (
  `idCursoAlumno` int NOT NULL AUTO_INCREMENT,
  `costo` float NOT NULL DEFAULT '0',
  `saldo` float NOT NULL DEFAULT '0',
  `fechaIngreso` date DEFAULT NULL,
  `fechaBajaEgreso` date DEFAULT NULL,
  `Alumno_idAlumno` int NOT NULL,
  `EstadoAlumno_idEstadoAlumno` int NOT NULL,
  `Curso_idCurso` int NOT NULL,
  `MotivoBaja_idMotivoBaja` int DEFAULT NULL,
  PRIMARY KEY (`idCursoAlumno`),
  KEY `fk_CursoAlumno_Alumno` (`Alumno_idAlumno`),
  KEY `fk_CursoAlumno_EstadoAlumno` (`EstadoAlumno_idEstadoAlumno`),
  KEY `fk_CursoAlumno_Curso` (`Curso_idCurso`),
  KEY `fk_CursoAlumno_MotivoBaja` (`MotivoBaja_idMotivoBaja`),
  CONSTRAINT `fk_CursoAlumno_Alumno` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`),
  CONSTRAINT `fk_CursoAlumno_Curso` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_CursoAlumno_EstadoAlumno` FOREIGN KEY (`EstadoAlumno_idEstadoAlumno`) REFERENCES `estadoalumno` (`idEstadoAlumno`),
  CONSTRAINT `fk_CursoAlumno_MotivoBaja` FOREIGN KEY (`MotivoBaja_idMotivoBaja`) REFERENCES `motivobaja` (`idMotivoBaja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoalumno`
--

LOCK TABLES `cursoalumno` WRITE;
/*!40000 ALTER TABLE `cursoalumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursoalumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursohora`
--

DROP TABLE IF EXISTS `cursohora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursohora` (
  `idCursoHora` int NOT NULL AUTO_INCREMENT,
  `Horario_idHorario` int NOT NULL,
  `Curso_idCurso` int NOT NULL,
  PRIMARY KEY (`idCursoHora`),
  KEY `fk_CursoHora_Horario` (`Horario_idHorario`),
  KEY `fk_CursoHora_Curso` (`Curso_idCurso`),
  CONSTRAINT `fk_CursoHora_Curso` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_CursoHora_Horario` FOREIGN KEY (`Horario_idHorario`) REFERENCES `horario` (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursohora`
--

LOCK TABLES `cursohora` WRITE;
/*!40000 ALTER TABLE `cursohora` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursohora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursoprofesor`
--

DROP TABLE IF EXISTS `cursoprofesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursoprofesor` (
  `idCursoProfesor` int NOT NULL AUTO_INCREMENT,
  `Curso_idCurso` int NOT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  `Caracter_idCaracter` int NOT NULL,
  PRIMARY KEY (`idCursoProfesor`),
  KEY `fk_CursoProfesor_Curso` (`Curso_idCurso`),
  KEY `fk_CursoProfesor_Empleado` (`Empleado_idEmpleado`),
  KEY `fk_CursoProfesor_Caracter` (`Caracter_idCaracter`),
  CONSTRAINT `fk_CursoProfesor_Caracter` FOREIGN KEY (`Caracter_idCaracter`) REFERENCES `caracter` (`idCaracter`),
  CONSTRAINT `fk_CursoProfesor_Curso` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_CursoProfesor_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursoprofesor`
--

LOCK TABLES `cursoprofesor` WRITE;
/*!40000 ALTER TABLE `cursoprofesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `cursoprofesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `domicilio` (
  `idDomicilio` int NOT NULL AUTO_INCREMENT,
  `nroLote` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Telefono` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `idLugar` int NOT NULL,
  `idEdificio` int NOT NULL,
  PRIMARY KEY (`idDomicilio`),
  KEY `fk_Domicilio_Lugar` (`idLugar`),
  KEY `fk_Domicilio_Edificio` (`idEdificio`),
  CONSTRAINT `fk_Domicilio_Edificio` FOREIGN KEY (`idEdificio`) REFERENCES `edificio` (`idEdificio`),
  CONSTRAINT `fk_Domicilio_Lugar` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'0',NULL,1,1),(2,'0',NULL,1,1);
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificio`
--

DROP TABLE IF EXISTS `edificio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `edificio` (
  `idEdificio` int NOT NULL AUTO_INCREMENT,
  `Torre` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Piso` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Dpto` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idEdificio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificio`
--

LOCK TABLES `edificio` WRITE;
/*!40000 ALTER TABLE `edificio` DISABLE KEYS */;
INSERT INTO `edificio` VALUES (1,'Sin edificio',NULL,NULL),(2,'Sin edificio',NULL,NULL);
/*!40000 ALTER TABLE `edificio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `fechaIngreso` date DEFAULT NULL,
  `fechaBaja` date DEFAULT NULL,
  `borrado` tinyint NOT NULL DEFAULT '0',
  `idPersona` int NOT NULL,
  `idEstadoEmpleado` int NOT NULL,
  `idGremio` int NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_Empleado_Persona` (`idPersona`),
  KEY `fk_Empleado_EstadoEmpleado` (`idEstadoEmpleado`),
  KEY `fk_Empleado_Gremio` (`idGremio`),
  CONSTRAINT `fk_Empleado_EstadoEmpleado` FOREIGN KEY (`idEstadoEmpleado`) REFERENCES `estadoempleado` (`idEstadoEmpleado`),
  CONSTRAINT `fk_Empleado_Gremio` FOREIGN KEY (`idGremio`) REFERENCES `gremio` (`idGremio`),
  CONSTRAINT `fk_Empleado_Persona` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,NULL,NULL,0,1,1,1),(2,NULL,NULL,0,1,1,1);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadocargo`
--

DROP TABLE IF EXISTS `empleadocargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadocargo` (
  `idEmpleadoCargo` int NOT NULL AUTO_INCREMENT,
  `Cargo_idCargo` int NOT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  PRIMARY KEY (`idEmpleadoCargo`),
  KEY `fk_EmpleadoCargo_Cargo` (`Cargo_idCargo`),
  KEY `fk_EmpleadoCargo_Empleado` (`Empleado_idEmpleado`),
  CONSTRAINT `fk_EmpleadoCargo_Cargo` FOREIGN KEY (`Cargo_idCargo`) REFERENCES `cargo` (`idCargo`),
  CONSTRAINT `fk_EmpleadoCargo_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadocargo`
--

LOCK TABLES `empleadocargo` WRITE;
/*!40000 ALTER TABLE `empleadocargo` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleadocargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadolicencia`
--

DROP TABLE IF EXISTS `empleadolicencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadolicencia` (
  `idEmpleadoLicencia` int NOT NULL AUTO_INCREMENT,
  `inicio` date DEFAULT NULL,
  `fin` date DEFAULT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  `Licencia_idLicencia` int NOT NULL,
  `Caracter_idCaracter` int NOT NULL,
  `Curso_idCurso` int NOT NULL,
  PRIMARY KEY (`idEmpleadoLicencia`),
  KEY `fk_EmpleadoLicencia_Empleado` (`Empleado_idEmpleado`),
  KEY `fk_EmpleadoLicencia_Licencia` (`Licencia_idLicencia`),
  KEY `fk_EmpleadoLicencia_Caracter` (`Caracter_idCaracter`),
  KEY `fk_EmpleadoLicencia_Curso` (`Curso_idCurso`),
  CONSTRAINT `fk_EmpleadoLicencia_Caracter` FOREIGN KEY (`Caracter_idCaracter`) REFERENCES `caracter` (`idCaracter`),
  CONSTRAINT `fk_EmpleadoLicencia_Curso` FOREIGN KEY (`Curso_idCurso`) REFERENCES `curso` (`idCurso`),
  CONSTRAINT `fk_EmpleadoLicencia_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`),
  CONSTRAINT `fk_EmpleadoLicencia_Licencia` FOREIGN KEY (`Licencia_idLicencia`) REFERENCES `licencia` (`idLicencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadolicencia`
--

LOCK TABLES `empleadolicencia` WRITE;
/*!40000 ALTER TABLE `empleadolicencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleadolicencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleadotitulo`
--

DROP TABLE IF EXISTS `empleadotitulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleadotitulo` (
  `idEmpleadoTitulo` int NOT NULL AUTO_INCREMENT,
  `Titulo_idTitulo` int NOT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  PRIMARY KEY (`idEmpleadoTitulo`),
  KEY `fk_EmpleadoTitulo_Titulo` (`Titulo_idTitulo`),
  KEY `fk_EmpleadoTitulo_Empleado` (`Empleado_idEmpleado`),
  CONSTRAINT `fk_EmpleadoTitulo_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`),
  CONSTRAINT `fk_EmpleadoTitulo_Titulo` FOREIGN KEY (`Titulo_idTitulo`) REFERENCES `titulo` (`idTitulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleadotitulo`
--

LOCK TABLES `empleadotitulo` WRITE;
/*!40000 ALTER TABLE `empleadotitulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleadotitulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `errores`
--

DROP TABLE IF EXISTS `errores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `errores` (
  `idErrores` int NOT NULL AUTO_INCREMENT,
  `hora` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `detalle` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Empleado_idEmpleado` int NOT NULL,
  PRIMARY KEY (`idErrores`),
  KEY `fk_Errores_Empleado` (`Empleado_idEmpleado`),
  CONSTRAINT `fk_Errores_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `errores`
--

LOCK TABLES `errores` WRITE;
/*!40000 ALTER TABLE `errores` DISABLE KEYS */;
/*!40000 ALTER TABLE `errores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `escuela`
--

DROP TABLE IF EXISTS `escuela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `escuela` (
  `idEscuela` int NOT NULL AUTO_INCREMENT,
  `nombreEscuela` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `director` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `logo` blob,
  `fondo` blob,
  PRIMARY KEY (`idEscuela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `escuela`
--

LOCK TABLES `escuela` WRITE;
/*!40000 ALTER TABLE `escuela` DISABLE KEYS */;
/*!40000 ALTER TABLE `escuela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoalumno`
--

DROP TABLE IF EXISTS `estadoalumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoalumno` (
  `idEstadoAlumno` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstadoAlumno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoalumno`
--

LOCK TABLES `estadoalumno` WRITE;
/*!40000 ALTER TABLE `estadoalumno` DISABLE KEYS */;
INSERT INTO `estadoalumno` VALUES (1,'Inscripto'),(2,'Egresado'),(3,'Baja');
/*!40000 ALTER TABLE `estadoalumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estadoempleado`
--

DROP TABLE IF EXISTS `estadoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoempleado` (
  `idEstadoEmpleado` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idEstadoEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoempleado`
--

LOCK TABLES `estadoempleado` WRITE;
/*!40000 ALTER TABLE `estadoempleado` DISABLE KEYS */;
INSERT INTO `estadoempleado` VALUES (1,'Activo'),(2,'Inactivo'),(3,'Licencia');
/*!40000 ALTER TABLE `estadoempleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto` (
  `idFoto` int NOT NULL AUTO_INCREMENT,
  `imagen` longblob,
  PRIMARY KEY (`idFoto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES (1,NULL);
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gremio`
--

DROP TABLE IF EXISTS `gremio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gremio` (
  `idGremio` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idGremio`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gremio`
--

LOCK TABLES `gremio` WRITE;
/*!40000 ALTER TABLE `gremio` DISABLE KEYS */;
INSERT INTO `gremio` VALUES (1,'UPCN'),(2,'ATE'),(3,'Sin gremio');
/*!40000 ALTER TABLE `gremio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `idHorario` int NOT NULL AUTO_INCREMENT,
  `desde` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `hast` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `dia` int NOT NULL,
  PRIMARY KEY (`idHorario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `licencia`
--

DROP TABLE IF EXISTS `licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `licencia` (
  `idLicencia` int NOT NULL AUTO_INCREMENT,
  `articulo` int DEFAULT NULL,
  `detalle` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `Caracter_idCaracter` int NOT NULL,
  PRIMARY KEY (`idLicencia`),
  KEY `fk_Licencia_Caracter` (`Caracter_idCaracter`),
  CONSTRAINT `fk_Licencia_Caracter` FOREIGN KEY (`Caracter_idCaracter`) REFERENCES `caracter` (`idCaracter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `licencia`
--

LOCK TABLES `licencia` WRITE;
/*!40000 ALTER TABLE `licencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `licencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugar`
--

DROP TABLE IF EXISTS `lugar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugar` (
  `idLugar` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Nivel` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `De` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`idLugar`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugar`
--

LOCK TABLES `lugar` WRITE;
/*!40000 ALTER TABLE `lugar` DISABLE KEYS */;
INSERT INTO `lugar` VALUES (1,'Sin lugar',NULL,NULL),(2,'Sin lugar',NULL,NULL);
/*!40000 ALTER TABLE `lugar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lugarcurso`
--

DROP TABLE IF EXISTS `lugarcurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lugarcurso` (
  `idLugarCurso` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idLugarCurso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lugarcurso`
--

LOCK TABLES `lugarcurso` WRITE;
/*!40000 ALTER TABLE `lugarcurso` DISABLE KEYS */;
INSERT INTO `lugarcurso` VALUES (1,'Aula 1'),(2,'Aula 2'),(3,'Laboratorio'),(4,'Virtual');
/*!40000 ALTER TABLE `lugarcurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `motivobaja`
--

DROP TABLE IF EXISTS `motivobaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `motivobaja` (
  `idMotivoBaja` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idMotivoBaja`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `motivobaja`
--

LOCK TABLES `motivobaja` WRITE;
/*!40000 ALTER TABLE `motivobaja` DISABLE KEYS */;
INSERT INTO `motivobaja` VALUES (1,'Voluntaria'),(2,'Disciplinaria'),(3,'Finalizaci├│n');
/*!40000 ALTER TABLE `motivobaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nacionalidad`
--

DROP TABLE IF EXISTS `nacionalidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nacionalidad` (
  `idNacionalidad` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idNacionalidad`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nacionalidad`
--

LOCK TABLES `nacionalidad` WRITE;
/*!40000 ALTER TABLE `nacionalidad` DISABLE KEYS */;
INSERT INTO `nacionalidad` VALUES (1,'Argentina'),(2,'Otra');
/*!40000 ALTER TABLE `nacionalidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idPago` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `importe` float NOT NULL DEFAULT '0',
  `Empleado_idEmpleado` int NOT NULL,
  `CursoAlumno_idCursoAlumno` int NOT NULL,
  PRIMARY KEY (`idPago`),
  KEY `fk_Pago_Empleado` (`Empleado_idEmpleado`),
  KEY `fk_Pago_CursoAlumno` (`CursoAlumno_idCursoAlumno`),
  CONSTRAINT `fk_Pago_CursoAlumno` FOREIGN KEY (`CursoAlumno_idCursoAlumno`) REFERENCES `cursoalumno` (`idCursoAlumno`),
  CONSTRAINT `fk_Pago_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagosvarios`
--

DROP TABLE IF EXISTS `pagosvarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagosvarios` (
  `idPagosVarios` int NOT NULL AUTO_INCREMENT,
  `fecha` date DEFAULT NULL,
  `detalle` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `importe` int NOT NULL DEFAULT '0',
  `Empleado_idEmpleado` int NOT NULL,
  `Alumno_idAlumno` int NOT NULL,
  PRIMARY KEY (`idPagosVarios`),
  KEY `fk_PagosVarios_Empleado` (`Empleado_idEmpleado`),
  KEY `fk_PagosVarios_Alumno` (`Alumno_idAlumno`),
  CONSTRAINT `fk_PagosVarios_Alumno` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`),
  CONSTRAINT `fk_PagosVarios_Empleado` FOREIGN KEY (`Empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagosvarios`
--

LOCK TABLES `pagosvarios` WRITE;
/*!40000 ALTER TABLE `pagosvarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `pagosvarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `periodo` (
  `idPeriodo` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idPeriodo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,'Anual'),(2,'Cuatrimestral'),(3,'Bimestral');
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `idPersona` int NOT NULL AUTO_INCREMENT,
  `nombrePersona` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `apellidoPersona` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `CUIL` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `hijoPersona` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `correo` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `celular` varchar(45) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `borrado` tinyint NOT NULL DEFAULT '0',
  `idSexo` int NOT NULL,
  `idDomicilio` int NOT NULL,
  `idTipoDocumento` int NOT NULL,
  `idNacionalidad` int NOT NULL,
  `idFoto` int DEFAULT NULL,
  `lugarNacimiento` int DEFAULT NULL,
  PRIMARY KEY (`idPersona`),
  KEY `fk_Persona_Sexo` (`idSexo`),
  KEY `fk_Persona_Domicilio` (`idDomicilio`),
  KEY `fk_Persona_TipoDocumento` (`idTipoDocumento`),
  KEY `fk_Persona_Nacionalidad` (`idNacionalidad`),
  KEY `fk_Persona_Foto` (`idFoto`),
  KEY `fk_Persona_Lugar` (`lugarNacimiento`),
  CONSTRAINT `fk_Persona_Domicilio` FOREIGN KEY (`idDomicilio`) REFERENCES `domicilio` (`idDomicilio`),
  CONSTRAINT `fk_Persona_Foto` FOREIGN KEY (`idFoto`) REFERENCES `foto` (`idFoto`),
  CONSTRAINT `fk_Persona_Lugar` FOREIGN KEY (`lugarNacimiento`) REFERENCES `lugar` (`idLugar`),
  CONSTRAINT `fk_Persona_Nacionalidad` FOREIGN KEY (`idNacionalidad`) REFERENCES `nacionalidad` (`idNacionalidad`),
  CONSTRAINT `fk_Persona_Sexo` FOREIGN KEY (`idSexo`) REFERENCES `sexo` (`idSexo`),
  CONSTRAINT `fk_Persona_TipoDocumento` FOREIGN KEY (`idTipoDocumento`) REFERENCES `tipodocumento` (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Admin','Admin',NULL,NULL,NULL,NULL,NULL,0,1,1,1,1,NULL,NULL),(2,'Admin','Admin',NULL,NULL,NULL,NULL,NULL,0,1,1,1,1,NULL,NULL);
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personatrabajo`
--

DROP TABLE IF EXISTS `personatrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personatrabajo` (
  `idPersonaTrabajo` int NOT NULL AUTO_INCREMENT,
  `Trabajo_idTrabajo` int NOT NULL,
  `Persona_idPersona` int NOT NULL,
  PRIMARY KEY (`idPersonaTrabajo`),
  KEY `fk_PersonaTrabajo_Trabajo` (`Trabajo_idTrabajo`),
  KEY `fk_PersonaTrabajo_Persona` (`Persona_idPersona`),
  CONSTRAINT `fk_PersonaTrabajo_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `fk_PersonaTrabajo_Trabajo` FOREIGN KEY (`Trabajo_idTrabajo`) REFERENCES `trabajo` (`idTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personatrabajo`
--

LOCK TABLES `personatrabajo` WRITE;
/*!40000 ALTER TABLE `personatrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `personatrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes`
--

DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes` (
  `idPlanes` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Borrado` tinyint NOT NULL DEFAULT '0',
  PRIMARY KEY (`idPlanes`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes`
--

LOCK TABLES `planes` WRITE;
/*!40000 ALTER TABLE `planes` DISABLE KEYS */;
INSERT INTO `planes` VALUES (1,'Plan A',0),(2,'Plan B',0);
/*!40000 ALTER TABLE `planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planpersona`
--

DROP TABLE IF EXISTS `planpersona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planpersona` (
  `idPlanPersona` int NOT NULL AUTO_INCREMENT,
  `Planes_idPlanes` int NOT NULL,
  `Persona_idPersona` int NOT NULL,
  PRIMARY KEY (`idPlanPersona`),
  KEY `fk_PlanPersona_Planes` (`Planes_idPlanes`),
  KEY `fk_PlanPersona_Persona` (`Persona_idPersona`),
  CONSTRAINT `fk_PlanPersona_Persona` FOREIGN KEY (`Persona_idPersona`) REFERENCES `persona` (`idPersona`),
  CONSTRAINT `fk_PlanPersona_Planes` FOREIGN KEY (`Planes_idPlanes`) REFERENCES `planes` (`idPlanes`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planpersona`
--

LOCK TABLES `planpersona` WRITE;
/*!40000 ALTER TABLE `planpersona` DISABLE KEYS */;
/*!40000 ALTER TABLE `planpersona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sexo`
--

DROP TABLE IF EXISTS `sexo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sexo` (
  `idSexo` int NOT NULL AUTO_INCREMENT,
  `detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idSexo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sexo`
--

LOCK TABLES `sexo` WRITE;
/*!40000 ALTER TABLE `sexo` DISABLE KEYS */;
INSERT INTO `sexo` VALUES (1,'Masculino'),(2,'Femenino'),(3,'No binario');
/*!40000 ALTER TABLE `sexo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipocurso`
--

DROP TABLE IF EXISTS `tipocurso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipocurso` (
  `idTipoCurso` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `Costo` float NOT NULL DEFAULT '0',
  `Periodo_idPeriodo` int NOT NULL,
  PRIMARY KEY (`idTipoCurso`),
  KEY `fk_TipoCurso_Periodo` (`Periodo_idPeriodo`),
  CONSTRAINT `fk_TipoCurso_Periodo` FOREIGN KEY (`Periodo_idPeriodo`) REFERENCES `periodo` (`idPeriodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipocurso`
--

LOCK TABLES `tipocurso` WRITE;
/*!40000 ALTER TABLE `tipocurso` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipocurso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodocumento`
--

DROP TABLE IF EXISTS `tipodocumento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodocumento` (
  `idTipoDocumento` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idTipoDocumento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodocumento`
--

LOCK TABLES `tipodocumento` WRITE;
/*!40000 ALTER TABLE `tipodocumento` DISABLE KEYS */;
INSERT INTO `tipodocumento` VALUES (1,'DNI'),(2,'Pasaporte'),(3,'CI');
/*!40000 ALTER TABLE `tipodocumento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `titulo`
--

DROP TABLE IF EXISTS `titulo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `titulo` (
  `idTitulo` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idTitulo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `titulo`
--

LOCK TABLES `titulo` WRITE;
/*!40000 ALTER TABLE `titulo` DISABLE KEYS */;
/*!40000 ALTER TABLE `titulo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajo`
--

DROP TABLE IF EXISTS `trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajo` (
  `idTrabajo` int NOT NULL AUTO_INCREMENT,
  `Detalle` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`idTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajo`
--

LOCK TABLES `trabajo` WRITE;
/*!40000 ALTER TABLE `trabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT,
  `user` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `pass` varchar(45) COLLATE utf8mb4_spanish_ci NOT NULL,
  `jerarquia` int NOT NULL DEFAULT '0',
  `borrado` tinyint NOT NULL DEFAULT '0',
  `idEmpleado` int NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `user` (`user`),
  KEY `fk_Usuario_Empleado` (`idEmpleado`),
  CONSTRAINT `fk_Usuario_Empleado` FOREIGN KEY (`idEmpleado`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','admin',1,0,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-28 21:11:52
