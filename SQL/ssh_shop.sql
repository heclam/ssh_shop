-- MySQL dump 10.13  Distrib 5.7.26, for Win64 (x86_64)
--
-- Host: localhost    Database: ssh_shop
-- ------------------------------------------------------
-- Server version	5.7.26-log

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
-- Table structure for table `adminuser`
--

DROP TABLE IF EXISTS `adminuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adminuser` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminuser`
--

LOCK TABLES `adminuser` WRITE;
/*!40000 ALTER TABLE `adminuser` DISABLE KEYS */;
INSERT INTO `adminuser` VALUES (1,'admin','admin');
/*!40000 ALTER TABLE `adminuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'男表'),(2,'女表'),(4,'情侣手表');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorysecond`
--

DROP TABLE IF EXISTS `categorysecond`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorysecond` (
  `csid` int(11) NOT NULL AUTO_INCREMENT,
  `csname` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`csid`),
  KEY `FK40abjjlcyixl0taokqus2tltk` (`cid`),
  CONSTRAINT `FK40abjjlcyixl0taokqus2tltk` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`),
  CONSTRAINT `fk_ccid` FOREIGN KEY (`cid`) REFERENCES `category` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorysecond`
--

LOCK TABLES `categorysecond` WRITE;
/*!40000 ALTER TABLE `categorysecond` DISABLE KEYS */;
INSERT INTO `categorysecond` VALUES (2,'石英表',2),(4,'劳力士',2),(5,'标准版',2),(19,'智能手表',1);
/*!40000 ALTER TABLE `categorysecond` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderitem`
--

DROP TABLE IF EXISTS `orderitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderitem` (
  `itemid` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `oid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`itemid`),
  KEY `oid` (`oid`),
  KEY `FKda3ea7fmstveqyd16txynbgo8` (`pid`),
  KEY `FK6d8bi8fo2c3wp6knm86u9n3s7` (`uid`),
  CONSTRAINT `FK6d8bi8fo2c3wp6knm86u9n3s7` FOREIGN KEY (`uid`) REFERENCES `orders` (`oid`),
  CONSTRAINT `FKda3ea7fmstveqyd16txynbgo8` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`pid`),
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderitem`
--

LOCK TABLES `orderitem` WRITE;
/*!40000 ALTER TABLE `orderitem` DISABLE KEYS */;
INSERT INTO `orderitem` VALUES (74,1,123,10,4004,44),(75,1,123,12,4004,44),(76,1,123,11,4005,45),(77,1,123,8,4005,45),(78,1,123,9,4006,46),(79,1,123,5,4007,47),(80,1,12,2,4008,48),(81,1,12312,3,4009,49),(82,1,234,17,4010,50),(83,1,120,31,4011,4011),(84,1,123,32,4011,4011),(85,1,12312,3,4012,4012),(86,1,7787,1,4013,4013),(87,1,23,18,4014,4014),(88,1,123,32,4015,4015),(89,1,123,12,4016,4016),(90,2,246,5,4016,4016);
/*!40000 ALTER TABLE `orderitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(21) DEFAULT NULL,
  `addr` varchar(60) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `uid` (`uid`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=4017 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (4004,246,'2019-01-09 15:17:10',1,NULL,NULL,NULL,7),(4005,246,'2019-01-09 15:17:35',1,NULL,NULL,NULL,7),(4006,123,'2019-01-09 15:17:43',1,NULL,NULL,NULL,7),(4007,123,'2019-01-09 15:17:50',1,NULL,NULL,NULL,7),(4008,12,'2019-01-09 15:17:57',1,NULL,NULL,NULL,7),(4009,12312,'2019-01-09 15:18:06',4,'luoluo','官洲','34567',7),(4010,234,'2019-01-09 15:19:02',4,'sdf','广东省','1231324',7),(4011,243,'2019-01-29 23:49:10',1,'sdf','广东省','1231324',7),(4012,12312,'2019-01-29 23:50:41',1,NULL,NULL,NULL,7),(4013,7787,'2019-01-30 11:58:01',1,NULL,NULL,NULL,7),(4014,23,'2019-01-30 11:58:16',2,NULL,NULL,NULL,7),(4015,123,'2019-01-30 11:58:23',3,'sdf','广东省','1231324',7),(4016,369,'2019-02-28 21:12:21',1,NULL,NULL,NULL,7);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `market_price` double DEFAULT NULL,
  `shop_price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `is_host` int(11) DEFAULT NULL,
  `pdate` datetime DEFAULT NULL,
  `csid` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK97ljqk2sr3a0qb0nb431xhoig` (`csid`),
  CONSTRAINT `FK97ljqk2sr3a0qb0nb431xhoig` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`),
  CONSTRAINT `fk_pcsid` FOREIGN KEY (`csid`) REFERENCES `categorysecond` (`csid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'amaz',9999,7787,'images/img1.jpg',123,'fgsdfsdffsdf',1,'2018-10-01 22:18:36',4),(2,'wer',123,12,'images/img2.jpg',234,'gdfhhgs',1,'2018-12-31 22:19:26',5),(3,'hghfgh',123123,12312,'images/img3.jpg',123,'fgdfyjuykykuy',1,'2018-10-02 22:19:59',5),(4,'inosinof',8907,7887,'images/img4.jpg',789,'lksdfldsflkn',1,'2018-09-25 22:20:25',5),(5,'bdfdsfmndsfin',123,123,'images/img5.jpg',123,'34',1,'2018-12-31 22:20:51',2),(6,'sdf',123,234,'images/img6.jpg',234,'qsdfadd',0,'2019-01-14 22:21:36',2),(7,'dsf',123,234,'images/img7.jpg',234,'cbvc',0,'2019-01-23 22:21:40',2),(8,'cfv',12,123,'images/img8.jpg',234,'cvb',1,'2019-01-25 22:21:42',2),(9,'vsef',12,123,'images/img9.jpg',234,'vbvbcvb',1,'2019-01-13 22:21:45',2),(10,'werwer',323,123,'images/img10.jpg',234,'cvbcvbcv',1,'2019-01-29 22:21:47',2),(11,'werfg',34,123,'images/img11.jpg',234,'cvbcvbcsdfe',1,'2019-01-27 22:21:49',2),(12,'kuk',345,123,'images/img12.jpg',234,'efwef',1,'2019-01-29 22:21:52',2),(13,'jy',34,123,'images/img13.jpg',234,'we',1,'2019-01-29 00:19:14',2),(14,'vb',345,123,'images/img14.jpg',12,'无法v',1,'2019-01-29 00:19:17',2),(15,'45',34,45,'images/img15.jpg',23,'23呃',1,'2019-01-15 00:19:31',2),(16,'rt',234,234,'images/img16.jpg',23,'234',1,'2019-01-01 00:19:33',5),(17,'y',345,234,'images/img17.jpg',23,'345',0,'2018-12-31 00:19:41',5),(18,'rt',45,23,'images/img18.jpg',23,'dfg',1,'2019-01-30 00:19:36',5),(19,'hgj',1235,1232,'images/img19.jpg',23,'费创号0',1,'2019-01-29 01:06:08',5),(20,'123',123,123,'images/img20.jpg',23,'123qwe',1,'2019-01-06 00:19:44',2),(21,'sdf',345,234,'images/img21.jpg',23,'asdasd',1,'2019-01-06 00:19:47',2),(31,'aaaaaaaaaa',141.1,120,'images/img21.jpg',NULL,'测试商品',1,'2019-01-29 12:20:41',19),(32,'bbbbb2',123,123,'images/img10.jpg',NULL,'限量版',1,'2019-01-29 13:41:47',19);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `code` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (7,'sdf','123','落落','aaa@shop.com','1231324','广东省',1,NULL),(11,'aaa','wser','落落','bbb@shop.com','1231324','广东省',0,'925aa91b19da4e70be2bbd1d4fdf5b89f7b64be6936f402b977958df3745c8bd'),(12,'qwe','123','bb','bbb@shop.com','1231324','广东省',0,'56997e25e4da41bf87504e77dd6b7e8fa5d488dad3914694bec8de1599fd6c17');
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

-- Dump completed on 2019-07-24 22:18:12
