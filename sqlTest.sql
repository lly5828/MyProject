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
) ENGINE=InnoDB AUTO_INCREMENT=50790 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AttendanceRecord`
--

LOCK TABLES `AttendanceRecord` WRITE;
/*!40000 ALTER TABLE `AttendanceRecord` DISABLE KEYS */;
INSERT INTO `AttendanceRecord` VALUES (50670,NULL,NULL,'waiting',1,1,1,1,1),(50671,NULL,NULL,'normal',2,1,1,1,3),(50672,NULL,NULL,'normal',0,1,1,1,5),(50673,NULL,NULL,'waiting',0,1,1,1,7),(50674,NULL,NULL,'waiting',0,1,1,1,9),(50675,NULL,NULL,'waiting',0,1,1,1,11),(50676,NULL,NULL,'waiting',0,1,1,1,13),(50677,NULL,NULL,'waiting',0,1,1,1,15),(50678,NULL,NULL,'waiting',0,1,1,2,1),(50679,NULL,NULL,'waiting',2,1,1,2,3),(50680,NULL,NULL,'waiting',0,1,1,2,5),(50681,NULL,NULL,'waiting',0,1,1,2,7),(50682,NULL,NULL,'waiting',0,1,1,2,9),(50683,NULL,NULL,'waiting',0,1,1,2,11),(50684,NULL,NULL,'waiting',0,1,1,2,13),(50685,NULL,NULL,'waiting',0,1,1,2,15),(50686,NULL,NULL,'waiting',0,1,1,3,1),(50687,NULL,NULL,'waiting',0,1,1,3,3),(50688,NULL,NULL,'waiting',0,1,1,3,5),(50689,NULL,NULL,'waiting',0,1,1,3,7),(50690,NULL,NULL,'waiting',0,1,1,3,9),(50691,NULL,NULL,'waiting',1,1,1,3,11),(50692,NULL,NULL,'waiting',0,1,1,3,13),(50693,NULL,NULL,'waiting',0,1,1,3,15),(50694,NULL,NULL,'waiting',0,1,1,4,1),(50695,NULL,NULL,'waiting',0,1,1,4,3),(50696,NULL,NULL,'waiting',0,1,1,4,5),(50697,NULL,NULL,'waiting',0,1,1,4,7),(50698,NULL,NULL,'waiting',0,1,1,4,9),(50699,NULL,NULL,'waiting',0,1,1,4,11),(50700,NULL,NULL,'waiting',0,1,1,4,13),(50701,NULL,NULL,'waiting',0,1,1,4,15),(50702,NULL,NULL,'waiting',0,1,1,5,1),(50703,NULL,NULL,'waiting',0,1,1,5,3),(50704,NULL,NULL,'waiting',0,1,1,5,5),(50705,NULL,NULL,'waiting',0,1,1,5,7),(50706,NULL,NULL,'waiting',0,1,1,5,9),(50707,NULL,NULL,'waiting',0,1,1,5,11),(50708,NULL,NULL,'waiting',0,1,1,5,13),(50709,NULL,NULL,'waiting',0,1,1,5,15),(50710,NULL,NULL,'waiting',1,2,1,1,1),(50711,NULL,NULL,'waiting',2,2,1,1,3),(50712,NULL,NULL,'waiting',0,2,1,1,5),(50713,NULL,NULL,'waiting',0,2,1,1,7),(50714,NULL,NULL,'waiting',0,2,1,1,9),(50715,NULL,NULL,'waiting',0,2,1,1,11),(50716,NULL,NULL,'waiting',0,2,1,1,13),(50717,NULL,NULL,'waiting',0,2,1,1,15),(50718,NULL,NULL,'waiting',0,2,1,2,1),(50719,NULL,NULL,'waiting',2,2,1,2,3),(50720,NULL,NULL,'waiting',0,2,1,2,5),(50721,NULL,NULL,'waiting',0,2,1,2,7),(50722,NULL,NULL,'waiting',0,2,1,2,9),(50723,NULL,NULL,'waiting',0,2,1,2,11),(50724,NULL,NULL,'waiting',0,2,1,2,13),(50725,NULL,NULL,'waiting',0,2,1,2,15),(50726,NULL,NULL,'waiting',0,2,1,3,1),(50727,NULL,NULL,'waiting',0,2,1,3,3),(50728,NULL,NULL,'waiting',0,2,1,3,5),(50729,NULL,NULL,'waiting',0,2,1,3,7),(50730,NULL,NULL,'waiting',0,2,1,3,9),(50731,NULL,NULL,'waiting',1,2,1,3,11),(50732,NULL,NULL,'waiting',0,2,1,3,13),(50733,NULL,NULL,'waiting',0,2,1,3,15),(50734,NULL,NULL,'waiting',0,2,1,4,1),(50735,NULL,NULL,'waiting',0,2,1,4,3),(50736,NULL,NULL,'waiting',0,2,1,4,5),(50737,NULL,NULL,'waiting',0,2,1,4,7),(50738,NULL,NULL,'waiting',0,2,1,4,9),(50739,NULL,NULL,'waiting',0,2,1,4,11),(50740,NULL,NULL,'waiting',0,2,1,4,13),(50741,NULL,NULL,'waiting',0,2,1,4,15),(50742,NULL,NULL,'waiting',0,2,1,5,1),(50743,NULL,NULL,'waiting',0,2,1,5,3),(50744,NULL,NULL,'waiting',0,2,1,5,5),(50745,NULL,NULL,'waiting',0,2,1,5,7),(50746,NULL,NULL,'waiting',0,2,1,5,9),(50747,NULL,NULL,'waiting',0,2,1,5,11),(50748,NULL,NULL,'waiting',0,2,1,5,13),(50749,NULL,NULL,'waiting',0,2,1,5,15),(50750,NULL,NULL,'waiting',1,3,1,1,1),(50751,NULL,NULL,'waiting',2,3,1,1,3),(50752,NULL,NULL,'waiting',0,3,1,1,5),(50753,NULL,NULL,'waiting',0,3,1,1,7),(50754,NULL,NULL,'waiting',0,3,1,1,9),(50755,NULL,NULL,'waiting',0,3,1,1,11),(50756,NULL,NULL,'waiting',0,3,1,1,13),(50757,NULL,NULL,'waiting',0,3,1,1,15),(50758,NULL,NULL,'waiting',0,3,1,2,1),(50759,NULL,NULL,'waiting',2,3,1,2,3),(50760,NULL,NULL,'waiting',0,3,1,2,5),(50761,NULL,NULL,'waiting',0,3,1,2,7),(50762,NULL,NULL,'waiting',0,3,1,2,9),(50763,NULL,NULL,'waiting',0,3,1,2,11),(50764,NULL,NULL,'waiting',0,3,1,2,13),(50765,NULL,NULL,'waiting',0,3,1,2,15),(50766,NULL,NULL,'waiting',0,3,1,3,1),(50767,NULL,NULL,'waiting',0,3,1,3,3),(50768,NULL,NULL,'waiting',0,3,1,3,5),(50769,NULL,NULL,'waiting',0,3,1,3,7),(50770,NULL,NULL,'waiting',0,3,1,3,9),(50771,NULL,NULL,'waiting',1,3,1,3,11),(50772,NULL,NULL,'waiting',0,3,1,3,13),(50773,NULL,NULL,'waiting',0,3,1,3,15),(50774,NULL,NULL,'waiting',0,3,1,4,1),(50775,NULL,NULL,'waiting',0,3,1,4,3),(50776,NULL,NULL,'waiting',0,3,1,4,5),(50777,NULL,NULL,'waiting',0,3,1,4,7),(50778,NULL,NULL,'waiting',0,3,1,4,9),(50779,NULL,NULL,'waiting',0,3,1,4,11),(50780,NULL,NULL,'waiting',0,3,1,4,13),(50781,NULL,NULL,'waiting',0,3,1,4,15),(50782,NULL,NULL,'waiting',0,3,1,5,1),(50783,NULL,NULL,'waiting',0,3,1,5,3),(50784,NULL,NULL,'waiting',0,3,1,5,5),(50785,NULL,NULL,'waiting',0,3,1,5,7),(50786,NULL,NULL,'waiting',0,3,1,5,9),(50787,NULL,NULL,'waiting',0,3,1,5,11),(50788,NULL,NULL,'waiting',0,3,1,5,13),(50789,NULL,NULL,'waiting',0,3,1,5,15);
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
INSERT INTO `Course` VALUES (0,'empty',2201,32767,1),(1,'math',2201,1,1),(2,'computer',2201,2,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=50581 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseTime`
--

