DROP TABLE IF EXISTS `test`.`employee`;
CREATE TABLE  `test`.`employee` (
  `employee_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `test`.`meetings`;
CREATE TABLE  `test`.`meetings` (
  `meeting_id` int(11) NOT NULL AUTO_INCREMENT,
  `meeting_place` varchar(255) DEFAULT NULL,
  `meeting_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `test`.`emp_meetings`;
CREATE TABLE  `test`.`emp_meetings` (
  `employee_id` bigint(20) NOT NULL,
  `meeting_id` int(11) NOT NULL,
  KEY `FK20A0072F4C697E19` (`meeting_id`),
  KEY `FK20A0072FCD8B91DC` (`employee_id`),
  CONSTRAINT `FK20A0072FCD8B91DC` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`),
  CONSTRAINT `FK20A0072F4C697E19` FOREIGN KEY (`meeting_id`) REFERENCES `meetings` (`meeting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;