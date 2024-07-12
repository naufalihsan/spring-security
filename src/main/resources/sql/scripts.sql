CREATE DATABASE bank;

USE bank;

CREATE TABLE `users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `enabled` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
);

CREATE TABLE `authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username_idx` (`username`),
  CONSTRAINT `fk_authorities_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT IGNORE INTO `users` (`id`, `username`, `password`, `enabled`) VALUES (NULL, 'happy', '12345', 1);
INSERT IGNORE INTO `authorities` (`id`, `username`, `authority`) VALUES (NULL, 'happy', 'write');

CREATE TABLE `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `pwd` VARCHAR(200) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
);

INSERT INTO `customer` (`email`, `pwd`, `role`) VALUES ('johndoe@example.com', '54321', 'admin');
