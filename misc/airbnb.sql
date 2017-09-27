-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema airbnb
--

CREATE DATABASE IF NOT EXISTS airbnb;
USE airbnb;

--
-- Definition of table `file_upload`
--

DROP TABLE IF EXISTS `file_upload`;
CREATE TABLE `file_upload` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(128) DEFAULT NULL,
  `file_data` longblob,
  `description` longtext,
  `entity_id` int(10) unsigned NOT NULL,
  `mime_type` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `file_upload`
--

/*!40000 ALTER TABLE `file_upload` DISABLE KEYS */;
INSERT INTO `file_upload` (`id`,`file_name`,`file_data`,`description`,`entity_id`,`mime_type`) VALUES 
/*!40000 ALTER TABLE `file_upload` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telephone` varchar(45) NOT NULL,
  `file_upload_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_file_upload_id` (`file_upload_id`),
  CONSTRAINT `FK_file_upload_id` FOREIGN KEY (`file_upload_id`) REFERENCES `file_upload` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`username`,`password`,`first_name`,`last_name`,`email`,`telephone`,`file_upload_id`) VALUES 
 (1,'mihalisp','123456','Mihalis','Papakonstantinou','mihalispapak@hotmail.com','',NULL),
 (3,'username','123456','Nikos','Nikolaou2','mihalispapak@hotmail.com','',NULL),
 (5,'spiderman','123456,123456,123456,123456,123456,123456,123456,123456','Mihalis','Papakonstantinou','mihalispapak@hotmail.com','6973297434',NULL),
 (6,'test','123,123','Mihalis','Papakonstantinou','mihalispapak@gmail.com','123',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile`
--

/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` (`id`,`type`) VALUES 
 (2,'ADMIN'),
 (4,'OWNER'),
 (5,'RENTER'),
 (1,'USER');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;


--
-- Definition of table `user_user_profile`
--

DROP TABLE IF EXISTS `user_user_profile`;
CREATE TABLE `user_user_profile` (
  `user_id` bigint(20) NOT NULL,
  `user_profile_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`user_profile_id`),
  KEY `FK_USER_PROFILE` (`user_profile_id`),
  CONSTRAINT `FK_APP_USER` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_USER_PROFILE` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_user_profile`
--

/*!40000 ALTER TABLE `user_user_profile` DISABLE KEYS */;
INSERT INTO `user_user_profile` (`user_id`,`user_profile_id`) VALUES 
 (1,2),
 (3,1),
 (3,2),
 (5,1),
 (5,2),
 (5,4),
 (5,5),
 (6,1),
 (6,2),
 (6,4),
 (6,5);
/*!40000 ALTER TABLE `user_user_profile` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;