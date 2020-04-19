-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jasaq_db
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `services_mitra`
--

DROP TABLE IF EXISTS `services_mitra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `services_mitra` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `logo` longtext,
  `services_name` varchar(255) DEFAULT NULL,
  `services_mitra` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8pinl9a064hctackeit83dbpr` (`services_mitra`),
  CONSTRAINT `FK8pinl9a064hctackeit83dbpr` FOREIGN KEY (`services_mitra`) REFERENCES `type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `services_mitra`
--

LOCK TABLES `services_mitra` WRITE;
/*!40000 ALTER TABLE `services_mitra` DISABLE KEYS */;
INSERT INTO `services_mitra` VALUES (1,'logo motor','Motor',2),(2,'logo mobil','Mobil',2),(3,'logo komputer','AC',1),(4,'logo computer','Computer',1),(5,'logo CCTV','CCTV',1),(6,'logo Kulkas','Kulkas',1),(7,'logo TV','TV',1),(8,'logo mesin cuci','Mesin Cuci',1),(9,'logo handphon','Handphone',1),(10,'logo printer','Printer',1),(11,'logo sepeda','Sepeda',2),(12,'logo skuter','Skuter',2),(13,'logo kompor','Kompor',3),(14,'logo genset','Genset',3),(15,'logo pompa air','Pompa Air',3),(16,'logo tukang','Tukang',3),(17,'logo Kunci','Kunci',3),(18,'logo Sofa','Sofa',3),(19,'logo Sepatu','Sepatu',3);
/*!40000 ALTER TABLE `services_mitra` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-04-19 20:35:08
