-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 07, 2021 at 12:59 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mamakasting`
--

-- --------------------------------------------------------

--
-- Table structure for table `glumci`
--

CREATE TABLE `glumci` (
  `glumacID` int(11) NOT NULL,
  `imePrezime` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `pol` varchar(100) NOT NULL,
  `visina` int(11) NOT NULL,
  `tezina` int(11) NOT NULL,
  `bojaOciju` varchar(100) NOT NULL,
  `rezervisan` varchar(100) NOT NULL DEFAULT 'ne'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `glumci`
--

INSERT INTO `glumci` (`glumacID`, `imePrezime`, `username`, `password`, `pol`, `visina`, `tezina`, `bojaOciju`, `rezervisan`) VALUES
(1, '', '', '', '', 0, 0, '', 'ne'),
(3, 'Aki Raznatovic', 'aki', 'aki', 'musko', 180, 70, 'Aki Raznatovic', 'ne'),
(4, 'Anica Raznatovic', 'anci', 'anci', 'zenski', 175, 60, 'Anica Raznatovic', 'ne'),
(6, 'Marko Markovic', 'marko', 'marko', 'muski', 190, 80, 'Marko Markovic', 'ne'),
(7, 'Mina Raznatovic', 'mina', 'mina', 'zenski', 180, 60, 'zelena', 'ne'),
(8, 'Moje Prezime', 'test', 'test', 'muski', 200, 100, 'plava', 'ne');

-- --------------------------------------------------------

--
-- Table structure for table `produkcije`
--

CREATE TABLE `produkcije` (
  `produkcijaID` int(11) NOT NULL,
  `imeProdukcije` varchar(100) NOT NULL,
  `korisnickoIme` varchar(100) NOT NULL,
  `lozinka` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `produkcije`
--

INSERT INTO `produkcije` (`produkcijaID`, `imeProdukcije`, `korisnickoIme`, `lozinka`) VALUES
(1, 'Glavna', 'test', 'test'),
(3, 'Zezanje', 'test1', 'test1');

-- --------------------------------------------------------

--
-- Table structure for table `projekat`
--

CREATE TABLE `projekat` (
  `projekatID` int(11) NOT NULL,
  `imeProjekta` varchar(100) NOT NULL,
  `glavniMuski` int(11) NOT NULL,
  `glavniZenski` int(11) NOT NULL,
  `sporedna1` int(11) NOT NULL,
  `sporedna2` int(11) NOT NULL,
  `sporedna3` int(11) NOT NULL,
  `produkcijaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projekat`
--

INSERT INTO `projekat` (`projekatID`, `imeProjekta`, `glavniMuski`, `glavniZenski`, `sporedna1`, `sporedna2`, `sporedna3`, `produkcijaID`) VALUES
(3, 'Ime', 2, 3, 4, 5, 6, 1),
(4, 'Novi', 3, 4, 1, 1, 6, 1),
(5, 'Najnoviji', 2, 1, 1, 5, 7, 1),
(6, 'sda', 3, 1, 1, 1, 1, 1),
(8, 'NNK2', 4, 2, 1, 1, 1, 2),
(9, 'Ludilo', 3, 6, 1, 7, 1, 1),
(10, 'Cudo', 6, 1, 1, 7, 1, 3),
(13, 'Najnob', 7, 1, 8, 3, 4, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `glumci`
--
ALTER TABLE `glumci`
  ADD PRIMARY KEY (`glumacID`);

--
-- Indexes for table `produkcije`
--
ALTER TABLE `produkcije`
  ADD PRIMARY KEY (`produkcijaID`);

--
-- Indexes for table `projekat`
--
ALTER TABLE `projekat`
  ADD PRIMARY KEY (`projekatID`),
  ADD KEY `projekat_ibfk_1` (`glavniMuski`),
  ADD KEY `projekat_ibfk_2` (`glavniZenski`),
  ADD KEY `projekat_ibfk_3` (`sporedna1`),
  ADD KEY `projekat_ibfk_4` (`sporedna2`),
  ADD KEY `projekat_ibfk_5` (`sporedna3`),
  ADD KEY `projekat_ibfk_6` (`produkcijaID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `glumci`
--
ALTER TABLE `glumci`
  MODIFY `glumacID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `produkcije`
--
ALTER TABLE `produkcije`
  MODIFY `produkcijaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `projekat`
--
ALTER TABLE `projekat`
  MODIFY `projekatID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
