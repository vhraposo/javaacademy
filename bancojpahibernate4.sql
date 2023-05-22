-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 22-Maio-2023 às 23:39
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
-- Banco de dados: `bancojpahibernate4`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe`
--

CREATE TABLE `classe` (
  `cid` int(11) NOT NULL,
  `cnome` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `classe`
--

INSERT INTO `classe` (`cid`, `cnome`) VALUES
(1, 'Primeira'),
(2, 'Segunda'),
(3, 'Terceira');

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe_professor`
--

CREATE TABLE `classe_professor` (
  `professor_id` int(11) NOT NULL,
  `Classe_cid` int(11) NOT NULL,
  `professorSet_pid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor`
--

CREATE TABLE `professor` (
  `pid` int(11) NOT NULL,
  `pnome` varchar(255) DEFAULT NULL,
  `assunto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor`
--

INSERT INTO `professor` (`pid`, `pnome`, `assunto`) VALUES
(4, 'Pedro', 'JavaScript'),
(5, 'Lucas', 'HTML/CSS'),
(6, 'Victor', 'Angular');

-- --------------------------------------------------------

--
-- Estrutura da tabela `professor_classe`
--

CREATE TABLE `professor_classe` (
  `Professor_pid` int(11) NOT NULL,
  `clasSet_cid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `professor_classe`
--

INSERT INTO `professor_classe` (`Professor_pid`, `clasSet_cid`) VALUES
(4, 1),
(4, 2),
(4, 3),
(5, 1),
(5, 2),
(5, 3),
(6, 1),
(6, 2),
(6, 3);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`cid`);

--
-- Índices para tabela `classe_professor`
--
ALTER TABLE `classe_professor`
  ADD KEY `professor_id` (`professor_id`),
  ADD KEY `FKtdtnrtxufmfcn5p4rr1njm1df` (`professorSet_pid`),
  ADD KEY `FK3opyjl6qxe49rxs0b6fw33ltl` (`Classe_cid`);

--
-- Índices para tabela `professor`
--
ALTER TABLE `professor`
  ADD PRIMARY KEY (`pid`);

--
-- Índices para tabela `professor_classe`
--
ALTER TABLE `professor_classe`
  ADD PRIMARY KEY (`Professor_pid`,`clasSet_cid`),
  ADD KEY `FKdk8hqu09q5mp77idh4yq9avb0` (`clasSet_cid`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `classe`
--
ALTER TABLE `classe`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `professor`
--
ALTER TABLE `professor`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `professor_classe`
--
ALTER TABLE `professor_classe`
  ADD CONSTRAINT `FKahf0akpkh9s85ek6ux00kqosp` FOREIGN KEY (`Professor_pid`) REFERENCES `professor` (`pid`),
  ADD CONSTRAINT `FKdk8hqu09q5mp77idh4yq9avb0` FOREIGN KEY (`clasSet_cid`) REFERENCES `classe` (`cid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
