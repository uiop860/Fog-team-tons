-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fog_db
-- ------------------------------------------------------
-- Server version	8.0.25-0ubuntu0.20.04.1

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
-- Table structure for table `carport_length`
--

DROP TABLE IF EXISTS `carport_length`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_length` (
  `carport_length_id` int NOT NULL AUTO_INCREMENT,
  `carport_length` int NOT NULL,
  PRIMARY KEY (`carport_length_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_length`
--

LOCK TABLES `carport_length` WRITE;
/*!40000 ALTER TABLE `carport_length` DISABLE KEYS */;
INSERT INTO `carport_length` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600),(14,630),(15,660),(16,690),(17,720),(18,750),(19,780);
/*!40000 ALTER TABLE `carport_length` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `carport_width`
--

DROP TABLE IF EXISTS `carport_width`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `carport_width` (
  `carport_width_id` int NOT NULL AUTO_INCREMENT,
  `carport_width` int NOT NULL,
  PRIMARY KEY (`carport_width_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carport_width`
--

LOCK TABLES `carport_width` WRITE;
/*!40000 ALTER TABLE `carport_width` DISABLE KEYS */;
INSERT INTO `carport_width` VALUES (1,240),(2,270),(3,300),(4,330),(5,360),(6,390),(7,420),(8,450),(9,480),(10,510),(11,540),(12,570),(13,600),(14,630),(15,660),(16,690),(17,720),(18,750);
/*!40000 ALTER TABLE `carport_width` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Træ'),(2,'Skruer'),(3,'Beslag'),(4,'Håndtag'),(5,'Tag');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `employee_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(90) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'test','test','employee'),(3,'admin','admin','employee');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `material` (
  `material_id` int NOT NULL AUTO_INCREMENT,
  `unit_id` int NOT NULL,
  `category_id` int NOT NULL,
  `material_name` varchar(90) NOT NULL,
  `description` varchar(90) NOT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`material_id`),
  KEY `fk_material_category1_idx` (`category_id`),
  KEY `fk_material_unit1_idx` (`unit_id`),
  CONSTRAINT `fk_material_category1` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `fk_material_unit1` FOREIGN KEY (`unit_id`) REFERENCES `unit` (`unit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
INSERT INTO `material` VALUES (1,1,1,'97x97 mm. trykimp. Stolpe','97x97 mm. trykimp. Stolpe',0.35),(2,1,1,'45x195 mm. spærtræ ubh.','Spær, monteres på rem',0.8495),(3,1,5,'Plastmo Ecolite blåtonet','Tagplader monteres på spær',0.4166),(4,1,1,'45x195 mm. spærtræ ubh.','Remme på langsiden, sadles ned i stolper',0.8495),(5,1,1,'45x195 mm. spærtræ ubh.','Remme på bredsiden, sadles ned i stolper',0.8495),(6,1,3,'Universal 190 mm beslag','Beslag til stolper/remme',18),(7,2,2,'4,0 x 50 mm. beslagskruer 250 stk.','Til montering af universalbeslag + hulbånd',50),(8,2,2,'Plastmo bundskruer 200 stk.','Skruer til tagplader',105),(9,1,3,'Firkantskiver 40x40x11mm','Til montering af rem på stolper',10),(10,2,2,'Bræddebolt 10x120 mm. 25 stk.','Til montering af rem på stolper',104);
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderlist`
--

DROP TABLE IF EXISTS `orderlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderlist` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `material_id` int NOT NULL,
  `amount` int NOT NULL,
  `total_material_price` double NOT NULL,
  KEY `fk_parts_material1_idx` (`material_id`),
  KEY `fk_orderlist_request1_idx` (`request_id`),
  CONSTRAINT `fk_orderlist_request1` FOREIGN KEY (`request_id`) REFERENCES `request` (`request_id`),
  CONSTRAINT `fk_parts_material1` FOREIGN KEY (`material_id`) REFERENCES `material` (`material_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderlist`
--

LOCK TABLES `orderlist` WRITE;
/*!40000 ALTER TABLE `orderlist` DISABLE KEYS */;
INSERT INTO `orderlist` VALUES (1,1,6,630),(1,2,12,4281.48),(1,4,2,968.43),(1,5,2,713.58),(1,7,1,50),(1,8,1,105),(1,10,1,104),(1,6,24,216),(1,9,6,60),(1,3,5,1187.31),(2,1,6,630),(2,2,10,6371.25),(2,4,2,764.55),(2,5,2,1274.25),(2,7,1,50),(2,8,1,105),(2,10,1,104),(2,6,20,180),(2,9,6,60),(2,3,8,1499.76),(3,1,6,630),(3,2,12,3669.84),(3,4,2,968.43),(3,5,2,611.64),(3,7,1,50),(3,8,1,105),(3,10,1,104),(3,6,24,216),(3,9,6,60),(3,3,4,949.85),(4,1,4,420),(4,2,7,2675.93),(4,4,2,560.67),(4,5,2,764.55),(4,7,1,50),(4,8,1,105),(4,10,1,104),(4,6,14,126),(4,9,4,40),(4,3,5,687.39),(5,1,4,420),(5,2,9,4128.57),(5,4,2,662.61),(5,5,2,917.46),(5,7,1,50),(5,8,1,105),(5,10,1,104),(5,6,18,162),(5,9,4,40),(5,3,6,974.84),(6,3,5,874.86),(6,9,4,40),(6,6,18,162),(6,5,2,713.58),(6,4,2,713.58),(6,2,9,3211.11),(6,1,4,420),(6,10,1,104),(6,8,1,105),(6,7,1,50);
/*!40000 ALTER TABLE `orderlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `request_id` int NOT NULL AUTO_INCREMENT,
  `phone` int NOT NULL,
  `name` varchar(90) NOT NULL,
  `email` varchar(90) NOT NULL,
  `road` varchar(90) NOT NULL,
  `housenumber` int NOT NULL,
  `city` varchar(90) NOT NULL,
  `zipcode` int NOT NULL,
  `carport_length_id` int NOT NULL,
  `carport_width_id` int NOT NULL,
  `employee_id` int DEFAULT NULL,
  `total_carport_price` double DEFAULT NULL,
  PRIMARY KEY (`request_id`),
  KEY `fk_user_carport_length1_idx` (`carport_length_id`),
  KEY `fk_user_carport_width1_idx` (`carport_width_id`),
  KEY `fk_request_employee1_idx` (`employee_id`),
  CONSTRAINT `fk_request_employee1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `fk_user_carport_length1` FOREIGN KEY (`carport_length_id`) REFERENCES `carport_length` (`carport_length_id`),
  CONSTRAINT `fk_user_carport_width1` FOREIGN KEY (`carport_width_id`) REFERENCES `carport_width` (`carport_width_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COMMENT=' ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES (1,45329102,'Niels Petersen','Niels@petersen.dk','Kongevejen',32,'Hørsholm',2970,12,7,1,8315.8),(2,74257923,'Anders Mortensen','AndersM@gmail.com','Banangade',24,'København N',2200,8,18,NULL,11038.81),(3,61473699,'Solvej Espersen','SolvejSolskin@sunny.dk','Gummiliste Vej',74,'Vedbæk',2950,12,5,NULL,7364.760000000001),(4,63791155,'Lars Hjortshøj','Lars@Hjortshoej.dk','Læssøesgade',14,'København N',2200,4,8,NULL,5533.54),(5,71639861,'Linse Kessler','Linsepigen@bryggen.com','Bryggen',33,'København V',2180,6,11,NULL,7564.48),(6,24378494,'Bob Mallory','Bob@hackerman.com','Eve Vej',123,'København N',2200,7,7,NULL,6394.13);
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unit`
--

LOCK TABLES `unit` WRITE;
/*!40000 ALTER TABLE `unit` DISABLE KEYS */;
INSERT INTO `unit` VALUES (1,'stk'),(2,'pakke'),(3,'rulle'),(4,'sæt');
/*!40000 ALTER TABLE `unit` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-27 15:15:51
