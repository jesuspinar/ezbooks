-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 10, 2023 at 03:45 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ezbooks_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `Autor`
--

CREATE TABLE `Autor` (
  `idAutor` int(11) NOT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `apellidos` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Direcciones`
--

CREATE TABLE `Direcciones` (
  `idDirecciones` int(11) NOT NULL,
  `calle` varchar(65) DEFAULT NULL,
  `ciudad` varchar(65) DEFAULT NULL,
  `provincia` varchar(65) DEFAULT NULL,
  `pais` varchar(65) DEFAULT NULL,
  `codigo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Editorial`
--

CREATE TABLE `Editorial` (
  `idEditorial` int(11) NOT NULL,
  `nombre` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Genero`
--

CREATE TABLE `Genero` (
  `idGenero` int(11) NOT NULL,
  `nombre` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Libro`
--

CREATE TABLE `Libro` (
  `idLibro` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `titulo` varchar(65) DEFAULT NULL,
  `descripcion` varchar(120) DEFAULT NULL,
  `precio` decimal(4,2) NOT NULL,
  `img_portada` varchar(250) DEFAULT NULL,
  `vendido` tinyint(4) NOT NULL,
  `idEditorial` int(11) NOT NULL,
  `idAutor` int(11) NOT NULL,
  `idGenero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Log`
--

CREATE TABLE `Log` (
  `idLog` int(11) NOT NULL,
  `fecha_hora` datetime NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Rol`
--

CREATE TABLE `Rol` (
  `idRol` int(11) NOT NULL,
  `permisos` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Transaccion`
--

CREATE TABLE `Transaccion` (
  `idTransaccion` int(11) NOT NULL,
  `idLibro` int(11) NOT NULL,
  `precio` decimal(4,2) NOT NULL,
  `idUsuarioComprador` int(11) NOT NULL,
  `idDireccionComprador` int(11) NOT NULL,
  `idUsuarioVendedor` int(11) NOT NULL,
  `idDireccionVendedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario`
--

CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `apellidos` varchar(75) DEFAULT NULL,
  `idDirecciones` int(11) NOT NULL,
  `idRol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Autor`
--
ALTER TABLE `Autor`
  ADD PRIMARY KEY (`idAutor`);

--
-- Indexes for table `Direcciones`
--
ALTER TABLE `Direcciones`
  ADD PRIMARY KEY (`idDirecciones`);

--
-- Indexes for table `Editorial`
--
ALTER TABLE `Editorial`
  ADD PRIMARY KEY (`idEditorial`);

--
-- Indexes for table `Genero`
--
ALTER TABLE `Genero`
  ADD PRIMARY KEY (`idGenero`);

--
-- Indexes for table `Libro`
--
ALTER TABLE `Libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD KEY `fk_Libro_Editorial1_idx` (`idEditorial`),
  ADD KEY `fk_Libro_Autor1_idx` (`idAutor`),
  ADD KEY `fk_Libro_Genero1_idx` (`idGenero`),
  ADD KEY `fk_Libro_Usuario1_idx` (`idUsuario`);

--
-- Indexes for table `Log`
--
ALTER TABLE `Log`
  ADD PRIMARY KEY (`idLog`),
  ADD KEY `fk_Log_Usuario1_idx` (`idUsuario`);

--
-- Indexes for table `Rol`
--
ALTER TABLE `Rol`
  ADD PRIMARY KEY (`idRol`);

--
-- Indexes for table `Transaccion`
--
ALTER TABLE `Transaccion`
  ADD PRIMARY KEY (`idTransaccion`),
  ADD KEY `fk_Transaccion_Libro1_idx` (`idLibro`,`precio`),
  ADD KEY `fk_Transaccion_Usuario1_idx` (`idUsuarioComprador`,`idDireccionComprador`),
  ADD KEY `fk_Transaccion_Usuario2_idx` (`idUsuarioVendedor`,`idDireccionVendedor`),
  ADD KEY `idDireccionComprador` (`idDireccionComprador`),
  ADD KEY `idDireccionVendedor` (`idDireccionVendedor`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`idUsuario`),
  ADD KEY `fk_Usuario_Direcciones` (`idDirecciones`),
  ADD KEY `fk_Usuario_Rol1` (`idRol`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Autor`
--
ALTER TABLE `Autor`
  MODIFY `idAutor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Direcciones`
--
ALTER TABLE `Direcciones`
  MODIFY `idDirecciones` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Editorial`
--
ALTER TABLE `Editorial`
  MODIFY `idEditorial` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Genero`
--
ALTER TABLE `Genero`
  MODIFY `idGenero` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Libro`
--
ALTER TABLE `Libro`
  MODIFY `idLibro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Rol`
--
ALTER TABLE `Rol`
  MODIFY `idRol` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Transaccion`
--
ALTER TABLE `Transaccion`
  MODIFY `idTransaccion` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Libro`
--
ALTER TABLE `Libro`
  ADD CONSTRAINT `fk_Libro_Autor1` FOREIGN KEY (`idAutor`) REFERENCES `Autor` (`idAutor`),
  ADD CONSTRAINT `fk_Libro_Editorial1` FOREIGN KEY (`idEditorial`) REFERENCES `Editorial` (`idEditorial`),
  ADD CONSTRAINT `fk_Libro_Genero1` FOREIGN KEY (`idGenero`) REFERENCES `Genero` (`idGenero`),
  ADD CONSTRAINT `fk_Libro_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`);

--
-- Constraints for table `Log`
--
ALTER TABLE `Log`
  ADD CONSTRAINT `fk_Log_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`);

--
-- Constraints for table `Transaccion`
--
ALTER TABLE `Transaccion`
  ADD CONSTRAINT `transaccion_ibfk_3` FOREIGN KEY (`idLibro`) REFERENCES `Libro` (`idLibro`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaccion_ibfk_4` FOREIGN KEY (`idUsuarioComprador`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaccion_ibfk_5` FOREIGN KEY (`idUsuarioVendedor`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaccion_ibfk_6` FOREIGN KEY (`idDireccionComprador`) REFERENCES `Usuario` (`idDirecciones`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaccion_ibfk_7` FOREIGN KEY (`idDireccionVendedor`) REFERENCES `Usuario` (`idDirecciones`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD CONSTRAINT `fk_Usuario_Direcciones` FOREIGN KEY (`idDirecciones`) REFERENCES `Direcciones` (`idDirecciones`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Usuario_Rol1` FOREIGN KEY (`idRol`) REFERENCES `Rol` (`idRol`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
