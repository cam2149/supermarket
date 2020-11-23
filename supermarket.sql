-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2020 a las 02:37:53
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `supermarket`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test_cliente`
--

CREATE TABLE `test_cliente` (
  `IdCliente` int(11) NOT NULL,
  `Identifiacion` decimal(18,0) NOT NULL,
  `Nombres` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `Direccion` varchar(300) NOT NULL,
  `Telefono` varchar(50) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `test_cliente`
--

INSERT INTO `test_cliente` (`IdCliente`, `Identifiacion`, `Nombres`, `Apellidos`, `Direccion`, `Telefono`, `Email`) VALUES
(1, '11223344', 'CLIENTE', 'BAJO', 'CALLE 1 # 2-1', '3210099', 'CL01@YAHOO.ES'),
(2, '789456', 'PETER', 'ROJO', 'CALLE 11 # 21-11', NULL, NULL),
(3, '66995522', 'JAIR', 'RUIZ', 'CALLE 63 # 55-1', '3669955', 'JAIR@YAHOO.ES'),
(4, '2255448', 'VICTOR', 'BARCO', 'CALLE 19 # 21', '7410022', 'VICTOR@YAHOO.ES'),
(5, '123456789', 'MARIA', 'CALLE', 'CALLE 61 # 77D-96', '6660005', 'CALLE@YAHOO.ES'),
(6, '41000333', 'LUIS', 'CORREO', 'CALLE 45 # 32-11', '4444444', 'LCORREO@YAHOO.ES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test_factura`
--

CREATE TABLE `test_factura` (
  `IdFactura` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `FechaVenta` datetime NOT NULL,
  `ValorTotal` decimal(18,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test_factura_detalle`
--

CREATE TABLE `test_factura_detalle` (
  `IdFacturaDetalle` int(11) NOT NULL,
  `IdFactura` int(11) NOT NULL,
  `IdProducto` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `ValorUnidad` decimal(18,3) NOT NULL,
  `ValorTotal` decimal(18,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `test_producto`
--

CREATE TABLE `test_producto` (
  `IdProducto` int(11) NOT NULL,
  `Codigo` varchar(30) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `ValorUnidad` decimal(18,3) NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `test_producto`
--

INSERT INTO `test_producto` (`IdProducto`, `Codigo`, `Nombre`, `ValorUnidad`, `Stock`) VALUES
(1, '0001', 'TOSTACOS', '950.000', 15),
(2, '0002', 'LECHE', '2350.000', 40),
(3, '0003', 'PLATANO', '1500.000', 20),
(4, '0004', 'PAÑALES', '36500.000', 4),
(5, '0005', 'BULTO DE MANDARINAS', '156800.000', 9),
(6, '0006', 'ARROZ', '6450.000', 60),
(7, '0007', 'PESCADO', '99000.000', 45),
(8, '0008', 'HUEVOS', '11500.000', 20),
(9, '0009', 'PAPAS JAJAJAJA', '6600.000', 1),
(10, '0010', 'DETERGENTE', '5001000.000', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `test_cliente`
--
ALTER TABLE `test_cliente`
  ADD PRIMARY KEY (`IdCliente`);

--
-- Indices de la tabla `test_factura`
--
ALTER TABLE `test_factura`
  ADD PRIMARY KEY (`IdFactura`),
  ADD KEY `FK_CLIENTES` (`IdCliente`);

--
-- Indices de la tabla `test_factura_detalle`
--
ALTER TABLE `test_factura_detalle`
  ADD PRIMARY KEY (`IdFacturaDetalle`);

--
-- Indices de la tabla `test_producto`
--
ALTER TABLE `test_producto`
  ADD PRIMARY KEY (`IdProducto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `test_cliente`
--
ALTER TABLE `test_cliente`
  MODIFY `IdCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `test_factura`
--
ALTER TABLE `test_factura`
  MODIFY `IdFactura` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `test_factura_detalle`
--
ALTER TABLE `test_factura_detalle`
  MODIFY `IdFacturaDetalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `test_producto`
--
ALTER TABLE `test_producto`
  MODIFY `IdProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `test_factura`
--
ALTER TABLE `test_factura`
  ADD CONSTRAINT `FK_CLIENTES` FOREIGN KEY (`IdCliente`) REFERENCES `test_cliente` (`IdCliente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
