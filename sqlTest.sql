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
) ENGINE=InnoDB AUTO_INCREMENT=51032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AttendanceRecord`
--

LOCK TABLES `AttendanceRecord` WRITE;
/*!40000 ALTER TABLE `AttendanceRecord` DISABLE KEYS */;
INSERT INTO `AttendanceRecord` VALUES (50790,NULL,NULL,'normal',1,1,14,1,1),(50791,NULL,NULL,'normal',2,1,14,1,3),(50792,NULL,NULL,'normal',0,1,14,1,5),(50793,NULL,NULL,'waiting',0,1,14,1,7),(50794,NULL,NULL,'waiting',0,1,14,1,9),(50795,NULL,NULL,'waiting',0,1,14,1,11),(50796,NULL,NULL,'waiting',0,1,14,1,13),(50797,NULL,NULL,'waiting',0,1,14,1,15),(50798,NULL,NULL,'waiting',0,1,14,2,1),(50799,NULL,NULL,'waiting',2,1,14,2,3),(50800,NULL,NULL,'waiting',0,1,14,2,5),(50801,NULL,NULL,'waiting',0,1,14,2,7),(50802,NULL,NULL,'waiting',0,1,14,2,9),(50803,NULL,NULL,'waiting',0,1,14,2,11),(50804,NULL,NULL,'waiting',0,1,14,2,13),(50805,NULL,NULL,'waiting',0,1,14,2,15),(50806,NULL,NULL,'waiting',0,1,14,3,1),(50807,NULL,NULL,'waiting',0,1,14,3,3),(50808,NULL,NULL,'waiting',0,1,14,3,5),(50809,NULL,NULL,'waiting',0,1,14,3,7),(50810,NULL,NULL,'waiting',0,1,14,3,9),(50811,NULL,NULL,'waiting',1,1,14,3,11),(50812,NULL,NULL,'waiting',0,1,14,3,13),(50813,NULL,NULL,'waiting',0,1,14,3,15),(50814,NULL,NULL,'waiting',0,1,14,4,1),(50815,NULL,NULL,'waiting',0,1,14,4,3),(50816,NULL,NULL,'waiting',0,1,14,4,5),(50817,NULL,NULL,'waiting',0,1,14,4,7),(50818,NULL,NULL,'waiting',0,1,14,4,9),(50819,NULL,NULL,'waiting',0,1,14,4,11),(50820,NULL,NULL,'normal',0,1,14,4,13),(50821,NULL,NULL,'absent',0,1,14,4,15),(50822,NULL,NULL,'waiting',0,1,14,5,1),(50823,NULL,NULL,'waiting',0,1,14,5,3),(50824,NULL,NULL,'waiting',0,1,14,5,5),(50825,NULL,NULL,'waiting',0,1,14,5,7),(50826,NULL,NULL,'waiting',0,1,14,5,9),(50827,NULL,NULL,'waiting',0,1,14,5,11),(50828,NULL,NULL,'waiting',0,1,14,5,13),(50829,NULL,NULL,'waiting',0,1,14,5,15),(50830,NULL,NULL,'waiting',1,1,15,1,1),(50831,NULL,NULL,'waiting',2,1,15,1,3),(50832,NULL,NULL,'waiting',0,1,15,1,5),(50833,NULL,NULL,'waiting',0,1,15,1,7),(50834,NULL,NULL,'waiting',0,1,15,1,9),(50835,NULL,NULL,'waiting',0,1,15,1,11),(50836,NULL,NULL,'waiting',0,1,15,1,13),(50837,NULL,NULL,'waiting',0,1,15,1,15),(50838,NULL,NULL,'waiting',0,1,15,2,1),(50839,NULL,NULL,'waiting',2,1,15,2,3),(50840,NULL,NULL,'waiting',0,1,15,2,5),(50841,NULL,NULL,'waiting',0,1,15,2,7),(50842,NULL,NULL,'waiting',0,1,15,2,9),(50843,NULL,NULL,'waiting',0,1,15,2,11),(50844,NULL,NULL,'waiting',0,1,15,2,13),(50845,NULL,NULL,'waiting',0,1,15,2,15),(50846,NULL,NULL,'waiting',0,1,15,3,1),(50847,NULL,NULL,'waiting',0,1,15,3,3),(50848,NULL,NULL,'waiting',0,1,15,3,5),(50849,NULL,NULL,'waiting',0,1,15,3,7),(50850,NULL,NULL,'waiting',0,1,15,3,9),(50851,NULL,NULL,'waiting',1,1,15,3,11),(50852,NULL,NULL,'waiting',0,1,15,3,13),(50853,NULL,NULL,'waiting',0,1,15,3,15),(50854,NULL,NULL,'waiting',0,1,15,4,1),(50855,NULL,NULL,'waiting',0,1,15,4,3),(50856,NULL,NULL,'waiting',0,1,15,4,5),(50857,NULL,NULL,'waiting',0,1,15,4,7),(50858,NULL,NULL,'waiting',0,1,15,4,9),(50859,NULL,NULL,'waiting',0,1,15,4,11),(50860,NULL,NULL,'waiting',0,1,15,4,13),(50861,NULL,NULL,'waiting',0,1,15,4,15),(50862,NULL,NULL,'waiting',0,1,15,5,1),(50863,NULL,NULL,'waiting',0,1,15,5,3),(50864,NULL,NULL,'waiting',0,1,15,5,5),(50865,NULL,NULL,'waiting',0,1,15,5,7),(50866,NULL,NULL,'waiting',0,1,15,5,9),(50867,NULL,NULL,'waiting',0,1,15,5,11),(50868,NULL,NULL,'waiting',0,1,15,5,13),(50869,NULL,NULL,'waiting',0,1,15,5,15),(50870,NULL,NULL,'waiting',1,2,14,1,1),(50871,NULL,NULL,'waiting',2,2,14,1,3),(50872,NULL,NULL,'waiting',0,2,14,1,5),(50873,NULL,NULL,'waiting',0,2,14,1,7),(50874,NULL,NULL,'waiting',0,2,14,1,9),(50875,NULL,NULL,'waiting',0,2,14,1,11),(50876,NULL,NULL,'waiting',0,2,14,1,13),(50877,NULL,NULL,'waiting',0,2,14,1,15),(50878,NULL,NULL,'waiting',0,2,14,2,1),(50879,NULL,NULL,'waiting',2,2,14,2,3),(50880,NULL,NULL,'waiting',0,2,14,2,5),(50881,NULL,NULL,'waiting',0,2,14,2,7),(50882,NULL,NULL,'waiting',0,2,14,2,9),(50883,NULL,NULL,'waiting',0,2,14,2,11),(50884,NULL,NULL,'waiting',0,2,14,2,13),(50885,NULL,NULL,'waiting',0,2,14,2,15),(50886,NULL,NULL,'waiting',0,2,14,3,1),(50887,NULL,NULL,'waiting',0,2,14,3,3),(50888,NULL,NULL,'waiting',0,2,14,3,5),(50889,NULL,NULL,'waiting',0,2,14,3,7),(50890,NULL,NULL,'waiting',0,2,14,3,9),(50891,NULL,NULL,'waiting',1,2,14,3,11),(50892,NULL,NULL,'waiting',0,2,14,3,13),(50893,NULL,NULL,'waiting',0,2,14,3,15),(50894,NULL,NULL,'waiting',0,2,14,4,1),(50895,NULL,NULL,'waiting',0,2,14,4,3),(50896,NULL,NULL,'waiting',0,2,14,4,5),(50897,NULL,NULL,'waiting',0,2,14,4,7),(50898,NULL,NULL,'waiting',0,2,14,4,9),(50899,NULL,NULL,'waiting',0,2,14,4,11),(50900,NULL,NULL,'waiting',0,2,14,4,13),(50901,NULL,NULL,'leave',0,2,14,4,15),(50902,NULL,NULL,'waiting',0,2,14,5,1),(50903,NULL,NULL,'waiting',0,2,14,5,3),(50904,NULL,NULL,'waiting',0,2,14,5,5),(50905,NULL,NULL,'waiting',0,2,14,5,7),(50906,NULL,NULL,'waiting',0,2,14,5,9),(50907,NULL,NULL,'waiting',0,2,14,5,11),(50908,NULL,NULL,'waiting',0,2,14,5,13),(50909,NULL,NULL,'waiting',0,2,14,5,15),(50910,NULL,NULL,'waiting',1,2,15,1,1),(50911,NULL,NULL,'waiting',2,2,15,1,3),(50912,NULL,NULL,'waiting',0,2,15,1,5),(50913,NULL,NULL,'waiting',0,2,15,1,7),(50914,NULL,NULL,'waiting',0,2,15,1,9),(50915,NULL,NULL,'waiting',0,2,15,1,11),(50916,NULL,NULL,'waiting',0,2,15,1,13),(50917,NULL,NULL,'waiting',0,2,15,1,15),(50918,NULL,NULL,'waiting',0,2,15,2,1),(50919,NULL,NULL,'waiting',2,2,15,2,3),(50920,NULL,NULL,'waiting',0,2,15,2,5),(50921,NULL,NULL,'waiting',0,2,15,2,7),(50922,NULL,NULL,'waiting',0,2,15,2,9),(50923,NULL,NULL,'waiting',0,2,15,2,11),(50924,NULL,NULL,'waiting',0,2,15,2,13),(50925,NULL,NULL,'waiting',0,2,15,2,15),(50926,NULL,NULL,'waiting',0,2,15,3,1),(50927,NULL,NULL,'waiting',0,2,15,3,3),(50928,NULL,NULL,'waiting',0,2,15,3,5),(50929,NULL,NULL,'waiting',0,2,15,3,7),(50930,NULL,NULL,'waiting',0,2,15,3,9),(50931,NULL,NULL,'waiting',1,2,15,3,11),(50932,NULL,NULL,'waiting',0,2,15,3,13),(50933,NULL,NULL,'waiting',0,2,15,3,15),(50934,NULL,NULL,'waiting',0,2,15,4,1),(50935,NULL,NULL,'waiting',0,2,15,4,3),(50936,NULL,NULL,'waiting',0,2,15,4,5),(50937,NULL,NULL,'waiting',0,2,15,4,7),(50938,NULL,NULL,'waiting',0,2,15,4,9),(50939,NULL,NULL,'waiting',0,2,15,4,11),(50940,NULL,NULL,'waiting',0,2,15,4,13),(50941,NULL,NULL,'waiting',0,2,15,4,15),(50942,NULL,NULL,'waiting',0,2,15,5,1),(50943,NULL,NULL,'waiting',0,2,15,5,3),(50944,NULL,NULL,'waiting',0,2,15,5,5),(50945,NULL,NULL,'waiting',0,2,15,5,7),(50946,NULL,NULL,'waiting',0,2,15,5,9),(50947,NULL,NULL,'waiting',0,2,15,5,11),(50948,NULL,NULL,'waiting',0,2,15,5,13),(50949,NULL,NULL,'waiting',0,2,15,5,15),(50950,NULL,NULL,'waiting',1,3,14,1,1),(50951,NULL,NULL,'waiting',2,3,14,1,3),(50952,NULL,NULL,'waiting',0,3,14,1,5),(50953,NULL,NULL,'waiting',0,3,14,1,7),(50954,NULL,NULL,'waiting',0,3,14,1,9),(50955,NULL,NULL,'waiting',0,3,14,1,11),(50956,NULL,NULL,'waiting',0,3,14,1,13),(50957,NULL,NULL,'waiting',0,3,14,1,15),(50958,NULL,NULL,'waiting',0,3,14,2,1),(50959,NULL,NULL,'waiting',2,3,14,2,3),(50960,NULL,NULL,'waiting',0,3,14,2,5),(50961,NULL,NULL,'waiting',0,3,14,2,7),(50962,NULL,NULL,'waiting',0,3,14,2,9),(50963,NULL,NULL,'waiting',0,3,14,2,11),(50964,NULL,NULL,'waiting',0,3,14,2,13),(50965,NULL,NULL,'waiting',0,3,14,2,15),(50966,NULL,NULL,'waiting',0,3,14,3,1),(50967,NULL,NULL,'waiting',0,3,14,3,3),(50968,NULL,NULL,'waiting',0,3,14,3,5),(50969,NULL,NULL,'waiting',0,3,14,3,7),(50970,NULL,NULL,'waiting',0,3,14,3,9),(50971,NULL,NULL,'waiting',1,3,14,3,11),(50972,NULL,NULL,'waiting',0,3,14,3,13),(50973,NULL,NULL,'waiting',0,3,14,3,15),(50974,NULL,NULL,'waiting',0,3,14,4,1),(50975,NULL,NULL,'waiting',0,3,14,4,3),(50976,NULL,NULL,'waiting',0,3,14,4,5),(50977,NULL,NULL,'waiting',0,3,14,4,7),(50978,NULL,NULL,'waiting',0,3,14,4,9),(50979,NULL,NULL,'waiting',0,3,14,4,11),(50980,NULL,NULL,'waiting',0,3,14,4,13),(50981,NULL,NULL,'normal',0,3,14,4,15),(50982,NULL,NULL,'waiting',0,3,14,5,1),(50983,NULL,NULL,'waiting',0,3,14,5,3),(50984,NULL,NULL,'waiting',0,3,14,5,5),(50985,NULL,NULL,'waiting',0,3,14,5,7),(50986,NULL,NULL,'waiting',0,3,14,5,9),(50987,NULL,NULL,'waiting',0,3,14,5,11),(50988,NULL,NULL,'waiting',0,3,14,5,13),(50989,NULL,NULL,'waiting',0,3,14,5,15),(50990,NULL,NULL,'waiting',1,3,15,1,1),(50991,NULL,NULL,'waiting',2,3,15,1,3),(50992,NULL,NULL,'waiting',0,3,15,1,5),(50993,NULL,NULL,'waiting',0,3,15,1,7),(50994,NULL,NULL,'waiting',0,3,15,1,9),(50995,NULL,NULL,'waiting',0,3,15,1,11),(50996,NULL,NULL,'waiting',0,3,15,1,13),(50997,NULL,NULL,'waiting',0,3,15,1,15),(50998,NULL,NULL,'waiting',0,3,15,2,1),(50999,NULL,NULL,'waiting',2,3,15,2,3),(51000,NULL,NULL,'waiting',0,3,15,2,5),(51001,NULL,NULL,'waiting',0,3,15,2,7),(51002,NULL,NULL,'waiting',0,3,15,2,9),(51003,NULL,NULL,'waiting',0,3,15,2,11),(51004,NULL,NULL,'waiting',0,3,15,2,13),(51005,NULL,NULL,'waiting',0,3,15,2,15),(51006,NULL,NULL,'waiting',0,3,15,3,1),(51007,NULL,NULL,'waiting',0,3,15,3,3),(51008,NULL,NULL,'waiting',0,3,15,3,5),(51009,NULL,NULL,'waiting',0,3,15,3,7),(51010,NULL,NULL,'waiting',0,3,15,3,9),(51011,NULL,NULL,'waiting',1,3,15,3,11),(51012,NULL,NULL,'waiting',0,3,15,3,13),(51013,NULL,NULL,'waiting',0,3,15,3,15),(51014,NULL,NULL,'waiting',0,3,15,4,1),(51015,NULL,NULL,'waiting',0,3,15,4,3),(51016,NULL,NULL,'waiting',0,3,15,4,5),(51017,NULL,NULL,'waiting',0,3,15,4,7),(51018,NULL,NULL,'waiting',0,3,15,4,9),(51019,NULL,NULL,'waiting',0,3,15,4,11),(51020,NULL,NULL,'waiting',0,3,15,4,13),(51021,NULL,NULL,'waiting',0,3,15,4,15),(51022,NULL,NULL,'waiting',0,3,15,5,1),(51023,NULL,NULL,'waiting',0,3,15,5,3),(51024,NULL,NULL,'waiting',0,3,15,5,5),(51025,NULL,NULL,'waiting',0,3,15,5,7),(51026,NULL,NULL,'waiting',0,3,15,5,9),(51027,NULL,NULL,'waiting',0,3,15,5,11),(51028,NULL,NULL,'waiting',0,3,15,5,13),(51029,NULL,NULL,'waiting',0,3,15,5,15);
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
) ENGINE=InnoDB AUTO_INCREMENT=50586 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CourseTime`
--

