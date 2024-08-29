-- --------------------------------------------------------
-- Host:                         192.168.57.102
-- Server version:               10.1.48-MariaDB-0ubuntu0.18.04.1 - Ubuntu 18.04
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for product_inventory_assignment_rest
CREATE DATABASE IF NOT EXISTS `product_inventory_assignment_rest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `product_inventory_assignment_rest`;

-- Dumping structure for table product_inventory_assignment_rest.product
DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) NOT NULL,
  `product_description` varchar(255) NOT NULL,
  `total_inventory` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.product: ~1 rows (approximately)
INSERT INTO `product` (`id`, `product_name`, `product_description`, `total_inventory`) VALUES
	(1, 'Z135', 'Rays baseball cap', 1855);

-- Dumping structure for table product_inventory_assignment_rest.sku
DROP TABLE IF EXISTS `sku`;
CREATE TABLE IF NOT EXISTS `sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  -- New key
  `product_attribute_id` int(11) NOT NULL,
  `sku` varchar(50) NOT NULL,
  `inventory` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_sku_product` (`product_id`),
  -- key
  KEY `FK_sku_product_attribute_value` (`product_attribute_id`),
  CONSTRAINT `FK_sku_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  --New constraint
  CONSTRAINT `FK_sku_product_attribute` FOREIGN KEY (`product_attribute_id`) REFERENCES `product_attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.sku: ~2 rows (approximately)
INSERT INTO `sku` (`id`, `product_id`, `sku`, `inventory`) VALUES
	(1, 1, 1, 'Z135-28862', 1000),
	(2, 1, 2, 'Z136-29055', 855);

-- NEW TABLES
--
-- Dumping structure for table product_inventory_assignment_rest.attribute
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE IF NOT EXISTS `attribute` (
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.attribute: ~3 rows (approximately)
INSERT INTO `attribute` (`name`) VALUES ('Color'), ('Size');

-- Dumping structure for table product_inventory_assignment_rest.attribute_value
DROP TABLE IF EXISTS `attribute_value`;
CREATE TABLE IF NOT EXISTS `attribute_value` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attribute_id` int(11) NOT NULL,
  `value` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `attribute_value` (`attribute_id`, `value`),
  CONSTRAINT `FK_attribute_value_attribute` FOREIGN KEY (`attribute_id`) REFERENCES `attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.attribute_value: ~3 rows (approximately)
INSERT INTO `attribute_value` (`attribute_id`, `value`) VALUES 
('Color', 'White'), ('Color', 'Red'), ('Color', 'Blue'), ('Color', 'Green'),
('Size', 'S'), ('Size', 'M'), ('Size', 'XL'), ('Size', 'OSF');

-- Dumping structure for table product_inventory_assignment_rest.product_attribute
CREATE TABLE IF NOT EXISTS `product_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `attribute_name` varchar(50) NOT NULL,
  `attribute_value` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `product_attribute_value` (`product_id`, `attribute_name`, `attribute_value`),
  CONSTRAINT `FK_product_attribute_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_attribute_attribute_value` FOREIGN KEY (`attribute_name`, `attribute_value`) REFERENCES `attribute_value` (`attribute_name`, `value`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.product_attribute: ~3 rows (approximately)
INSERT INTO `product_attribute` (`product_id`, `attribute_name`, `attribute_value`) VALUES 
(1, 'Color', 'White'), -- White color
(1, 'Color', 'Blue'), -- Blue color
(1, 'Size', 'S'), -- Size S
(1, 'Size', 'M'); -- Size M

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
