CREATE DATABASE demo;
use demo;
 CREATE TABLE Student (
    ID int NOT NULL,
    fname varchar(255) NOT NULL,
    lname varchar(255),
    gpa int,
    PRIMARY KEY (ID)
); 
 CREATE TABLE Course (
    courseid int NOT NULL,
    coursename varchar(255) NOT NULL,
    semester varchar(255),
    PRIMARY KEY (courseid)
); 
 CREATE TABLE StudentCourse (
id int NOT NULL AUTO_INCREMENT,
    studentid int NOT NULL,
    courseid int NOT NULL,
    PRIMARY KEY (id),
FOREIGN KEY (studentid) REFERENCES Student(ID),
FOREIGN KEY (courseid) REFERENCES Course(courseid)
); 
