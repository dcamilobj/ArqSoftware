-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema VehicleSalesDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema VehicleSalesDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `VehicleSalesDB` DEFAULT CHARACTER SET utf8 ;
USE `VehicleSalesDB` ;

-- -----------------------------------------------------
-- Table `VehicleSalesDB`.`Client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VehicleSalesDB`.`Client` (
  `idClient` VARCHAR(20) NOT NULL,
  `firstName` VARCHAR(50) NOT NULL,
  `lastName` VARCHAR(50) NOT NULL,
  `birthDate` DATE NULL DEFAULT NULL,
  `phone` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClient`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `VehicleSalesDB`.`Vehicle`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VehicleSalesDB`.`Vehicle` (
  `licensePlate` VARCHAR(50) NOT NULL,
  `brand` VARCHAR(45) NOT NULL,
  `color` VARCHAR(45) NULL DEFAULT NULL,
  `price` INT(11) NOT NULL,
  `image` LONGBLOB NOT NULL,
  PRIMARY KEY (`licensePlate`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `VehicleSalesDB`.`Sale`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `VehicleSalesDB`.`Sale` (
  `client` VARCHAR(20) NOT NULL,
  `vehicle` VARCHAR(50) NOT NULL,
  `idSale` INT NOT NULL AUTO_INCREMENT,
  INDEX `idClient_idx` (`client` ASC),
  INDEX `licensePlate_idx` (`vehicle` ASC),
  PRIMARY KEY (`idSale`),
  CONSTRAINT `idClient`
    FOREIGN KEY (`client`)
    REFERENCES `VehicleSalesDB`.`Client` (`idClient`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `licensePlate`
    FOREIGN KEY (`vehicle`)
    REFERENCES `VehicleSalesDB`.`Vehicle` (`licensePlate`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
