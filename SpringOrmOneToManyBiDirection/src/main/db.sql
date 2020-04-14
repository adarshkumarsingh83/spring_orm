DROP TABLE IF EXISTS `test`.`employee`;
CREATE TABLE  `test`.`employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `test`.`phone`;
CREATE TABLE  `test`.`phone` (
  `phone_id` int(11) NOT NULL AUTO_INCREMENT,
  `phone_number` varchar(255) DEFAULT NULL,
  `phone_type` varchar(255) DEFAULT NULL,
  `employee_id` bigint(20) NOT NULL,
  PRIMARY KEY (`phone_id`),
  KEY `FK4984D4ECD8B91DC` (`employee_id`),
  CONSTRAINT `FK4984D4ECD8B91DC` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;