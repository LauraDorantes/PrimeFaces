-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema TAREA1
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema TAREA1
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TAREA1` DEFAULT CHARACTER SET utf8 ;
USE `TAREA1` ;

-- -----------------------------------------------------
-- Table `TAREA1`.`TBL_UNO`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TAREA1`.`TBL_UNO` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CAMPO1` INT NOT NULL,
  `CAMPO2` VARCHAR(100) NOT NULL,
  `CAMPO3` VARCHAR(45) NOT NULL,
  `CAMPO4` DATETIME NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TAREA1`.`TBL_DOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TAREA1`.`TBL_DOS` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `CAMPO1` INT NOT NULL,
  `CAMPO2` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
