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
) ENGINE=InnoDB AUTO_INCREMENT=51752 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AttendanceRecord`
--

LOCK TABLES `AttendanceRecord` WRITE;
/*!40000 ALTER TABLE `AttendanceRecord` DISABLE KEYS */;
INSERT INTO `AttendanceRecord` VALUES (51512,NULL,NULL,'normal',2,1,14,1,1),(51513,NULL,NULL,'waiting',2,1,14,1,3),(51514,NULL,NULL,'normal',1,1,14,1,5),(51515,NULL,NULL,'waiting',3,1,14,1,7),(51516,NULL,NULL,'waiting',4,1,14,1,9),(51517,NULL,NULL,'waiting',5,1,14,1,11),(51518,NULL,NULL,'waiting',6,1,14,1,13),(51519,NULL,NULL,'waiting',10,1,14,1,15),(51520,NULL,NULL,'waiting',1,1,14,2,1),(51521,NULL,NULL,'waiting',1,1,14,2,3),(51522,NULL,NULL,'waiting',3,1,14,2,5),(51523,NULL,NULL,'waiting',2,1,14,2,7),(51524,NULL,NULL,'waiting',7,1,14,2,9),(51525,NULL,NULL,'waiting',8,1,14,2,11),(51526,NULL,NULL,'waiting',9,1,14,2,13),(51527,NULL,NULL,'waiting',11,1,14,2,15),(51528,NULL,NULL,'waiting',3,1,14,3,1),(51529,NULL,NULL,'waiting',3,1,14,3,3),(51530,NULL,NULL,'waiting',2,1,14,3,5),(51531,NULL,NULL,'waiting',1,1,14,3,7),(51532,NULL,NULL,'waiting',4,1,14,3,9),(51533,NULL,NULL,'waiting',4,1,14,3,11),(51534,NULL,NULL,'waiting',5,1,14,3,13),(51535,NULL,NULL,'waiting',5,1,14,3,15),(51536,NULL,NULL,'waiting',2,1,14,4,1),(51537,NULL,NULL,'waiting',1,1,14,4,3),(51538,NULL,NULL,'waiting',3,1,14,4,5),(51539,NULL,NULL,'waiting',10,1,14,4,7),(51540,NULL,NULL,'waiting',6,1,14,4,9),(51541,NULL,NULL,'waiting',6,1,14,4,11),(51542,NULL,NULL,'waiting',7,1,14,4,13),(51543,NULL,NULL,'waiting',7,1,14,4,15),(51544,NULL,NULL,'waiting',2,1,14,5,1),(51545,NULL,NULL,'waiting',1,1,14,5,3),(51546,NULL,NULL,'waiting',3,1,14,5,5),(51547,NULL,NULL,'waiting',11,1,14,5,7),(51548,NULL,NULL,'waiting',8,1,14,5,9),(51549,NULL,NULL,'waiting',8,1,14,5,11),(51550,NULL,NULL,'waiting',9,1,14,5,13),(51551,NULL,NULL,'waiting',9,1,14,5,15),(51552,NULL,NULL,'waiting',2,1,15,1,1),(51553,NULL,NULL,'waiting',2,1,15,1,3),(51554,NULL,NULL,'waiting',1,1,15,1,5),(51555,NULL,NULL,'waiting',3,1,15,1,7),(51556,NULL,NULL,'waiting',4,1,15,1,9),(51557,NULL,NULL,'absent',5,1,15,1,11),(51558,NULL,NULL,'normal',6,1,15,1,13),(51559,NULL,NULL,'normal',10,1,15,1,15),(51560,NULL,NULL,'absent',1,1,15,2,1),(51561,NULL,NULL,'waiting',1,1,15,2,3),(51562,NULL,NULL,'waiting',3,1,15,2,5),(51563,NULL,NULL,'waiting',2,1,15,2,7),(51564,NULL,NULL,'absent',7,1,15,2,9),(51565,NULL,NULL,'waiting',8,1,15,2,11),(51566,NULL,NULL,'waiting',9,1,15,2,13),(51567,NULL,NULL,'waiting',11,1,15,2,15),(51568,NULL,NULL,'waiting',3,1,15,3,1),(51569,NULL,NULL,'waiting',3,1,15,3,3),(51570,NULL,NULL,'waiting',2,1,15,3,5),(51571,NULL,NULL,'waiting',1,1,15,3,7),(51572,NULL,NULL,'waiting',4,1,15,3,9),(51573,NULL,NULL,'waiting',4,1,15,3,11),(51574,NULL,NULL,'waiting',5,1,15,3,13),(51575,NULL,NULL,'waiting',5,1,15,3,15),(51576,NULL,NULL,'waiting',2,1,15,4,1),(51577,NULL,NULL,'waiting',1,1,15,4,3),(51578,NULL,NULL,'waiting',3,1,15,4,5),(51579,NULL,NULL,'waiting',10,1,15,4,7),(51580,NULL,NULL,'waiting',6,1,15,4,9),(51581,NULL,NULL,'waiting',6,1,15,4,11),(51582,NULL,NULL,'waiting',7,1,15,4,13),(51583,NULL,NULL,'waiting',7,1,15,4,15),(51584,NULL,NULL,'waiting',2,1,15,5,1),(51585,NULL,NULL,'waiting',1,1,15,5,3),(51586,NULL,NULL,'waiting',3,1,15,5,5),(51587,NULL,NULL,'waiting',11,1,15,5,7),(51588,NULL,NULL,'waiting',8,1,15,5,9),(51589,NULL,NULL,'waiting',8,1,15,5,11),(51590,NULL,NULL,'waiting',9,1,15,5,13),(51591,NULL,NULL,'waiting',9,1,15,5,15),(51592,NULL,NULL,'waiting',2,2,14,1,1),(51593,NULL,NULL,'waiting',2,2,14,1,3),(51594,NULL,NULL,'waiting',1,2,14,1,5),(51595,NULL,NULL,'waiting',3,2,14,1,7),(51596,NULL,NULL,'waiting',4,2,14,1,9),(51597,NULL,NULL,'waiting',5,2,14,1,11),(51598,NULL,NULL,'waiting',6,2,14,1,13),(51599,NULL,NULL,'waiting',10,2,14,1,15),(51600,NULL,NULL,'waiting',1,2,14,2,1),(51601,NULL,NULL,'waiting',1,2,14,2,3),(51602,NULL,NULL,'waiting',3,2,14,2,5),(51603,NULL,NULL,'waiting',2,2,14,2,7),(51604,NULL,NULL,'waiting',7,2,14,2,9),(51605,NULL,NULL,'waiting',8,2,14,2,11),(51606,NULL,NULL,'waiting',9,2,14,2,13),(51607,NULL,NULL,'waiting',11,2,14,2,15),(51608,NULL,NULL,'waiting',3,2,14,3,1),(51609,NULL,NULL,'waiting',3,2,14,3,3),(51610,NULL,NULL,'waiting',2,2,14,3,5),(51611,NULL,NULL,'waiting',1,2,14,3,7),(51612,NULL,NULL,'waiting',4,2,14,3,9),(51613,NULL,NULL,'waiting',4,2,14,3,11),(51614,NULL,NULL,'waiting',5,2,14,3,13),(51615,NULL,NULL,'waiting',5,2,14,3,15),(51616,NULL,NULL,'waiting',2,2,14,4,1),(51617,NULL,NULL,'waiting',1,2,14,4,3),(51618,NULL,NULL,'waiting',3,2,14,4,5),(51619,NULL,NULL,'waiting',10,2,14,4,7),(51620,NULL,NULL,'waiting',6,2,14,4,9),(51621,NULL,NULL,'waiting',6,2,14,4,11),(51622,NULL,NULL,'waiting',7,2,14,4,13),(51623,NULL,NULL,'waiting',7,2,14,4,15),(51624,NULL,NULL,'waiting',2,2,14,5,1),(51625,NULL,NULL,'waiting',1,2,14,5,3),(51626,NULL,NULL,'waiting',3,2,14,5,5),(51627,NULL,NULL,'waiting',11,2,14,5,7),(51628,NULL,NULL,'waiting',8,2,14,5,9),(51629,NULL,NULL,'waiting',8,2,14,5,11),(51630,NULL,NULL,'waiting',9,2,14,5,13),(51631,NULL,NULL,'waiting',9,2,14,5,15),(51632,NULL,NULL,'waiting',2,2,15,1,1),(51633,NULL,NULL,'waiting',2,2,15,1,3),(51634,NULL,NULL,'waiting',1,2,15,1,5),(51635,NULL,NULL,'waiting',3,2,15,1,7),(51636,NULL,NULL,'waiting',4,2,15,1,9),(51637,NULL,NULL,'absent',5,2,15,1,11),(51638,NULL,NULL,'absent',6,2,15,1,13),(51639,NULL,NULL,'normal',10,2,15,1,15),(51640,NULL,NULL,'waiting',1,2,15,2,1),(51641,NULL,NULL,'waiting',1,2,15,2,3),(51642,NULL,NULL,'waiting',3,2,15,2,5),(51643,NULL,NULL,'absent',2,2,15,2,7),(51644,NULL,NULL,'waiting',7,2,15,2,9),(51645,NULL,NULL,'waiting',8,2,15,2,11),(51646,NULL,NULL,'waiting',9,2,15,2,13),(51647,NULL,NULL,'waiting',11,2,15,2,15),(51648,NULL,NULL,'waiting',3,2,15,3,1),(51649,NULL,NULL,'waiting',3,2,15,3,3),(51650,NULL,NULL,'waiting',2,2,15,3,5),(51651,NULL,NULL,'waiting',1,2,15,3,7),(51652,NULL,NULL,'waiting',4,2,15,3,9),(51653,NULL,NULL,'waiting',4,2,15,3,11),(51654,NULL,NULL,'waiting',5,2,15,3,13),(51655,NULL,NULL,'waiting',5,2,15,3,15),(51656,NULL,NULL,'waiting',2,2,15,4,1),(51657,NULL,NULL,'waiting',1,2,15,4,3),(51658,NULL,NULL,'waiting',3,2,15,4,5),(51659,NULL,NULL,'waiting',10,2,15,4,7),(51660,NULL,NULL,'waiting',6,2,15,4,9),(51661,NULL,NULL,'waiting',6,2,15,4,11),(51662,NULL,NULL,'waiting',7,2,15,4,13),(51663,NULL,NULL,'waiting',7,2,15,4,15),(51664,NULL,NULL,'waiting',2,2,15,5,1),(51665,NULL,NULL,'waiting',1,2,15,5,3),(51666,NULL,NULL,'waiting',3,2,15,5,5),(51667,NULL,NULL,'waiting',11,2,15,5,7),(51668,NULL,NULL,'waiting',8,2,15,5,9),(51669,NULL,NULL,'waiting',8,2,15,5,11),(51670,NULL,NULL,'waiting',9,2,15,5,13),(51671,NULL,NULL,'waiting',9,2,15,5,15),(51672,NULL,NULL,'waiting',2,3,14,1,1),(51673,NULL,NULL,'waiting',2,3,14,1,3),(51674,NULL,NULL,'waiting',1,3,14,1,5),(51675,NULL,NULL,'waiting',3,3,14,1,7),(51676,NULL,NULL,'waiting',4,3,14,1,9),(51677,NULL,NULL,'waiting',5,3,14,1,11),(51678,NULL,NULL,'waiting',6,3,14,1,13),(51679,NULL,NULL,'waiting',10,3,14,1,15),(51680,NULL,NULL,'waiting',1,3,14,2,1),(51681,NULL,NULL,'waiting',1,3,14,2,3),(51682,NULL,NULL,'waiting',3,3,14,2,5),(51683,NULL,NULL,'waiting',2,3,14,2,7),(51684,NULL,NULL,'waiting',7,3,14,2,9),(51685,NULL,NULL,'waiting',8,3,14,2,11),(51686,NULL,NULL,'waiting',9,3,14,2,13),(51687,NULL,NULL,'waiting',11,3,14,2,15),(51688,NULL,NULL,'waiting',3,3,14,3,1),(51689,NULL,NULL,'waiting',3,3,14,3,3),(51690,NULL,NULL,'waiting',2,3,14,3,5),(51691,NULL,NULL,'waiting',1,3,14,3,7),(51692,NULL,NULL,'waiting',4,3,14,3,9),(51693,NULL,NULL,'waiting',4,3,14,3,11),(51694,NULL,NULL,'waiting',5,3,14,3,13),(51695,NULL,NULL,'waiting',5,3,14,3,15),(51696,NULL,NULL,'waiting',2,3,14,4,1),(51697,NULL,NULL,'waiting',1,3,14,4,3),(51698,NULL,NULL,'waiting',3,3,14,4,5),(51699,NULL,NULL,'waiting',10,3,14,4,7),(51700,NULL,NULL,'waiting',6,3,14,4,9),(51701,NULL,NULL,'waiting',6,3,14,4,11),(51702,NULL,NULL,'waiting',7,3,14,4,13),(51703,NULL,NULL,'waiting',7,3,14,4,15),(51704,NULL,NULL,'waiting',2,3,14,5,1),(51705,NULL,NULL,'waiting',1,3,14,5,3),(51706,NULL,NULL,'waiting',3,3,14,5,5),(51707,NULL,NULL,'waiting',11,3,14,5,7),(51708,NULL,NULL,'waiting',8,3,14,5,9),(51709,NULL,NULL,'waiting',8,3,14,5,11),(51710,NULL,NULL,'waiting',9,3,14,5,13),(51711,NULL,NULL,'waiting',9,3,14,5,15),(51712,NULL,NULL,'waiting',2,3,15,1,1),(51713,NULL,NULL,'waiting',2,3,15,1,3),(51714,NULL,NULL,'waiting',1,3,15,1,5),(51715,NULL,NULL,'waiting',3,3,15,1,7),(51716,NULL,NULL,'waiting',4,3,15,1,9),(51717,NULL,NULL,'absent',5,3,15,1,11),(51718,NULL,NULL,'normal',6,3,15,1,13),(51719,NULL,NULL,'absent',10,3,15,1,15),(51720,NULL,NULL,'waiting',1,3,15,2,1),(51721,NULL,NULL,'waiting',1,3,15,2,3),(51722,NULL,NULL,'waiting',3,3,15,2,5),(51723,NULL,NULL,'absent',2,3,15,2,7),(51724,NULL,NULL,'waiting',7,3,15,2,9),(51725,NULL,NULL,'waiting',8,3,15,2,11),(51726,NULL,NULL,'waiting',9,3,15,2,13),(51727,NULL,NULL,'waiting',11,3,15,2,15),(51728,NULL,NULL,'waiting',3,3,15,3,1),(51729,NULL,NULL,'waiting',3,3,15,3,3),(51730,NULL,NULL,'waiting',2,3,15,3,5),(51731,NULL,NULL,'waiting',1,3,15,3,7),(51732,NULL,NULL,'waiting',4,3,15,3,9),(51733,NULL,NULL,'waiting',4,3,15,3,11),(51734,NULL,NULL,'waiting',5,3,15,3,13),(51735,NULL,NULL,'waiting',5,3,15,3,15),(51736,NULL,NULL,'waiting',2,3,15,4,1),(51737,NULL,NULL,'waiting',1,3,15,4,3),(51738,NULL,NULL,'waiting',3,3,15,4,5),(51739,NULL,NULL,'waiting',10,3,15,4,7),(51740,NULL,NULL,'waiting',6,3,15,4,9),(51741,NULL,NULL,'waiting',6,3,15,4,11),(51742,NULL,NULL,'waiting',7,3,15,4,13),(51743,NULL,NULL,'waiting',7,3,15,4,15),(51744,NULL,NULL,'waiting',2,3,15,5,1),(51745,NULL,NULL,'waiting',1,3,15,5,3),(51746,NULL,NULL,'waiting',3,3,15,5,5),(51747,NULL,NULL,'waiting',11,3,15,5,7),(51748,NULL,NULL,'waiting',8,3,15,5,9),(51749,NULL,NULL,'waiting',8,3,15,5,11),(51750,NULL,NULL,'waiting',9,3,15,5,13),(51751,NULL,NULL,'waiting',9,3,15,5,15);
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50708 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseTime`
--

