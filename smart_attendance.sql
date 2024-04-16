-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: smart_attendance
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `AttendanceRecord`
--

DROP TABLE IF EXISTS `AttendanceRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `AttendanceRecord` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `timeId` int DEFAULT NULL,
  `courseName` varchar(255) DEFAULT NULL,
  `status` enum('normal','leave','absent','waiting') DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `studentId` int DEFAULT NULL,
  `weekNo` int DEFAULT NULL,
  `dayNo` int DEFAULT NULL,
  `timeNo` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=54032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AttendanceRecord`
--

LOCK TABLES `AttendanceRecord` WRITE;
/*!40000 ALTER TABLE `AttendanceRecord` DISABLE KEYS */;
INSERT INTO `AttendanceRecord` VALUES (53432,NULL,NULL,'normal',2,1,14,1,1),(53433,NULL,NULL,'waiting',2,1,14,1,3),(53434,NULL,NULL,'normal',1,1,14,1,5),(53435,NULL,NULL,'waiting',3,1,14,1,7),(53436,NULL,NULL,'waiting',4,1,14,1,9),(53437,NULL,NULL,'waiting',5,1,14,1,11),(53438,NULL,NULL,'waiting',6,1,14,1,13),(53439,NULL,NULL,'waiting',10,1,14,1,15),(53440,NULL,NULL,'waiting',1,1,14,2,1),(53441,NULL,NULL,'waiting',1,1,14,2,3),(53442,NULL,NULL,'waiting',3,1,14,2,5),(53443,NULL,NULL,'waiting',2,1,14,2,7),(53444,NULL,NULL,'waiting',7,1,14,2,9),(53445,NULL,NULL,'waiting',8,1,14,2,11),(53446,NULL,NULL,'waiting',9,1,14,2,13),(53447,NULL,NULL,'waiting',11,1,14,2,15),(53448,NULL,NULL,'waiting',3,1,14,3,1),(53449,NULL,NULL,'waiting',3,1,14,3,3),(53450,NULL,NULL,'waiting',2,1,14,3,5),(53451,NULL,NULL,'waiting',1,1,14,3,7),(53452,NULL,NULL,'waiting',4,1,14,3,9),(53453,NULL,NULL,'waiting',4,1,14,3,11),(53454,NULL,NULL,'waiting',5,1,14,3,13),(53455,NULL,NULL,'waiting',5,1,14,3,15),(53456,NULL,NULL,'waiting',2,1,14,4,1),(53457,NULL,NULL,'waiting',1,1,14,4,3),(53458,NULL,NULL,'waiting',3,1,14,4,5),(53459,NULL,NULL,'waiting',10,1,14,4,7),(53460,NULL,NULL,'waiting',6,1,14,4,9),(53461,NULL,NULL,'waiting',6,1,14,4,11),(53462,NULL,NULL,'waiting',7,1,14,4,13),(53463,NULL,NULL,'waiting',7,1,14,4,15),(53464,NULL,NULL,'waiting',2,1,14,5,1),(53465,NULL,NULL,'waiting',1,1,14,5,3),(53466,NULL,NULL,'waiting',3,1,14,5,5),(53467,NULL,NULL,'waiting',11,1,14,5,7),(53468,NULL,NULL,'waiting',8,1,14,5,9),(53469,NULL,NULL,'waiting',8,1,14,5,11),(53470,NULL,NULL,'waiting',9,1,14,5,13),(53471,NULL,NULL,'waiting',9,1,14,5,15),(53472,NULL,NULL,'waiting',2,1,15,1,1),(53473,NULL,NULL,'waiting',2,1,15,1,3),(53474,NULL,NULL,'waiting',1,1,15,1,5),(53475,NULL,NULL,'waiting',3,1,15,1,7),(53476,NULL,NULL,'waiting',4,1,15,1,9),(53477,NULL,NULL,'waiting',5,1,15,1,11),(53478,NULL,NULL,'waiting',6,1,15,1,13),(53479,NULL,NULL,'waiting',10,1,15,1,15),(53480,NULL,NULL,'waiting',1,1,15,2,1),(53481,NULL,NULL,'waiting',1,1,15,2,3),(53482,NULL,NULL,'waiting',3,1,15,2,5),(53483,NULL,NULL,'waiting',2,1,15,2,7),(53484,NULL,NULL,'waiting',7,1,15,2,9),(53485,NULL,NULL,'waiting',8,1,15,2,11),(53486,NULL,NULL,'waiting',9,1,15,2,13),(53487,NULL,NULL,'waiting',11,1,15,2,15),(53488,NULL,NULL,'waiting',3,1,15,3,1),(53489,NULL,NULL,'waiting',3,1,15,3,3),(53490,NULL,NULL,'waiting',2,1,15,3,5),(53491,NULL,NULL,'waiting',1,1,15,3,7),(53492,NULL,NULL,'waiting',4,1,15,3,9),(53493,NULL,NULL,'waiting',4,1,15,3,11),(53494,NULL,NULL,'waiting',5,1,15,3,13),(53495,NULL,NULL,'waiting',5,1,15,3,15),(53496,NULL,NULL,'waiting',2,1,15,4,1),(53497,NULL,NULL,'waiting',1,1,15,4,3),(53498,NULL,NULL,'waiting',3,1,15,4,5),(53499,NULL,NULL,'waiting',10,1,15,4,7),(53500,NULL,NULL,'waiting',6,1,15,4,9),(53501,NULL,NULL,'waiting',6,1,15,4,11),(53502,NULL,NULL,'waiting',7,1,15,4,13),(53503,NULL,NULL,'waiting',7,1,15,4,15),(53504,NULL,NULL,'waiting',2,1,15,5,1),(53505,NULL,NULL,'waiting',1,1,15,5,3),(53506,NULL,NULL,'waiting',3,1,15,5,5),(53507,NULL,NULL,'waiting',11,1,15,5,7),(53508,NULL,NULL,'waiting',8,1,15,5,9),(53509,NULL,NULL,'waiting',8,1,15,5,11),(53510,NULL,NULL,'waiting',9,1,15,5,13),(53511,NULL,NULL,'waiting',9,1,15,5,15),(53512,NULL,NULL,'waiting',2,1,16,1,1),(53513,NULL,NULL,'waiting',2,1,16,1,3),(53514,NULL,NULL,'waiting',1,1,16,1,5),(53515,NULL,NULL,'waiting',3,1,16,1,7),(53516,NULL,NULL,'waiting',4,1,16,1,9),(53517,NULL,NULL,'waiting',5,1,16,1,11),(53518,NULL,NULL,'waiting',6,1,16,1,13),(53519,NULL,NULL,'waiting',10,1,16,1,15),(53520,NULL,NULL,'waiting',1,1,16,2,1),(53521,NULL,NULL,'waiting',1,1,16,2,3),(53522,NULL,NULL,'waiting',3,1,16,2,5),(53523,NULL,NULL,'waiting',2,1,16,2,7),(53524,NULL,NULL,'waiting',7,1,16,2,9),(53525,NULL,NULL,'absent',8,1,16,2,11),(53526,NULL,NULL,'waiting',9,1,16,2,13),(53527,NULL,NULL,'waiting',11,1,16,2,15),(53528,NULL,NULL,'waiting',3,1,16,3,1),(53529,NULL,NULL,'waiting',3,1,16,3,3),(53530,NULL,NULL,'waiting',2,1,16,3,5),(53531,NULL,NULL,'waiting',1,1,16,3,7),(53532,NULL,NULL,'waiting',4,1,16,3,9),(53533,NULL,NULL,'waiting',4,1,16,3,11),(53534,NULL,NULL,'waiting',5,1,16,3,13),(53535,NULL,NULL,'waiting',5,1,16,3,15),(53536,NULL,NULL,'waiting',2,1,16,4,1),(53537,NULL,NULL,'waiting',1,1,16,4,3),(53538,NULL,NULL,'waiting',3,1,16,4,5),(53539,NULL,NULL,'waiting',10,1,16,4,7),(53540,NULL,NULL,'waiting',6,1,16,4,9),(53541,NULL,NULL,'waiting',6,1,16,4,11),(53542,NULL,NULL,'waiting',7,1,16,4,13),(53543,NULL,NULL,'waiting',7,1,16,4,15),(53544,NULL,NULL,'waiting',2,1,16,5,1),(53545,NULL,NULL,'waiting',1,1,16,5,3),(53546,NULL,NULL,'waiting',3,1,16,5,5),(53547,NULL,NULL,'waiting',11,1,16,5,7),(53548,NULL,NULL,'waiting',8,1,16,5,9),(53549,NULL,NULL,'waiting',8,1,16,5,11),(53550,NULL,NULL,'waiting',9,1,16,5,13),(53551,NULL,NULL,'waiting',9,1,16,5,15),(53552,NULL,NULL,'waiting',2,1,17,1,1),(53553,NULL,NULL,'waiting',2,1,17,1,3),(53554,NULL,NULL,'waiting',1,1,17,1,5),(53555,NULL,NULL,'waiting',3,1,17,1,7),(53556,NULL,NULL,'waiting',4,1,17,1,9),(53557,NULL,NULL,'waiting',5,1,17,1,11),(53558,NULL,NULL,'waiting',6,1,17,1,13),(53559,NULL,NULL,'waiting',10,1,17,1,15),(53560,NULL,NULL,'waiting',1,1,17,2,1),(53561,NULL,NULL,'waiting',1,1,17,2,3),(53562,NULL,NULL,'waiting',3,1,17,2,5),(53563,NULL,NULL,'waiting',2,1,17,2,7),(53564,NULL,NULL,'waiting',7,1,17,2,9),(53565,NULL,NULL,'waiting',8,1,17,2,11),(53566,NULL,NULL,'waiting',9,1,17,2,13),(53567,NULL,NULL,'waiting',11,1,17,2,15),(53568,NULL,NULL,'waiting',3,1,17,3,1),(53569,NULL,NULL,'waiting',3,1,17,3,3),(53570,NULL,NULL,'waiting',2,1,17,3,5),(53571,NULL,NULL,'waiting',1,1,17,3,7),(53572,NULL,NULL,'waiting',4,1,17,3,9),(53573,NULL,NULL,'waiting',4,1,17,3,11),(53574,NULL,NULL,'waiting',5,1,17,3,13),(53575,NULL,NULL,'waiting',5,1,17,3,15),(53576,NULL,NULL,'waiting',2,1,17,4,1),(53577,NULL,NULL,'waiting',1,1,17,4,3),(53578,NULL,NULL,'waiting',3,1,17,4,5),(53579,NULL,NULL,'waiting',10,1,17,4,7),(53580,NULL,NULL,'waiting',6,1,17,4,9),(53581,NULL,NULL,'waiting',6,1,17,4,11),(53582,NULL,NULL,'waiting',7,1,17,4,13),(53583,NULL,NULL,'waiting',7,1,17,4,15),(53584,NULL,NULL,'waiting',2,1,17,5,1),(53585,NULL,NULL,'waiting',1,1,17,5,3),(53586,NULL,NULL,'waiting',3,1,17,5,5),(53587,NULL,NULL,'waiting',11,1,17,5,7),(53588,NULL,NULL,'waiting',8,1,17,5,9),(53589,NULL,NULL,'waiting',8,1,17,5,11),(53590,NULL,NULL,'waiting',9,1,17,5,13),(53591,NULL,NULL,'waiting',9,1,17,5,15),(53592,NULL,NULL,'waiting',2,1,18,1,1),(53593,NULL,NULL,'waiting',2,1,18,1,3),(53594,NULL,NULL,'waiting',1,1,18,1,5),(53595,NULL,NULL,'waiting',3,1,18,1,7),(53596,NULL,NULL,'waiting',4,1,18,1,9),(53597,NULL,NULL,'waiting',5,1,18,1,11),(53598,NULL,NULL,'waiting',6,1,18,1,13),(53599,NULL,NULL,'waiting',10,1,18,1,15),(53600,NULL,NULL,'waiting',1,1,18,2,1),(53601,NULL,NULL,'waiting',1,1,18,2,3),(53602,NULL,NULL,'waiting',3,1,18,2,5),(53603,NULL,NULL,'waiting',2,1,18,2,7),(53604,NULL,NULL,'waiting',7,1,18,2,9),(53605,NULL,NULL,'waiting',8,1,18,2,11),(53606,NULL,NULL,'waiting',9,1,18,2,13),(53607,NULL,NULL,'waiting',11,1,18,2,15),(53608,NULL,NULL,'waiting',3,1,18,3,1),(53609,NULL,NULL,'waiting',3,1,18,3,3),(53610,NULL,NULL,'waiting',2,1,18,3,5),(53611,NULL,NULL,'waiting',1,1,18,3,7),(53612,NULL,NULL,'waiting',4,1,18,3,9),(53613,NULL,NULL,'waiting',4,1,18,3,11),(53614,NULL,NULL,'waiting',5,1,18,3,13),(53615,NULL,NULL,'waiting',5,1,18,3,15),(53616,NULL,NULL,'waiting',2,1,18,4,1),(53617,NULL,NULL,'waiting',1,1,18,4,3),(53618,NULL,NULL,'waiting',3,1,18,4,5),(53619,NULL,NULL,'waiting',10,1,18,4,7),(53620,NULL,NULL,'waiting',6,1,18,4,9),(53621,NULL,NULL,'waiting',6,1,18,4,11),(53622,NULL,NULL,'waiting',7,1,18,4,13),(53623,NULL,NULL,'waiting',7,1,18,4,15),(53624,NULL,NULL,'waiting',2,1,18,5,1),(53625,NULL,NULL,'waiting',1,1,18,5,3),(53626,NULL,NULL,'waiting',3,1,18,5,5),(53627,NULL,NULL,'waiting',11,1,18,5,7),(53628,NULL,NULL,'waiting',8,1,18,5,9),(53629,NULL,NULL,'waiting',8,1,18,5,11),(53630,NULL,NULL,'waiting',9,1,18,5,13),(53631,NULL,NULL,'waiting',9,1,18,5,15),(53632,NULL,NULL,'waiting',2,2,14,1,1),(53633,NULL,NULL,'waiting',2,2,14,1,3),(53634,NULL,NULL,'waiting',1,2,14,1,5),(53635,NULL,NULL,'waiting',3,2,14,1,7),(53636,NULL,NULL,'waiting',4,2,14,1,9),(53637,NULL,NULL,'waiting',5,2,14,1,11),(53638,NULL,NULL,'waiting',6,2,14,1,13),(53639,NULL,NULL,'waiting',10,2,14,1,15),(53640,NULL,NULL,'waiting',1,2,14,2,1),(53641,NULL,NULL,'waiting',1,2,14,2,3),(53642,NULL,NULL,'waiting',3,2,14,2,5),(53643,NULL,NULL,'waiting',2,2,14,2,7),(53644,NULL,NULL,'waiting',7,2,14,2,9),(53645,NULL,NULL,'waiting',8,2,14,2,11),(53646,NULL,NULL,'waiting',9,2,14,2,13),(53647,NULL,NULL,'waiting',11,2,14,2,15),(53648,NULL,NULL,'waiting',3,2,14,3,1),(53649,NULL,NULL,'waiting',3,2,14,3,3),(53650,NULL,NULL,'waiting',2,2,14,3,5),(53651,NULL,NULL,'waiting',1,2,14,3,7),(53652,NULL,NULL,'waiting',4,2,14,3,9),(53653,NULL,NULL,'waiting',4,2,14,3,11),(53654,NULL,NULL,'waiting',5,2,14,3,13),(53655,NULL,NULL,'waiting',5,2,14,3,15),(53656,NULL,NULL,'waiting',2,2,14,4,1),(53657,NULL,NULL,'waiting',1,2,14,4,3),(53658,NULL,NULL,'waiting',3,2,14,4,5),(53659,NULL,NULL,'waiting',10,2,14,4,7),(53660,NULL,NULL,'waiting',6,2,14,4,9),(53661,NULL,NULL,'waiting',6,2,14,4,11),(53662,NULL,NULL,'waiting',7,2,14,4,13),(53663,NULL,NULL,'waiting',7,2,14,4,15),(53664,NULL,NULL,'waiting',2,2,14,5,1),(53665,NULL,NULL,'waiting',1,2,14,5,3),(53666,NULL,NULL,'waiting',3,2,14,5,5),(53667,NULL,NULL,'waiting',11,2,14,5,7),(53668,NULL,NULL,'waiting',8,2,14,5,9),(53669,NULL,NULL,'waiting',8,2,14,5,11),(53670,NULL,NULL,'waiting',9,2,14,5,13),(53671,NULL,NULL,'waiting',9,2,14,5,15),(53672,NULL,NULL,'waiting',2,2,15,1,1),(53673,NULL,NULL,'waiting',2,2,15,1,3),(53674,NULL,NULL,'waiting',1,2,15,1,5),(53675,NULL,NULL,'waiting',3,2,15,1,7),(53676,NULL,NULL,'waiting',4,2,15,1,9),(53677,NULL,NULL,'waiting',5,2,15,1,11),(53678,NULL,NULL,'waiting',6,2,15,1,13),(53679,NULL,NULL,'waiting',10,2,15,1,15),(53680,NULL,NULL,'waiting',1,2,15,2,1),(53681,NULL,NULL,'waiting',1,2,15,2,3),(53682,NULL,NULL,'waiting',3,2,15,2,5),(53683,NULL,NULL,'waiting',2,2,15,2,7),(53684,NULL,NULL,'waiting',7,2,15,2,9),(53685,NULL,NULL,'waiting',8,2,15,2,11),(53686,NULL,NULL,'waiting',9,2,15,2,13),(53687,NULL,NULL,'waiting',11,2,15,2,15),(53688,NULL,NULL,'waiting',3,2,15,3,1),(53689,NULL,NULL,'waiting',3,2,15,3,3),(53690,NULL,NULL,'waiting',2,2,15,3,5),(53691,NULL,NULL,'waiting',1,2,15,3,7),(53692,NULL,NULL,'waiting',4,2,15,3,9),(53693,NULL,NULL,'waiting',4,2,15,3,11),(53694,NULL,NULL,'waiting',5,2,15,3,13),(53695,NULL,NULL,'waiting',5,2,15,3,15),(53696,NULL,NULL,'waiting',2,2,15,4,1),(53697,NULL,NULL,'waiting',1,2,15,4,3),(53698,NULL,NULL,'waiting',3,2,15,4,5),(53699,NULL,NULL,'waiting',10,2,15,4,7),(53700,NULL,NULL,'waiting',6,2,15,4,9),(53701,NULL,NULL,'waiting',6,2,15,4,11),(53702,NULL,NULL,'waiting',7,2,15,4,13),(53703,NULL,NULL,'waiting',7,2,15,4,15),(53704,NULL,NULL,'waiting',2,2,15,5,1),(53705,NULL,NULL,'waiting',1,2,15,5,3),(53706,NULL,NULL,'waiting',3,2,15,5,5),(53707,NULL,NULL,'waiting',11,2,15,5,7),(53708,NULL,NULL,'waiting',8,2,15,5,9),(53709,NULL,NULL,'waiting',8,2,15,5,11),(53710,NULL,NULL,'waiting',9,2,15,5,13),(53711,NULL,NULL,'waiting',9,2,15,5,15),(53712,NULL,NULL,'waiting',2,2,16,1,1),(53713,NULL,NULL,'waiting',2,2,16,1,3),(53714,NULL,NULL,'waiting',1,2,16,1,5),(53715,NULL,NULL,'waiting',3,2,16,1,7),(53716,NULL,NULL,'waiting',4,2,16,1,9),(53717,NULL,NULL,'waiting',5,2,16,1,11),(53718,NULL,NULL,'waiting',6,2,16,1,13),(53719,NULL,NULL,'waiting',10,2,16,1,15),(53720,NULL,NULL,'waiting',1,2,16,2,1),(53721,NULL,NULL,'waiting',1,2,16,2,3),(53722,NULL,NULL,'waiting',3,2,16,2,5),(53723,NULL,NULL,'waiting',2,2,16,2,7),(53724,NULL,NULL,'waiting',7,2,16,2,9),(53725,NULL,NULL,'absent',8,2,16,2,11),(53726,NULL,NULL,'waiting',9,2,16,2,13),(53727,NULL,NULL,'waiting',11,2,16,2,15),(53728,NULL,NULL,'waiting',3,2,16,3,1),(53729,NULL,NULL,'waiting',3,2,16,3,3),(53730,NULL,NULL,'waiting',2,2,16,3,5),(53731,NULL,NULL,'waiting',1,2,16,3,7),(53732,NULL,NULL,'waiting',4,2,16,3,9),(53733,NULL,NULL,'waiting',4,2,16,3,11),(53734,NULL,NULL,'waiting',5,2,16,3,13),(53735,NULL,NULL,'waiting',5,2,16,3,15),(53736,NULL,NULL,'waiting',2,2,16,4,1),(53737,NULL,NULL,'waiting',1,2,16,4,3),(53738,NULL,NULL,'waiting',3,2,16,4,5),(53739,NULL,NULL,'waiting',10,2,16,4,7),(53740,NULL,NULL,'waiting',6,2,16,4,9),(53741,NULL,NULL,'waiting',6,2,16,4,11),(53742,NULL,NULL,'waiting',7,2,16,4,13),(53743,NULL,NULL,'waiting',7,2,16,4,15),(53744,NULL,NULL,'waiting',2,2,16,5,1),(53745,NULL,NULL,'waiting',1,2,16,5,3),(53746,NULL,NULL,'waiting',3,2,16,5,5),(53747,NULL,NULL,'waiting',11,2,16,5,7),(53748,NULL,NULL,'waiting',8,2,16,5,9),(53749,NULL,NULL,'waiting',8,2,16,5,11),(53750,NULL,NULL,'waiting',9,2,16,5,13),(53751,NULL,NULL,'waiting',9,2,16,5,15),(53752,NULL,NULL,'waiting',2,2,17,1,1),(53753,NULL,NULL,'waiting',2,2,17,1,3),(53754,NULL,NULL,'waiting',1,2,17,1,5),(53755,NULL,NULL,'waiting',3,2,17,1,7),(53756,NULL,NULL,'waiting',4,2,17,1,9),(53757,NULL,NULL,'waiting',5,2,17,1,11),(53758,NULL,NULL,'waiting',6,2,17,1,13),(53759,NULL,NULL,'waiting',10,2,17,1,15),(53760,NULL,NULL,'waiting',1,2,17,2,1),(53761,NULL,NULL,'waiting',1,2,17,2,3),(53762,NULL,NULL,'waiting',3,2,17,2,5),(53763,NULL,NULL,'waiting',2,2,17,2,7),(53764,NULL,NULL,'waiting',7,2,17,2,9),(53765,NULL,NULL,'waiting',8,2,17,2,11),(53766,NULL,NULL,'waiting',9,2,17,2,13),(53767,NULL,NULL,'waiting',11,2,17,2,15),(53768,NULL,NULL,'waiting',3,2,17,3,1),(53769,NULL,NULL,'waiting',3,2,17,3,3),(53770,NULL,NULL,'waiting',2,2,17,3,5),(53771,NULL,NULL,'waiting',1,2,17,3,7),(53772,NULL,NULL,'waiting',4,2,17,3,9),(53773,NULL,NULL,'waiting',4,2,17,3,11),(53774,NULL,NULL,'waiting',5,2,17,3,13),(53775,NULL,NULL,'waiting',5,2,17,3,15),(53776,NULL,NULL,'waiting',2,2,17,4,1),(53777,NULL,NULL,'waiting',1,2,17,4,3),(53778,NULL,NULL,'waiting',3,2,17,4,5),(53779,NULL,NULL,'waiting',10,2,17,4,7),(53780,NULL,NULL,'waiting',6,2,17,4,9),(53781,NULL,NULL,'waiting',6,2,17,4,11),(53782,NULL,NULL,'waiting',7,2,17,4,13),(53783,NULL,NULL,'waiting',7,2,17,4,15),(53784,NULL,NULL,'waiting',2,2,17,5,1),(53785,NULL,NULL,'waiting',1,2,17,5,3),(53786,NULL,NULL,'waiting',3,2,17,5,5),(53787,NULL,NULL,'waiting',11,2,17,5,7),(53788,NULL,NULL,'waiting',8,2,17,5,9),(53789,NULL,NULL,'waiting',8,2,17,5,11),(53790,NULL,NULL,'waiting',9,2,17,5,13),(53791,NULL,NULL,'waiting',9,2,17,5,15),(53792,NULL,NULL,'waiting',2,2,18,1,1),(53793,NULL,NULL,'waiting',2,2,18,1,3),(53794,NULL,NULL,'waiting',1,2,18,1,5),(53795,NULL,NULL,'waiting',3,2,18,1,7),(53796,NULL,NULL,'waiting',4,2,18,1,9),(53797,NULL,NULL,'waiting',5,2,18,1,11),(53798,NULL,NULL,'waiting',6,2,18,1,13),(53799,NULL,NULL,'waiting',10,2,18,1,15),(53800,NULL,NULL,'waiting',1,2,18,2,1),(53801,NULL,NULL,'waiting',1,2,18,2,3),(53802,NULL,NULL,'waiting',3,2,18,2,5),(53803,NULL,NULL,'waiting',2,2,18,2,7),(53804,NULL,NULL,'waiting',7,2,18,2,9),(53805,NULL,NULL,'waiting',8,2,18,2,11),(53806,NULL,NULL,'waiting',9,2,18,2,13),(53807,NULL,NULL,'waiting',11,2,18,2,15),(53808,NULL,NULL,'waiting',3,2,18,3,1),(53809,NULL,NULL,'waiting',3,2,18,3,3),(53810,NULL,NULL,'waiting',2,2,18,3,5),(53811,NULL,NULL,'waiting',1,2,18,3,7),(53812,NULL,NULL,'waiting',4,2,18,3,9),(53813,NULL,NULL,'waiting',4,2,18,3,11),(53814,NULL,NULL,'waiting',5,2,18,3,13),(53815,NULL,NULL,'waiting',5,2,18,3,15),(53816,NULL,NULL,'waiting',2,2,18,4,1),(53817,NULL,NULL,'waiting',1,2,18,4,3),(53818,NULL,NULL,'waiting',3,2,18,4,5),(53819,NULL,NULL,'waiting',10,2,18,4,7),(53820,NULL,NULL,'waiting',6,2,18,4,9),(53821,NULL,NULL,'waiting',6,2,18,4,11),(53822,NULL,NULL,'waiting',7,2,18,4,13),(53823,NULL,NULL,'waiting',7,2,18,4,15),(53824,NULL,NULL,'waiting',2,2,18,5,1),(53825,NULL,NULL,'waiting',1,2,18,5,3),(53826,NULL,NULL,'waiting',3,2,18,5,5),(53827,NULL,NULL,'waiting',11,2,18,5,7),(53828,NULL,NULL,'waiting',8,2,18,5,9),(53829,NULL,NULL,'waiting',8,2,18,5,11),(53830,NULL,NULL,'waiting',9,2,18,5,13),(53831,NULL,NULL,'waiting',9,2,18,5,15),(53832,NULL,NULL,'waiting',2,3,14,1,1),(53833,NULL,NULL,'waiting',2,3,14,1,3),(53834,NULL,NULL,'waiting',1,3,14,1,5),(53835,NULL,NULL,'waiting',3,3,14,1,7),(53836,NULL,NULL,'waiting',4,3,14,1,9),(53837,NULL,NULL,'waiting',5,3,14,1,11),(53838,NULL,NULL,'waiting',6,3,14,1,13),(53839,NULL,NULL,'waiting',10,3,14,1,15),(53840,NULL,NULL,'waiting',1,3,14,2,1),(53841,NULL,NULL,'waiting',1,3,14,2,3),(53842,NULL,NULL,'waiting',3,3,14,2,5),(53843,NULL,NULL,'waiting',2,3,14,2,7),(53844,NULL,NULL,'waiting',7,3,14,2,9),(53845,NULL,NULL,'waiting',8,3,14,2,11),(53846,NULL,NULL,'waiting',9,3,14,2,13),(53847,NULL,NULL,'waiting',11,3,14,2,15),(53848,NULL,NULL,'waiting',3,3,14,3,1),(53849,NULL,NULL,'waiting',3,3,14,3,3),(53850,NULL,NULL,'waiting',2,3,14,3,5),(53851,NULL,NULL,'waiting',1,3,14,3,7),(53852,NULL,NULL,'waiting',4,3,14,3,9),(53853,NULL,NULL,'waiting',4,3,14,3,11),(53854,NULL,NULL,'waiting',5,3,14,3,13),(53855,NULL,NULL,'waiting',5,3,14,3,15),(53856,NULL,NULL,'waiting',2,3,14,4,1),(53857,NULL,NULL,'waiting',1,3,14,4,3),(53858,NULL,NULL,'waiting',3,3,14,4,5),(53859,NULL,NULL,'waiting',10,3,14,4,7),(53860,NULL,NULL,'waiting',6,3,14,4,9),(53861,NULL,NULL,'waiting',6,3,14,4,11),(53862,NULL,NULL,'waiting',7,3,14,4,13),(53863,NULL,NULL,'waiting',7,3,14,4,15),(53864,NULL,NULL,'waiting',2,3,14,5,1),(53865,NULL,NULL,'waiting',1,3,14,5,3),(53866,NULL,NULL,'waiting',3,3,14,5,5),(53867,NULL,NULL,'waiting',11,3,14,5,7),(53868,NULL,NULL,'waiting',8,3,14,5,9),(53869,NULL,NULL,'waiting',8,3,14,5,11),(53870,NULL,NULL,'waiting',9,3,14,5,13),(53871,NULL,NULL,'waiting',9,3,14,5,15),(53872,NULL,NULL,'waiting',2,3,15,1,1),(53873,NULL,NULL,'waiting',2,3,15,1,3),(53874,NULL,NULL,'waiting',1,3,15,1,5),(53875,NULL,NULL,'waiting',3,3,15,1,7),(53876,NULL,NULL,'waiting',4,3,15,1,9),(53877,NULL,NULL,'waiting',5,3,15,1,11),(53878,NULL,NULL,'waiting',6,3,15,1,13),(53879,NULL,NULL,'waiting',10,3,15,1,15),(53880,NULL,NULL,'waiting',1,3,15,2,1),(53881,NULL,NULL,'waiting',1,3,15,2,3),(53882,NULL,NULL,'waiting',3,3,15,2,5),(53883,NULL,NULL,'waiting',2,3,15,2,7),(53884,NULL,NULL,'waiting',7,3,15,2,9),(53885,NULL,NULL,'waiting',8,3,15,2,11),(53886,NULL,NULL,'waiting',9,3,15,2,13),(53887,NULL,NULL,'waiting',11,3,15,2,15),(53888,NULL,NULL,'waiting',3,3,15,3,1),(53889,NULL,NULL,'waiting',3,3,15,3,3),(53890,NULL,NULL,'waiting',2,3,15,3,5),(53891,NULL,NULL,'waiting',1,3,15,3,7),(53892,NULL,NULL,'waiting',4,3,15,3,9),(53893,NULL,NULL,'waiting',4,3,15,3,11),(53894,NULL,NULL,'waiting',5,3,15,3,13),(53895,NULL,NULL,'waiting',5,3,15,3,15),(53896,NULL,NULL,'waiting',2,3,15,4,1),(53897,NULL,NULL,'waiting',1,3,15,4,3),(53898,NULL,NULL,'waiting',3,3,15,4,5),(53899,NULL,NULL,'waiting',10,3,15,4,7),(53900,NULL,NULL,'waiting',6,3,15,4,9),(53901,NULL,NULL,'waiting',6,3,15,4,11),(53902,NULL,NULL,'waiting',7,3,15,4,13),(53903,NULL,NULL,'waiting',7,3,15,4,15),(53904,NULL,NULL,'waiting',2,3,15,5,1),(53905,NULL,NULL,'waiting',1,3,15,5,3),(53906,NULL,NULL,'waiting',3,3,15,5,5),(53907,NULL,NULL,'waiting',11,3,15,5,7),(53908,NULL,NULL,'waiting',8,3,15,5,9),(53909,NULL,NULL,'waiting',8,3,15,5,11),(53910,NULL,NULL,'waiting',9,3,15,5,13),(53911,NULL,NULL,'waiting',9,3,15,5,15),(53912,NULL,NULL,'waiting',2,3,16,1,1),(53913,NULL,NULL,'waiting',2,3,16,1,3),(53914,NULL,NULL,'waiting',1,3,16,1,5),(53915,NULL,NULL,'waiting',3,3,16,1,7),(53916,NULL,NULL,'waiting',4,3,16,1,9),(53917,NULL,NULL,'waiting',5,3,16,1,11),(53918,NULL,NULL,'waiting',6,3,16,1,13),(53919,NULL,NULL,'waiting',10,3,16,1,15),(53920,NULL,NULL,'waiting',1,3,16,2,1),(53921,NULL,NULL,'waiting',1,3,16,2,3),(53922,NULL,NULL,'waiting',3,3,16,2,5),(53923,NULL,NULL,'waiting',2,3,16,2,7),(53924,NULL,NULL,'waiting',7,3,16,2,9),(53925,NULL,NULL,'absent',8,3,16,2,11),(53926,NULL,NULL,'waiting',9,3,16,2,13),(53927,NULL,NULL,'waiting',11,3,16,2,15),(53928,NULL,NULL,'waiting',3,3,16,3,1),(53929,NULL,NULL,'waiting',3,3,16,3,3),(53930,NULL,NULL,'waiting',2,3,16,3,5),(53931,NULL,NULL,'waiting',1,3,16,3,7),(53932,NULL,NULL,'waiting',4,3,16,3,9),(53933,NULL,NULL,'waiting',4,3,16,3,11),(53934,NULL,NULL,'waiting',5,3,16,3,13),(53935,NULL,NULL,'waiting',5,3,16,3,15),(53936,NULL,NULL,'waiting',2,3,16,4,1),(53937,NULL,NULL,'waiting',1,3,16,4,3),(53938,NULL,NULL,'waiting',3,3,16,4,5),(53939,NULL,NULL,'waiting',10,3,16,4,7),(53940,NULL,NULL,'waiting',6,3,16,4,9),(53941,NULL,NULL,'waiting',6,3,16,4,11),(53942,NULL,NULL,'waiting',7,3,16,4,13),(53943,NULL,NULL,'waiting',7,3,16,4,15),(53944,NULL,NULL,'waiting',2,3,16,5,1),(53945,NULL,NULL,'waiting',1,3,16,5,3),(53946,NULL,NULL,'waiting',3,3,16,5,5),(53947,NULL,NULL,'waiting',11,3,16,5,7),(53948,NULL,NULL,'waiting',8,3,16,5,9),(53949,NULL,NULL,'waiting',8,3,16,5,11),(53950,NULL,NULL,'waiting',9,3,16,5,13),(53951,NULL,NULL,'waiting',9,3,16,5,15),(53952,NULL,NULL,'waiting',2,3,17,1,1),(53953,NULL,NULL,'waiting',2,3,17,1,3),(53954,NULL,NULL,'waiting',1,3,17,1,5),(53955,NULL,NULL,'waiting',3,3,17,1,7),(53956,NULL,NULL,'waiting',4,3,17,1,9),(53957,NULL,NULL,'waiting',5,3,17,1,11),(53958,NULL,NULL,'waiting',6,3,17,1,13),(53959,NULL,NULL,'waiting',10,3,17,1,15),(53960,NULL,NULL,'waiting',1,3,17,2,1),(53961,NULL,NULL,'waiting',1,3,17,2,3),(53962,NULL,NULL,'waiting',3,3,17,2,5),(53963,NULL,NULL,'waiting',2,3,17,2,7),(53964,NULL,NULL,'waiting',7,3,17,2,9),(53965,NULL,NULL,'waiting',8,3,17,2,11),(53966,NULL,NULL,'waiting',9,3,17,2,13),(53967,NULL,NULL,'waiting',11,3,17,2,15),(53968,NULL,NULL,'waiting',3,3,17,3,1),(53969,NULL,NULL,'waiting',3,3,17,3,3),(53970,NULL,NULL,'waiting',2,3,17,3,5),(53971,NULL,NULL,'waiting',1,3,17,3,7),(53972,NULL,NULL,'waiting',4,3,17,3,9),(53973,NULL,NULL,'waiting',4,3,17,3,11),(53974,NULL,NULL,'waiting',5,3,17,3,13),(53975,NULL,NULL,'waiting',5,3,17,3,15),(53976,NULL,NULL,'waiting',2,3,17,4,1),(53977,NULL,NULL,'waiting',1,3,17,4,3),(53978,NULL,NULL,'waiting',3,3,17,4,5),(53979,NULL,NULL,'waiting',10,3,17,4,7),(53980,NULL,NULL,'waiting',6,3,17,4,9),(53981,NULL,NULL,'waiting',6,3,17,4,11),(53982,NULL,NULL,'waiting',7,3,17,4,13),(53983,NULL,NULL,'waiting',7,3,17,4,15),(53984,NULL,NULL,'waiting',2,3,17,5,1),(53985,NULL,NULL,'waiting',1,3,17,5,3),(53986,NULL,NULL,'waiting',3,3,17,5,5),(53987,NULL,NULL,'waiting',11,3,17,5,7),(53988,NULL,NULL,'waiting',8,3,17,5,9),(53989,NULL,NULL,'waiting',8,3,17,5,11),(53990,NULL,NULL,'waiting',9,3,17,5,13),(53991,NULL,NULL,'waiting',9,3,17,5,15),(53992,NULL,NULL,'waiting',2,3,18,1,1),(53993,NULL,NULL,'waiting',2,3,18,1,3),(53994,NULL,NULL,'waiting',1,3,18,1,5),(53995,NULL,NULL,'waiting',3,3,18,1,7),(53996,NULL,NULL,'waiting',4,3,18,1,9),(53997,NULL,NULL,'waiting',5,3,18,1,11),(53998,NULL,NULL,'waiting',6,3,18,1,13),(53999,NULL,NULL,'waiting',10,3,18,1,15),(54000,NULL,NULL,'waiting',1,3,18,2,1),(54001,NULL,NULL,'waiting',1,3,18,2,3),(54002,NULL,NULL,'waiting',3,3,18,2,5),(54003,NULL,NULL,'waiting',2,3,18,2,7),(54004,NULL,NULL,'waiting',7,3,18,2,9),(54005,NULL,NULL,'waiting',8,3,18,2,11),(54006,NULL,NULL,'waiting',9,3,18,2,13),(54007,NULL,NULL,'waiting',11,3,18,2,15),(54008,NULL,NULL,'waiting',3,3,18,3,1),(54009,NULL,NULL,'waiting',3,3,18,3,3),(54010,NULL,NULL,'waiting',2,3,18,3,5),(54011,NULL,NULL,'waiting',1,3,18,3,7),(54012,NULL,NULL,'waiting',4,3,18,3,9),(54013,NULL,NULL,'waiting',4,3,18,3,11),(54014,NULL,NULL,'waiting',5,3,18,3,13),(54015,NULL,NULL,'waiting',5,3,18,3,15),(54016,NULL,NULL,'waiting',2,3,18,4,1),(54017,NULL,NULL,'waiting',1,3,18,4,3),(54018,NULL,NULL,'waiting',3,3,18,4,5),(54019,NULL,NULL,'waiting',10,3,18,4,7),(54020,NULL,NULL,'waiting',6,3,18,4,9),(54021,NULL,NULL,'waiting',6,3,18,4,11),(54022,NULL,NULL,'waiting',7,3,18,4,13),(54023,NULL,NULL,'waiting',7,3,18,4,15),(54024,NULL,NULL,'waiting',2,3,18,5,1),(54025,NULL,NULL,'waiting',1,3,18,5,3),(54026,NULL,NULL,'waiting',3,3,18,5,5),(54027,NULL,NULL,'waiting',11,3,18,5,7),(54028,NULL,NULL,'waiting',8,3,18,5,9),(54029,NULL,NULL,'waiting',8,3,18,5,11),(54030,NULL,NULL,'waiting',9,3,18,5,13),(54031,NULL,NULL,'waiting',9,3,18,5,15);
/*!40000 ALTER TABLE `AttendanceRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ClassRoom`
--

DROP TABLE IF EXISTS `ClassRoom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ClassRoom` (
  `id` int NOT NULL,
  `courseId` int DEFAULT NULL,
  `place` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ClassRoom`
--

LOCK TABLES `ClassRoom` WRITE;
/*!40000 ALTER TABLE `ClassRoom` DISABLE KEYS */;
/*!40000 ALTER TABLE `ClassRoom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Course` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `myClassId` int DEFAULT NULL,
  `teacherId` int DEFAULT NULL,
  `classRoomId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (0,'empty',2201,32767,1),(1,'数学',2201,1,1),(2,'语文',2201,2,1),(3,'英语',2201,3,1),(4,'物理',2201,4,1),(5,'化学',2201,5,1),(6,'生物',2201,6,1),(7,'政治',2201,7,1),(8,'历史',2201,9,1),(9,'地理',2201,8,1),(10,'Java',2201,10,1),(11,'Python',2201,11,1);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CourseTime`
--

DROP TABLE IF EXISTS `CourseTime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CourseTime` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dayInWeek` int DEFAULT NULL,
  `dayTime` enum('mRest0_1','morning1','mRest1_2','morning2','mRest2_3','morning3','mRest3_4','morning4','aRest0_1','afternoon1','aRest1_2','afternoon2','aRest2_3','afternoon3','aRest3_4','afternoon4','other') DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `timeNo` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50790 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseTime`
--

LOCK TABLES `CourseTime` WRITE;
/*!40000 ALTER TABLE `CourseTime` DISABLE KEYS */;
INSERT INTO `CourseTime` VALUES (50749,1,NULL,1,5),(50750,2,NULL,1,1),(50751,2,NULL,1,3),(50752,3,NULL,1,7),(50753,4,NULL,1,3),(50754,5,NULL,1,3),(50755,1,NULL,2,1),(50756,1,NULL,2,3),(50757,2,NULL,2,7),(50758,3,NULL,2,5),(50759,4,NULL,2,1),(50760,5,NULL,2,1),(50761,1,NULL,3,7),(50762,2,NULL,3,5),(50763,3,NULL,3,1),(50764,3,NULL,3,3),(50765,4,NULL,3,5),(50766,5,NULL,3,5),(50767,1,NULL,4,9),(50768,3,NULL,4,9),(50769,3,NULL,4,11),(50770,1,NULL,5,11),(50771,3,NULL,5,13),(50772,3,NULL,5,15),(50773,1,NULL,6,13),(50774,4,NULL,6,9),(50775,4,NULL,6,11),(50776,2,NULL,7,9),(50777,4,NULL,7,13),(50778,4,NULL,7,15),(50779,2,NULL,8,11),(50780,5,NULL,8,9),(50781,5,NULL,8,11),(50782,2,NULL,9,13),(50783,5,NULL,9,13),(50784,5,NULL,9,15),(50785,1,NULL,10,15),(50786,4,NULL,10,7),(50787,2,NULL,11,15),(50788,5,NULL,11,7),(50789,0,NULL,0,1);
/*!40000 ALTER TABLE `CourseTime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FaceInformation`
--

DROP TABLE IF EXISTS `FaceInformation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FaceInformation` (
  `PhotoPath` varchar(255) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FaceInformation`
--

LOCK TABLES `FaceInformation` WRITE;
/*!40000 ALTER TABLE `FaceInformation` DISABLE KEYS */;
INSERT INTO `FaceInformation` VALUES ('/opt/myProject_another/photoes/peopleList/lly1.jpeg',73),('/opt/myProject_another/photoes/peopleList/shl2.jpeg',74),('/opt/myProject_another/photoes/peopleList/lhy1.jpeg',75);
/*!40000 ALTER TABLE `FaceInformation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LeaveRecord`
--

DROP TABLE IF EXISTS `LeaveRecord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LeaveRecord` (
  `leaveRecordNum` int NOT NULL,
  `studentApplyId` int DEFAULT NULL,
  `teacherDealId` int DEFAULT NULL,
  `startTimeId` int DEFAULT NULL,
  `endTimeId` int DEFAULT NULL,
  `factoryId` int DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `leaveResult` enum('waiting','pass','fail') DEFAULT NULL,
  `weekNo` int DEFAULT NULL,
  `dayNo` int DEFAULT NULL,
  `timeNo` int DEFAULT NULL,
  PRIMARY KEY (`leaveRecordNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeaveRecord`
--

LOCK TABLES `LeaveRecord` WRITE;
/*!40000 ALTER TABLE `LeaveRecord` DISABLE KEYS */;
INSERT INTO `LeaveRecord` VALUES (1,1,1,NULL,NULL,32,'1_16','fail',16,2,1);
/*!40000 ALTER TABLE `LeaveRecord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `LeaveRecordFactory`
--

DROP TABLE IF EXISTS `LeaveRecordFactory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `LeaveRecordFactory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `recordCount` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeaveRecordFactory`
--

LOCK TABLES `LeaveRecordFactory` WRITE;
/*!40000 ALTER TABLE `LeaveRecordFactory` DISABLE KEYS */;
INSERT INTO `LeaveRecordFactory` VALUES (32,'testClass',1);
/*!40000 ALTER TABLE `LeaveRecordFactory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `MyClass`
--

DROP TABLE IF EXISTS `MyClass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `MyClass` (
  `id` int NOT NULL,
  `studentId` int DEFAULT NULL,
  `teacherId` int DEFAULT NULL,
  `courseId` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `leaveRecordFactoryId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `MyClass`
--

LOCK TABLES `MyClass` WRITE;
/*!40000 ALTER TABLE `MyClass` DISABLE KEYS */;
INSERT INTO `MyClass` VALUES (2201,NULL,NULL,NULL,'testClass',32);
/*!40000 ALTER TABLE `MyClass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Person`
--

DROP TABLE IF EXISTS `Person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Person` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `faceInformationId` int DEFAULT NULL,
  `phoneNumber` varchar(20) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Person`
--

LOCK TABLES `Person` WRITE;
/*!40000 ALTER TABLE `Person` DISABLE KEYS */;
/*!40000 ALTER TABLE `Person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SchoolTimeTable`
--

DROP TABLE IF EXISTS `SchoolTimeTable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SchoolTimeTable` (
  `id` int NOT NULL AUTO_INCREMENT,
  `week` int DEFAULT NULL,
  `courseTimeId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50495 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SchoolTimeTable`
--

LOCK TABLES `SchoolTimeTable` WRITE;
/*!40000 ALTER TABLE `SchoolTimeTable` DISABLE KEYS */;
/*!40000 ALTER TABLE `SchoolTimeTable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Student` (
  `id` int NOT NULL,
  `myClassId` int DEFAULT NULL,
  `attendanceRecordId` int DEFAULT NULL,
  `studentNumber` varchar(255) DEFAULT NULL,
  `status` enum('normal','leave','absent') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  `faceInformationId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (1,2201,NULL,'1','normal','lly','123',1,73),(2,2201,NULL,'2','normal','shl','123',1,74),(3,2201,NULL,'3','normal','lhy','123',1,75);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teacher`
--

DROP TABLE IF EXISTS `Teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Teacher` (
  `id` int NOT NULL,
  `teachClassId` int DEFAULT NULL,
  `teachCourseId` int DEFAULT NULL,
  `teacherNumber` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  `sex` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teacher`
--

LOCK TABLES `Teacher` WRITE;
/*!40000 ALTER TABLE `Teacher` DISABLE KEYS */;
INSERT INTO `Teacher` VALUES (1,2201,1,'1','teaM','123',1),(2,2201,2,'2','teaC','789',0),(3,2201,3,'3','teaE','789',0),(4,2201,4,'4','teaPh','789',1),(5,2201,5,'5','teaChe','789',0),(6,2201,6,'6','teaB','789',0),(7,2201,7,'7','teaP','789',1),(8,2201,9,'8','teaG','789',0),(9,2201,8,'9','teaH','789',1),(10,2201,10,'10','teaJ','789',0),(11,2201,11,'11','teaPy','789',0),(32767,2201,0,'32767','null','null',1);
/*!40000 ALTER TABLE `Teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-16 15:40:29
