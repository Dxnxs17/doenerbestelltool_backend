-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 25. Jul 2024 um 22:02
-- Server-Version: 10.4.27-MariaDB
-- PHP-Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `doenerbestelltool`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `configuration`
--

CREATE TABLE `configuration` (
  `CoID` int(11) NOT NULL,
  `Product` int(11) NOT NULL,
  `Price` varchar(6) NOT NULL,
  `Sauce1` int(11) DEFAULT NULL,
  `Sauce2` int(11) DEFAULT NULL,
  `Meat` int(11) DEFAULT NULL,
  `Special Instruction` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `configuration`
--

INSERT INTO `configuration` (`CoID`, `Product`, `Price`, `Sauce1`, `Sauce2`, `Meat`, `Special Instruction`) VALUES
(1, 15, '5.5', 1, NULL, 2, '/'),
(2, 1, '6.8', 2, NULL, 1, '/'),
(3, 2, '7.5', 2, NULL, 1, '/'),
(4, 5, '4.5', NULL, NULL, NULL, 'Ketchup'),
(5, 1, '6.8', 2, NULL, 1, '/'),
(6, 4, '7.5', NULL, NULL, NULL, 'Keine Extras'),
(7, 5, '4.5', NULL, NULL, NULL, 'Keine Extras'),
(8, 15, '5.5', 2, NULL, 1, '/'),
(9, 1, '6.8', NULL, NULL, 1, '/'),
(10, 15, '5.5', NULL, NULL, 1, '/'),
(11, 3, '8', NULL, NULL, NULL, 'scharf'),
(12, 1, '6.8', 2, 6, 2, '/'),
(13, 15, '5.5', 2, 6, 2, '/'),
(14, 2, '7.5', 2, NULL, 1, '/'),
(15, 5, '4.5', NULL, NULL, NULL, 'scharf');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `configwish`
--

CREATE TABLE `configwish` (
  `CoID` int(11) NOT NULL,
  `SWID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `configwish`
--

INSERT INTO `configwish` (`CoID`, `SWID`) VALUES
(1, 7),
(1, 6),
(2, 5),
(3, 5),
(5, 5),
(8, 2),
(8, 3),
(12, 8),
(13, 4),
(14, 5);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customer`
--

CREATE TABLE `customer` (
  `CuID` int(11) NOT NULL,
  `Forename` varchar(50) NOT NULL,
  `Surename` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `customer`
--

INSERT INTO `customer` (`CuID`, `Forename`, `Surename`) VALUES
(1, 'Roland', 'Mayer'),
(2, 'Denis', 'Shekerov'),
(3, 'Noah', 'Weißenbach');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `meat`
--

CREATE TABLE `meat` (
  `MID` int(11) NOT NULL,
  `Meat` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `meat`
--

INSERT INTO `meat` (`MID`, `Meat`) VALUES
(1, 'Kalb'),
(2, 'Pute');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `orders`
--

CREATE TABLE `orders` (
  `orderid` int(11) NOT NULL,
  `customerid` int(11) NOT NULL,
  `configurationid` int(11) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `orders`
--

INSERT INTO `orders` (`orderid`, `customerid`, `configurationid`, `date`) VALUES
(1, 1, 1, '2024-03-22'),
(2, 2, 2, '2024-04-15'),
(3, 2, 3, '2024-04-15'),
(4, 2, 4, '2024-04-15'),
(5, 2, 5, '2024-04-15'),
(6, 2, 6, '2024-04-15'),
(7, 2, 7, '2024-04-15'),
(8, 2, 8, '2024-04-15'),
(9, 2, 9, '2024-04-15'),
(10, 2, 10, '2024-04-15'),
(11, 3, 11, '2024-04-18'),
(12, 3, 12, '2024-04-18'),
(13, 3, 13, '2024-04-18'),
(14, 3, 14, '2024-04-18'),
(15, 3, 15, '2024-04-18');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `product`
--

CREATE TABLE `product` (
  `PID` int(11) NOT NULL,
  `Product` varchar(50) NOT NULL,
  `Basic Price` varchar(6) NOT NULL,
  `Size 1=Big/0=Small` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `product`
--

INSERT INTO `product` (`PID`, `Product`, `Basic Price`, `Size 1=Big/0=Small`) VALUES
(1, 'Döner', '6.80', b'1'),
(2, 'Roll Döner', '7.50', b'1'),
(3, 'dönerbox', '8.00', b'0'),
(4, 'Pide', '7.50', b'0'),
(5, 'Pommes', '4.50', b'0'),
(6, 'Lahmacun Salat', '6.00', b'0'),
(7, 'Lahmacun Fleisch', '8.00', b'0'),
(8, 'Baklava', '5.00', b'0'),
(9, 'Cola', '1.75', b'0'),
(10, 'Cola Light', '1.75', b'0'),
(11, 'Cola Zero', '1.75', b'0'),
(12, 'Fanta', '1.75', b'0'),
(13, 'Uludag', '1.75', b'0'),
(14, 'Ayran', '1.50', b'0'),
(15, 'Döner', '5.50', b'0');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `sauce`
--

CREATE TABLE `sauce` (
  `SID` int(11) NOT NULL,
  `Sauce` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `sauce`
--

INSERT INTO `sauce` (`SID`, `Sauce`) VALUES
(1, 'ohne Sauce'),
(2, 'Joghurtsauce'),
(3, 'Knoblauch-Joghurtsauce'),
(4, 'Chili-Cocktail Sauce'),
(5, 'Curry-Mango Sauce'),
(6, 'Spicy Mayonnaise Sauce'),
(7, 'Mississippi Potatoes Sauce');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `special wishes`
--

CREATE TABLE `special wishes` (
  `SWID` int(11) NOT NULL,
  `Wish` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `special wishes`
--

INSERT INTO `special wishes` (`SWID`, `Wish`) VALUES
(1, 'ohne Eisbergsalat'),
(2, 'ohne Rotkohl'),
(3, 'ohne Weißkraut'),
(4, 'ohne Peperoni'),
(5, 'ohne Tomaten'),
(6, 'ohne Zwiebeln'),
(7, 'nicht verbrannt'),
(8, 'Scharf');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `configuration`
--
ALTER TABLE `configuration`
  ADD PRIMARY KEY (`CoID`),
  ADD KEY `configuration_sauce1_FK` (`Sauce1`),
  ADD KEY `configuration_sauce2_FK` (`Sauce2`),
  ADD KEY `configuration_product_FK` (`Product`),
  ADD KEY `configuration_meat_FK` (`Meat`);

--
-- Indizes für die Tabelle `configwish`
--
ALTER TABLE `configwish`
  ADD KEY `configwish_configuration_FK` (`CoID`),
  ADD KEY `configwish_specialWishes_FK` (`SWID`);

--
-- Indizes für die Tabelle `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`CuID`);

--
-- Indizes für die Tabelle `meat`
--
ALTER TABLE `meat`
  ADD PRIMARY KEY (`MID`,`Meat`);

--
-- Indizes für die Tabelle `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderid`),
  ADD KEY `orders_customer_FK` (`customerid`),
  ADD KEY `orders_configuration_FK` (`configurationid`);

--
-- Indizes für die Tabelle `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`PID`,`Product`,`Basic Price`,`Size 1=Big/0=Small`);

--
-- Indizes für die Tabelle `sauce`
--
ALTER TABLE `sauce`
  ADD PRIMARY KEY (`SID`);

--
-- Indizes für die Tabelle `special wishes`
--
ALTER TABLE `special wishes`
  ADD PRIMARY KEY (`SWID`,`Wish`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `configuration`
--
ALTER TABLE `configuration`
  MODIFY `CoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT für Tabelle `customer`
--
ALTER TABLE `customer`
  MODIFY `CuID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT für Tabelle `meat`
--
ALTER TABLE `meat`
  MODIFY `MID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT für Tabelle `orders`
--
ALTER TABLE `orders`
  MODIFY `orderid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT für Tabelle `product`
--
ALTER TABLE `product`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT für Tabelle `sauce`
--
ALTER TABLE `sauce`
  MODIFY `SID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT für Tabelle `special wishes`
--
ALTER TABLE `special wishes`
  MODIFY `SWID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `configuration`
--
ALTER TABLE `configuration`
  ADD CONSTRAINT `configuration_meat_FK` FOREIGN KEY (`Meat`) REFERENCES `meat` (`MID`),
  ADD CONSTRAINT `configuration_product_FK` FOREIGN KEY (`Product`) REFERENCES `product` (`PID`),
  ADD CONSTRAINT `configuration_sauce1_FK` FOREIGN KEY (`Sauce1`) REFERENCES `sauce` (`SID`),
  ADD CONSTRAINT `configuration_sauce2_FK` FOREIGN KEY (`Sauce2`) REFERENCES `sauce` (`SID`);

--
-- Constraints der Tabelle `configwish`
--
ALTER TABLE `configwish`
  ADD CONSTRAINT `configwish_configuration_FK` FOREIGN KEY (`CoID`) REFERENCES `configuration` (`CoID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `configwish_specialWishes_FK` FOREIGN KEY (`SWID`) REFERENCES `special wishes` (`SWID`) ON DELETE NO ACTION;

--
-- Constraints der Tabelle `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_configuration_FK` FOREIGN KEY (`configurationid`) REFERENCES `configuration` (`CoID`),
  ADD CONSTRAINT `orders_customer_FK` FOREIGN KEY (`customerid`) REFERENCES `customer` (`CuID`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
