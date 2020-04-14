CREATE DATABASE  IF NOT EXISTS `jpadatabase`;
USE `jpadatabase`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES 
(1,'adarsh','kumar','21232f297a57a5a743894a0e4a801fc3','adi')
,(2,'radha','singh','ee11cbb19052e40b07aac0ca060c23ee','radha');

UNLOCK TABLES;



DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `role` int(11) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `roleName` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3580769128426C` (`user_id`),
  CONSTRAINT `FK3580769128426C` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


LOCK TABLES `role` WRITE;

INSERT INTO `role` VALUES 
(1,1,1,'Admin')
,(2,2,2,'User');

UNLOCK TABLES;


