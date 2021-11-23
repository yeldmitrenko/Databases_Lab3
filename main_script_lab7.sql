CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS student_group;
DROP TABLE IF EXISTS academic_debt;
DROP TABLE IF EXISTS city;
DROP TABLE IF EXISTS completed_secondary_education;
DROP TABLE IF EXISTS region;
DROP TABLE IF EXISTS student_marked_debt;

CREATE TABLE student (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(35) NOT NULL,
    surname VARCHAR(45) NOT NULL,
    overall_rating INT NOT NULL,
    birthday_date DATE NOT NULL,
    entry_date DATE NOT NULL,
    student_number VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
		city_id INT NOT NULL,
		student_group_id INT NOT NULL,
        completed_secondary_education_id INT NOT NULL,
        student_marked_debt_id INT NOT NULL,
	UNIQUE (student_number)
);

CREATE TABLE student_group (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(15) NOT NULL,
    group_number INT NOT NULL,
    entry_year INT NOT NULL
);

CREATE TABLE city (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
		region_id INT NOT NULL
);

CREATE TABLE region (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    code INT NOT NULL
);

CREATE TABLE completed_secondary_education (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(13) NOT NULL,
    director VARCHAR(3) NOT NULL,
		city_id INT NOT NULL,
        region_id INT NOT NULL
);

CREATE TABLE academic_debt (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(35) NOT NULL,
		student_marked_debt_id INT NOT NULL
);

CREATE TABLE student_marked_debt (
	id INT AUTO_INCREMENT PRIMARY KEY,
		academic_debt_id INT NOT NULL,
		student_id INT NOT NULL
);
