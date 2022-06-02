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
-- Table `TAREA1`.`TBL_PROVEDOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TAREA1`.`TBL_PROVEDOR` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TAREA1`.`TBL_MARCA`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TAREA1`.`TBL_MARCA` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `MARCA` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TAREA1`.`TBL_PRODUCTOS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `TAREA1`.`TBL_PRODUCTOS` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMBRE` VARCHAR(45) NOT NULL,
  `DESCRIPCION` VARCHAR(45) NOT NULL,
  `URL` VARCHAR(45) NOT NULL,
  `PRECIOPUBLICO` INT NOT NULL,
  `COSTO` INT NOT NULL,
  `TBL_PROVEDOR_ID` INT NOT NULL,
  `TBL_MARCA_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_TBL_PRODUCTOS_TBL_PROVEDOR1`
    FOREIGN KEY (`TBL_PROVEDOR_ID`)
    REFERENCES `TAREA1`.`TBL_PROVEDOR` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TBL_PRODUCTOS_TBL_MARCA1`
    FOREIGN KEY (`TBL_MARCA_ID`)
    REFERENCES `TAREA1`.`TBL_MARCA` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_TBL_PRODUCTOS_TBL_PROVEDOR1_idx` ON `TAREA1`.`TBL_PRODUCTOS` (`TBL_PROVEDOR_ID` ASC) VISIBLE;

CREATE INDEX `fk_TBL_PRODUCTOS_TBL_MARCA1_idx` ON `TAREA1`.`TBL_PRODUCTOS` (`TBL_MARCA_ID` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
