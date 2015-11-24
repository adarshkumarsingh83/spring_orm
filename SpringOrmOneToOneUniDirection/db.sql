DROP TABLE IF EXISTS `test`.`employee`;
CREATE TABLE  `test`.`employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `cell_phone` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `employee_DetailId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FK75C8D6AE897F899E` (`employee_DetailId`),
  CONSTRAINT `FK75C8D6AE897F899E` FOREIGN KEY (`employee_DetailId`) REFERENCES `employee_detail` (`employee_DetailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `test`.`employee_detail`;
CREATE TABLE  `test`.`employee_detail` (
  `employee_DetailId` bigint(20) NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_DetailId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;