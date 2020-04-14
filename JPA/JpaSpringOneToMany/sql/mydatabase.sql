
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

INSERT INTO `CREDIT_CARD` (`ID`, `NUMBER`, `TYPE`) VALUES
(1, '5162 6060 9949 0150', 'MasterCard'),
(2, '4916 6904 4775 9328', 'Visa'),
(3, '5565 5022 2072 6872', 'MasterCard'),
(4, '4485 6328 4051 8159', 'Visa'),
(5, '5226 0970 9242 2313', 'MasterCard'),
(6, '5130 8051 3184 9683', 'MasterCard');

--
-- Dumping data for table `PERSON`
--

INSERT INTO `PERSON` (`ID`, `FIRST_NAME`, `LAST_NAME`, `MONEY`) VALUES
(1, 'Adarsh', 'Kumar', 10000),
(2, 'Amit', 'Kumar', 20000),
(3, 'Radha', 'Singh', 15000);

--
-- Dumping data for table `PERSON_CREDIT_CARD`
--

INSERT INTO `PERSON_CREDIT_CARD` (`PERSON_ID`, `creditCards_ID`) VALUES
(1, 1),
(2, 2),
(2, 3),
(3, 4),
(3, 5),
(3, 6);
