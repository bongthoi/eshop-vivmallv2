-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 103.77.169.245    Database: vivmallvndbv2
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `_sequence`
--

DROP TABLE IF EXISTS `_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_sequence` (
  `seq_name` varchar(50) NOT NULL,
  `seq_group` varchar(10) NOT NULL,
  `seq_val` int(10) NOT NULL,
  PRIMARY KEY (`seq_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_sequence`
--

LOCK TABLES `_sequence` WRITE;
/*!40000 ALTER TABLE `_sequence` DISABLE KEYS */;
INSERT INTO `_sequence` VALUES ('OD-ID','OD',53),('PN_ID','PN',1);
/*!40000 ALTER TABLE `_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `_sequence_barcode`
--

DROP TABLE IF EXISTS `_sequence_barcode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `_sequence_barcode` (
  `id` int(11) NOT NULL,
  `contry_code` varchar(3) DEFAULT NULL COMMENT '- Nhóm 1: Từ trái sang phải, hai hoặc ba chữ số đầu là mã số về quốc gia (vùng lãnh thổ)',
  `company_code` varchar(6) DEFAULT NULL COMMENT '- Nhóm 2: Tiếp theo gồm bốn, năm hoặc sáu chữ số là mã số về doanh nghiệp.',
  `product_code_count` int(5) DEFAULT NULL COMMENT '- Nhóm 3: Tiếp theo gồm năm, bốn hoặc ba chữ số là mã số về hàng hóa.\n\n-tạo tự động +1 vi du 1,2,3,4,5',
  `product_length` int(2) DEFAULT NULL COMMENT 'độ dài mã +1 prodcut vd 00001 ,00002',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `_sequence_barcode`
--

LOCK TABLES `_sequence_barcode` WRITE;
/*!40000 ALTER TABLE `_sequence_barcode` DISABLE KEYS */;
INSERT INTO `_sequence_barcode` VALUES (1,'893','0002',76,5);
/*!40000 ALTER TABLE `_sequence_barcode` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_about`
--

DROP TABLE IF EXISTS `tb_about`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_about` (
  `id` varchar(10) NOT NULL,
  `title` varchar(245) DEFAULT NULL,
  `description` text,
  `logo` varchar(45) DEFAULT NULL,
  `creator` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_about`
--

LOCK TABLES `tb_about` WRITE;
/*!40000 ALTER TABLE `tb_about` DISABLE KEYS */;
INSERT INTO `tb_about` VALUES ('about-001','Vinh Sáng','Glourious Viet Nam 2017 2018','dfg','u11','2017-01-01 00:00:00','<p>Đang cập nhật...</p>');
/*!40000 ALTER TABLE `tb_about` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_bigunit`
--

DROP TABLE IF EXISTS `tb_bigunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_bigunit` (
  `id` int(3) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_bigunit`
--

LOCK TABLES `tb_bigunit` WRITE;
/*!40000 ALTER TABLE `tb_bigunit` DISABLE KEYS */;
INSERT INTO `tb_bigunit` VALUES (1,'barrels',' don vi thung nuoc'),(2,'Block','don vi block'),(3,'pack','thung bia'),(99,'None','None of big Unit');
/*!40000 ALTER TABLE `tb_bigunit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_businesstype`
--

DROP TABLE IF EXISTS `tb_businesstype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_businesstype` (
  `id` int(3) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_businesstype`
--

LOCK TABLES `tb_businesstype` WRITE;
/*!40000 ALTER TABLE `tb_businesstype` DISABLE KEYS */;
INSERT INTO `tb_businesstype` VALUES (1,'self-business','aaaa'),(2,'Agent','aaaa');
/*!40000 ALTER TABLE `tb_businesstype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_category`
--

DROP TABLE IF EXISTS `tb_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(145) DEFAULT NULL,
  `CategoryDes` varchar(245) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `CreateUser` varchar(45) DEFAULT NULL,
  `UpdateUser` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  `CategoryImg` varchar(245) DEFAULT NULL,
  `IndustryId` int(11) DEFAULT NULL,
  `CategoryOrder` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_category`
--

LOCK TABLES `tb_category` WRITE;
/*!40000 ALTER TABLE `tb_category` DISABLE KEYS */;
INSERT INTO `tb_category` VALUES (5,'Camera','Camera','2017-06-26 11:12:06','2017-10-26 10:49:14','u1@gmail.com','admin@gmail.com',1,'2017-10-26_CAMERA_AD1.jpg',1,1),(67,'Phụ kiện thú cưng','Đeo cổ thú cưng','2017-10-25 09:24:29','2017-11-01 15:40:34','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_PKTC_BANNER.png',25,254),(68,'Thời trang thú  cưng','Quần áo','2017-10-25 14:35:27','2017-11-01 15:37:53','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_TTTC-BANNER.png',25,251),(69,'Vật dụng thú cưng','Chăm sóc lông và móng','2017-10-25 15:01:10','2017-11-01 15:40:40','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_VDTC_BANNER.png',25,252),(70,'Thiết bị định vị','GPS','2017-10-25 15:02:14','2017-11-01 15:38:18','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_TC_02.png',25,253),(71,'Đồ Chơi Con Quay','Đồ Chơi Con Quay','2017-10-25 15:58:23','2017-11-01 15:38:43','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-26_SPINNER_02.jpg',26,261),(72,'Phụ kiện điện thoại','Case, miếng dán đt','2017-10-26 09:19:18','2017-11-02 15:45:33','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-11-02_phukiendienthoai.png',32,321),(73,'Tai nghe trẻ em','Tai nghe chụp tai','2017-10-26 09:21:13','2017-11-01 15:36:01','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_TN_BANNER.png',1,4),(74,'Tai nghe người lớn','Tai nghe chụp tai , Tai nghe nhét tai','2017-10-26 09:22:38','2017-11-01 15:36:11','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-26_banner-product1.jpg',1,5),(75,'Thiết bị khác','LCD','2017-10-26 10:47:14','2017-11-01 15:35:22','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_TBK_BANNER.png',1,2),(76,'Thiết bị thông minh','Đồng hồ, vòng đeo tay, ổ cắm, bóng đèn','2017-10-26 14:09:12','2017-11-01 15:35:37','quan.hh@vinhsangvn.com','admin@gmail.com',1,'2017-10-31_TBTM_BANNER.png',1,3),(77,'Phụ kiện máy tính','Phụ kiện máy tính','2017-11-01 15:19:17','2017-11-03 11:19:13','admin@gmail.com','admin@gmail.com',1,'2017-11-03_PKMT-BANNER_02.png',32,322),(78,'Thiết Bị Cảm Biến','Thiết Bị Cảm Biến','2018-05-16 11:19:04','2018-05-16 11:27:00','admin@gmail.com','admin@gmail.com',1,'2018-05-16_2017-10-24_2017-10-11_AD1.jpg',33,1);
/*!40000 ALTER TABLE `tb_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_contacts`
--

DROP TABLE IF EXISTS `tb_contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `subject` varchar(245) DEFAULT NULL,
  `content` text,
  `phone` varchar(15) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_contacts`
--

LOCK TABLES `tb_contacts` WRITE;
/*!40000 ALTER TABLE `tb_contacts` DISABLE KEYS */;
INSERT INTO `tb_contacts` VALUES (54,'t','bongthoi1111@gmail.com','aaaaa','atest','11111111111',NULL,'2018-04-18 13:45:33',0),(55,'aaaaaaa','seller@vivmall.vn','seller@vivmall.vn','aaaaaaaaaaa','111111111',NULL,'2018-04-19 10:11:33',0),(56,'aaaaaaa','seller@vivmall.vn','aaaaaaaaa','test seller','11111111',NULL,'2018-04-19 15:53:57',0);
/*!40000 ALTER TABLE `tb_contacts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_delivery_method`
--

DROP TABLE IF EXISTS `tb_delivery_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_delivery_method` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `img` varchar(245) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `fee` double DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_delivery_method`
--

LOCK TABLES `tb_delivery_method` WRITE;
/*!40000 ALTER TABLE `tb_delivery_method` DISABLE KEYS */;
INSERT INTO `tb_delivery_method` VALUES (1,'Quận 1','no_image.jpg','Miễn phí',0,1),(2,'Quận 2','no_image.jpg','Miễn phí',20000,1),(3,'Quận 3','no_image.jpg','Miễn phí',30000,1),(4,'Quận 4','no_image.jpg','Miễn phí',40000,1),(5,'Quận 5','no_image.jpg','Miễn phí',50000,1),(6,'Quận 6','no_image.jpg','Miễn phí',60000,1),(7,'Quận 7','no_image.jpg','Miễn phí',70000,1),(8,'Quận 8','no_image.jpg','Miễn phí',80000,1),(9,'Quận 9','no_image.jpg','Miễn phí',90000,1),(10,'Quận 10','no_image.jpg','Miễn phí',100000,1),(11,'Quận 11','no_image.jpg','Miễn phí',0,1),(12,'Quận 12','no_image.jpg','Miễn phí',120000,1),(13,'Bình Tân','no_image.jpg','Miễn phí',0,0),(14,'Bình Thạnh','no_image.jpg','Miễn phí',0,0),(15,'Gò Vấp	','no_image.jpg','Miễn phí',0,0),(16,'Phú Nhuận','no_image.jpg','Miễn phí',0,0),(17,'Tân Bình','no_image.jpg','Miễn phí',0,0),(18,'Tân Phú','no_image.jpg','Miễn phí',0,0),(19,'Thủ Đức','no_image.jpg','Miễn phí',0,0),(20,'Bình Chánh','no_image.jpg','Miễn phí',0,0),(21,'Cần Giờ','no_image.jpg','Có phí',100000,0),(22,'Củ Chi','no_image.jpg','Có phí',50000,0),(23,'Hóc Môn','2017-11-16_localhost8.PNG','Có phí',50000,0),(24,'Nhà Bè','2017-11-16_localhost9.PNG','Có phí',100000,0);
/*!40000 ALTER TABLE `tb_delivery_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_emailfeedback`
--

DROP TABLE IF EXISTS `tb_emailfeedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_emailfeedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `contact_id` int(11) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  `subject` varchar(245) DEFAULT NULL,
  `content` text,
  `senddate` datetime DEFAULT NULL,
  `from_email` varchar(100) DEFAULT NULL,
  `to_email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_emailfeedback`
--

LOCK TABLES `tb_emailfeedback` WRITE;
/*!40000 ALTER TABLE `tb_emailfeedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_emailfeedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_guide`
--

DROP TABLE IF EXISTS `tb_guide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_guide` (
  `id` varchar(10) NOT NULL,
  `title` varchar(245) DEFAULT NULL,
  `description` text,
  `logo` varchar(45) DEFAULT NULL,
  `creator` varchar(45) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `content` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_guide`
--

LOCK TABLES `tb_guide` WRITE;
/*!40000 ALTER TABLE `tb_guide` DISABLE KEYS */;
INSERT INTO `tb_guide` VALUES ('intro-001','Hướng dẫn sử dụng','This is guide 2017 2018','',NULL,NULL,'<p>&nbsp;aaaaa</p>\r\n<p>bbbbb</p>\r\n<p>&nbsp;<img src=\"../upload/guide/2017-07-05_test.jpg\" alt=\"\" width=\"600\" height=\"300\" /></p>');
/*!40000 ALTER TABLE `tb_guide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_industry`
--

DROP TABLE IF EXISTS `tb_industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_industry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `IndustryName` varchar(145) DEFAULT NULL,
  `IndustryDes` varchar(245) DEFAULT NULL,
  `IndustryImg` varchar(245) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  `IndustryOrder` int(11) DEFAULT '1',
  `Icon` varchar(245) DEFAULT NULL,
  `ColorBackground` varchar(245) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_industry`
--

LOCK TABLES `tb_industry` WRITE;
/*!40000 ALTER TABLE `tb_industry` DISABLE KEYS */;
INSERT INTO `tb_industry` VALUES (1,'Điện tử','Điện tử','2017-10-24_2017-10-11_AD1.jpg',1,1,'electronic.png','electronic'),(25,'Thú Cưng','Thú Cưng','2017-10-31_TC_02.png',1,2,'fashion.png','fashion'),(26,'Đồ chơi','Đồ chơi','2017-10-26_SPINNER_02.jpg',1,4,'digital.png','digital'),(32,'Phụ kiện','Phụ kiện','2017-11-02_phukiendienthoai.png',1,5,'2017-11-01_18.png','sports'),(33,'Cảm Biến','Cảm Biến','2018-05-17_shop_now_cam_bien.jpg',1,5,'2018-05-16_icon_cam_bien.png','jewelry');
/*!40000 ALTER TABLE `tb_industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_news`
--

DROP TABLE IF EXISTS `tb_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_news` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(245) DEFAULT NULL,
  `image_feature` varchar(245) DEFAULT NULL,
  `content` text,
  `status` tinyint(1) DEFAULT NULL,
  `creator` varchar(245) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_news`
--

LOCK TABLES `tb_news` WRITE;
/*!40000 ALTER TABLE `tb_news` DISABLE KEYS */;
INSERT INTO `tb_news` VALUES (1,'Joanne Cheung','2017-10-30_Joanne.jpg','<div class=\"entry-photo\" style=\"background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\">Joanne Cheung &ndash; Tổng gi&aacute;m đốc v&agrave; đồng thời cũng l&agrave; người s&aacute;ng lập ra c&ocirc;ng ty Korex Technology Co.,Ltd, một trong những doanh nghiệp ti&ecirc;n phong trong lĩnh vực thiết bị điện tử th&ocirc;ng minh tại Shenzhen. Vivmall.vn rất h&acirc;n hạnh được hợp t&aacute;c với Korex để đem đến những sản phẩm Smart watch, Fitness tracker v&agrave; thiết bị Smart home đến thị trường Việt Nam để ra mắt thị trường c&ocirc;ng nghệ điện tử th&ocirc;ng minh tại Việt Nam....</div>\r\n<div class=\"entry-photo\" style=\"background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\"><img style=\"vertical-align: top; background-repeat: initial; font-weight: inherit; outline: 0px; max-width: 100%; width: 870px; border: 1px solid #eaeaea;\" src=\"../../../upload/news/Joanne.jpg\" alt=\"Blog\" /></div>\r\n<div class=\"content-text clearfix\" style=\"padding-top: 20px; padding-bottom: 20px; background-repeat: initial; outline: 0px; vertical-align: top; text-align: justify; color: #333333; font-family: Arial, sans-serif;\">\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top;\">&nbsp;</p>\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top;\">Về những sản phẩm d&acirc;y đeo th&ocirc;ng minh, Korex Technology đ&atilde; ph&aacute;t minh ra những mẫu d&acirc;y đeo, đồng hồ th&ocirc;ng minh với mẫu m&atilde; đa dạng, bắt mắt v&agrave; thời trang, đem đến cho kh&aacute;ch h&agrave;ng những trải nghiệm mới mẻ về những sản phẩm th&ocirc;ng minh hiện đại n&agrave;y!</p>\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top; text-align: center;\"><img style=\"vertical-align: top; background-repeat: initial; font-weight: inherit; outline: 0px; max-width: 100%;\" src=\"../../../upload/news/band1.jpg\" alt=\"Blog\" /></p>\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top; text-align: center;\">Fitness Tracker thời thượng</p>\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top; text-align: center;\"><img style=\"vertical-align: top; background-repeat: initial; font-weight: inherit; outline: 0px; max-width: 100%;\" src=\"../../../upload/news/dongho.jpg\" alt=\"Blog\" /></p>\r\n<p style=\"margin-top: 0px; margin-bottom: 15px; background-repeat: initial; font-weight: inherit; outline: 0px; vertical-align: top; text-align: center;\">Đồng hồ định vị th&ocirc;ng minh trẻ em</p>\r\n</div>',1,'admin@gmail.com','2018-03-21 12:51:43',1),(3,'Sự Kiện 2015','2017-10-31_giangsinh1.jpg','<div class=\"entry-photo\" style=\"background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\"><span style=\"color: #333333; font-family: Verdana, sans-serif; font-size: 15px; background-color: #ffffff;\">Mọi thứ bắt đầu mới với năm mới sắp tới. Ch&uacute;c năm mới của bạn tr&agrave;n ngập những điều hạnh ph&uacute;c nhất....</span></div>\r\n<div class=\"entry-photo\" style=\"background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\">\r\n<p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 10px; color: #333333; font-family: Verdana, sans-serif; font-size: 18.75px; background-color: #ffffff;\">&nbsp;</p>\r\n<p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 10px; color: #333333; font-family: Verdana, sans-serif; font-size: 18.75px; background-color: #ffffff;\"><img style=\"box-sizing: inherit; border-style: none; vertical-align: middle; margin: 10px auto 35px; display: block;\" src=\"http://vinhsangv2.khaitamtri.vn/upload/event/2017-06-13_giangsinh1.PNG\" alt=\"\" width=\"905\" height=\"517\" /></p>\r\n<p style=\"box-sizing: inherit; margin-top: 0px; margin-bottom: 10px; color: #333333; font-family: Verdana, sans-serif; font-size: 18.75px; background-color: #ffffff;\"><img style=\"box-sizing: inherit; border-style: none; vertical-align: middle; margin: 10px auto 35px; display: block;\" src=\"http://vinhsangv2.khaitamtri.vn/upload/event/2017-06-13_giangsinh2.PNG\" alt=\"\" width=\"906\" height=\"516\" /></p>\r\n</div>',1,'admin@gmail.com','2017-10-31 10:16:56',2);
/*!40000 ALTER TABLE `tb_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_news_categories`
--

DROP TABLE IF EXISTS `tb_news_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_news_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `image_feature` varchar(245) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `ordered` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_news_categories`
--

LOCK TABLES `tb_news_categories` WRITE;
/*!40000 ALTER TABLE `tb_news_categories` DISABLE KEYS */;
INSERT INTO `tb_news_categories` VALUES (1,'Tin Tức','no_image.jpg','Tin tức',1,1),(2,'Sự Kiện','no_image.jpg','Sự Kiện',1,2);
/*!40000 ALTER TABLE `tb_news_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_orders`
--

DROP TABLE IF EXISTS `tb_orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_orders` (
  `id` varchar(20) NOT NULL,
  `Email` varchar(245) DEFAULT NULL,
  `Name` varchar(145) DEFAULT NULL,
  `Address` varchar(245) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `PaymentMethod` int(3) DEFAULT NULL,
  `DeliveryMethod` int(3) DEFAULT NULL,
  `TotalQuantity` int(11) DEFAULT NULL,
  `TotalAmount` decimal(11,0) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `Note` varchar(245) DEFAULT NULL,
  `IsCheck` tinyint(1) DEFAULT '0' COMMENT '0 tao moi\n1 xac nhan\n2 huy bo',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_orders`
--

LOCK TABLES `tb_orders` WRITE;
/*!40000 ALTER TABLE `tb_orders` DISABLE KEYS */;
INSERT INTO `tb_orders` VALUES ('OD-00000000050','bongthoi1111@gmail.com','Van Thoi','36 Trần Quý,Phường 06,Quận 11,TP.Hồ Chí Minh','11111111',1,12,2,2387000,'2017-11-20 11:52:38','aaaaaaaaaaaaaa',1),('OD-00000000052','admin@gmail.com','admin first name','36 Trần Quý,Phường 06,Quận 11,TP.Hồ Chí Minh','02112',1,1,1,1353000,'2017-11-24 12:50:12','',1);
/*!40000 ALTER TABLE `tb_orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_orders_detail`
--

DROP TABLE IF EXISTS `tb_orders_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_orders_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ProductId` varchar(13) DEFAULT NULL,
  `ProductName` varchar(245) DEFAULT NULL,
  `Unit` int(3) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `Price` decimal(11,0) DEFAULT NULL,
  `Price1` decimal(11,0) DEFAULT NULL,
  `Amount` decimal(11,0) DEFAULT NULL,
  `OrdersId` varchar(20) DEFAULT NULL COMMENT 'ma phieu xuat',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=310 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_orders_detail`
--

LOCK TABLES `tb_orders_detail` WRITE;
/*!40000 ALTER TABLE `tb_orders_detail` DISABLE KEYS */;
INSERT INTO `tb_orders_detail` VALUES (306,'8930002000413','Bảng Viết Thông Minh LCD',1,1,1034000,1034000,1034000,'OD-00000000050'),(307,'8930002000666','IP Camera',1,1,1353000,1588300,1353000,'OD-00000000050'),(308,'8930002000666','IP Camera',1,1,1353000,1353000,1353000,'OD-00000000052'),(309,'8930002000109','Đồ Tàu Cho Thú Cưng',1,1,179000,179000,179000,'OD-00000000053');
/*!40000 ALTER TABLE `tb_orders_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_payment_method`
--

DROP TABLE IF EXISTS `tb_payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_payment_method` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(245) DEFAULT NULL,
  `img` varchar(245) DEFAULT NULL,
  `account_name` varchar(45) DEFAULT NULL,
  `account_pass` varchar(45) DEFAULT NULL,
  `url` varchar(245) DEFAULT NULL,
  `merchant_site_code` varchar(45) DEFAULT NULL,
  `secure_pass` varchar(245) DEFAULT NULL,
  `return_url` varchar(245) DEFAULT NULL,
  `return_cancel` varchar(245) DEFAULT NULL,
  `receiver` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_payment_method`
--

LOCK TABLES `tb_payment_method` WRITE;
/*!40000 ALTER TABLE `tb_payment_method` DISABLE KEYS */;
INSERT INTO `tb_payment_method` VALUES (1,'Thanh toán khi nhận hàng','Quý khách sẽ thanh toán bằng tiền mặt khi nhận hàng tại nhà...','handle.png',NULL,NULL,NULL,NULL,NULL,'checkout_success','checkout_cancel',NULL,1),(2,'PayPal','Phương thức thanh toán thông qua cổng thanh toán PayPal','paypal.png',NULL,NULL,NULL,NULL,NULL,'checkout_success','checkout_cancel',NULL,0),(3,'Ngân Lượng','Phương thức thanh toán thông qua cổng thanh toán Ngân Lượng','nganluong.png','chau.hm@vinhsangvn.com','P@$$word159753','https://www.nganluong.vn/checkout.php?','47688','b5ab00d4e3856a876c85c4985d4892fe','checkout_success','checkout_cancel','chau.hm@vinhsangvn.com',1);
/*!40000 ALTER TABLE `tb_payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_product`
--

DROP TABLE IF EXISTS `tb_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_product` (
  `id` varchar(13) NOT NULL COMMENT 'barcode genarator',
  `ProductName` varchar(245) DEFAULT NULL,
  `ProductDes` text,
  `ProductGuide` text,
  `ProductInfo` text,
  `FeatureImage` varchar(245) DEFAULT NULL,
  `Unit` int(3) DEFAULT NULL,
  `BigUnit` int(3) DEFAULT NULL,
  `CostPrice` decimal(11,0) DEFAULT NULL,
  `SellPrice` decimal(11,0) DEFAULT NULL,
  `SellPrice1` decimal(11,0) DEFAULT NULL,
  `SellPrice2` decimal(11,0) DEFAULT NULL,
  `SupplierId` varchar(20) DEFAULT NULL,
  `CategoryId` int(11) DEFAULT NULL,
  `BusinessType` int(3) DEFAULT NULL,
  `CreateDate` datetime DEFAULT NULL,
  `UpdateDate` datetime DEFAULT NULL,
  `CreateUser` varchar(45) DEFAULT NULL,
  `UpdateUser` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_product`
--

LOCK TABLES `tb_product` WRITE;
/*!40000 ALTER TABLE `tb_product` DISABLE KEYS */;
INSERT INTO `tb_product` VALUES ('8930002000062','Móc Đèn Led Đeo Cổ Thú Cưng','<p>&nbsp;C&oacute; 5 m&agrave;u: đỏ, xanh biển, hồng, cam, xanh l&aacute;.</p>','','<p>Đèn có th&ecirc;̉ thay pin, có nhi&ecirc;̀u ch&ecirc;́ đ&ocirc;̣ sáng: sáng li&ecirc;n tục, nh&acirc;́p nháy 1 l&acirc;̀n và nh&acirc;́p nháy 2 l&acirc;̀n.</p>\r\n<p>&nbsp;<span style=\"color: #626262;\">- Đèn led đ&ecirc;̉ móc vào v&ograve;ng c&ocirc;̉, giúp giữ an toàn cho th&uacute; cưng trong bóng đ&ecirc;m,</span></p>\r\n<p>&nbsp;</p>\r\n<p style=\"color: #626262;\">- &Aacute;nh sáng của đèn có th&ecirc;̉ nhìn th&acirc;́y trong bán kính hơn &frac12; dặm.</p>','2017-10-25_Moc den LED thu cung.png',6,99,95000,95000,95000,95000,'sup002',67,1,'2017-10-25 09:32:05','2017-10-30 14:45:31','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000079','Khăn Choàng Cổ Thú Cưng','<p>&nbsp;</p>\r\n<p>Gồm 2 m&agrave;u: cam v&agrave; xanh dạ quang</p>','','<p>Khăn cho&agrave;ng cổ cho th&uacute; cưng được may bằng chất liệu mềm d&agrave;y dặn, m&agrave;u sắc v&agrave; chất vải b&ocirc;ng chống bụi. Ngo&agrave;i đeo cổ th&igrave; c&ograve;n c&oacute; thể biến tấu th&agrave;nh khăn cho&agrave;ng, khăn ăn dặm hay thậm ch&iacute; l&agrave; khăn bịt tai.</p>\r\n<p>&nbsp;</p>\r\n<p>Quy c&aacute;ch : d&acirc;y rộng 15mm, v&ograve;ng cổ từ 26-42cm.</p>','2017-10-25_Khang choang thu cung (xanh la).png',6,99,61000,61000,61000,61000,'sup002',67,1,'2017-10-25 09:36:51','2017-10-30 14:44:54','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000086','Cà Vạt Thú Cưng','<p>&nbsp;Size: Freesize</p>\r\n<p>&nbsp;</p>','','<p>Chất liệu: Được may bằng chất vải len n&ecirc;n sẽ rất mềm nhẹ bắt s&aacute;ng.</p>\r\n<p>C&agrave; vạt cho ch&oacute; m&egrave;o bao gồm:</p>\r\n<p> Phần c&agrave; vạt được may cố định với d&acirc;y đeo.</p>\r\n<p>&nbsp;</p>\r\n<p> Phần d&acirc;y đeo c&agrave; vạt dễ d&agrave;ng nới ra thu v&agrave;o, th&iacute;ch hợp với tất cả th&uacute; cưng c&oacute; k&iacute;ch cỡ kh&aacute;c nhau.</p>\r\n<p>&nbsp;</p>','2017-10-25_Ca vat thu cung.png',6,99,78000,78000,78000,78000,'sup002',67,1,'2017-10-25 09:58:00','2017-10-30 14:44:27','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000093','Áo Sơ Mi Thú Cưng','<p>- Chất liệu: Cotton.</p>\r\n<p>- M&agrave;u sắc : Xanh dương nhạt .</p>\r\n<p>&nbsp;</p>','','<p>Đường may tỉ mỉ c&ugrave;ng thiết kế độc đ&aacute;o gi&uacute;p th&uacute; cưng của bạn nổi bật với những b&eacute; c&uacute;n xung quanh.</p>','2017-10-25_Somi thu cung.png',1,99,174000,174000,174000,174000,'sup002',68,1,'2017-10-25 14:38:33','2017-10-30 14:47:49','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000109','Đồ Tàu Cho Thú Cưng','<p>- Chất liệu : Cotton tho&aacute;ng m&aacute;t.</p>\r\n<p>- M&agrave;u sắc : Đỏ , Xanh , Hồng .</p>','','<p>- Thiết kế : Phong c&aacute;ch Trung Hoa hợp thời trang ,c&oacute; nhiều họa tiết tạo th&ecirc;m điểm nhấn cho trang phục ,thu h&uacute;t sự ch&uacute; &yacute; bởi vẻ ngo&agrave;i bắt mắt ngộ nghĩnh.</p>','2018-03-21_do-tau-cho-thu-cung.png',1,99,179000,179000,179000,179000,'sup002',68,1,'2017-10-25 14:42:49','2018-03-21 11:52:25','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000116','Đồ Tàu Cho Thú Cưng','<p>- Chất liệu : Cotton tho&aacute;ng m&aacute;t.</p>\r\n<p>- M&agrave;u sắc : Đỏ ,Xanh ,Hồng .</p>','','<p>Thiết kế : Phong c&aacute;ch Trung Hoa hợp thời trang ,c&oacute; nhiều họa tiết tạo th&ecirc;m điểm nhấn cho trang phục ,thu h&uacute;t sự ch&uacute; &yacute; bởi vẻ ngo&agrave;i bắt mắt ngộ nghĩnh.</p>','2017-10-25_Do tau thu cung (hong).png',1,99,179000,179000,179000,179000,'sup002',68,1,'2017-10-25 14:45:08','2017-10-30 14:46:40','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000123','Đồ Tàu Cho Thú Cưng','<p><span style=\"color: #333333; font-family: Arial, sans-serif;\">- Chất liệu : Cotton tho&aacute;ng m&aacute;t. - M&agrave;u sắc : Đỏ , Xanh , Hồng .</span></p>','','<p>- Thiết kế :&nbsp; Phong c&aacute;ch Trung Hoa hợp thời trang ,c&oacute; nhiều họa tiết tạo th&ecirc;m điểm nhấn cho trang phục ,thu h&uacute;t sự ch&uacute; &yacute; bởi vẻ ngo&agrave;i bắt mắt ngộ nghĩnh.</p>','2017-10-25_Do tau thu cung (xanh duong).png',1,99,179000,179000,179000,179000,'sup002',68,1,'2017-10-25 14:47:09','2017-10-30 14:46:14','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000130','Khăn Choàng Cổ Thú Cưng','<p>Gồm 2 m&agrave;u: cam v&agrave; xanh dạ quang</p>','','<p>Khăn cho&agrave;ng cổ cho th&uacute; cưng được may bằng chất liệu mềm d&agrave;y dặn, m&agrave;u sắc v&agrave; chất vải b&ocirc;ng chống bụi. Ngo&agrave;i đeo cổ th&igrave; c&ograve;n c&oacute; thể biến tấu th&agrave;nh khăn cho&agrave;ng, khăn ăn dặm hay thậm ch&iacute; l&agrave; khăn bịt tai.</p>\r\n<p>Quy c&aacute;ch : d&acirc;y rộng 15mm, v&ograve;ng cổ từ 26-42cm.</p>','2017-10-25_Khang choang thu cung (cam).png',1,99,61000,61000,61000,61000,'sup002',67,1,'2017-10-25 14:49:29','2017-10-30 14:43:58','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000147','Lược Chải Lông Thú Cưng','<p>- Lược chải l&ocirc;ng dạng đầu kim c&oacute; t&aacute;c dụng l&agrave;m b&ocirc;ng x&ugrave; l&ocirc;ng gi&uacute;p ta dễ d&agrave;ng lấy l&ocirc;ng rụng, l&ocirc;ng chết cho những th&uacute; cưng l&ocirc;ng d&agrave;i.</p>','','<p>&nbsp;- Lược răng đều, mịn chải mướt, su&ocirc;n, kh&ocirc;ng bị cấn khi chải, loại bỏ tối đa l&ocirc;ng chết nhưng kh&ocirc;ng l&agrave;m g&atilde;y rụng l&ocirc;ng khỏe.</p>\r\n<p>- Lược chải l&ocirc;ng gồm một mặt sợi thưa v&agrave; một mặt nhiều sợi tiện sử dụng.</p>\r\n<p>- Kiểu d&aacute;ng đẹp, bền, dễ cầm, chắc chắn, dễ sử dụng.</p>\r\n<p>- Th&iacute;ch hợp d&ugrave;ng cho cả những b&eacute; th&uacute; cưng l&ocirc;ng ngắn hay d&agrave;i.</p>','2017-10-25_Luoc chai long thu cung.png',1,99,102000,102000,102000,102000,'sup002',69,1,'2017-10-25 15:04:28','2017-10-30 14:49:40','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000154','Lược Gỡ Rối Thú Cưng','<p>- M&agrave;u sắc:&nbsp; Đỏ x&aacute;m.</p>','<p>- Chải nhẹ nhàng xu&ocirc;i theo chi&ecirc;̀u l&ocirc;ng của th&uacute; cưng, bắt đ&acirc;̀u từ tr&ecirc;n đ&acirc;̀u, c&ocirc;̉, lưng sau đó đ&ecirc;́n ngực, bụng, 4 ch&acirc;n và đu&ocirc;i.&nbsp;</p>\r\n<p>- N&ecirc;́u ch&ocirc;̃ l&ocirc;ng nào bị r&ocirc;́i hãy nhẹ tay đ&ecirc;̉ kh&ocirc;ng làm ch&oacute; m&egrave;o bị đau hay khó chịu</p>','<p>-&nbsp; Được thi&ecirc;́t k&ecirc;́ g&ocirc;̀m 2 hàm răng lược thi&ecirc;́t k&ecirc;́ dạng dao móc.</p>\r\n<p>- V&acirc;̣t li&ecirc;̣u: ch&ocirc;́ng tĩnh đi&ecirc;̣n, đảm bảo an toàn khi sử dụng và d&ecirc;̃ dàng v&ecirc;̣ sinh sạch sẽ sản ph&acirc;̉m.</p>','2017-10-25_Luoc go roi thu cung.png',1,99,108000,108000,108000,108000,'sup002',69,1,'2017-10-25 15:06:39','2017-10-30 14:49:04','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000161','Bộ Kềm Cắt Móng Thú Cưng','<p>Bộ sản phẩm bao gồm: 1 kềm + 1 dũa.</p>','<p>Chỉ cắt v&agrave;o phần m&oacute;ng, nh&igrave;n kỹ, để biết tủy của m&oacute;ng đến đ&acirc;u tr&aacute;nh kh&ocirc;ng cắt v&agrave;o đ&oacute; khiến vật nu&ocirc;i chảy m&aacute;u.</p>','<p>L&agrave; một trong những vật dụng kh&ocirc;ng thể thiếu cho th&uacute; cưng.</p>\r\n<p>Bộ kềm dũa cắt m&oacute;ng cho ch&oacute; m&egrave;o, chất tốt, đẹp, bền</p>','2017-10-25_Kem cat mong thu cung.png',1,99,99000,99000,99000,99000,'sup002',69,1,'2017-10-25 15:09:02','2017-10-30 14:48:31','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000185','Thiết Bị Định Vị Thú Cưng P2','<p>H&agrave;ng độc quyền</p>','','<p>&nbsp;Những ch&uacute; ch&oacute; đ&aacute;ng y&ecirc;u, những c&ocirc; m&egrave;o xinh xắn m&agrave; c&aacute;c bạn nu&ocirc;i dưỡng h&agrave;ng ng&agrave;y thật lo lắng khi dắt ch&uacute;ng đi dạo m&agrave; bị lạc mất v&igrave; 1 ph&uacute;t lơ đễnh. Thiết bị gi&uacute;p theo d&otilde;i vị tr&iacute; theo thời gian thực, xem lại lộ tr&igrave;nh trong ng&agrave;y, theo d&otilde;i trực tuyến tr&ecirc;n m&aacute;y t&iacute;nh hoặc điện thoại&hellip;của bạn.</p>','2017-10-25_Thiet bi dinh vi thu cung 4.png',6,99,660000,660000,660000,660000,'sup003',70,1,'2017-10-25 15:16:10','2017-10-30 14:50:13','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000192','Đồ Chơi Con Quay','<p>M&agrave;u sắc: đen, trắng, v&agrave;ng, đỏ, xanh dương, xanh l&aacute;</p>','','<p>T&aacute;c dụng : Gi&uacute;p giải ph&oacute;ng cơ thể v&agrave; t&acirc;m trạng của bạn, giảm stress, l&agrave;m cho bạn tập trung v&agrave;o c&ocirc;ng việc của bạn.</p>\r\n<p>Thời gian xoay v&ograve;ng: 1-2 ph&uacute;t (Thời gian xoay v&ograve;ng quay t&ugrave;y thuộc v&agrave;o lực t&aacute;c dụng khi xoay).</p>\r\n<p>&nbsp;Chất liệu: Được l&agrave;m bằng kim loại v&agrave; nhựa.</p>','2018-03-21_do-choi-con-quay.png',1,99,54000,54000,54000,54000,'sup002',71,1,'2017-10-25 16:00:48','2018-03-21 11:48:22','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000215','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p>C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-03-21_op-lung-iphone-cam.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:27:55','2018-03-21 12:46:04','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000222','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-03-21_op-lung-iphone-vang.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:30:09','2018-03-21 12:46:22','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000239','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 8.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:31:13','2018-06-06 14:19:34','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000246','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 1.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:32:05','2018-06-06 14:20:48','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000253','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 7.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:33:00','2018-06-06 14:19:21','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000260','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 6.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:33:56','2018-06-06 14:19:04','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000277','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 5.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:34:43','2018-06-06 14:18:33','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000284','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 4.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:35:44','2018-06-06 14:18:08','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000291','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 3.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:36:56','2018-06-06 14:17:48','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000307','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-06-06_2017-10-26 op ung cho iphone 1.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:37:50','2018-06-06 14:17:01','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000314','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-03-21_op-lung-iphone-vang.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:38:43','2018-03-21 12:44:31','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000321','Ốp lưng Iphone 5/6/7','<p style=\"color: #626262;\">- Chất liệu nhựa dẻo, kiểu d&aacute;ng thời trang v&agrave; đẹp mắt.</p>\r\n<p style=\"color: #626262;\">- Thiết kế vừa vặn v&agrave; &ocirc;m s&aacute;t th&acirc;n m&aacute;y.</p>\r\n<p style=\"color: #626262;\">&nbsp;- Dễ d&agrave;ng th&aacute;o/lắp ốp v&agrave;o m&aacute;y.</p>\r\n<p style=\"color: #626262;\">C&oacute; tất cả case cho ip 5,6,7</p>','','','2018-03-21_op-lung-iphone-cam.png',1,99,64000,64000,64000,64000,'sup002',72,1,'2017-10-26 09:39:36','2018-03-21 12:43:25','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000338','Miếng Dán Cường Lực Iphone 5/6/7','<p>Miếng d&aacute;n m&agrave;n h&igrave;nh cao cấp c&oacute; t&aacute;c dụng chống vỡ, chống xước v&agrave; chống ch&oacute;i cho m&agrave;n h&igrave;nh iPhone.</p>\r\n<p>Chịu xước với tất cả c&aacute;c loại vật thể kh&aacute;c: cọ s&aacute;t, chọc, dao cứa, ch&igrave;a kh&oacute;a.</p>\r\n<p>Miếng d&aacute;n bằng k&iacute;nh cường lực trong suốt cực s&aacute;ng v&agrave; kh&ocirc;ng l&agrave;m giảm chất lượng h&igrave;nh ảnh.</p>\r\n<p>Hiển thị h&igrave;nh ảnh với độ n&eacute;t cao l&ecirc;n đến 100% so với h&igrave;nh ảnh hiển thị gốc</p>','','','2017-10-26_mieng dan cuong luc cho iphone 5 6 7.png',1,99,29000,29000,29000,29000,'sup002',72,1,'2017-10-26 09:45:34','2017-10-30 15:14:51','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000345','Tai Nghe Stereo hoa văn','<p>- Với &acirc;m lượng vừa phải, kh&ocirc;ng qu&aacute; to Headphone cho trẻ em l&agrave; tai nghe sản xuất d&agrave;nh ri&ecirc;ng cho đối tượng l&agrave; trẻ em, để khi nghe trẻ kh&ocirc;ng bị ảnh hưởng tới tai do &acirc;m lượng qu&aacute; to như tr&ecirc;n c&aacute;c tai nghe th&ocirc;ng thường.</p>\r\n<p>- Headphone c&oacute; nhiều kiểu d&aacute;ng dễ thương ngộ nghĩnh cho c&aacute;c b&eacute; dễ lựa chọn</p>\r\n<p>- Tai sử dụng jack cắm 3.5mm c&oacute; thể d&ugrave;ng được tr&ecirc;n tất cả c&aacute;c m&aacute;y nghe nhạc th&ocirc;ng thường.</p>\r\n<p>&nbsp;</p>\r\n<p>- Với chất liệu mềm mịn tạo cảm gi&aacute;c thoải m&aacute;i ,kh&ocirc;ng l&agrave;m đau tai c&aacute;c b&eacute;.</p>\r\n<p>M&agrave;u sắc: m&agrave;u đen tai m&egrave;o, xanh dương, xanh l&aacute; .</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>','','<p>&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 30MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KJZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS+/-15%</p>\r\n<p>&bull; Độ nhạy: 80+/-5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M+/-15%</p>\r\n<p>Lưu &yacute;: kh&ocirc;ng th&iacute;ch hợp cho trẻ dưới 3 tuổi</p>','2018-03-21_tay-nghe-hoa-van-danh-cho-tre-em1.png',1,99,246000,246000,246000,246000,'sup002',73,1,'2017-10-26 09:54:05','2018-03-21 12:49:53','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000352','Tai Nghe Stereo hoa văn','<p>- Với &acirc;m lượng vừa phải, kh&ocirc;ng qu&aacute; to Headphone cho trẻ em l&agrave; tai nghe sản xuất d&agrave;nh ri&ecirc;ng cho đối tượng l&agrave; trẻ em, để khi nghe trẻ kh&ocirc;ng bị ảnh hưởng tới tai do &acirc;m lượng qu&aacute; to như tr&ecirc;n c&aacute;c tai nghe th&ocirc;ng thường.</p>\r\n<p>- Headphone c&oacute; nhiều kiểu d&aacute;ng dễ thương ngộ nghĩnh cho c&aacute;c b&eacute; dễ lựa chọn</p>\r\n<p>- Tai sử dụng jack cắm 3.5mm c&oacute; thể d&ugrave;ng được tr&ecirc;n tất cả c&aacute;c m&aacute;y nghe nhạc th&ocirc;ng thường.</p>\r\n<p>- Với chất liệu mềm mịn tạo cảm gi&aacute;c thoải m&aacute;i ,kh&ocirc;ng l&agrave;m đau tai c&aacute;c b&eacute;.</p>\r\n<p>M&agrave;u sắc: m&agrave;u đen tai m&egrave;o, xanh dương, xanh l&aacute;.</p>\r\n<p>&nbsp;</p>','','<p>&nbsp;</p>\r\n<p>&nbsp;Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 30MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KJZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS+/-15%</p>\r\n<p>&bull; Độ nhạy: 80+/-5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M+/-15%</p>\r\n<p>&nbsp;</p>\r\n<p>Lưu &yacute;: kh&ocirc;ng th&iacute;ch hợp cho trẻ dưới 3 tuổi</p>','2017-10-26_Tai nghe hoa văn dành cho trẻ em 2.png',1,99,246000,246000,246000,246000,'sup002',73,1,'2017-10-26 09:55:47','2017-10-30 15:07:39','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000369','Tai Nghe Stereo hoa văn','<p>&nbsp;- Với &acirc;m lượng vừa phải, kh&ocirc;ng qu&aacute; to Headphone cho trẻ em l&agrave; tai nghe sản xuất d&agrave;nh ri&ecirc;ng cho đối tượng l&agrave; trẻ em, để khi nghe trẻ kh&ocirc;ng bị ảnh hưởng tới tai do &acirc;m lượng qu&aacute; to như tr&ecirc;n c&aacute;c tai nghe th&ocirc;ng thường.</p>\r\n<p>- Headphone c&oacute; nhiều kiểu d&aacute;ng dễ thương ngộ nghĩnh cho c&aacute;c b&eacute; dễ lựa chọn</p>\r\n<p>- Tai sử dụng jack cắm 3.5mm c&oacute; thể d&ugrave;ng được tr&ecirc;n tất cả c&aacute;c m&aacute;y nghe nhạc th&ocirc;ng thường.</p>\r\n<p>- Với chất liệu mềm mịn tạo cảm gi&aacute;c thoải m&aacute;i ,kh&ocirc;ng l&agrave;m đau tai c&aacute;c b&eacute;.</p>\r\n<p>M&agrave;u sắc: m&agrave;u đen tai m&egrave;o, xanh dương, xanh l&aacute;.</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>','','<p>&nbsp;</p>\r\n<p>&nbsp;Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 30MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KJZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS+/-15%</p>\r\n<p>&bull; Độ nhạy: 80+/-5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M+/-15%</p>\r\n<p>&nbsp;</p>\r\n<p>Lưu &yacute;: kh&ocirc;ng th&iacute;ch hợp cho trẻ dưới 3 tuổi</p>','2017-10-26_Tai nghe hoa văn dành cho trẻ em 3.png',1,99,246000,246000,246000,246000,'sup002',73,1,'2017-10-26 09:57:37','2017-10-30 15:07:11','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000376','Tai Nghe Amalen  hồng','<p>- Với &acirc;m lượng vừa phải, kh&ocirc;ng qu&aacute; to, Kids Stereo Headphone l&agrave; tai nghe sản xuất d&agrave;nh ri&ecirc;ng cho đối tượng l&agrave; trẻ em, để khi nghe trẻ kh&ocirc;ng bị ảnh hưởng tới tai do &acirc;m lượng qu&aacute; to như những chiếc tai nghe th&ocirc;ng thường.</p>\r\n<p>- Tai sử dụng jack cắm 3.5mm c&oacute; thể d&ugrave;ng được tr&ecirc;n tất cả c&aacute;c m&aacute;y nghe nhạc th&ocirc;ng thường.</p>\r\n<p>- Với chất liệu mềm mịn tạo cảm gi&aacute;c thoải m&aacute;i ,kh&ocirc;ng l&agrave;m đau tai c&aacute;c b&eacute;.</p>\r\n<p>- C&oacute; thể chia sẻ b&agrave;i h&aacute;t c&ugrave;ng tai nghe kh&aacute;c chung loại.</p>\r\n<p>- M&agrave;u sắc: hồng</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 40MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS+/-15%</p>\r\n<p>&bull; Độ nhạy: 93+/-5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M+/-15%</p>\r\n<p>Lưu &yacute;: kh&ocirc;ng th&iacute;ch hợp cho trẻ dưới 3 tuổi</p>','2017-10-26_Tai nghe trẻ em Stereo 1.png',1,99,237000,237000,237000,237000,'sup002',73,1,'2017-10-26 10:01:29','2017-10-30 15:06:06','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000383','Tai Nghe Stereo LH-720','<p>T&iacute;ch hợp microphone cố định, độ nhạy cao</p>\r\n<p>Với Stereo LH - 720 bạn sẽ được cảm nhận &acirc;m thanh trung thực ,chụp tai bằng xốp mịn kh&ocirc;ng bị đau tai v&agrave; gi&uacute;p loại bỏ tạp &acirc;m từ b&ecirc;n ngo&agrave;i&nbsp;</p>\r\n<p>- M&agrave;u Sắc: Xanh ,Đen</p>','','<p>Th&ocirc;ng số kỹ thuật :</p>\r\n<p> Micro</p>\r\n<p>&bull; K&iacute;ch thước đầu micro: 6.0 x 5.0mm</p>\r\n<p>&bull; Độ nhạy: -38 dB &plusmn; 3dB</p>\r\n<p>&bull; Trở kh&aacute;ng: 2.2 KΏ</p>\r\n<p>&bull; Điện &aacute;p : 4.5V</p>\r\n<p> Headphone</p>\r\n<p>&bull; Trở kh&aacute;ng: 32 Ώ</p>\r\n<p>&bull; Tần số: 20~20 kHz</p>\r\n<p>&bull; K&iacute;ch thước jack: d&acirc;y kết nối 3.5mm</p>\r\n<p>&bull; &Aacute;p suất &acirc;m thanh: 98 dB &plusmn; 3dB</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y headphone: &ge; 2.0M</p>','2017-10-26_Tai nghe Stereo 1.png',1,99,56000,56000,56000,56000,'sup002',74,1,'2017-10-26 10:08:59','2017-10-30 15:09:34','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000390','Tai Nghe Micro Lotong','<p>- L&agrave; một headphone d&agrave;nh cho game thủ, với &acirc;m thanh chất lượng cao, đem lại cho bạn trải nghiệm chơi game sống động tuyệt vời.</p>\r\n<p>- T&iacute;ch hợp micro c&oacute; thể xoay chuyển 160 độ.</p>\r\n<p>- Thiết kế chụp tai lớn, đệm m&uacute;t bọc bằng da, c&aacute;ch &acirc;m tốt.</p>','','<p>Th&ocirc;ng số kỹ thuật :</p>\r\n<p> Micro</p>\r\n<p>&bull; K&iacute;ch thước đầu micro: 6.0 x 5.0mm</p>\r\n<p>&bull; Độ nhạy: -40 dB &plusmn; 3dB</p>\r\n<p>&bull; Trở kh&aacute;ng: 2.2 KΏ</p>\r\n<p>&bull; Điện &aacute;p : 4.5V</p>\r\n<p> Headphone</p>\r\n<p>&bull; Trở kh&aacute;ng: 32 Ώ</p>\r\n<p>&bull; Tần số: 20~20 kHz</p>\r\n<p>&bull; K&iacute;ch thước jack: d&acirc;y kết nối 3.5mm</p>\r\n<p>&bull; &Aacute;p suất &acirc;m thanh: 98 dB &plusmn; 3dB</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y headphone: &ge; 2.0M</p>','2017-10-26_Tai nghe micro cho game thủ.png',1,99,83000,83000,83000,83000,'sup002',74,1,'2017-10-26 10:31:40','2017-10-30 15:09:01','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000406','Micro để bàn','<p>&ndash; C&oacute; c&ocirc;ng tắc nhấn để n&oacute;i v&agrave; cần kh&oacute;a.</p>\r\n<p>&ndash; D&acirc;y bọc chống nhiễu 1 l&otilde;i đơn d&agrave;i 2m.</p>','<p style=\"color: #626262;\">Th&ocirc;ng số kỹ thuật :</p>\r\n<p style=\"color: #626262;\">Micro loại: LH &ndash; M2</p>\r\n<p style=\"color: #626262;\">T&iacute;nh định hướng: Uni directional</p>\r\n<p style=\"color: #626262;\">Trở kh&aacute;ng: &nbsp; &nbsp; &nbsp; 2K Ohm</p>\r\n<p style=\"color: #626262;\">Độ nhạy: -58db+/-3bd</p>\r\n<p style=\"color: #626262;\">Tần số: 75 16000 Hz</p>\r\n<p style=\"color: #626262;\">Chiều d&agrave;i d&acirc;y c&aacute;p: 2.5+/-0.3m</p>\r\n<p style=\"color: #626262;\">K&iacute;ch thước jack: 3.5mm stereo</p>\r\n<p style=\"color: #626262;\">Quy c&aacute;ch: 9*5mm</p>','<p>Th&ocirc;ng số kỹ thuật :</p>\r\n<p>Micro loại: LH &ndash; M2</p>\r\n<p>T&iacute;nh định hướng: Uni directional</p>\r\n<p>Trở kh&aacute;ng: &nbsp; &nbsp; &nbsp; 2K Ohm</p>\r\n<p>Độ nhạy: -58db+/-3bd</p>\r\n<p>Tần số: 75 16000 Hz</p>\r\n<p>Chiều d&agrave;i d&acirc;y c&aacute;p: 2.5+/-0.3m</p>\r\n<p>K&iacute;ch thước jack: 3.5mm stereo</p>\r\n<p>Quy c&aacute;ch: 9*5mm</p>','2017-10-26_micro.png',1,99,51000,51000,51000,51000,'sup002',77,1,'2017-10-26 10:34:44','2017-11-01 15:20:37','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000413','Bảng Viết Thông Minh LCD','<p>- Với bảng viết th&ocirc;ng minh,gi&uacute;p bạn c&oacute; thể s&aacute;ng tạo &yacute; tưởng ở mọi nơi.Phong c&aacute;ch mới với thiết kế mỏng, nhẹ, gi&uacute;p bạn dễ d&agrave;ng đem theo b&ecirc;n m&igrave;nh.</p>\r\n<p>-Th&iacute;ch hợp với tất cả lứa tuổi.</p>\r\n<p>- X&oacute;a bảng đơn giản chỉ bằng một n&uacute;t bấm.</p>\r\n<p>- Pin 3V c&oacute; thể thay thể được.</p>\r\n<p>- K&iacute;ch thước: 12 inch</p>\r\n<p>-M&agrave;u sắc:&nbsp; Xanh dương, hồng</p>','','','2017-10-26_bang viet thong minh (hong - mat truoc).png',1,99,1034000,1034000,1034000,1034000,'sup002',75,1,'2017-10-26 10:53:20','2017-10-30 15:10:30','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000420','Bảng Viết Thông Minh LCD','<p>- Với bảng viết th&ocirc;ng minh,gi&uacute;p bạn c&oacute; thể s&aacute;ng tạo &yacute; tưởng ở mọi nơi.Phong c&aacute;ch mới với thiết kế mỏng, nhẹ, gi&uacute;p bạn dễ d&agrave;ng đem theo b&ecirc;n m&igrave;nh.</p>\r\n<p>-Th&iacute;ch hợp với tất cả lứa tuổi.</p>\r\n<p>- X&oacute;a bảng đơn giản chỉ bằng một n&uacute;t bấm.</p>\r\n<p>- Pin 3V c&oacute; thể thay thể được.</p>\r\n<p>- K&iacute;ch thước: 12 inch</p>\r\n<p>-M&agrave;u sắc:&nbsp; Xanh dương, hồng</p>','','','2017-10-26_bang viet thong minh (xanh duong - mat sau).png',1,99,1034000,1034000,1034000,1034000,'sup002',75,1,'2017-10-26 10:57:21','2017-10-30 15:10:09','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000437','Cáp Usb Cho Iphone','<p>T&iacute;nh Năng:</p>\r\n<p>- Sạc iPhone của bạn bất cứ nơi n&agrave;o một c&aacute;ch dễ d&agrave;ng với sang trọng với Keyring charger</p>\r\n<p>- Đồng bộ ho&agrave;n hảo c&aacute;c thiệt bị hỗ trợ cho iPhone hoặc iPad của bạn d&ugrave; bạn đang trong văn ph&ograve;ng, ở nh&agrave;, hoặc đang di chuyển</p>\r\n<p>- Tương th&iacute;ch với hầu hết c&aacute;c thiệt bị hỗ trợ c&oacute; cổng USB</p>\r\n<p>- K&iacute;ch thước : như một chiếc ch&igrave;a kh&oacute;a nh&agrave;, Keyring Charger c&oacute; thể dễ d&agrave;ng bỏ v&agrave;o t&uacute;i x&aacute;ch, l&agrave;m d&acirc;y m&oacute;c kh&oacute;a, v&ograve;ng đeo tay, vv.</p>\r\n<p>- M&agrave;u sắc: v&agrave;ng, cam, hồng, xanh, trắng</p>','','','2017-10-26_Cáp USB cho iphone cam.png',1,99,72000,72000,72000,72000,'sup002',72,1,'2017-10-26 10:59:37','2017-10-30 14:57:15','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000444','Cáp Usb Cho Iphone','<p>T&iacute;nh Năng:</p>\r\n<p>- Sạc iPhone của bạn bất cứ nơi n&agrave;o một c&aacute;ch dễ d&agrave;ng với sang trọng với Keyring charger</p>\r\n<p>- Đồng bộ ho&agrave;n hảo c&aacute;c thiệt bị hỗ trợ cho iPhone hoặc iPad của bạn d&ugrave; bạn đang trong văn ph&ograve;ng, ở nh&agrave;, hoặc đang di chuyển</p>\r\n<p>- Tương th&iacute;ch với hầu hết c&aacute;c thiệt bị hỗ trợ c&oacute; cổng USB</p>\r\n<p>- K&iacute;ch thước : như một chiếc ch&igrave;a kh&oacute;a nh&agrave;, Keyring Charger c&oacute; thể dễ d&agrave;ng bỏ v&agrave;o t&uacute;i x&aacute;ch, l&agrave;m d&acirc;y m&oacute;c kh&oacute;a, v&ograve;ng đeo tay, vv.</p>\r\n<p>- M&agrave;u sắc: v&agrave;ng, cam, hồng, xanh, trắng</p>','','','2017-10-26_Cáp USB cho iphone hong.png',1,99,72000,72000,72000,72000,'sup002',72,1,'2017-10-26 11:00:52','2017-10-30 14:56:45','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000451','Cáp Usb Cho Iphone','<p>T&iacute;nh Năng:</p>\r\n<p>- Sạc iPhone của bạn bất cứ nơi n&agrave;o một c&aacute;ch dễ d&agrave;ng với sang trọng với Keyring charger</p>\r\n<p>- Đồng bộ ho&agrave;n hảo c&aacute;c thiệt bị hỗ trợ cho iPhone hoặc iPad của bạn d&ugrave; bạn đang trong văn ph&ograve;ng, ở nh&agrave;, hoặc đang di chuyển</p>\r\n<p>- Tương th&iacute;ch với hầu hết c&aacute;c thiệt bị hỗ trợ c&oacute; cổng USB</p>\r\n<p>- K&iacute;ch thước : như một chiếc ch&igrave;a kh&oacute;a nh&agrave;, Keyring Charger c&oacute; thể dễ d&agrave;ng bỏ v&agrave;o t&uacute;i x&aacute;ch, l&agrave;m d&acirc;y m&oacute;c kh&oacute;a, v&ograve;ng đeo tay, vv.</p>\r\n<p>- M&agrave;u sắc: v&agrave;ng, cam, hồng, xanh, trắng</p>','','','2017-10-26_Cáp USB cho iphone trang.png',1,99,72000,72000,72000,72000,'sup002',72,1,'2017-10-26 11:01:55','2017-10-30 14:56:15','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000468','Cáp Usb Cho Iphone','<p>T&iacute;nh Năng:</p>\r\n<p>- Sạc iPhone của bạn bất cứ nơi n&agrave;o một c&aacute;ch dễ d&agrave;ng với sang trọng với Keyring charger</p>\r\n<p>- Đồng bộ ho&agrave;n hảo c&aacute;c thiệt bị hỗ trợ cho iPhone hoặc iPad của bạn d&ugrave; bạn đang trong văn ph&ograve;ng, ở nh&agrave;, hoặc đang di chuyển</p>\r\n<p>- Tương th&iacute;ch với hầu hết c&aacute;c thiệt bị hỗ trợ c&oacute; cổng USB</p>\r\n<p>- K&iacute;ch thước : như một chiếc ch&igrave;a kh&oacute;a nh&agrave;, Keyring Charger c&oacute; thể dễ d&agrave;ng bỏ v&agrave;o t&uacute;i x&aacute;ch, l&agrave;m d&acirc;y m&oacute;c kh&oacute;a, v&ograve;ng đeo tay, vv.</p>\r\n<p>- M&agrave;u sắc: v&agrave;ng, cam, hồng, xanh, trắng</p>','','','2017-10-26_Cáp USB cho iphone vang.png',1,99,72000,72000,72000,72000,'sup002',72,1,'2017-10-26 11:02:49','2017-10-30 14:55:48','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000475','Cáp Usb Cho Iphone','<p>T&iacute;nh Năng:</p>\r\n<p>- Sạc iPhone của bạn bất cứ nơi n&agrave;o một c&aacute;ch dễ d&agrave;ng với sang trọng với Keyring charger</p>\r\n<p>- Đồng bộ ho&agrave;n hảo c&aacute;c thiệt bị hỗ trợ cho iPhone hoặc iPad của bạn d&ugrave; bạn đang trong văn ph&ograve;ng, ở nh&agrave;, hoặc đang di chuyển</p>\r\n<p>- Tương th&iacute;ch với hầu hết c&aacute;c thiệt bị hỗ trợ c&oacute; cổng USB</p>\r\n<p>- K&iacute;ch thước : như một chiếc ch&igrave;a kh&oacute;a nh&agrave;, Keyring Charger c&oacute; thể dễ d&agrave;ng bỏ v&agrave;o t&uacute;i x&aacute;ch, l&agrave;m d&acirc;y m&oacute;c kh&oacute;a, v&ograve;ng đeo tay, vv.</p>\r\n<p>- M&agrave;u sắc: v&agrave;ng, cam, hồng, xanh, trắng</p>','','','2017-10-26_Cáp USB cho iphone xanh duong.png',1,99,72000,72000,72000,72000,'sup002',72,1,'2017-10-26 11:03:43','2017-10-30 14:55:01','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000482','Tai Nghe Nhét Tai Amalen','<p>- Tương th&iacute;ch với tất cả c&aacute;c điện thoại đang c&oacute; tr&ecirc;n thị trường hiện nay</p>\r\n<p>- Sử dụng đầu cấm 3.5mm th&ocirc;ng dụng</p>\r\n<p>- &Acirc;m Thanh trung thực , tai nghe c&oacute; n&uacute;t cao su gi&uacute;p giảm tạp &acirc;m từ b&ecirc;n ho&agrave;i</p>\r\n<p>- Tai nghe c&ograve;n trang bị th&ecirc;m mic t&iacute;ch hợp chung với phần chỉnh &acirc;m lượng ,gi&uacute;p bạn c&oacute; thể nghe điện thoại 1 c&aacute;ch dễ d&agrave;ng .</p>\r\n<p>- Tai nghe nhỏ gọn ,phần n&uacute;t cao su gi&uacute;p giữ tai nghe kh&ocirc;ng bị rơi ra khỏi tai ,thuận tiện để đeo khi chạy bộ ,tập thể dục .</p>\r\n<p>M&agrave;u sắc:&nbsp; Trắng.</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 9MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS &plusmn; 15%</p>\r\n<p>&bull; Độ nhạy: 100 &plusmn; 5dB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M &plusmn; 15%</p>','2017-10-26_f3a7c399-f172-4f70-b703-76d25aee6cbf.png',1,99,163000,163000,163000,163000,'sup002',72,1,'2017-10-26 11:25:44','2017-10-30 14:54:05','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000499','Tai Nghe Cao Cấp TN1','<p>- Tương th&iacute;ch với tất cả c&aacute;c điện thoại đang c&oacute; tr&ecirc;n thị trường hiện nay</p>\r\n<p>- Sử dụng đầu cấm 3.5mm th&ocirc;ng dụng</p>\r\n<p>- &Acirc;m Thanh trung thực , tai nghe c&oacute; n&uacute;t cao su gi&uacute;p giảm tạp &acirc;m từ b&ecirc;n ho&agrave;i</p>\r\n<p>- Tai nghe c&ograve;n trang bị th&ecirc;m mic t&iacute;ch hợp chung với phần chỉnh &acirc;m lượng ,gi&uacute;p bạn c&oacute; thể nghe điện thoại 1 c&aacute;ch dễ d&agrave;ng .</p>\r\n<p>- Tai nghe nhỏ gọn ,phần n&uacute;t cao su gi&uacute;p giữ tai nghe kh&ocirc;ng bị rơi ra khỏi tai ,thuận tiện để đeo khi chạy bộ ,tập thể dục .</p>\r\n<p>M&agrave;u sắc:&nbsp; Trắng, đen, đỏ</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 9MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS &plusmn; 15%</p>\r\n<p>&bull; Độ nhạy: 100 &plusmn; 5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M &plusmn; 15%</p>','2017-10-26_2a16c1a4-453d-47eb-91b4-b457f1d9d098.png',1,99,131000,131000,131000,131000,'sup002',72,1,'2017-10-26 11:35:41','2017-10-30 14:53:29','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000505','Tai Nghe Cao Cấp TN1','<p>- Tương th&iacute;ch với tất cả c&aacute;c điện thoại đang c&oacute; tr&ecirc;n thị trường hiện nay</p>\r\n<p>- Sử dụng đầu cấm 3.5mm th&ocirc;ng dụng</p>\r\n<p>- &Acirc;m Thanh trung thực , tai nghe c&oacute; n&uacute;t cao su gi&uacute;p giảm tạp &acirc;m từ b&ecirc;n ho&agrave;i</p>\r\n<p>- Tai nghe c&ograve;n trang bị th&ecirc;m mic t&iacute;ch hợp chung với phần chỉnh &acirc;m lượng ,gi&uacute;p bạn c&oacute; thể nghe điện thoại 1 c&aacute;ch dễ d&agrave;ng .</p>\r\n<p>- Tai nghe nhỏ gọn ,phần n&uacute;t cao su gi&uacute;p giữ tai nghe kh&ocirc;ng bị rơi ra khỏi tai ,thuận tiện để đeo khi chạy bộ ,tập thể dục .</p>\r\n<p>M&agrave;u sắc:&nbsp; Trắng, đen, đỏ</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 9MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS &plusmn; 15%</p>\r\n<p>&bull; Độ nhạy: 100 &plusmn; 5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M &plusmn; 15%</p>','2017-10-26_06a3f76f-cd4a-4b65-a830-ce5f364972c5.png',1,99,131000,131000,131000,131000,'sup002',72,1,'2017-10-26 11:37:04','2017-10-30 14:53:00','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000512','Tai Nghe Cao Cấp TN1','<p>- Tương th&iacute;ch với tất cả c&aacute;c điện thoại đang c&oacute; tr&ecirc;n thị trường hiện nay</p>\r\n<p>- Sử dụng đầu cấm 3.5mm th&ocirc;ng dụng</p>\r\n<p>- &Acirc;m Thanh trung thực , tai nghe c&oacute; n&uacute;t cao su gi&uacute;p giảm tạp &acirc;m từ b&ecirc;n ho&agrave;i</p>\r\n<p>- Tai nghe c&ograve;n trang bị th&ecirc;m mic t&iacute;ch hợp chung với phần chỉnh &acirc;m lượng ,gi&uacute;p bạn c&oacute; thể nghe điện thoại 1 c&aacute;ch dễ d&agrave;ng .</p>\r\n<p>- Tai nghe nhỏ gọn ,phần n&uacute;t cao su gi&uacute;p giữ tai nghe kh&ocirc;ng bị rơi ra khỏi tai ,thuận tiện để đeo khi chạy bộ ,tập thể dục .</p>\r\n<p>M&agrave;u sắc:&nbsp; Trắng, đen, đỏ</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 9MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS &plusmn; 15%</p>\r\n<p>&bull; Độ nhạy: 100 &plusmn; 5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M &plusmn; 15%</p>','2017-10-26_6cac1fc8-b81a-4d69-b21a-56ca5d7b771b.png',1,99,131000,131000,131000,131000,'sup002',72,1,'2017-10-26 11:38:16','2017-10-30 14:52:19','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000529','Tai Nghe Cao Cấp TN2','<p>- Tương th&iacute;ch với tất cả c&aacute;c điện thoại đang c&oacute; tr&ecirc;n thị trường hiện nay</p>\r\n<p>- Sử dụng đầu cấm 3.5mm th&ocirc;ng dụng</p>\r\n<p>- &Acirc;m Thanh trung thực , tai nghe c&oacute; n&uacute;t cao su gi&uacute;p giảm tạp &acirc;m từ b&ecirc;n ho&agrave;i</p>\r\n<p>- Tai nghe c&ograve;n trang bị th&ecirc;m mic t&iacute;ch hợp chung với phần chỉnh &acirc;m lượng ,gi&uacute;p bạn c&oacute; thể nghe điện thoại 1 c&aacute;ch dễ d&agrave;ng .</p>\r\n<p>- Tai nghe nhỏ gọn ,phần n&uacute;t cao su gi&uacute;p giữ tai nghe kh&ocirc;ng bị rơi ra khỏi tai ,thuận tiện để đeo khi chạy bộ ,tập thể dục .</p>\r\n<p>M&agrave;u sắc:&nbsp; Trắng, đỏ</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>&bull; Đường k&iacute;nh 1 b&ecirc;n tai nghe: 9MM</p>\r\n<p>&bull; Tần số : 20 &ndash; 20KHZ</p>\r\n<p>&bull; Trở kh&aacute;ng loa: 16 OHMS &plusmn; 15%</p>\r\n<p>&bull; Độ nhạy: 100 &plusmn; 5DB</p>\r\n<p>&bull; K&iacute;ch thước jack: 3.5MM mạ v&agrave;ng</p>\r\n<p>&bull; Độ d&agrave;i d&acirc;y tai nghe: 1.2M &plusmn; 15%</p>','2017-10-26_tai nghe nhét tai_ 180,000.png',1,99,174000,174000,174000,174000,'sup002',72,1,'2017-10-26 11:41:22','2017-10-30 14:51:46','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000536','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>','2018-03-21_vong-deo-tay-thong-minh-fitness-tracker-ax1.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:13:33','2018-03-21 12:48:59','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000543','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>\r\n<p>--</p>','2018-03-21_vong-deo-tay-thong-minh-fitness-tracker-ax12.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:15:12','2018-03-21 12:49:23','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000550','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>','2017-10-26_Vòng đeo tay thông minh Fitness Tracker AX1 3.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:16:45','2017-10-30 14:41:46','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000567','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>','2017-10-26_Vòng đeo tay thông minh Fitness Tracker AX1 5.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:18:26','2017-10-30 14:41:15','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000574','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>\r\n<p>--</p>','2018-03-21_vong-deo-tay-thong-minh-fitness-tracker-ax1.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:19:27','2018-03-21 11:51:17','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000581','Vòng đeo tay thông minh AX1','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- Xem giờ</p>\r\n<p>- Đo nhịp tim</p>\r\n<p>-&nbsp; &nbsp; &nbsp; &nbsp;Đo số bước ch&acirc;n</p>\r\n<p>Pin siếu tốt&nbsp;</p>\r\n<p>Thiết bị kết nối: Android 4.0 &amp; IOS 7.0 trở l&ecirc;n</p>','','<p>&bull; ACTIVITY TRACKER AX1&nbsp; c&oacute; đầy đủ chức năng trong những chiếc v&ograve;ng đeo tay th&ocirc;ng minh được b&aacute;n hiện nay tr&ecirc;n thị trường.</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; ACTIVITY TRACKER AX1 c&oacute; thời gian chờ pin cực khủng li&ecirc;n tục từ 5-7 ng&agrave;y. Đặc biệt, khi kết nối v&ograve;ng đeo tay th&ocirc;ng minh với điện thoại, sẽ hiển thị cảnh b&aacute;o dung lượng pin dự ph&ograve;ng c&ograve;n lại bao nhi&ecirc;u ngay tr&ecirc;n smartphone.</p>\r\n<p>C&oacute; nhiều m&agrave;u v&agrave; hoa văn như tr&ecirc;n h&igrave;nh</p>\r\n<p>--</p>','2018-03-21_vong-deo-tay-thong-minh-fitness-tracker-ax1.png',1,99,417000,417000,417000,417000,'sup003',76,1,'2017-10-26 14:20:27','2018-03-21 11:49:43','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000598','Vòng đeo tay thông minh i5 plus','<p>M&agrave;u sắc:&nbsp; &nbsp;Đỏ, Xanh dương, Đen.</p>','','<p>Chức Năng Ch&iacute;nh :</p>\r\n<p>- B&aacute;o cuộc gọi đến, tin nhắn, zalo, facebook, viber, email...</p>\r\n<p>- Đếm bước đi, bước nhảy: ngoải ra c&oacute; thể đặt ra mục ti&ecirc;u số bước đi cần đi trong ng&agrave;y.</p>\r\n<p>- Ph&acirc;n t&iacute;ch giấc ngủ:Ph&acirc;n t&iacute;ch giấc ngủ (deep sleep v&agrave; light sleep). Rất hay cho những ai muốn cải thiện giấc ngủ v&agrave; tập Polyphasic sleep.</p>\r\n<p>- Đặt giờ b&aacute;o thức</p>\r\n<p>- B&aacute;o cuộc gọi gọi tới: sử dụng khi đi đường, ph&ograve;ng họp, ...</p>\r\n<p>- Chống nước theo ti&ecirc;u chuẩn IP67 (c&ugrave;ng chuẩn với d&ograve;ng Z Xperia của Sony): tắm rửa thoải m&aacute;i</p>\r\n<p>- Pin siếu tốt k&eacute;o d&agrave;i l&ecirc;n tới 7 ng&agrave;y.</p>\r\n<p>- Thiết bị kết nối: Android 4.0 trở l&ecirc;n &amp; IOS 7.0 trở l&ecirc;n.</p>\r\n<p>* Lưu &yacute;: Qu&yacute; kh&aacute;ch kh&ocirc;ng được update sản phẩm, sản phẩm update sẽ dẫn đến kh&ocirc;ng kết nối dc bluetooth v&agrave; b&ecirc;n nh&agrave; sản xuất sẽ kh&ocirc;ng bảo h&agrave;nh.</p>','2017-10-26_Vòng đeo tay thông minh i5 Plus 2.png',1,99,617000,617000,617000,617000,'sup003',76,1,'2017-10-26 14:24:14','2017-10-30 14:39:32','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000604','Vòng đeo tay thông minh AX-G8','<p>&nbsp;- Được chế tạo với m&agrave;n h&igrave;nh tr&ograve;n 1.2 inch đơn giản tr&ocirc;ng gi&ocirc;́ng như những chiếc đồng hồ truyền thống. T&iacute;nh năng thay đổi t&ugrave;y biến mặt đồng hồ kết hợp với d&acirc;y đeo kim loại gi&uacute;p bạn tự do thể hiện c&aacute; t&iacute;nh.&nbsp;</p>\r\n<p>Bạn lu&ocirc;n c&oacute; một thiết bị th&ocirc;ng b&aacute;o t&uacute;c trực tr&ecirc;n cổ tay v&agrave; c&oacute; thể theo d&otilde;i nhịp tim, chỉ số calories, huyết &aacute;p, đo số bước ch&acirc;n,.....&nbsp;</p>','','<p>Th&ocirc;ng số kỹ thuật:</p>\r\n<p>CPU: nordic nRF51822</p>\r\n<p>Cảm biến: KXT J2-1009</p>\r\n<p>Cảm biến HR: PD70-01C-TR7</p>\r\n<p>M&agrave;n h&igrave;nh: M&agrave;n h&igrave;nh OLED 0,95 \'\'</p>\r\n<p>Bluetooth: BLE4.0</p>\r\n<p>Bộ nhớ: 32KB + 256KB</p>\r\n<p>Ti&ecirc;u chuẩn đ&oacute;ng g&oacute;i: 1 d&acirc;y đeo cổ tay, 1 c&aacute;p sạc, 1 hướng dẫn sử dụng, 1 gift box.</p>','2017-10-26_Đồng hồ thông minh AX-G8 2.png',1,99,1043000,1043000,1043000,1043000,'sup003',76,1,'2017-10-26 14:32:16','2017-10-30 14:38:56','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000611','Đồng hồ định vị trẻ em AX-G1','<p>M&agrave;u sắc:&nbsp; &nbsp;xanh biển v&agrave; hồng</p>','','<p>Th&ocirc;ng số sản phẩm:</p>\r\n<p>Chức năng: M&agrave;n h&igrave;nh cảm ứng đầy m&agrave;u sắc</p>\r\n<p>Định vị: GPS, LBS v&agrave; WiFi</p>\r\n<p>Chức năng: Trợ gi&uacute;p khẩn cấp SOS, Giao tiếp k&eacute;p, M&aacute;y ảnh từ xa,Gi&aacute;m s&aacute;t từ xa, Chống thấm nước , B&aacute;o thức, Hiển thị ng&agrave;y v&agrave; giờ.</p>\r\n<p>Trường hợp Chất liệu: Nhựa</p>\r\n<p>&nbsp;Chất liệu: Cao su</p>\r\n<p>T&ugrave;y chỉnh: C&oacute;</p>','2017-10-26_Đồng hồ định vị cho trẻ em AX-G1 (xanh duong).png',1,99,966000,966000,966000,966000,'sup003',76,1,'2017-10-26 14:35:00','2017-10-30 15:12:47','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000628','Đồng hồ định vị trẻ em AX-G1','<p>M&agrave;u sắc:&nbsp; &nbsp; &nbsp;xanh biển v&agrave; hồng</p>','','<p>Th&ocirc;ng số sản phẩm:</p>\r\n<p>Chức năng: M&agrave;n h&igrave;nh cảm ứng đầy m&agrave;u sắc</p>\r\n<p>Định vị: GPS, LBS v&agrave; WiFi</p>\r\n<p>Chức năng: Trợ gi&uacute;p khẩn cấp SOS, Giao tiếp k&eacute;p, M&aacute;y ảnh từ xa,Gi&aacute;m s&aacute;t từ xa, Chống thấm nước , B&aacute;o thức, Hiển thị ng&agrave;y v&agrave; giờ.</p>\r\n<p>Trường hợp Chất liệu: Nhựa</p>\r\n<p>&nbsp;Chất liệu: Cao su</p>\r\n<p>T&ugrave;y chỉnh: C&oacute;</p>','2017-10-26_Đồng hồ định vị cho trẻ em AX-G1 (hong).png',1,99,966000,966000,966000,966000,'sup003',76,1,'2017-10-26 14:36:53','2017-10-30 14:37:53','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000635','Đồng hồ định vị trẻ em AX-G1B','<p>Packaging:&nbsp;</p>\r\n<p>1 x Đồng hồ GPS&nbsp;</p>\r\n<p>1 x D&acirc;y c&aacute;p USB&nbsp;</p>\r\n<p>1 x Hướng dẫn sử dụng bắng Tiếng Anh</p>','','<p>Đ&acirc;y l&agrave; loại h&igrave;nh đ&ograve;ng hồ cho trẻ em mới nhất mang 2 m&agrave;u xanh, đỏ. Đ&acirc;y kh&ocirc;ng đơn giản l&agrave; một chiếc đồng hồ đeo tay b&igrave;nh thường, kh&ocirc;ng chỉ mang kiểu d&aacute;ng thu h&uacute;t sở th&iacute;ch con trẻ m&agrave; c&ograve;n thể gi&uacute;p cha mẹ li&ecirc;n lạc được với con trẻ bất cứ l&uacute;c n&agrave;o, thậm ch&iacute; l&agrave; kiểm so&aacute;t từng hoạt động ch&uacute;ng.&nbsp;</p>\r\n<p>&bull; Cha mẹ c&oacute; thể gọi cho trẻ về nh&agrave; khi đến giờ ăn tối&nbsp;</p>\r\n<p>&bull; Gọi cho con trẻ khi nhớ ch&uacute;ng m&agrave; kh&ocirc;ng g&acirc;y ra ch&uacute;t phiền to&aacute;i n&agrave;o;</p>\r\n<p>&bull; Lu&ocirc;n x&aacute;c định được vị tr&iacute; con trẻ khi ch&uacute;ng ra ngo&agrave;i chơi;</p>\r\n<p>&bull; Khi con trẻ đến trường, cha mẹ c&oacute; thể tạo ra 1 v&ugrave;ng an to&agrave;n, khi ch&uacute;ng rời khỏi v&ugrave;ng an to&agrave;n đ&oacute;, cha mẹ sẽ lập tức nhận được 1 cảnh b&aacute;o;&nbsp;</p>\r\n<p>&bull; Khi con trẻ gặp nguy hiểm, ch&uacute;ng c&oacute; thể nhấn n&uacute;t gọi cho cha mẹ.</p>\r\n<p>Sạc pin：Sạc USB，Li-Battery 380mAh</p>\r\n<p>- Th&ocirc;ng số sản phẩm:</p>\r\n<p>Chức năng: M&agrave;n h&igrave;nh cảm ứng đầy m&agrave;u sắc</p>\r\n<p>Định vị: GPS, LBS v&agrave; WiFi</p>\r\n<p>Chức năng: Trợ gi&uacute;p khẩn cấp SOS, Giao tiếp k&eacute;p, M&aacute;y ảnh từ xa,Gi&aacute;m s&aacute;t từ xa, Chống thấm nước , B&aacute;o thức, Hiển thị ng&agrave;y v&agrave; giờ.</p>\r\n<p>Trường hợp Chất liệu: Nhựa</p>\r\n<p>&nbsp;Chất liệu: Cao su</p>\r\n<p>T&ugrave;y chỉnh: C&oacute;</p>\r\n<p>&nbsp;</p>','2018-03-21_op-lung-iphone-cam.png',1,99,1428000,1428000,1428000,1428000,'sup003',76,1,'2017-10-26 14:41:48','2018-03-21 12:45:10','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000642','Ổ cắm WIFI - S1','','<p>- Để điều khiển được thiết bị bạn cần tải ứng dụng&nbsp; tr&ecirc;n điện thoại của Wifi&nbsp; Socket (t&ecirc;n ứng dụng c&oacute; ghi tr&ecirc;n tờ hướng sẫn sản phẩm) . Sau khi tải, mở ứng dụng l&ecirc;n sẽ thấy y&ecirc;u cầu nhập m&atilde; WIFI , bạn sẽ nhập m&atilde; WIFI mặc định của sản phẩm v&agrave;o ,sau đ&oacute; đợi kết nối. Lưu &yacute;: điện thoại phải c&oacute; kết nối wifi ,3G,4G.</p>\r\n<p>- Ngo&agrave;i Chức năng điều khiển bật tắt ,c&ograve;n c&oacute; thể hẹn thời gian cho thiết bị. Bạn cũng c&oacute; thể tắt thiết bị trực tiếp bằng c&aacute;ch nhấn n&uacute;t tr&ecirc;n Wifi Socket.</p>\r\n<p>- Smart Wifi Socket kh&ocirc;ng bị giới hạn thiết bị kết nối ,bạn c&oacute; thể thay thế tất cả c&aacute;c ổ cắm trong nh&agrave; bạn v&agrave; điều khiển chỉ với thao t&aacute;c nhỏ tr&ecirc;n điện thoại th&ocirc;ng minh .</p>\r\n<p>&nbsp;</p>\r\n<p>&nbsp;</p>','<p>&bull; Ổ cắm WIFI với điều khiển từ xa IR.&nbsp;</p>\r\n<p>&bull; Wi-Fi kết nối ổ cắm Bluetooth để hoạt động.&nbsp;</p>\r\n<p>&bull; Bật điện tử hoặc tắt - từ bất cứ nơi n&agrave;o.&nbsp;</p>\r\n<p>&bull; Hoạt động qua Wi-Fi v&agrave; h&igrave;nh thức m&atilde; IR, tại nh&agrave; v&agrave; khi ra khỏi nh&agrave;.&nbsp;</p>\r\n<p>&bull; Đặt thiết bị điện tử của bạn tr&ecirc;n một lịch tr&igrave;nh.&nbsp;</p>\r\n<p>&bull; Hệ thống m&ocirc;-đun, bạn c&oacute; thể bổ sung th&ecirc;m ổ cắm AIMOX dễ d&agrave;ng, bất cứ l&uacute;c n&agrave;o.&nbsp;</p>\r\n<p>&bull; Kiểm so&aacute;t nh&agrave; bạn nhiều hay &iacute;t t&ugrave;y &yacute;.&nbsp;</p>\r\n<p>&bull; N&uacute;t thao t&aacute;c đơn giản.&nbsp;</p>\r\n<p>&bull; Ổ cắm thiết kế độc nhất.&nbsp;</p>\r\n<p>&bull; Nh&agrave; ở vững chắc.&nbsp;</p>\r\n<p>&bull; Trực quan, dễ thiết lập.&nbsp;</p>\r\n<p>&bull; Dễ sử dụng.&nbsp;</p>\r\n<p>&bull; Thực tiễn v&agrave; linh hoạt.&nbsp;</p>\r\n<p>&nbsp;</p>\r\n<p>&bull; Ứng dụng miễn ph&iacute; được cung cấp.</p>','2018-03-21_op-lung-iphone-cam.png',1,99,383000,383000,383000,383000,'sup003',76,1,'2017-10-26 14:46:26','2018-03-21 12:44:54','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000659','Bóng Đèn Wifi B1 Plus','','','<p>- Kh&ocirc;ng như đ&egrave;n chiếu s&aacute;ng th&ocirc;ng thường , Wifi Light l&agrave; đ&egrave;n chiếu s&aacute;ng được trang bị b&oacute;ng LED v&agrave; được điều khiển từ xa th&ocirc;ng qua ứng dụng tr&ecirc;n điện thoại .</p>\r\n<p>- Tương th&iacute;ch với c&aacute;c điện thoại Smartphone sử dụng hệ điều h&agrave;nh Android v&agrave; IOS</p>\r\n<p>- Để điều khiển được thiết bị bạn cần tải ứng dụng quản l&yacute; tr&ecirc;n điện thoại của Wifi Light&nbsp; (t&ecirc;n ứng dụng c&oacute; ghi tr&ecirc;n tờ hướng sẫn sản phẩm) . Sau khi tải, mở ứng dụng l&ecirc;n sẽ thấy y&ecirc;u cầu nhập m&atilde; Wifi, bạn sẽ nhập m&atilde; Wifi mặc định của sản phẩm v&agrave;o ,sau đ&oacute; đợi kết nối.&nbsp;</p>\r\n<p>Lưu &yacute;: điện thoại phải c&oacute; kết nối wifi ,3G,4G</p>\r\n<p>- Ngo&agrave;i Chức năng điều khiển bật tắt ,c&ograve;n c&oacute; thể hẹn thời gian cho thiết bị gi&uacute;p tiết kiệm điện cho ng&ocirc;i nh&agrave; th&acirc;n y&ecirc;u của bạn v&agrave; c&oacute; thể điều khiển v&ocirc; số m&agrave;u sắc của đ&egrave;n trực tiếp&nbsp; tr&ecirc;n điện thoại của bạn.</p>\r\n<p>- Wifi Light kh&ocirc;ng bị giới hạn thiết bị kết nối ,bạn c&oacute; thể thay thế tất cả c&aacute;c thiết bị ph&aacute;t s&aacute;ng trong nh&agrave; bạn v&agrave; điều khiển chỉ với thao t&aacute;c nhỏ tr&ecirc;n điện thoại th&ocirc;ng minh .</p>','2017-10-26_bong den wifi B1 Plus 1.png',1,99,337000,337000,337000,337000,'sup003',76,1,'2017-10-26 14:48:30','2017-10-30 14:36:25','quan.hh@vinhsangvn.com','quan.hh@vinhsangvn.com',1),('8930002000666','IP Camera','<p><span style=\"color: #333333; font-family: Arial, sans-serif;\">+ C&oacute; thể kết nối với Camera bằng nhiều thiết bị th&ocirc;ng qua ứng dụng tr&ecirc;n điện thoại&nbsp;</span></p>\r\n<p style=\"margin-top: 0px; margin-bottom: 10px; background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\">+ Kh&ocirc;ng cần mất th&ecirc;m chi ph&iacute; n&agrave;o kh&aacute;c ,chỉ cần tải ứng dụng về v&agrave; sử dụng.</p>\r\n<p style=\"margin-top: 0px; margin-bottom: 10px; background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\">- Chất lượng h&igrave;nh ảnh sắc n&eacute;t.</p>\r\n<p style=\"margin-top: 0px; margin-bottom: 10px; background-repeat: initial; outline: 0px; vertical-align: top; color: #333333; font-family: Arial, sans-serif;\">- Điều chỉnh hướng xoay 360o</p>','','<p>Kh&aacute;c với c&aacute;c loại camera th&ocirc;ng thường ,bạn phải cắm d&acirc;y ,kết nối ,c&agrave;i đặt, rất nhiều c&aacute;c bước rườm r&agrave;, kh&oacute; di chuyển. IP Camera sẽ khắc phục được c&aacute;c khuyết điểm của camera truyền thống ,dễ d&agrave;ng c&agrave;i đặt v&agrave; sử dụng .</p>\r\n<p>- Điểm nội bật của IP Camera:&nbsp;</p>\r\n<p>+ C&oacute; thể kết nối với Camera bằng nhiều thiết bị th&ocirc;ng qua ứng dụng tr&ecirc;n điện thoại&nbsp;</p>\r\n<p>+ Kh&ocirc;ng cần mất th&ecirc;m chi ph&iacute; n&agrave;o kh&aacute;c ,chỉ cần tải ứng dụng về v&agrave; sử dụng.</p>\r\n<p>- Chất lượng h&igrave;nh ảnh sắc n&eacute;t.</p>\r\n<p>- Điều chỉnh hướng xoay 360o</p>','2017-10-26_ip camera 4.png',1,99,1353000,1353000,1353000,1353000,'sup003',5,1,'2017-10-26 14:50:53','2017-11-22 08:08:03','quan.hh@vinhsangvn.com','admin@gmail.com',1),('8930002000710','Máy cảm biến hồng ngoại Infrared sensor - AX-H-IR','<p>- Bộ điều phối Zigbee HA1.2, c&oacute; t&iacute;nh tương th&iacute;ch tốt;</p>\r\n<p>- Khả năng ti&ecirc;u hao năng lượng thấp, tuổi thọ pin l&ecirc;n đến 18 th&aacute;ng;</p>\r\n<p>- C&oacute; hiệu quả trong việc ngăn ngừa thiết bị d&ograve; t&igrave;m b&aacute;o động nhầm;</p>\r\n<p>- Nhắc nhở v&agrave; b&aacute;o động khi điện &aacute;p pin ở dưới mức quy định;</p>\r\n<p>- D&aacute;n l&ecirc;n bất kỳ nơi n&agrave;o v&agrave; c&oacute; thể sử dụng liền;</p>\r\n<p>- T&iacute;nh năng chống th&aacute;o gỡ pin;</p>\r\n<p>- Theo d&otilde;i v&agrave; gi&aacute;m s&aacute;t trực tuyến</p>\r\n<p>- Chất liệu: ABS+PC Nhựa ABS+PC</p>\r\n<p>-&nbsp;C&ocirc;ng suất 3V, tuổi thọ pin 18 th&aacute;ng.</p>\r\n<p>-&nbsp;Độ nhạy: phạm vị 12m, g&oacute;c ph&aacute;t hiện 90 độ.</p>','','<p>Cảm biến chuyển động hồng ngoại cơ thể người.</p>','2018-05-16_AX-H-IR.png',6,99,516000,516000,0,0,'sup003',78,1,'2018-05-16 11:43:56','2018-07-12 09:02:58','admin@gmail.com','admin@gmail.com',1),('8930002000727','Máy cảm biến nhiệt độ/độ ẩm AX-H-HT','<p>- Bộ điều phối Zigbee HA1.2;</p>\r\n<p>- Khả năng ti&ecirc;u thụ năng lượng rất thấp, thời gian sử dụng pin d&agrave;i hơn;</p>\r\n<p>- Sử dụng bộ cảm biến bằng số c&oacute; độ ch&iacute;nh x&aacute;c cao;</p>\r\n<p>- Nhắc nhở v&agrave; cảnh b&aacute;o khi điện &aacute;p pin ở dưới mức quy định;</p>\r\n<p>- Dễ d&agrave;ng th&aacute;o l&aacute;p, thay pin;</p>\r\n<p>- D&aacute;n l&ecirc;n bất kỳ nơi n&agrave;o v&agrave; c&oacute; thể sử dụng liền.</p>\r\n<p>- Chất liệu: ABS+PC Nhựa ABS+PC.</p>\r\n<p>-&nbsp;C&ocirc;ng suất 3V, tuổi thọ pin 12 th&aacute;ng.</p>\r\n<p>-&nbsp;Độ nhạy: -20-120 ℃, 0-100%.</p>\r\n<p>&nbsp;</p>','','<p>B&aacute;o động nhiệt độ v&agrave; độ ẩm.</p>','2018-05-16_AX-H-HT.png',6,99,512000,512000,0,0,'sup003',78,1,'2018-05-16 11:49:52','2018-07-12 08:49:24','admin@gmail.com','admin@gmail.com',1),('8930002000734','Máy cảm biến cửa từ AX-H-DL','<p>- Bộ điều phối Zigbee HA1.2;</p>\r\n<p>- Khả năng ti&ecirc;u hao năng lượng kh&aacute; thấp, tuổi thọ pin l&ecirc;n đến 24 th&aacute;ng;</p>\r\n<p>- Gi&aacute;m s&aacute;t trực tiếp;</p>\r\n<p>- Sử dụng 2 bộ phận đ&oacute;ng mở cửa, th&iacute;ch hợp d&ugrave;ng cho c&aacute;c c&aacute;nh cửa ở những hướng kh&aacute;c nhau;</p>\r\n<p>- Nhắc nhở v&agrave; b&aacute;o động khi điện &aacute;p pin ở dưới mức quy định;</p>\r\n<p>- C&oacute; thể d&aacute;n ở bất kỳ nơi n&agrave;o v&agrave; sử dụng liền.</p>\r\n<p>- Chất liệu: ABS+PC Nhựa ABS+PC.</p>\r\n<p>-&nbsp;C&ocirc;ng suất 3V, tuổi thọ pin 24 th&aacute;ng.</p>\r\n<p>-&nbsp;Độ nhạy: phạm vi 15m.</p>','','','2018-05-16_AX-H-DL.png',6,99,482000,482000,0,0,'sup003',78,1,'2018-05-16 11:52:37','2018-07-12 08:48:18','admin@gmail.com','admin@gmail.com',1),('8930002000741','Máy cảm biến báo động ngập nước AX-H-W1','<p>- Bộ điều phối Zigbee HA1.2;</p>\r\n<p>- Khả năng ti&ecirc;u hao năng lượng thấp, tuổi thọ pin l&ecirc;n đến 24 th&aacute;ng;</p>\r\n<p>- Nhắc nhở v&agrave; b&aacute;o động khi điện &aacute;p pin ở dưới mức quy định;</p>\r\n<p>- Dễ d&agrave;ng th&aacute;o l&aacute;p, thay pin;</p>\r\n<p>- C&oacute; thể d&aacute;n ở bất kỳ nơi n&agrave;o v&agrave; sử dụng liền.</p>\r\n<p>- Chất liệu: ABS+PC Nhựa ABS+PC.</p>\r\n<p>-&nbsp;C&ocirc;ng suất 3V, tuổi thọ pin 12 th&aacute;ng.</p>','','<p>B&aacute;o động ngập nước.</p>','2018-05-16_AX-H-W1.png',6,99,512000,512000,0,0,'sup003',78,1,'2018-05-16 11:55:18','2018-07-12 08:46:57','admin@gmail.com','admin@gmail.com',1),('8930002000758','Cổng vào hổ trợ báo động Gateway - AX-H-HS','<p>- Gateway giao thức ZigBee, hỗ trợ b&aacute;o động bằng &acirc;m thanh v&agrave; &aacute;nh s&aacute;ng, nhắc nhở bằng giọng n&oacute;i, đ&egrave;n chiếu s&aacute;ng v&agrave;o ban đ&ecirc;m, điều khiển thiết bị bằng ZigBee;</p>\r\n<p>- Bộ điều phối ZigBee HA1.2;</p>\r\n<p>- Trang bị chức năng chiếu s&aacute;ng RGB.</p>\r\n<p>- Chất liệu: ABS+PC Nhựa ABS+PC.</p>\r\n<p>-&nbsp;C&ocirc;ng suất: AC100-240V.</p>','','','2018-05-16_AX-H-HS.png',6,99,1522000,1522000,0,0,'sup003',78,1,'2018-05-16 11:57:34','2018-07-12 09:04:34','admin@gmail.com','admin@gmail.com',1),('8930002000765','Ổ cắm thông minh Smart Socket - S1','<p>-&nbsp;Điều khiển bằng giọng n&oacute;i Wifi.</p>\r\n<p>- Chất liệu: PC Nhựa PC.</p>\r\n<p>&nbsp;</p>','','','2018-05-16_Socket-S1.png',6,99,0,2000000,0,0,'sup003',78,1,'2018-05-16 11:59:28','2018-05-17 11:07:04','admin@gmail.com','admin@gmail.com',0);
/*!40000 ALTER TABLE `tb_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_roles`
--

DROP TABLE IF EXISTS `tb_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_roles` (
  `id` varchar(40) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_roles`
--

LOCK TABLES `tb_roles` WRITE;
/*!40000 ALTER TABLE `tb_roles` DISABLE KEYS */;
INSERT INTO `tb_roles` VALUES ('ROLE_ADMIN','admin'),('ROLE_AGENTCN','agent china'),('ROLE_AGENTVI','agen vietnam'),('ROLE_MEMBER','member'),('ROLE_USER','user');
/*!40000 ALTER TABLE `tb_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_slide`
--

DROP TABLE IF EXISTS `tb_slide`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_slide` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(245) DEFAULT NULL,
  `image` varchar(245) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `creator` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_slide`
--

LOCK TABLES `tb_slide` WRITE;
/*!40000 ALTER TABLE `tb_slide` DISABLE KEYS */;
INSERT INTO `tb_slide` VALUES (15,'banner3','2017-10-24_vivmall_banner2.jpg','2017-10-24 11:26:57','admin@gmail.com'),(16,'banner2','2017-10-24_vivmall_banner1.jpg','2017-10-24 14:50:19','admin@gmail.com'),(22,'smart city','2018-04-20_900-450.jpg','2018-04-20 09:19:51','admin@gmail.com'),(23,'banner_smart_devices','2018-05-17_smart_devices_banner.jpg','2018-05-17 11:43:36','admin@gmail.com'),(24,'banner_khuyen_mai','2018-07-16_web banner-01.jpg','2018-07-16 14:55:49','admin@gmail.com'),(25,'big_sale','2018-10-23_big_sale.jpg','2018-10-23 16:57:06','admin@gmail.com');
/*!40000 ALTER TABLE `tb_slide` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_supplier`
--

DROP TABLE IF EXISTS `tb_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_supplier` (
  `id` char(6) NOT NULL,
  `SupplierName` varchar(145) DEFAULT NULL,
  `BusinessType` int(11) DEFAULT NULL,
  `Description` varchar(245) DEFAULT NULL,
  `Address` varchar(245) DEFAULT NULL,
  `Phone` varchar(15) DEFAULT NULL,
  `Email` varchar(145) DEFAULT NULL,
  `Website` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_supplier`
--

LOCK TABLES `tb_supplier` WRITE;
/*!40000 ALTER TABLE `tb_supplier` DISABLE KEYS */;
INSERT INTO `tb_supplier` VALUES ('sup001','Glorious Vietnam',1,'aaa','aaa','1243','aaa@gmail.com','vinhsang.com',1),('sup002','Made-in-China',2,'aaa','aa','1243','aaa@gmail.com','vinhsang.com',1),('sup003','korex',2,'korex','korex','1234','AX@chinakorex.com','http://www.chinakorex.com',1);
/*!40000 ALTER TABLE `tb_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_unit`
--

DROP TABLE IF EXISTS `tb_unit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_unit` (
  `id` int(3) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_unit`
--

LOCK TABLES `tb_unit` WRITE;
/*!40000 ALTER TABLE `tb_unit` DISABLE KEYS */;
INSERT INTO `tb_unit` VALUES (1,'Item','cái'),(2,'can','thùng'),(3,'pack','gói'),(4,'set','bộ'),(5,'bottle','chai'),(6,'piece','cái'),(7,'box','hop');
/*!40000 ALTER TABLE `tb_unit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user`
--

DROP TABLE IF EXISTS `tb_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(60) DEFAULT NULL,
  `FirstName` varchar(45) DEFAULT NULL,
  `LastName` varchar(45) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  `RegisterDate` datetime DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user`
--

LOCK TABLES `tb_user` WRITE;
/*!40000 ALTER TABLE `tb_user` DISABLE KEYS */;
INSERT INTO `tb_user` VALUES ('admin@gmail.com','$2a$10$eo3fwsiPzAd6VmPM6F3nhOJqA3WtDazEaIqkGdtNieWEd4.yQRPdO','admin first name','admin last name','2011-01-01 00:00:00','36 Trần Quý,Phường 06,Quận 11,TP.Hồ Chí Minh','02112',1,'2011-04-04 00:00:00'),('bongthoi1111@gmail.com','$2a$10$GGuOnKIoNT/XduI5/M8MiuuXdBv7W8b1F8gIcYmdyxDwiQzvoS89K','Van Thoi','Bong','2017-01-01 00:00:00','36 Trần Quý,Phường 06,Quận 11,TP.Hồ Chí Minh','11111111',1,'2017-11-16 14:53:39'),('linh.lhn@vinhsangvn.com','$2a$10$ymJcNJiKc3F.w43Ek4M6FOAaEfo7w5Hwkb.2xZEgMSf0KmMNs8Q8m','Nhật Linh','Lê Hoàng ','2017-01-01 00:00:00','aaaaaaa','11111111111',1,'2017-11-15 14:23:18'),('quan.hh@vinhsangvn.com','$2a$10$eo3fwsiPzAd6VmPM6F3nhOJqA3WtDazEaIqkGdtNieWEd4.yQRPdO','Quân','Quân','2011-01-01 00:00:00','asd','0211233333',1,'2011-04-04 00:00:00'),('test@gmail.com','$2a$10$HgkOEKBOQDd2Pj7sNoi03u4piW5D6Hp6WuIrIBEyqnp4wQkRR6JnO','demo','demo','1995-01-01 00:00:00','56a, hòa bình, phường 5, quận 11','123456789',1,'2018-10-23 17:32:41'),('vivmalldemo@gmail.com','$2a$10$8ugPz1nK5RdMWw4slFyTnucLpaWUP7ZD4dT86leBCcCOs7314DhM.','demo','vivmall','2017-01-01 00:00:00','56A Hòa Bình,Phường 05,Quận 11,TP.Hồ Chí Minh','028.62866208',1,'2017-11-28 09:24:03');
/*!40000 ALTER TABLE `tb_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_user_roles`
--

DROP TABLE IF EXISTS `tb_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_user_roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `role` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_user_roles`
--

LOCK TABLES `tb_user_roles` WRITE;
/*!40000 ALTER TABLE `tb_user_roles` DISABLE KEYS */;
INSERT INTO `tb_user_roles` VALUES (1,'quan.hh@vinhsangvn.com','ROLE_ADMIN'),(4,'admin@gmail.com','ROLE_ADMIN'),(27,'u1@gmail.com','ROLE_USER'),(30,'tung.pt@gmail.com','ROLE_USER'),(33,'tungphan995@gmail.com','ROLE_USER'),(34,'bongthoi1111@gmail.com','ROLE_USER'),(35,'linh.lhn@vinhsangvn.com','ROLE_ADMIN'),(36,'vivmalldemo@gmail.com','ROLE_USER'),(37,'test@gmail.com','ROLE_USER');
/*!40000 ALTER TABLE `tb_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_gridproduct`
--

DROP TABLE IF EXISTS `vw_gridproduct`;
/*!50001 DROP VIEW IF EXISTS `vw_gridproduct`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE VIEW `vw_gridproduct` AS SELECT 
 1 AS `id`,
 1 AS `ProductName`,
 1 AS `FeatureImage`,
 1 AS `Unit`,
 1 AS `BigUnit`,
 1 AS `CostPrice`,
 1 AS `SellPrice`,
 1 AS `SellPrice1`,
 1 AS `SellPrice2`,
 1 AS `CategoryId`,
 1 AS `BusinessType`,
 1 AS `SupplierId`,
 1 AS `CreateDate`,
 1 AS `UpdateDate`,
 1 AS `CreateUser`,
 1 AS `UpdateUser`,
 1 AS `enabled`,
 1 AS `BigUnitName`,
 1 AS `CategoryName`,
 1 AS `SupplierName`,
 1 AS `UnitName`,
 1 AS `BusinessTypeName`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'vivmallvndbv2'
--

--
-- Dumping routines for database 'vivmallvndbv2'
--
/*!50003 DROP FUNCTION IF EXISTS `getNextCustomSeq` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`mysql245`@`%` FUNCTION `getNextCustomSeq`(
    sSeqName VARCHAR(50),
    sSeqGroup VARCHAR(10)
) RETURNS varchar(20) CHARSET utf8
BEGIN
    DECLARE nLast_val INT; 
 
    SET nLast_val =  (SELECT seq_val
                          FROM _sequence
                          WHERE seq_name = sSeqName
                                AND seq_group = sSeqGroup);
    IF nLast_val IS NULL THEN
        SET nLast_val = 1;
        INSERT INTO _sequence (seq_name,seq_group,seq_val)
        VALUES (sSeqName,sSeqGroup,nLast_Val);
    ELSE
        SET nLast_val = nLast_val + 1;
        UPDATE _sequence SET seq_val = nLast_val
        WHERE seq_name = sSeqName AND seq_group = sSeqGroup;
    END IF; 
 
    SET @ret = (SELECT concat(sSeqGroup,'-',lpad(nLast_val,11,'0')));
    RETURN @ret;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `getNextProductBarcodeWithoutChecksumDigit` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`mysql245`@`%` FUNCTION `getNextProductBarcodeWithoutChecksumDigit`(
) RETURNS varchar(12) CHARSET utf8
BEGIN
DECLARE nLast_val INT; 
DECLARE nContry_val varchar(3);
DECLARE nCompany_val varchar(6);
declare nProduct_length int;

select  contry_code, company_code, product_code_count, product_length
into    nContry_val,nCompany_val,nLast_val,nProduct_length
from _sequence_barcode where id=1;
  IF nLast_val IS NULL THEN
        SET nLast_val = 1;
        INSERT INTO _sequence_barcode (id,contry_code, company_code, product_code_count, product_length)
        VALUES (1,'893','0001',1,5);
    ELSE
        SET nLast_val = nLast_val + 1;
        UPDATE _sequence_barcode SET product_code_count = nLast_val
        WHERE id=1;
    END IF; 

	SET @ret = (SELECT concat(nContry_val,nCompany_val,lpad(nLast_val,nProduct_length,'0')));
    RETURN @ret;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `SPLIT_STR` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`mysql245`@`%` FUNCTION `SPLIT_STR`(
  x VARCHAR(255),
  delim VARCHAR(12),
  pos INT
) RETURNS varchar(255) CHARSET utf8
RETURN REPLACE(SUBSTRING(SUBSTRING_INDEX(x, delim, pos),
       LENGTH(SUBSTRING_INDEX(x, delim, pos -1)) + 1),
       delim, '') ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_test_jasper_tb_product` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`mysql245`@`%` PROCEDURE `sp_test_jasper_tb_product`(
in maxUnit int(8)
)
BEGIN

SELECT * 
FROM tb_product
where Unit < maxUnit
;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `vw_gridproduct`
--

/*!50001 DROP VIEW IF EXISTS `vw_gridproduct`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8 */;
/*!50001 SET character_set_results     = utf8 */;
/*!50001 SET collation_connection      = utf8_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`mysql245`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_gridproduct` AS (select `p`.`id` AS `id`,`p`.`ProductName` AS `ProductName`,`p`.`FeatureImage` AS `FeatureImage`,`p`.`Unit` AS `Unit`,`p`.`BigUnit` AS `BigUnit`,`p`.`CostPrice` AS `CostPrice`,`p`.`SellPrice` AS `SellPrice`,`p`.`SellPrice1` AS `SellPrice1`,`p`.`SellPrice2` AS `SellPrice2`,`p`.`CategoryId` AS `CategoryId`,`p`.`BusinessType` AS `BusinessType`,`p`.`SupplierId` AS `SupplierId`,`p`.`CreateDate` AS `CreateDate`,`p`.`UpdateDate` AS `UpdateDate`,`p`.`CreateUser` AS `CreateUser`,`p`.`UpdateUser` AS `UpdateUser`,`p`.`enabled` AS `enabled`,`b`.`name` AS `BigUnitName`,`c`.`CategoryName` AS `CategoryName`,`s`.`SupplierName` AS `SupplierName`,`u`.`name` AS `UnitName`,`bs`.`name` AS `BusinessTypeName` from (((((`tb_product` `p` join `tb_bigunit` `b` on((`p`.`BigUnit` = `b`.`id`))) join `tb_category` `c` on((`p`.`CategoryId` = `c`.`id`))) join `tb_supplier` `s` on((`p`.`SupplierId` = `s`.`id`))) join `tb_unit` `u` on((`p`.`Unit` = `u`.`id`))) join `tb_businesstype` `bs` on((`p`.`BusinessType` = `bs`.`id`)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-02 16:21:07
