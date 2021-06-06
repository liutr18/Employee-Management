/*DROP, CREATE, USE DATABASE daoproject*/
DROP DATABASE IF EXISTS daoproject;
CREATE DATABASE daoproject CHARACTER SET UTF8;
USE daoproject;

/*DROP, CREATE, TEST TABLE employee*/
DROP TABLE IF EXISTS employee;
CREATE TABLE employee(
    eid int,
    name varchar(100),
    post varchar(100),
    hireDate date ,
    salary float,
    bonus float,
    PRIMARY KEY (eid)
);
INSERT INTO employee(eid, name, post, salary, bonus)
VALUES(10002,'Bobby Johnson','Marketing Analyst',220000.00,150000.00);

/*DROP, CREATE, TEST TABLE employee*/
DROP TABLE IF EXISTS dept;
CREATE TABLE dept(
    did int,
    location VARCHAR (100)
);
INSERT INTO dept(did,location) VALUES(27708,"Durham");