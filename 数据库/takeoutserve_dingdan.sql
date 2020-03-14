-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: takeoutserve
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `dingdan`
--

DROP TABLE IF EXISTS `dingdan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dingdan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_naem` varchar(45) COLLATE utf8_bin NOT NULL,
  `shangjia_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `caidan_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `tallprice` varchar(45) COLLATE utf8_bin NOT NULL,
  `user_address` varchar(45) COLLATE utf8_bin NOT NULL,
  `status` varchar(10) COLLATE utf8_bin NOT NULL DEFAULT '已配送',
  `dingdan_number` varchar(45) COLLATE utf8_bin NOT NULL,
  `user_phone` varchar(45) COLLATE utf8_bin NOT NULL,
  `shangjia_phone` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='订单信息';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dingdan`
--

LOCK TABLES `dingdan` WRITE;
/*!40000 ALTER TABLE `dingdan` DISABLE KEYS */;
INSERT INTO `dingdan` VALUES (1,'ypp','川菜美味','鱼香肉丝','13','重庆师范大学','已配送','154654654654','15213023541','17754925973'),(2,'ypp','川菜美味','盐煎肉','12','重庆师范大学','已配送','165419654655','15213023541','17754925973'),(3,'ypp','家乡味道','宫保鸡丁','13','重庆师范大学','已配送','103126312231','15213023541','17754925974'),(4,'zpg','家乡味道','水煮肉片','15','重庆师范大学','已配送','121564165416','15213023542','17754925973'),(5,'阳攀平','私房菜','盐煎肉','13','重庆师范大学清风苑4013','未配送','2020031201141215213023541','15213023541','17754925972'),(6,'阳攀平','私房菜','盐煎肉','13','重庆师范大学清风苑4013','未配送','2020031315523315213023541','15213023541','17754925972'),(7,'阳攀平','私房菜','盐煎肉','13','重庆师范大学清风苑4013','未配送','2020031321505815213023541','15213023541','17754925972'),(8,'阳攀平','私房菜','盐煎肉','13','重庆师范大学清风苑4013','未配送','2020031323565815213023541','15213023541','17754925972');
/*!40000 ALTER TABLE `dingdan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-14 15:38:12
