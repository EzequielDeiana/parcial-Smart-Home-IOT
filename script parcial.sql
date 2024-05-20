DROP DATABASE IF EXISTS `parcial-iot` ;
CREATE SCHEMA `parcial-iot` ;
use `parcial-iot` ;

CREATE TABLE `parcial-iot`.`evento` (
  `idevento` INT NOT NULL AUTO_INCREMENT,
  `descripcion` INT NULL,
  PRIMARY KEY (`idevento`));

CREATE TABLE `parcial-iot`.`dispositivo` (
  `iddispositivo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `activo` BIT(1) NOT NULL,
  PRIMARY KEY (`iddispositivo`));

ALTER TABLE `parcial-iot`.`evento` 
ADD COLUMN `iddispositivo` INT NOT NULL AFTER `descripcion`,
CHANGE COLUMN `descripcion` `descripcion` INT NOT NULL ,
ADD INDEX `fk_dispositivo_evento_idx` (`iddispositivo` ASC) VISIBLE;

ALTER TABLE `parcial-iot`.`evento` 
ADD CONSTRAINT `fk_dispositivo_evento`
  FOREIGN KEY (`iddispositivo`)
  REFERENCES `parcial-iot`.`dispositivo` (`iddispositivo`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `parcial-iot`.`sensorcortinaventana` (
  `idsensor` INT NOT NULL,
  `aperturadesde` DATETIME NOT NULL,
  `aperturahasta` DATETIME NOT NULL,
  PRIMARY KEY (`idsensor`),
  CONSTRAINT `fk_sensor_dispositivo`
    FOREIGN KEY (`idsensor`)
    REFERENCES `parcial-iot`.`dispositivo` (`iddispositivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `parcial-iot`.`sensortemperatura` (
  `idsensor` INT NOT NULL,
  `valorminimo` DOUBLE NOT NULL,
  `valormaximo` DOUBLE NOT NULL,
  PRIMARY KEY (`idsensor`),
  CONSTRAINT `fk_sensortemp_dispositivo`
    FOREIGN KEY (`idsensor`)
    REFERENCES `parcial-iot`.`dispositivo` (`iddispositivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `parcial-iot`.`sensorcortinaventana` 
CHANGE COLUMN `aperturadesde` `aperturadesde` TIME NOT NULL ,
CHANGE COLUMN `aperturahasta` `aperturahasta` TIME NOT NULL ;

ALTER TABLE `parcial-iot`.`evento` 
ADD COLUMN `fecha` DATE NOT NULL AFTER `iddispositivo`,
ADD COLUMN `hora` TIME NOT NULL AFTER `fecha`;

ALTER TABLE `parcial-iot`.`evento` 
CHANGE COLUMN `descripcion` `descripcion` VARCHAR(255) NOT NULL ;

ALTER TABLE `parcial-iot`.`evento` 
DROP COLUMN `hora`,
CHANGE COLUMN `fecha` `fechaHora` DATETIME NOT NULL ;

INSERT INTO `parcial-iot`.`dispositivo` (`nombre`, `activo`) VALUES ('cortina pieza', b'1');
INSERT INTO `parcial-iot`.`dispositivo` (`nombre`, `activo`) VALUES ('cortina cocina', b'1');
INSERT INTO `parcial-iot`.`dispositivo` (`nombre`, `activo`) VALUES ('cortina balcon', b'1');
INSERT INTO `parcial-iot`.`dispositivo` (`nombre`, `activo`) VALUES ('temp pieza', b'1');
INSERT INTO `parcial-iot`.`dispositivo` (`nombre`, `activo`) VALUES ('temp cocina', b'1');
INSERT INTO `parcial-iot`.`sensorcortinaventana` (`idsensor`, `aperturadesde`, `aperturahasta`) VALUES (1, "09:00:00", "19:00:00");
INSERT INTO `parcial-iot`.`sensorcortinaventana` (`idsensor`, `aperturadesde`, `aperturahasta`) VALUES (2, "12:00:00", "20:00:00");
INSERT INTO `parcial-iot`.`sensorcortinaventana` (`idsensor`, `aperturadesde`, `aperturahasta`) VALUES (3, "10:00.00", "18:00:00");
INSERT INTO `parcial-iot`.`sensortemperatura` (`idsensor`, `valorminimo`, `valormaximo`) VALUES (4, '17.5', '22');
INSERT INTO `parcial-iot`.`sensortemperatura` (`idsensor`, `valorminimo`, `valormaximo`) VALUES (5, '22', '24');