LOCK TABLES `CourseTime` WRITE;
/*!40000 ALTER TABLE `CourseTime` DISABLE KEYS */;
INSERT INTO `CourseTime` VALUES (50576,1,'morning1',1),(50577,3,'afternoon2',1),(50578,1,'morning2',2),(50579,2,'morning2',2),(50580,0,'morning1',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FaceInformation`
--

LOCK TABLES `FaceInformation` WRITE;
/*!40000 ALTER TABLE `FaceInformation` DISABLE KEYS */;
INSERT INTO `FaceInformation` VALUES ('/opt/myProject_another/photoes/peopleList/lly1.jpeg',46),('/opt/myProject_another/photoes/peopleList/shl2.jpeg',47),('/opt/myProject_another/photoes/peopleList/lhy1.jpeg',48);
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
INSERT INTO `LeaveRecord` VALUES (1,1,1,NULL,NULL,23,'rex','pass',1,2,1),(2,1,32767,NULL,NULL,23,'t','waiting',1,3,1),(3,1,1,NULL,NULL,23,'t','pass',1,1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeaveRecordFactory`
--

LOCK TABLES `LeaveRecordFactory` WRITE;
/*!40000 ALTER TABLE `LeaveRecordFactory` DISABLE KEYS */;
INSERT INTO `LeaveRecordFactory` VALUES (23,'testClass',3);
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
INSERT INTO `MyClass` VALUES (2201,NULL,NULL,NULL,'testClass',23);
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
INSERT INTO `Student` VALUES (1,2201,NULL,'1','normal','lly','123',1,46),(2,2201,NULL,'2','normal','shl','123',1,47),(3,2201,NULL,'3','normal','lhy','123',1,48);
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
INSERT INTO `Teacher` VALUES (1,2201,1,'1','teaM','123',1),(2,2201,2,'2','teaC','789',0),(32767,2201,0,'32767','null','null',1);
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

-- Dump completed on 2024-04-04 11:42:21
