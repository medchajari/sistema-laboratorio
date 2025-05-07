-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-05-2025 a las 13:29:22
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `laboratorio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `caja`
--

CREATE TABLE `caja` (
  `idCaja` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `monto` double NOT NULL,
  `forma_de_pago` varchar(50) NOT NULL,
  `numero_protocolo` varchar(50) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `efectivo` double NOT NULL,
  `transferencia` double NOT NULL,
  `cuenta_corriente` double NOT NULL,
  `obra_social` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `caja`
--

INSERT INTO `caja` (`idCaja`, `usuario`, `monto`, `forma_de_pago`, `numero_protocolo`, `fecha`, `efectivo`, `transferencia`, `cuenta_corriente`, `obra_social`) VALUES
(23, 'Melina', 55000, 'Cuenta Corriente', 'PROTOCOLOPRUEBA', '2025-04-29 22:33:53', 0, 0, 55000, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta_corriente`
--

CREATE TABLE `cuenta_corriente` (
  `id_cc` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_caja` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `egreso` double NOT NULL,
  `ingreso` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cuenta_corriente`
--

INSERT INTO `cuenta_corriente` (`id_cc`, `id_paciente`, `id_caja`, `usuario`, `fecha`, `egreso`, `ingreso`) VALUES
(26, 13, 23, 'Melina', '2025-04-29 22:33:53', 55000, 0),
(27, 13, 1, 'admin', '2025-04-29 22:34:13', 0, 20000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_de_pago`
--

CREATE TABLE `forma_de_pago` (
  `id_forma_de_pago` int(11) NOT NULL,
  `id_protocolo` int(11) NOT NULL,
  `metodo` varchar(50) NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial_obra_social`
--

CREATE TABLE `historial_obra_social` (
  `id_historial_obra_social` int(11) NOT NULL,
  `id_obra_social` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `numero_protocolo` varchar(50) NOT NULL,
  `fecha_solicitud` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `monto` double NOT NULL,
  `forma_de_pago` varchar(100) NOT NULL,
  `estado` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial_obra_social`
--

INSERT INTO `historial_obra_social` (`id_historial_obra_social`, `id_obra_social`, `id_paciente`, `numero_protocolo`, `fecha_solicitud`, `monto`, `forma_de_pago`, `estado`) VALUES
(32, 1, 13, 'PROTOCOLOPRUEBA', '2025-04-29 22:33:53', 0, 'Cuenta Corriente', 'Solicitado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `obra_social`
--

CREATE TABLE `obra_social` (
  `id_obra_social` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `porcentaje` double NOT NULL,
  `observacion` varchar(250) NOT NULL,
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `obra_social`
--

INSERT INTO `obra_social` (`id_obra_social`, `nombre`, `porcentaje`, `observacion`, `estado`) VALUES
(1, 'Sin Obra Social', 0, 'Este campo representa que el Paciente no tiene una obra social.', 1),
(7, 'OSPE', 10, 'OSPE Obra Social de Petroleros.', 1),
(9, 'OSPIN', 40, 'Obra social de la Industria Maderera.', 1),
(10, 'OSCHOCA', 50, 'Obra Social de Camioneros.', 1),
(11, 'OSECAC', 100, ' Obra Social de Empleados de Comercio', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `id_paciente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` varchar(50) NOT NULL,
  `dni` varchar(12) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `genero` varchar(50) NOT NULL,
  `historia_clinica` int(11) NOT NULL,
  `observacion` varchar(250) NOT NULL,
  `saldo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pacientes`
--

INSERT INTO `pacientes` (`id_paciente`, `nombre`, `apellido`, `fecha_nacimiento`, `dni`, `direccion`, `telefono`, `email`, `genero`, `historia_clinica`, `observacion`, `saldo`) VALUES
(12, 'juan', 'perez', '01 Enero 1980', '33011649', 'sin info', '3456468876', 'jp@gmail.com', 'Masculino', 0, 'cliente de prueba', 0),
(13, 'Margarita', 'De Los Santos', '14 de Mayo 2020', '53011647', 'Pablo Stampa 3325', '3456468878', 'margad@gmail.com', 'Femenino', 4, 'compañerita del programador', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesionales`
--

CREATE TABLE `profesionales` (
  `id_profesional` int(11) NOT NULL,
  `nombre_apellido` varchar(100) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `direccion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `profesionales`
--

INSERT INTO `profesionales` (`id_profesional`, `nombre_apellido`, `telefono`, `direccion`) VALUES
(1, 'Mario  Hernan Pergolini', '3456414142', 'rivadavia 2020');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `protocolo`
--

CREATE TABLE `protocolo` (
  `id_protocolo` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `numero_protocolo` varchar(20) NOT NULL,
  `medico` varchar(250) NOT NULL,
  `tipo` varchar(100) NOT NULL,
  `fecha_entrada` date NOT NULL,
  `fecha_salida` date NOT NULL,
  `estado` varchar(100) NOT NULL,
  `monto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `protocolo`
--

INSERT INTO `protocolo` (`id_protocolo`, `id_paciente`, `numero_protocolo`, `medico`, `tipo`, `fecha_entrada`, `fecha_salida`, `estado`, `monto`) VALUES
(42, 13, 'PROTOCOLOPRUEBA', 'Mario  Hernan Pergolini', 'Anatomía Patológica', '2025-04-29', '2025-05-29', 'En espera', 55000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_protocolo`
--

CREATE TABLE `tipo_protocolo` (
  `id_tipo` int(11) NOT NULL,
  `estudio` varchar(50) NOT NULL,
  `profesional` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tipo_protocolo`
--

INSERT INTO `tipo_protocolo` (`id_tipo`, `estudio`, `profesional`) VALUES
(3, 'Anatomía Patológica', 'maria'),
(4, 'Diagnostico Citologia', 'Melina Monzon');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `id_turno` int(11) NOT NULL,
  `id_paciente` int(11) NOT NULL,
  `id_profesional` int(11) NOT NULL,
  `fecha_turno` date NOT NULL,
  `hora_turno` date NOT NULL,
  `estado_turno` date NOT NULL,
  `observaciones` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `caja`
--
ALTER TABLE `caja`
  ADD PRIMARY KEY (`idCaja`);

--
-- Indices de la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  ADD PRIMARY KEY (`id_cc`);

--
-- Indices de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  ADD PRIMARY KEY (`id_forma_de_pago`),
  ADD KEY `id_protocolo` (`id_protocolo`);

--
-- Indices de la tabla `historial_obra_social`
--
ALTER TABLE `historial_obra_social`
  ADD PRIMARY KEY (`id_historial_obra_social`),
  ADD KEY `id_obra_social` (`id_obra_social`,`id_paciente`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `obra_social`
--
ALTER TABLE `obra_social`
  ADD PRIMARY KEY (`id_obra_social`);

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indices de la tabla `profesionales`
--
ALTER TABLE `profesionales`
  ADD PRIMARY KEY (`id_profesional`);

--
-- Indices de la tabla `protocolo`
--
ALTER TABLE `protocolo`
  ADD PRIMARY KEY (`id_protocolo`),
  ADD KEY `id_paciente` (`id_paciente`);

--
-- Indices de la tabla `tipo_protocolo`
--
ALTER TABLE `tipo_protocolo`
  ADD PRIMARY KEY (`id_tipo`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`id_turno`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username` (`username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `caja`
--
ALTER TABLE `caja`
  MODIFY `idCaja` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `cuenta_corriente`
--
ALTER TABLE `cuenta_corriente`
  MODIFY `id_cc` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  MODIFY `id_forma_de_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `historial_obra_social`
--
ALTER TABLE `historial_obra_social`
  MODIFY `id_historial_obra_social` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT de la tabla `obra_social`
--
ALTER TABLE `obra_social`
  MODIFY `id_obra_social` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `profesionales`
--
ALTER TABLE `profesionales`
  MODIFY `id_profesional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `protocolo`
--
ALTER TABLE `protocolo`
  MODIFY `id_protocolo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT de la tabla `tipo_protocolo`
--
ALTER TABLE `tipo_protocolo`
  MODIFY `id_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  ADD CONSTRAINT `forma_de_pago_ibfk_1` FOREIGN KEY (`id_protocolo`) REFERENCES `protocolo` (`id_protocolo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `historial_obra_social`
--
ALTER TABLE `historial_obra_social`
  ADD CONSTRAINT `historial_obra_social_ibfk_1` FOREIGN KEY (`id_obra_social`) REFERENCES `obra_social` (`id_obra_social`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historial_obra_social_ibfk_2` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `protocolo`
--
ALTER TABLE `protocolo`
  ADD CONSTRAINT `protocolo_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
