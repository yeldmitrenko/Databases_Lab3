USE student_db;

INSERT INTO region (name, code) VALUES
	('Lviv region', '10101'),
    ('Chernihiv region', '12345'),
    ('Sumy region', '50020');
    
INSERT INTO city (name, region_id) VALUES 
	('Lviv', '1'),
    ('Chernihiv', '2'),
    ('Sumy', '3');

INSERT INTO completed_secondary_education (name, phone_number, director, city_id) VALUES 
	('Secondary school #1', '0675646347', 'SVI',  '1'),
    ('Secondary school #2', '0678211234', 'PFN', '2'),
    ('Secondary school #3', '0456372847', 'WNB', '3');

INSERT INTO student_group (name, group_number, entry_year) VALUES 
	('AAA', '11', '2020'),
    ('BBB', '12', '2019'),
    ('CCC', '13', '2020');
    
INSERT INTO student (name, surname, overall_rating, birthday_date, entry_date, student_number, email, city_id, completed_secondary_education_id, student_group_id, student_marked_debt_id) VALUES 
	('Polina', 'Kovalchyck', '35', '2002-09-23', '2020-08-23', '12345', 'polina@gmail.com', '1', '2', '1', '1'),
    ('Oleg', 'Krivich', '27', '2002-06-12', '2019-05-18', '435234', 'oleg@gmail.com', '1', '2', '1', '2'),
	('Max', 'Lyachuv', '16', '2003-01-19', '2020-09-01', '550678', 'max@gmail.com', '1', '2', '1', '3');
    
INSERT INTO student_marked_debt (student_id, academic_debt_id) VALUES
	('1', '1'),
    ('2', '2'),
    ('3', '3');
    
INSERT INTO academic_debt (name, student_marked_debt_id) VALUES 
	('economics', '1'), 
    ('geography', '2'),
    ('journalism', '3');
