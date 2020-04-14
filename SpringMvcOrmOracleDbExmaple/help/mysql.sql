DROP TABLE IF EXISTS `test`.`employee`;
CREATE TABLE  `test`.`employee` (
  `empid` int(11) NOT NULL AUTO_INCREMENT,
  `empaddress` varchar(255) DEFAULT NULL,
  `empAge` int(11) DEFAULT NULL,
  `empname` varchar(255) DEFAULT NULL,
  `salary` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`empid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;