LOCK TABLES `CourseTime` WRITE;
/*!40000 ALTER TABLE `CourseTime` DISABLE KEYS */;
INSERT INTO `CourseTime` VALUES (50581,1,'morning1',1),(50582,3,'afternoon2',1),(50583,1,'morning2',2),(50584,2,'morning2',2),(50585,0,'morning1',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FaceInformation`
--

LOCK TABLES `FaceInformation` WRITE;
/*!40000 ALTER TABLE `FaceInformation` DISABLE KEYS */;
INSERT INTO `FaceInformation` VALUES ('/opt/myProject_another/photoes/peopleList/lly1.jpeg',49),('/opt/myProject_another/photoes/peopleList/shl2.jpeg',50),('/opt/myProject_another/photoes/peopleList/lhy1.jpeg',51);
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
INSERT INTO `LeaveRecord` VALUES (1,1,1,NULL,NULL,24,'rex','pass',14,2,1),(2,2,1,NULL,NULL,24,'t','pass',14,4,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `LeaveRecordFactory`
--

LOCK TABLES `LeaveRecordFactory` WRITE;
/*!40000 ALTER TABLE `LeaveRecordFactory` DISABLE KEYS */;
INSERT INTO `LeaveRecordFactory` VALUES (24,'testClass',2);
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
INSERT INTO `MyClass` VALUES (2201,NULL,NULL,NULL,'testClass',24);
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
INSERT INTO `Student` VALUES (1,2201,NULL,'1','normal','lly','123',1,49),(2,2201,NULL,'2','normal','shl','123',1,50),(3,2201,NULL,'3','normal','lhy','123',1,51);
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

-- Dump completed on 2024-04-04 17:24:56
