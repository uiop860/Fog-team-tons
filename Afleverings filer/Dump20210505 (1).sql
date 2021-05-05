CREATE DATABASE  IF NOT EXISTS `fog_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `fog_db`;
-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fog_db
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carport`
--

DROP TABLE IF EXISTS `carport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport` (
  `material_id` int NOT NULL,
  `amount` int NOT NULL,
  `order_id` int NOT NULL,
  KEY `fk_carport_order1_idx` (`order_id`),
  KEY `fk_carport_materials1_idx` (`material_id`),
  CONSTRAINT `fk_carport_materials1` FOREIGN KEY (`material_id`) REFERENCES `materials` (`material_id`),
  CONSTRAINT `fk_carport_order1` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport`
--

LOCK TABLES `carport` WRITE;
/*!40000 ALTER TABLE `carport` DISABLE KEYS */;
/*!40000 ALTER TABLE `carport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `category_id` int NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Træ'),(2,'Skruer'),(3,'Beslag'),(4,'Håndtag');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materials`
--

DROP TABLE IF EXISTS `materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materials` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `material_name` varchar(90) NOT NULL,
  `length` double DEFAULT NULL,
  `description` varchar(105) NOT NULL,
  `unit_id` int NOT NULL,
  `price` double NOT NULL,
  `category_id` int NOT NULL,
  PRIMARY KEY (`material_id`),
  KEY `fk_materials_unit1_idx` (`unit_id`),
  KEY `fk_materials_category1_idx` (`category_id`),
  CONSTRAINT `fk_materials_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_materials_unit1` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materials`
--

LOCK TABLES `materials` WRITE;
/*!40000 ALTER TABLE `materials` DISABLE KEYS */;
INSERT INTO `materials` VALUES (1,'25x200 mm. trykimp. Brædt',360,'Understernbrædder til for & bag ende',2,234,1),(2,'25x200 mm. trykimp. Brædt',540,'understernbrædder til siderne',2,351,1),(3,'25x125mm. trykimp. Brædt',360,'oversternbrædder til forenden',2,54,1),(4,'25x125mm. trykimp. Brædt',540,'oversternbrædder til siderne',2,81,1),(5,'38x73 mm. Lægte ubh.',420,'til z på bagside af dør',2,71,1),(6,'45x95 mm. Reglar ub.',270,'k løsholter til skur gavle',2,94,1),(7,'45x95 mm. Reglar ub.',240,'løsholter til skur sider',2,84,1),(8,'45x195 mm. spærtræ ubh.',600,'Remme i sider, sadles ned i stolper',2,510,1),(9,'45x195 mm. spærtræ ubh.',480,'Remme i sider, sadles ned i stolper ( skur del, deles)',2,432,1),(10,'45x195 mm. spærtræ ubh.',600,'Spær, monteres på rem',2,510,1),(11,'97x97 mm. trykimp. Stolpe',300,'Stolper nedgraves 90 cm. i jord',2,105,1),(12,'19x100 mm. trykimp. Brædt',210,'til beklædning af skur 1 på 2',2,27,1),(13,'19x100 mm. trykimp. Brædt',540,'vandbrædt på stern i sider',2,70,1),(14,'19x100 mm. trykimp. Brædt',360,'vandbrædt på stern i forende',2,47,1),(15,'Plastmo Ecolite blåtonet',600,'tagplader monteres på spær',2,250,1),(16,'Plastmo Ecolite blåtonet',360,'tagplader monteres på spær',2,129,1),(17,'Plastmo bundskruer 200 stk.',NULL,'Skruer til tagplader',1,409,2),(18,'Hulbånd 1x20 mm mtr.',NULL,'Til vindkryds på spær',3,209,3),(19,'Universal 190 mm højre',NULL,'Til montering af spær på rem',2,20,3),(20,'Universal 190 mm venstre',NULL,'Til montering af spær på rem',2,20,3),(21,'4,5 x 60 mm. skruer 200 stk.',NULL,'Til montering af stern&vandbrædt',1,77.5,2),(22,'4,0 x 50 mm. beslagskruer 250 stk.',NULL,'Til montering af universalbeslag + hulbånd',1,50,2),(23,'Bræddebolt 10x120 mm. 25 stk.',NULL,'Til montering af rem på stolper',1,279,2),(24,'Firkantskiver 40x40x11mm',NULL,'Til montering af rem på stolper',2,10.11,3),(25,'4,5 x 70 mm. Skruer 400 stk.',NULL,'Til montering af yderste beklædning',1,438,2),(26,'4,5 x 50 mm. Skruer 300 stk.',NULL,'Til montering af inderste beklædning',1,328.5,2),(27,'Stalddørsgreb 50x75',NULL,'Til lås på dør i skur',4,189,4),(28,'T hængsel 390 mm',NULL,'Til skurdør',2,79.95,3),(29,'Vinkelbeslag 35',NULL,'Til montering af løsholter i skur',2,4.95,3);
/*!40000 ALTER TABLE `materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `price` double NOT NULL,
  `carport_id` int NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id_UNIQUE` (`order_id`),
  KEY `fk_order_user1_idx` (`user_id`),
  CONSTRAINT `fk_order_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unit`
--

DROP TABLE IF EXISTS `unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unit` (
  `unit_id` int NOT NULL AUTO_INCREMENT,
  `unit_name` varchar(10) NOT NULL,
  PRIMARY KEY (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'Pakke'),(2,'Stk'),(3,'Rulle'),(4,'Sæt');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(90) NOT NULL,
  `role` varchar(15) NOT NULL DEFAULT 'customer',
  `road` varchar(90) NOT NULL,
  `housenumber` int NOT NULL,
  `city` varchar(45) NOT NULL,
  `zipcode` int NOT NULL,
  `country` varchar(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-05 11:45:52
