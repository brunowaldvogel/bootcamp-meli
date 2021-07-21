CREATE DATABASE IF NOT EXISTS ml_app_consultorio;
ALTER SCHEMA ml_app_consultorio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_spanish_ci; 

USE ml_app_consultorio;
CREATE TABLE IF NOT EXISTS usernames(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(16) NOT NULL,
    CONSTRAINT pk_usernames PRIMARY KEY(id)
);

CREATE USER IF NOT EXISTS 'ml_app_user1'@'localhost' IDENTIFIED BY 'ml_app_user1';
GRANT SELECT, INSERT, UPDATE, DELETE ON ml_app_consultorio.* TO 'ml_app_user1'@'localhost';

/*
	After logging in with ml_app_user1...
*/

CREATE DATABASE IF NOT EXISTS ml_app_1_bd1;
-- Error Code 1044: Access denied for user 'ml_app_user1

DROP DATABASE IF EXISTS ml_app_consultorio;
-- Error Code 1044: Access denied for user 'ml_app_user1

/*
	After logging in with root...
*/

CREATE USER IF NOT EXISTS 'ml_app_user2'@'localhost' IDENTIFIED BY 'ml_app_user2';
GRANT ALL PRIVILEGES ON ml_app_consultorio.* TO 'ml_app_user2'@'localhost';

/*
	After logging in with ml_app_user2...
*/

DROP DATABASE ml_app_consultorio;
-- Worked!

CREATE DATABASE IF NOT EXISTS ml_app_consultorio;
ALTER SCHEMA ml_app_consultorio DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_spanish_ci;

USE ml_app_consultorio;

CREATE TABLE usernames(
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(16) NOT NULL,
    CONSTRAINT pk_usernames PRIMARY KEY(id)
);

/*
	After logging in with root...
*/

CREATE USER IF NOT EXISTS 'ml_app_user3'@'localhost' IDENTIFIED BY 'ml_app_user3';
GRANT SELECT ON ml_app_consultorio.* TO 'ml_app_user3'@'localhost';

/*
	After logging in with ml_app_user3...
*/

USE ml_app_consultorio;

SELECT * FROM usernames;
-- Worked!

INSERT INTO username(name) values ('Jose');
-- Error Code 1142 - Insert command denied to user 'ml_app_user3'@'localhost' for table 'username'

/*
	After logging in with root...
*/

-- CLEANUP
DROP USER IF EXISTS 'ml_app_user1'@'localhost';
DROP USER IF EXISTS 'ml_app_user2'@'localhost';
DROP USER IF EXISTS 'ml_app_user3'@'localhost';
DROP DATABASE IF EXISTS ml_app_consultorio;