-- MySQL Script generated by MySQL Workbench
-- Fri Nov  8 11:05:22 2019
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pasasist
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pasasist
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pasasist` DEFAULT CHARACTER SET utf8 ;
USE `pasasist` ;

-- -----------------------------------------------------
-- Table `pasasist`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pasasist`.`Cliente` (
  `dniClie` CHAR(8) NOT NULL,
  `nombClie` VARCHAR(25) NOT NULL,
  `apelClie` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`dniClie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pasasist`.`Salida`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pasasist`.`Salida` (
  `codiSali` CHAR(4) NOT NULL,
  `precSali` DECIMAL(5,2) NOT NULL,
  `horaSali` TIME NOT NULL,
  `origSali` VARCHAR(50) NOT NULL,
  `destSali` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`codiSali`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pasasist`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pasasist`.`Usuario` (
  `dniUsua` CHAR(8) NOT NULL,
  `nombUsua` VARCHAR(25) NOT NULL,
  `apelUsua` VARCHAR(25) NOT NULL,
  `tipoUsua` VARCHAR(10) NOT NULL,
  `estaUsua` VARCHAR(9) NOT NULL,
  `direUsua` VARCHAR(50) NOT NULL,
  `clavUsua` VARCHAR(200) NOT NULL,
  `fotoUsua` MEDIUMBLOB NOT NULL,
  PRIMARY KEY (`dniUsua`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pasasist`.`Pasaje`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pasasist`.`Pasaje` (
  `numePasa` INT NOT NULL,
  `anioPasa` CHAR(4) NOT NULL,
  `numeAsiePasa` DECIMAL(2,0) NOT NULL,
  `fechPasa` DATE NOT NULL,
  `Cliente_dniClie` CHAR(8) NOT NULL,
  `Salida_codiSali` CHAR(4) NOT NULL,
  `Usuario_dniUsua` CHAR(8) NOT NULL,
  PRIMARY KEY (`numePasa`, `anioPasa`, `Cliente_dniClie`, `Salida_codiSali`, `Usuario_dniUsua`),
  INDEX `fk_Pasaje_Cliente_idx` (`Cliente_dniClie` ASC) VISIBLE,
  INDEX `fk_Pasaje_Salida1_idx` (`Salida_codiSali` ASC) VISIBLE,
  INDEX `fk_Pasaje_Usuario1_idx` (`Usuario_dniUsua` ASC) VISIBLE,
  CONSTRAINT `fk_Pasaje_Cliente`
    FOREIGN KEY (`Cliente_dniClie`)
    REFERENCES `pasasist`.`Cliente` (`dniClie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pasaje_Salida1`
    FOREIGN KEY (`Salida_codiSali`)
    REFERENCES `pasasist`.`Salida` (`codiSali`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pasaje_Usuario1`
    FOREIGN KEY (`Usuario_dniUsua`)
    REFERENCES `pasasist`.`Usuario` (`dniUsua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;