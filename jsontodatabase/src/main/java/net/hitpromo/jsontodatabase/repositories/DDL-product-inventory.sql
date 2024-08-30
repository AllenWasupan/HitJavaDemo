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
  KEY `product_name` (`product_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.product: ~1 rows (approximately)
INSERT INTO `product` (`id`, `product_name`, `product_description`, `total_inventory`) VALUES
	(1, 'Z135', 'Rays baseball cap', 1855);
ANALYZE TABLE `product`;
-- Dumping structure for table product_inventory_assignment_rest.sku
DROP TABLE IF EXISTS `sku`;
CREATE TABLE IF NOT EXISTS `sku` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `sku` varchar(50) NOT NULL,
  `inventory` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_sku_product` (`product_id`),
  CONSTRAINT `FK_sku_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.sku: ~2 rows (approximately)
INSERT INTO `sku` (`id`, `product_id`, `sku`, `inventory`) VALUES
	(1, 1, 'Z135-28862', 1000),
	(2, 1, 'Z136-29055', 855);

-- Dumping structure for table product_inventory_assignment_rest.attribute
DROP TABLE IF EXISTS `attribute`;
CREATE TABLE IF NOT EXISTS `attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.attribute: ~7 rows (approximately)
INSERT INTO `attribute` (`id`, `value`) VALUES
  (1, 'Red'),
  (2, 'Blue'),
  (3, 'Green'),
  (4, 'XS'),
  (5, 'S'),
  (6, 'M'),
  (7, 'L');

-- Dumping structure for table product_inventory_assignment_rest.product_attribute
DROP TABLE IF EXISTS `product_attribute`;
CREATE TABLE IF NOT EXISTS `product_attribute` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `attribute_value_id` int(11) NOT NULL,
  `position` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_product_attribute_position` (`product_id`, `attribute_value_id`, `position`),
  KEY `FK_product_attribute_product` (`product_id`),
  KEY `FK_product_attribute_attribute_value` (`attribute_value_id`),
  CONSTRAINT `FK_product_attribute_product` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_product_attribute_attribute_value` FOREIGN KEY (`attribute_value_id`) REFERENCES `attribute` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table product_inventory_assignment_rest.product_attribute: ~4 rows (approximately)
INSERT INTO `product_attribute` (`id`, `product_id`, `attribute_value_id`, `position`) VALUES
  (1, 1, 1, 1), -- Product 1, Color Red, Position 1
  (2, 1, 2, 2), -- Product 1, Color Blue, Position 2
  (3, 1, 5, 1), -- Product 1, Size S, Position 1
  (4, 1, 7, 2); -- Product 1, Size L, Position 2
  
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
