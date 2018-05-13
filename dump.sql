-- phpMyAdmin SQL Dump
-- version 4.0.10.18
-- https://www.phpmyadmin.net
--
-- Host: localhost:3306
-- Generation Time: May 13, 2018 at 03:28 PM
-- Server version: 5.5.56-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cleaningstore`
--

-- --------------------------------------------------------

--
-- Table structure for table `agenda`
--

CREATE TABLE IF NOT EXISTS `agenda` (
  `Nume` varchar(50) NOT NULL,
  `Prenume` varchar(50) NOT NULL,
  `Telefon Mobil` varchar(45) NOT NULL,
  `Telefon Fix` varchar(45) NOT NULL,
  `Email` varchar(45) NOT NULL,
  `Adresa` varchar(70) NOT NULL,
  `Oras` varchar(45) NOT NULL,
  `Judet` varchar(45) NOT NULL,
  `Cod Postal` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agenda`
--

INSERT INTO `agenda` (`Nume`, `Prenume`, `Telefon Mobil`, `Telefon Fix`, `Email`, `Adresa`, `Oras`, `Judet`, `Cod Postal`) VALUES
('Petrescu', 'Ion', '0755544312', '0211236784', 'uiiuiuhuhui@yahoo.com', 'Castelului, nr.14', 'Bucuresti', 'Bucuresti', '189101'),
('Crisan', 'Alexandru', '0711223344', '0213339988', 'Crisan.Alexandru@yahoo.com', 'Aleea Migdalelor, nr.5', 'Bucuresti', 'Bucuresti', '222444'),
('Stanescu', 'Cristina', '0787654321', '0212224445', 'Stanescu.Cristina@yahoo.com', 'Evantai, nr.47', 'Bucuresti', 'Bucuresti', '000123'),
('Caramitru', 'Clara', '0733367589', '0211112345', 'Caramitru.Clara@yahoo.com', 'Baiului, nr.7', 'Alba-Iulia', 'Alba', '234345'),
('Olaru', 'Alexandu', '0735473897', '0213528495', 'olaru.yo@gmail.com', 'Turnlui, nr.40', 'Bucuresti', 'Bucuresti', '123456'),
('Olaru', 'Alexandu', '0735473897', '0213528495', 'olaru.yo@gmail.com', 'Turnlui, nr.40', 'Bucuresti', 'Bucuresti', '123456'),
('Olaru', 'Alexandu', '0735473897', '0213528495', 'olaru.yo@gmail.com', 'Turnlui, nr.40', 'Bucuresti', 'Bucuresti', '123456'),
('Manolescu', 'Stefan', '0734256987', '0213467892', 'Manolescu.Stefan@yahoo.com', 'Teiului, nr.21', 'Timisoara', 'Timis', '383345'),
('Popa', 'Sandra', '0735473897', '0213528495', 'Sandra@yahoo.com', 'Castanului, nr.9', 'Bucuresti', 'Bucuresti', '123678'),
('Manolescu', 'Stefan', '0734256987', '0213467892', 'Manolescu.Stefan@yahoo.com', 'Teiului, nr.21', 'Timisoara', 'Timis', '383345'),
('popa', 'Marin', '012', '123', 'pop@gmail.com', 'das', 'auto', 'psfa', '1234'),
('Popa', 'Marin', '012', '012', 'test@mail.com', 'ad', 'oras', 'jud', '012'),
('Ionascu', 'Ionut', '021223', '07843', 'Ionascu@gmail.com', 'Bucuresti', 'Bucuresti', 'Bucuresti', '1234'),
('Ionascu', 'Ionut', '021223', '07843', 'Ionascu@gmail.com', 'Bucuresti', 'Bucuresti', 'Bucuresti', '1234'),
('Popaaaaaaaaaaa', 'Marin', '012', '012', 'test@mail.com', 'ad', 'oras', 'jud', '012'),
('Poo', 'Meed', '012', '012', 'un2@gmail.com', 'Bdr', 'Bucuresti', 'Ilfov', '123'),
('Popa', 'Ana', '254', '824', 'test2@gmail.com', 'Adresa', 'Oras2', 'Judet2', '123'),
('Poo', 'Meed', '012', '012', 'un2@gmail.com', 'Bdr', 'Bucuresti', 'Ilfov', '123'),
('Ionascu', 'Ionut', '021223', '07843', 'Ionascu@gmail.com', 'Bucuresti', 'Bucuresti', 'Bucuresti', '1234'),
('abc', '', '', '', '', '', '', '', ''),
('guci', '', '', '', '', '', '', '', ''),
('alexandra radu', '', '', '', '', '', '', '', ''),
('Dan', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE IF NOT EXISTS `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` int(11) DEFAULT '0',
  `cleaning_date` datetime DEFAULT NULL,
  `receipt_id` int(11) DEFAULT NULL,
  `service_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`id`, `status`, `cleaning_date`, `receipt_id`, `service_id`) VALUES
(4, 1, '2018-08-12 19:44:29', 10, 2),
(5, 1, '2018-08-12 20:12:36', 10, 3),
(6, 1, '2018-05-12 19:44:35', 10, 2),
(7, 1, '2018-05-12 19:31:17', 11, 1),
(8, 1, '2018-05-12 19:31:24', 11, 2),
(9, 1, '2018-05-13 00:00:38', 11, 3),
(10, 1, '2018-05-13 00:00:38', 11, 4),
(11, 1, '2018-05-13 00:00:38', 11, 5),
(12, 1, '2018-05-13 00:00:38', 11, 6),
(13, 1, '2018-05-13 00:00:38', 11, 7),
(14, 1, '2018-05-13 00:00:38', 11, 7),
(15, 1, '2018-05-12 19:31:28', 11, 1),
(16, 1, '2018-05-12 19:31:32', 11, 1),
(17, 1, '2018-05-13 12:43:46', 13, 6),
(18, 1, '2018-05-13 12:43:49', 13, 6),
(19, 1, '2018-05-13 12:43:53', 13, 6),
(20, 0, NULL, 14, 1),
(21, 0, NULL, 14, 2);

-- --------------------------------------------------------

--
-- Table structure for table `receipts`
--

CREATE TABLE IF NOT EXISTS `receipts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(255) DEFAULT NULL,
  `customer_email` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `receipts`
--

INSERT INTO `receipts` (`id`, `customer_name`, `customer_email`, `price`, `entry_date`, `return_date`) VALUES
(10, 'John Doe', 'johndoe@example.com', 60, '2018-05-09', '2018-05-12'),
(11, 'Mary Jane', 'maryjane@example.com', 430, '2018-05-09', '2018-05-13'),
(13, 'Jane Doe', 'janedoe@example.com', 90, '2018-05-13', '2018-05-13'),
(14, 'Jane Doe 2', 'janedoe@example.com', 35, '2018-05-13', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `services`
--

CREATE TABLE IF NOT EXISTS `services` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `services`
--

INSERT INTO `services` (`id`, `name`, `price`) VALUES
(1, 'T-Shirt', 15),
(2, 'Shirt', 20),
(3, 'Dress', 50),
(4, 'Boots', 150),
(5, 'Jewelry', 75),
(6, 'Trousers', 30),
(7, 'Pants', 45);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT '2',
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `users_email_uindex` (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `role`, `email`, `password`) VALUES
(1, 'admin', 1, 'admin@example.com', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14'),
(2, 'not admin', 2, 'notadmin@example.com', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14'),
(9, 'random', 1, 'random1@example.com', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14'),
(15, 'adminn', 1, 'adminas@example.com', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14'),
(20, 'asdf vrsev', 1, 'admin@example.coms', '54d5cb2d332dbdb4850293caae4559ce88b65163f1ea5d4e4b3ac49d772ded14');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
