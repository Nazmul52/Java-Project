-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: productdb
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `ProductCatagory` varchar(1000) DEFAULT NULL,
  `status` varchar(100) DEFAULT NULL,
  `BrandName` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (102,'Dell E171S 17 Inch square Monitor',6200,'Monitor','Available','Dell'),(103,'Dell E201HV 19.5 Inch LED Monitor',8500,'Monitor','Available','Dell'),(104,'HP V196 18.5 Inch Backlit Monitor',6100,'Monitor','Available','HP'),(105,'HP 20VX 20 Inch Boardless Monitor',6100,'Monitor','Available','HP'),(201,'Asus GT73-FML-2GB-DDR-5',6200,'Graphics Card','Available','Asus'),(202,'Asus PH-GTX10-2GB-DDR-5',12700,'Graphics Card','Available','Asus'),(203,'GIGABYTE GTX210 1Gb DDR3',3100,'Graphics Card','Available','GIGABYTE'),(204,'GIGABYTE GTX710 2Gb DDR3',3700,'Graphics Card','Available','GIGABYTE'),(301,'MSI H11 VH Plus',5600,'Motherboard','Available','MSI'),(302,'MSI H8-P33 Chipset',4400,'Motherboard','Available','MSI'),(303,'Esonic G12 DDR2',2400,'Motherboard','Available','Esonic'),(304,'Esonic G41 DDR3',2900,'Motherboard','Not Available','Esonic'),(401,'AMD FX Phildriver',17500,'Processor','Available','AMD'),(402,'AMD RYZEN Turbo',34500,'Processor','Not Available','AMD'),(403,'Intel 4th Generation G3250',4500,'Processor','Available','Intel'),(404,'Intel 6th Generation G4400',4800,'Processor','Available','Intel'),(501,'Antech VP192 82% Efficiency',3700,'Power Supply','Available','Antech'),(502,'Antech 550GB Bronze 550 Watt',5000,'Power Supply','Available','Antech'),(503,'Cooler Master RS550 550 Watt',8700,'Power Supply','Available','Cooler Master'),(601,'Adata 4GB DDR3',2300,'Ram','Available','Adata'),(602,'Adata 8GB DDR3',4800,'Ram','Available','Adata'),(603,'Adata 8GB DDR4',3200,'Ram','Not Available','Adata'),(604,'Twinmos 2GB DDR3',1200,'Ram','Available','Twinmos'),(605,'Twinmos 4GB DDR3',1900,'Ram','Available','Twinmos'),(606,'Transcend 2GB DDR3',1300,'Ram','Available','Transcend'),(607,'Transcend 4GB DDR3',1850,'Ram','Available','Transcend');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-07 23:18:01
