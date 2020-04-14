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
  PRIMARY KEY (`phone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `test`.`emp_phone`;
CREATE TABLE  `test`.`emp_phone` (
  `employee_id` bigint(20) NOT NULL,
  `phone_id` int(11) NOT NULL,
  KEY `FK87117337D467C758` (`phone_id`),
  KEY `FK87117337CD8B91DC` (`employee_id`),
  CONSTRAINT `FK87117337CD8B91DC` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK87117337D467C758` FOREIGN KEY (`phone_id`) REFERENCES `phone` (`phone_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;