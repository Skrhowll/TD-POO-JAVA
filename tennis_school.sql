-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 27 mars 2024 à 18:43
-- Version du serveur : 5.7.40
-- Version de PHP : 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `tennis_school`
--

-- --------------------------------------------------------

--
-- Structure de la table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` varchar(4) DEFAULT NULL,
  `subject_id` varchar(4) DEFAULT NULL,
  `grade` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `subject_id` (`subject_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `grade`
--

INSERT INTO `grade` (`id`, `student_id`, `subject_id`, `grade`) VALUES
(1, 'S1', 'Math', '90.00'),
(2, 'S1', 'Sci', '85.00'),
(3, 'S1', 'Eng', '88.00'),
(4, 'S2', 'Math', '92.00'),
(5, 'S2', 'Sci', '87.00'),
(6, 'S2', 'Eng', '89.00'),
(7, 'S3', 'Math', '85.00'),
(8, 'S3', 'Sci', '80.00'),
(9, 'S3', 'Eng', '82.00');

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` varchar(100) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `student`
--

INSERT INTO `student` (`id`, `firstName`, `lastName`) VALUES
('1082', 'sika1082', 'dove1082'),
('S1', 'John', 'Doe'),
('S2', 'Jane', 'Smith'),
('S3', 'Michael', 'Johnson');

-- --------------------------------------------------------

--
-- Structure de la table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `id` varchar(4) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `factor` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `subject`
--

INSERT INTO `subject` (`id`, `name`, `factor`) VALUES
('Math', 'Mathematics', NULL),
('Sci', 'Science', NULL),
('Eng', 'English', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
