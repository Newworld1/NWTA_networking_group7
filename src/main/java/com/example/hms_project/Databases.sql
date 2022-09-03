CREATE SCHEMA `hms_db` ;

CREATE TABLE `hms_db`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `level` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `hms_db`.`staff` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `dob` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


  CREATE TABLE `hms_db`.`booking` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `bookingA` VARCHAR(45) NOT NULL,
    `studentId` VARCHAR(45) NOT NULL,
    `roomId` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`));


    CREATE TABLE `hms_db`.`payment` (
      `idpayment` INT NOT NULL AUTO_INCREMENT,
      `pAmount` VARCHAR(45) NOT NULL,
      `pDate` VARCHAR(45) NOT NULL,
      `bookingId` VARCHAR(45) NOT NULL,
      `staffId` VARCHAR(45) NOT NULL,
      `studentId` VARCHAR(45) NOT NULL,
      PRIMARY KEY (`idpayment`));


CREATE TABLE `hms_db`.`room` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `roomNumber` VARCHAR(45) NOT NULL,
  `roomType` VARCHAR(45) NOT NULL,
  `facility` VARCHAR(45) NOT NULL ;
  `CPS` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));