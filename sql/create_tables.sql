CREATE DATABASE  IF NOT EXISTS `post_directory`;
USE `post_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `user`;


CREATE TABLE `user` (
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;


CREATE TABLE `post` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) DEFAULT NULL,
  `content` varchar(100) DEFAULT NULL,
  `image_path` varchar(100) DEFAULT NULL,
  `creator` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CREATOR_idx` (`creator`),
  CONSTRAINT `FK_DETAIL` FOREIGN KEY (`creator`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- select * from user
--


