SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

create database if not exists javafxTest;
use javafxTest;

--
-- Структура таблицы `broni`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`broni` (
  `BroniID` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `AdminID` int NOT NULL,
  `UserID` int NOT NULL,
  `ComputerID` int NOT NULL,
  PRIMARY KEY (`BroniID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `admins`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`admins` (
  `AdminID` int NOT NULL,
  `FIO` varchar(45) NOT NULL,
  `Salary` int NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  PRIMARY KEY (`AdminID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `users`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`users` (
  `UserID` int NOT NULL,
  `FIO` varchar(45) NOT NULL,
  `Passport` varchar(45) NOT NULL,
  `Login` varchar(45) NOT NULL,
  `Passw` varchar(45) NOT NULL,
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `rooms`
--


CREATE TABLE IF NOT EXISTS `javafxTest`.`rooms` (
  `RoomID` int NOT NULL,
  `Type` varchar(45) NOT NULL,
  `Cost per hour` varchar(45) NOT NULL,
  `Number of computers` varchar(45) NOT NULL,
  PRIMARY KEY (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `products`
--


CREATE TABLE IF NOT EXISTS `javafxTest`.`products` (
  `ProductID` int NOT NULL,
  `ProductName` varchar(45) NOT NULL,
  `ProductQuantity` int NOT NULL,
  `ProductPrice` double NOT NULL,
  PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `games`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`games` (
  `GameID` int NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Genre` varchar(45) NOT NULL,
  PRIMARY KEY (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `computers`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`computers` (
  `ComputerID` int NOT NULL,
  `CPU` varchar(45) NOT NULL,
  `Video card` varchar(45) NOT NULL,
  `RAM` varchar(45) NOT NULL,
  `RoomID` int NOT NULL,
  PRIMARY KEY (`ComputerID`),
  KEY `RoomID_idx` (`RoomID`),
  CONSTRAINT `RoomID` FOREIGN KEY (`RoomID`) REFERENCES `rooms` (`RoomID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `computers_has_games`
--

CREATE TABLE IF NOT EXISTS `javafxTest`.`computers_has_games` (
  `ComputerID` int NOT NULL,
  `GameID` int NOT NULL,
  PRIMARY KEY (`ComputerID`,`GameID`),
  KEY `fk_computers_has_games_games1_idx` (`GameID`),
  KEY `fk_computers_has_games_computers_idx` (`ComputerID`),
  CONSTRAINT `fk_computers_has_games_computers` FOREIGN KEY (`ComputerID`) REFERENCES `computers` (`ComputerID`),
  CONSTRAINT `fk_computers_has_games_games1` FOREIGN KEY (`GameID`) REFERENCES `games` (`GameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Структура таблицы `record`
--


CREATE TABLE IF NOT EXISTS `javafxTest`.`record` (
  `RecordID` int NOT NULL AUTO_INCREMENT,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `AdminID` int NOT NULL,
  `UserID` int NOT NULL,
  `ComputerID` int NOT NULL,
  `Balance` int DEFAULT NULL,
  PRIMARY KEY (`RecordID`),
  KEY `UserID_idx` (`UserID`),
  KEY `ComputerID_idx` (`ComputerID`),
  KEY `AdminID_idx` (`AdminID`),
  CONSTRAINT `AdminID` FOREIGN KEY (`AdminID`) REFERENCES `admins` (`AdminID`),
  CONSTRAINT `ComputerID` FOREIGN KEY (`ComputerID`) REFERENCES `computers` (`ComputerID`),
  CONSTRAINT `UserID` FOREIGN KEY (`UserID`) REFERENCES `users` (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Добавление данных
--

INSERT INTO `broni` VALUES (6,'2023-12-07','21:00:00',1,1,1);
INSERT INTO `admins` VALUES (1,'Дубков Матвей Алексеевич',25000,'dubkov','mat123'),(2,'Гусев Максим Иванович',20000,'gusev','max123');
INSERT INTO `users` VALUES (1,'Сычев Владислав Владимирович','2218 977345','f4orup','123123'),(2,'Свидяков Али Наилевич','2220 967543','souless','ali123'),(3,'Коверигин Иван Сергеевич','2220 987471','madlaris','ivan123'),(4,'asd asd asd','1212 123312','asdf','asdf1'),(5,'asd asd asddd','2121 123123','gwafg','sdfsdgsd'),(6,'qaz','1212','qwerty','qwerty123'),(7,'alo','12','login','parol'),(8,'','','','');
INSERT INTO `rooms` VALUES (1,'vip','120','5'),(2,'standart','90','5');
INSERT INTO `products` VALUES (1,'Чипсы Lays',7,120),(2,'Coca-Cola',15,80),(3,'Чебупели',10,150),(4,'Кириешки',13,40),(5,'Энергетик',20,115),(7,'Читос',12,60),(8,'Роллы',8,340),(9,'Чебупицца',10,210),(10,'Сухарики',20,45),(11,'Сарова 0.5',10,80),(12,'Шаурма',10,200);
INSERT INTO `games` VALUES (1,'CS 2','Шутер'),(2,'Dota 2','MOBA'),(3,'Warface','Шутер'),(4,'WOT','Военные'),(5,'WOW','Военные'),(6,'Minecraft','Песочница'),(7,'PUBG','Battle Royale'),(8,'Fortnite','Battle Royale'),(9,'RUST','Выживание'),(10,'DayZ','Выживание');
INSERT INTO `computers_has_games` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6),(9,6),(10,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(1,8),(2,8),(3,8),(4,8),(5,8),(6,8),(7,8),(8,8),(9,8),(10,8),(1,9),(2,9),(3,9),(4,9),(5,9),(6,9),(7,9),(8,9),(9,9),(10,9),(1,10),(2,10),(3,10),(4,10),(5,10),(6,10),(7,10),(8,10),(9,10),(10,10);
INSERT INTO `computers` VALUES (1,'r5 5500','rx 5700xt','16',1),(2,'i5 11400f','rtx 2060ti','16',1),(3,'r5 3600','gtx 1650ti','12',2),(4,'r7 2600','rtx 2060','16',2),(5,'i9 9900k','rtx 3080ti','32',1),(6,'r5 5600','rx 6700xt','24',1),(7,'i5 12400f','rtx 3060','16',1),(8,'r5 2600','rx 580','8',2),(9,'i5 7600','gtx 1050ti','8',2),(10,'i5 6600','gtx 1060','12',2);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;