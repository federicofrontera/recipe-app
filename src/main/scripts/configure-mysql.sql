--Use to run mysql db docker image, optional if you're not using a local mysqldb
-- docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY_PASSWORD=yes -d mysql

-- connect to mysql and run as root user
--Create Databases
CREATE DATABASE ff_dev;
CREATE DATABASE ff_prod;

--Create database service accounts
CREATE USER 'ff_dev_user'@'localhost' IDENTIFIED BY 'fede';
CREATE USER 'ff_prod_user'@'localhost' IDENTIFIED BY 'fede';
CREATE USER 'ff_dev_user'@'%' IDENTIFIED BY 'fede';
CREATE USER 'ff_prod_user'@'%' IDENTIFIED BY 'fede';

--Database grants
GRANT SELECT ON ff_dev.* to 'ff_dev_user'@'localhost';
GRANT INSERT ON ff_dev.* to 'ff_dev_user'@'localhost';
GRANT DELETE ON ff_dev.* to 'ff_dev_user'@'localhost';
GRANT UPDATE ON ff_dev.* to 'ff_dev_user'@'localhost';
GRANT SELECT ON ff_prod.* to 'ff_prod_user'@'localhost';
GRANT INSERT ON ff_prod.* to 'ff_prod_user'@'localhost';
GRANT DELETE ON ff_prod.* to 'ff_prod_user'@'localhost';
GRANT UPDATE ON ff_prod.* to 'ff_prod_user'@'localhost';
GRANT SELECT ON ff_dev.* to 'ff_dev_user'@'%';
GRANT INSERT ON ff_dev.* to 'ff_dev_user'@'%';
GRANT DELETE ON ff_dev.* to 'ff_dev_user'@'%';
GRANT UPDATE ON ff_dev.* to 'ff_dev_user'@'%';
GRANT SELECT ON ff_prod.* to 'ff_prod_user'@'%';
GRANT INSERT ON ff_prod.* to 'ff_prod_user'@'%';
GRANT DELETE ON ff_prod.* to 'ff_prod_user'@'%';
GRANT UPDATE ON ff_prod.* to 'ff_prod_user'@'%';