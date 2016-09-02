-- MySQL dump 10.13  Distrib 5.5.15, for Win32 (x86)
--
-- Host: localhost    Database: school
-- ------------------------------------------------------
-- Server version	5.5.15

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
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) NOT NULL,
  `DESC` text,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gbk;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'南京邮电大学','南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。南京邮电大学坐落于六朝古都——江苏省南京市，是原由工业与信息化部直属、现工信部与江苏省政府共建的以信息科技为特色、工学门类为主体、工管文理协调发展的多科性全国重点大学。首批入选国家“2011计划（14个协同创新中心）”建设，同时也是进入教育部“卓越工程师教育培养计划”建设的名牌高校。'),(2,'南京财经大学','南京财经大学（Nanjing University Of Finance & Economics）原名南京经济学院，学校源于1956年的南京粮食学校，1981年升格为南京粮食经济学院，1993年更名为南京经济学院。1999年南京物资学校并入南京经济学院，2000年，江苏财经高等专科学校、江苏经济管理干部学院并入。2003年4月，经教育部批准，南京经济学院正式更名为南京财经大学。目前，学校已发展成为以经济管理类学科为主，经济学、管理学、法学、工学、文学、理学等多学科支撑配套、协调发展的江苏省属重点建设大学。'),(3,'南京师范大学','南京师范大学，简称“南师”，坐落在钟灵毓秀、虎踞龙蟠的古都南京，是中国高等师范教育的发祥地之一。现为国家“211工程”重点建设的全国重点师范大学，江苏省重点建设大学。2011年成为江苏省研究生院试点单位。南京师范大学着力建设“综合性强，办学特色鲜明，国内一流的教学研究型大学”，并为今后建成“具有一定国际影响的国内高水平大学”奠定坚实基础。'),(4,'南京大学','南京大学，简称“南大”[1]，是一所源远流长的高等学府。追溯学脉古为源自三国吴永安元年的南京太学，近代校史肇始于1902年筹办的三江师范学堂，历经多次变迁，1949年“国立中央大学”易名“国立南京大学”，翌年径称“南京大学”，沿用至今。'),(5,'药科大学',NULL);
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-05 22:37:25
