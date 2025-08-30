-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-08-2025 a las 17:00:34
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pasarela`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrito_compras`
--

CREATE TABLE `carrito_compras` (
  `id_carrito` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL DEFAULT 1,
  `fecha_agregado` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `carrito_compras`
--

INSERT INTO `carrito_compras` (`id_carrito`, `id_usuario`, `id_producto`, `cantidad`, `fecha_agregado`) VALUES
(1, 1, 1, 1, '2025-08-10 15:15:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_compra`
--

CREATE TABLE `historial_compra` (
  `id_compra` int(11) NOT NULL,
  `Cantidad` int(50) NOT NULL,
  `precio_total` int(20) DEFAULT NULL,
  `fecha_compra` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `id_usuario` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `id_metodo_pago` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_compra`
--

INSERT INTO `historial_compra` (`id_compra`, `Cantidad`, `precio_total`, `fecha_compra`, `id_usuario`, `id_producto`, `id_metodo_pago`) VALUES
(1, 1, 80, '2025-08-30 13:55:48.044415', 1, 1, 1),
(2, 1, 150, '2025-08-30 13:55:53.969942', 2, 3, 2),
(3, 1, 599, '2025-08-30 13:56:34.178217', 3, 4, 4),
(4, 1, 30, '2025-08-30 13:56:34.188030', 4, 2, 3),
(5, 1, 50, '2025-08-30 13:56:34.191042', 5, 5, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodo_pago`
--

CREATE TABLE `metodo_pago` (
  `id_metodo` int(11) NOT NULL,
  `nombre_metodo` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `metodo_pago`
--

INSERT INTO `metodo_pago` (`id_metodo`, `nombre_metodo`) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta Debito'),
(3, 'Tarjeta Credito'),
(4, 'Transferencia'),
(5, 'PayPal'),
(6, 'Consignacion'),
(7, 'Bitcoin'),
(8, 'Apple Pay'),
(9, 'Google Pay');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id_producto` int(10) NOT NULL,
  `nombre_producto` varchar(30) DEFAULT NULL,
  `precio_producto` decimal(10,2) DEFAULT NULL,
  `cantidad_producto` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id_producto`, `nombre_producto`, `precio_producto`, `cantidad_producto`) VALUES
(1, 'Teclado Mecanico RGB', 46.00, 15),
(2, 'Mouse Inalambrico Logitech', 121.00, 25),
(3, 'Monitor LED 24 pulgadas', 150.00, 10),
(4, 'Laptop Dell Inspiron 15', 599.00, 5),
(5, 'Auriculares JBL Tune 500', 50.00, 30),
(6, 'Camara Web HD', 39.00, 12),
(7, 'Disco Duro Externo 1TB', 89.00, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id_roles` int(11) NOT NULL,
  `nombre_rol` varchar(30) DEFAULT NULL,
  `fecha_registro` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id_roles`, `nombre_rol`, `fecha_registro`) VALUES
(1, 'Administrador', '2025-08-16 21:03:53.529208'),
(2, 'Cliente', '2025-08-16 21:03:53.529208'),
(3, 'Vendedor', '2025-08-16 21:03:53.529208');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre_usuario` varchar(30) DEFAULT NULL,
  `apellido_usuario` varchar(30) DEFAULT NULL,
  `fecha_registro` timestamp(6) NOT NULL DEFAULT current_timestamp(6) ON UPDATE current_timestamp(6),
  `correo_usuario` varchar(30) DEFAULT NULL,
  `id_roles` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre_usuario`, `apellido_usuario`, `fecha_registro`, `correo_usuario`, `id_roles`) VALUES
(1, 'Carlos', 'Quinones', '2025-08-26 18:46:05.211428', 'carlos.quiñones@gmail.com', 2),
(2, 'Lucia', 'Martinez', '2025-08-26 18:26:06.710175', 'lucia.martinez@gmail.com', 1),
(3, 'Ana', 'Lopez', '2025-08-16 21:09:59.342764', 'ana.lopez@gmail.com', 3),
(4, 'Pedro', 'Ramirez', '2025-08-26 18:26:06.719609', 'pedro.ramirez@gmail.com', 1),
(5, 'Sofia', 'Torres', '2025-08-26 18:26:06.728913', 'sofia.torres@gmail.com', 2),
(6, 'Jorge', 'Vargas', '2025-08-16 21:09:59.342764', 'jorge.vargas@gmail.com', 3),
(7, 'Marta', 'Perez', '2025-08-26 18:26:06.738341', 'marta.perez@gmail.com', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_producto`
--

CREATE TABLE `usuario_producto` (
  `id_usuario_producto` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario_producto`
--

INSERT INTO `usuario_producto` (`id_usuario_producto`, `id_usuario`, `id_producto`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 3),
(5, 2, 5),
(6, 5, 6),
(7, 1, 7),
(8, 3, 4),
(9, 5, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrito_compras`
--
ALTER TABLE `carrito_compras`
  ADD PRIMARY KEY (`id_carrito`),
  ADD KEY `fk_carrito_usuario` (`id_usuario`),
  ADD KEY `fk_carrito_producto` (`id_producto`);

--
-- Indices de la tabla `historial_compra`
--
ALTER TABLE `historial_compra`
  ADD PRIMARY KEY (`id_compra`),
  ADD KEY `fk_usuario` (`id_usuario`),
  ADD KEY `fk_producto` (`id_producto`),
  ADD KEY `fk_metodo_pago` (`id_metodo_pago`);

--
-- Indices de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  ADD PRIMARY KEY (`id_metodo`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id_producto`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id_roles`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `fk_rol_usuario` (`id_roles`);

--
-- Indices de la tabla `usuario_producto`
--
ALTER TABLE `usuario_producto`
  ADD PRIMARY KEY (`id_usuario_producto`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_producto` (`id_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carrito_compras`
--
ALTER TABLE `carrito_compras`
  MODIFY `id_carrito` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `historial_compra`
--
ALTER TABLE `historial_compra`
  MODIFY `id_compra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `metodo_pago`
--
ALTER TABLE `metodo_pago`
  MODIFY `id_metodo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id_producto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id_roles` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `usuario_producto`
--
ALTER TABLE `usuario_producto`
  MODIFY `id_usuario_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrito_compras`
--
ALTER TABLE `carrito_compras`
  ADD CONSTRAINT `fk_carrito_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_carrito_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `historial_compra`
--
ALTER TABLE `historial_compra`
  ADD CONSTRAINT `fk_metodo_pago` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id_metodo`),
  ADD CONSTRAINT `fk_producto` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`),
  ADD CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_rol_usuario` FOREIGN KEY (`id_roles`) REFERENCES `roles` (`id_roles`),
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario_producto` (`id_usuario_producto`);

--
-- Filtros para la tabla `usuario_producto`
--
ALTER TABLE `usuario_producto`
  ADD CONSTRAINT `usuario_producto_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `usuario_producto_ibfk_2` FOREIGN KEY (`id_producto`) REFERENCES `productos` (`id_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
