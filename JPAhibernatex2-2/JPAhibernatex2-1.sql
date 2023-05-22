-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Maio-2023 às 22:28
-- Versão do servidor: 10.4.24-MariaDB
-- versão do PHP: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bancojpahibernate3`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `department`
--

CREATE TABLE `department` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `department`
--

INSERT INTO `department` (`id`, `name`) VALUES
(54, 'Desenvolvedor'),
(55, 'Informática'),
(56, 'Contabilidade'),
(57, 'Desenvolvedor'),
(58, 'Informática'),
(59, 'Contabilidade'),
(60, 'Desenvolvedor'),
(61, 'Informática'),
(62, 'Contabilidade'),
(63, 'asd'),
(64, 'Informática'),
(65, 'Contabilidade'),
(66, 'Financeiro'),
(67, 'Web'),
(68, 'Contabilidade'),
(69, 'Financeiro2'),
(70, 'Web2'),
(71, 'Contabilidade2');

-- --------------------------------------------------------

--
-- Estrutura da tabela `department_employee`
--

CREATE TABLE `department_employee` (
  `Department_id` int(11) NOT NULL,
  `employeeSet_eid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `employee`
--

CREATE TABLE `employee` (
  `eid` int(10) NOT NULL,
  `deg` varchar(100) NOT NULL,
  `ename` varchar(100) NOT NULL,
  `salary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `employee`
--

INSERT INTO `employee` (`eid`, `deg`, `ename`, `salary`) VALUES
(51, 'Manager 1', 'Fulano 1', 7000),
(52, 'Manager 2', 'Fulano 2', 8000),
(53, 'Manager 3', 'Fulano 3', 9000),
(54, 'Manager 1', 'Fulano 1', 7000),
(55, 'Manager 2', 'Fulano 2', 8000),
(56, 'Manager 3', 'Fulano 3', 9000),
(57, 'Manager 1', 'Fulano 1', 7000),
(58, 'Manager 2', 'Fulano 2', 8000),
(59, 'Manager 3', 'Fulano 3', 9000),
(60, 'Manager 1', 'emp 1', 7000),
(61, 'Manager 2', 'emp 2', 8000),
(62, 'Manager 3', 'Fulano 3', 9000),
(63, 'Manager 1', 'emp 1', 7000),
(64, 'Manager 2', 'emp 2', 8000),
(65, 'Manager 3', 'Fulano 3', 9000),
(66, 'Manager 1', 'emp 1_new', 7000),
(67, 'Manager 2', 'emp 2_new', 8000),
(68, 'Manager 3', 'emp 3_new', 9000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `employee_department`
--

CREATE TABLE `employee_department` (
  `employee_id` int(11) NOT NULL,
  `department_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `employee_department`
--

INSERT INTO `employee_department` (`employee_id`, `department_id`) VALUES
(51, 54),
(54, 57),
(57, 60),
(58, 60),
(60, 63),
(61, 63),
(63, 66),
(64, 66),
(66, 69),
(67, 69),
(67, 70),
(68, 71);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `department_employee`
--
ALTER TABLE `department_employee`
  ADD PRIMARY KEY (`Department_id`,`employeeSet_eid`),
  ADD KEY `FK9n03jvs8fl79qvlag341j3hbh` (`employeeSet_eid`);

--
-- Índices para tabela `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`eid`);

--
-- Índices para tabela `employee_department`
--
ALTER TABLE `employee_department`
  ADD PRIMARY KEY (`employee_id`,`department_id`),
  ADD KEY `FK13q1yf80psy5js9liugtf57v6` (`department_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `department`
--
ALTER TABLE `department`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=72;

--
-- AUTO_INCREMENT de tabela `employee`
--
ALTER TABLE `employee`
  MODIFY `eid` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=69;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `department_employee`
--
ALTER TABLE `department_employee`
  ADD CONSTRAINT `FK9n03jvs8fl79qvlag341j3hbh` FOREIGN KEY (`employeeSet_eid`) REFERENCES `employee` (`eid`),
  ADD CONSTRAINT `FKeu7bcdfempbcsnvjb09dmug9e` FOREIGN KEY (`Department_id`) REFERENCES `department` (`id`);

--
-- Limitadores para a tabela `employee_department`
--
ALTER TABLE `employee_department`
  ADD CONSTRAINT `FK13q1yf80psy5js9liugtf57v6` FOREIGN KEY (`department_id`) REFERENCES `department` (`id`),
  ADD CONSTRAINT `FKhvl2d0v7ri548e8m3plaj57np` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`eid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
