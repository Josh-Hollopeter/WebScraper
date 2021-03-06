-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Education
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Education` ;

-- -----------------------------------------------------
-- Schema Education
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Education` DEFAULT CHARACTER SET utf8 ;
USE `Education` ;

-- -----------------------------------------------------
-- Table `Education`.`Courses`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Education`.`Courses` ;

CREATE TABLE IF NOT EXISTS `Education`.`Courses` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `subject` VARCHAR(45) NULL,
  `title` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `mentor` VARCHAR(45) NULL,
  `effort` VARCHAR(45) NULL,
  `duration` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user1;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user1' IDENTIFIED BY 'user1';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE `Education`.* TO 'user1';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
