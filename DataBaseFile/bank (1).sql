-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 24, 2021 at 06:08 PM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `allaccount`
--

CREATE TABLE `allaccount` (
  `AccNo` bigint(20) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `FatherName` varchar(30) NOT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `Merital_status` varchar(30) DEFAULT NULL,
  `TypeOfAcc` varchar(40) NOT NULL,
  `DoB` varchar(80) DEFAULT NULL,
  `ServicRequired` varchar(50) DEFAULT NULL,
  `Amount` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `allaccount`
--

INSERT INTO `allaccount` (`AccNo`, `Name`, `FatherName`, `Gender`, `Merital_status`, `TypeOfAcc`, `DoB`, `ServicRequired`, `Amount`) VALUES
(1442, 'swati', 'Lakhan singh', 'Female', 'Married', 'Current Account', '1991-05-20', 'Mobile Banking', 24320),
(1639, 'mohini', 'Man Shing', 'Female', 'Single', 'Current Account', '1956-08-08', 'Net Banking', 6399),
(1689, 'manish singh', 'Narender singh', 'Female', 'Married', 'Saving', '1991-03-11', 'Cheque Book', 54100),
(2694, 'yashika', 'manish', 'Female', 'Single', 'Saving', '2004-08-06', 'Net Banking', 15200),
(4139, 'yashika singh', 'Manish singh naruka', 'Female', 'Single', 'Saving', '2016-08-13', 'Mobile Banking', 3000),
(8325, 'sejal singh naruka', 'manish singh', 'Female', 'Single', 'Saving', '2018-12-18', 'Net Banking', 30000),
(8444, 'savita', 'lakhan', 'Male', 'Single', 'Current Account', '1940-01-01', 'Net Banking', 1600),
(8504, 'kirty', 'lakhan', 'Female', 'Married', 'Current Account', '1944-07-28', 'Net Banking', 6000);

-- --------------------------------------------------------

--
-- Table structure for table `cashdeposit`
--

CREATE TABLE `cashdeposit` (
  `depositId` int(11) NOT NULL,
  `balance` int(11) DEFAULT NULL,
  `depositDate` varchar(70) DEFAULT NULL,
  `AccNo` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashdeposit`
--

INSERT INTO `cashdeposit` (`depositId`, `balance`, `depositDate`, `AccNo`) VALUES
(1, 10, '2021-07-22', 4139),
(2, 500, '2021-07-22', 4139),
(3, 2000, '2021-07-23', 1442),
(4, 500, '2021-07-23', 8444),
(5, 300, '2021-07-23', 8444);

-- --------------------------------------------------------

--
-- Table structure for table `cashwithdraw`
--

CREATE TABLE `cashwithdraw` (
  `withdrawID` int(11) NOT NULL,
  `balance` int(11) DEFAULT NULL,
  `withdrawDate` varchar(60) DEFAULT NULL,
  `AccNo` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cashwithdraw`
--

INSERT INTO `cashwithdraw` (`withdrawID`, `balance`, `withdrawDate`, `AccNo`) VALUES
(1, 10, '2021-07-22', 4139),
(2, 100, '2021-07-22', 4139),
(3, 5000, '2021-07-23', 1442),
(4, 200, '2021-07-23', 8444);

-- --------------------------------------------------------

--
-- Stand-in structure for view `finalestatement`
-- (See below for the actual view)
--
CREATE TABLE `finalestatement` (
`AccNO` bigint(20)
,`name` varchar(30)
,`totalAmount` float
,`DepositDate` varchar(70)
,`DepositBalance` int(11)
,`WithdrawDate` varchar(60)
,`WithdrawBalance` int(11)
);

-- --------------------------------------------------------

--
-- Table structure for table `transction`
--

CREATE TABLE `transction` (
  `AccNo` bigint(20) DEFAULT NULL,
  `transctionDate` varchar(90) DEFAULT NULL,
  `transctionId` int(11) NOT NULL,
  `depositAmount` bigint(20) DEFAULT NULL,
  `withdrawAmount` bigint(20) DEFAULT NULL,
  `Balance` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transction`
--

INSERT INTO `transction` (`AccNo`, `transctionDate`, `transctionId`, `depositAmount`, `withdrawAmount`, `Balance`) VALUES
(1442, '2021-07-23', 12, 50, 0, 50250),
(1442, '2021-07-23', 13, 0, 20, 50230),
(8325, '2021-07-23', 19, 300, 0, 23300),
(8325, '2021-07-23', 20, 500, 0, 23500),
(8325, '2021-07-23', 21, 5000, 0, 28000),
(8325, '2021-07-23', 22, 5000, 0, 33000),
(8325, '2021-07-23', 25, 0, 3000, 30000),
(1442, '2021-07-23', 26, 51, 0, 50281),
(1442, '2021-07-26', 27, 0, 23, 50258),
(1442, '2021-07-27', 28, 0, 50258, 0),
(1442, '2021-07-27', 29, 23900, 0, 23900),
(1442, '2021-07-31', 30, 100, 0, 24000),
(1442, '2021-07-31', 31, 100, 0, 24100),
(1442, '2021-07-31', 32, 100, 0, 24200),
(1442, '2021-07-31', 33, 0, 20, 24180),
(1442, '2021-07-31', 34, 0, 20, 24160),
(1639, '2021-08-01', 35, 5399, 0, 6399),
(1442, '2021-08-03', 36, 160, 0, 24320);

-- --------------------------------------------------------

--
-- Structure for view `finalestatement`
--
DROP TABLE IF EXISTS `finalestatement`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `finalestatement`  AS SELECT `allaccount`.`AccNo` AS `AccNO`, `allaccount`.`Name` AS `name`, `allaccount`.`Amount` AS `totalAmount`, `cashdeposit`.`depositDate` AS `DepositDate`, `cashdeposit`.`balance` AS `DepositBalance`, `cashwithdraw`.`withdrawDate` AS `WithdrawDate`, `cashwithdraw`.`balance` AS `WithdrawBalance` FROM ((`allaccount` left join `cashdeposit` on(`allaccount`.`AccNo` = `cashdeposit`.`AccNo`)) left join `cashwithdraw` on(`allaccount`.`AccNo` = `cashwithdraw`.`AccNo`)) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allaccount`
--
ALTER TABLE `allaccount`
  ADD PRIMARY KEY (`AccNo`);

--
-- Indexes for table `cashdeposit`
--
ALTER TABLE `cashdeposit`
  ADD PRIMARY KEY (`depositId`),
  ADD KEY `AccNo` (`AccNo`);

--
-- Indexes for table `cashwithdraw`
--
ALTER TABLE `cashwithdraw`
  ADD PRIMARY KEY (`withdrawID`),
  ADD KEY `AccNo` (`AccNo`);

--
-- Indexes for table `transction`
--
ALTER TABLE `transction`
  ADD PRIMARY KEY (`transctionId`),
  ADD KEY `AccNo` (`AccNo`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashdeposit`
--
ALTER TABLE `cashdeposit`
  MODIFY `depositId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cashwithdraw`
--
ALTER TABLE `cashwithdraw`
  MODIFY `withdrawID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transction`
--
ALTER TABLE `transction`
  MODIFY `transctionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cashdeposit`
--
ALTER TABLE `cashdeposit`
  ADD CONSTRAINT `cashdeposit_ibfk_1` FOREIGN KEY (`AccNo`) REFERENCES `allaccount` (`AccNo`);

--
-- Constraints for table `cashwithdraw`
--
ALTER TABLE `cashwithdraw`
  ADD CONSTRAINT `cashwithdraw_ibfk_1` FOREIGN KEY (`AccNo`) REFERENCES `allaccount` (`AccNo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transction`
--
ALTER TABLE `transction`
  ADD CONSTRAINT `transction_ibfk_1` FOREIGN KEY (`AccNo`) REFERENCES `allaccount` (`AccNo`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