LOCK TABLES `CourseTime` WRITE;
/*!40000 ALTER TABLE `CourseTime` DISABLE KEYS */;
INSERT INTO `CourseTime` VALUES (50667,1,'morning3',1),(50668,2,'morning1',1),(50669,2,'morning2',1),(50670,3,'morning4',1),(50671,4,'morning2',1),(50672,5,'morning2',1),(50673,1,'morning1',2),(50674,1,'morning2',2),(50675,2,'morning4',2),(50676,3,'morning3',2),(50677,4,'morning1',2),(50678,5,'morning1',2),(50679,1,'morning4',3),(50680,2,'morning3',3),(50681,3,'morning1',3),(50682,3,'morning2',3),(50683,4,'morning3',3),(50684,5,'morning3',3),(50685,1,'afternoon1',4),(50686,3,'afternoon1',4),(50687,3,'afternoon2',4),(50688,1,'afternoon2',5),(50689,3,'afternoon3',5),(50690,3,'afternoon4',5),(50691,1,'afternoon3',6),(50692,4,'afternoon1',6),(50693,4,'afternoon2',6),(50694,2,'afternoon1',7),(50695,4,'afternoon3',7),(50696,4,'afternoon4',7),(50697,2,'afternoon2',8),(50698,5,'afternoon1',8),(50699,5,'afternoon2',8),(50700,2,'afternoon3',9),(50701,5,'afternoon3',9),(50702,5,'afternoon4',9),(50703,1,'afternoon4',10),(50704,4,'morning4',10),(50705,2,'afternoon4',11),(50706,5,'morning4',11),(50707,0,'morning1',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FaceInformation`
--

LOCK TABLES `FaceInformation` WRITE;
/*!40000 ALTER TABLE `FaceInformation` DISABLE KEYS */;
INSERT INTO `FaceInformation` VALUES ('/opt/myProject_another/photoes/peopleList/lly1.jpeg',58),('/opt/myProject_another/photoes/peopleList/shl2.jpeg',59),('/opt/myProject_another/photoes/peopleList/lhy1.jpeg',60);
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
INSERT INTO `LeaveRecord` VALUES (1,1,1,NULL,NULL,27,'xxxxx','pass',14,4,1),(2,1,1,NULL,NULL,27,'2','fail',14,2,1),(3,1,10,NULL,NULL,27,'3','fail',14,3,1),(4,1,10,NULL,NULL,27,'4.5','pass',14,5,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeaveRecordFactory`
--

LOCK TABLES `LeaveRecordFactory` WRITE;
/*!40000 ALTER TABLE `LeaveRecordFactory` DISABLE KEYS */;
INSERT INTO `LeaveRecordFactory` VALUES (27,'testClass',4);
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
INSERT INTO `MyClass` VALUES (2201,NULL,NULL,NULL,'testClass',27);
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
INSERT INTO `Student` VALUES (1,2201,NULL,'1','normal','lly','123',1,58),(2,2201,NULL,'2','normal','shl','123',1,59),(3,2201,NULL,'3','normal','lhy','123',1,60);
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

-- Dump completed on 2024-04-09 21:33:09
