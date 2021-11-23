INSERT INTO region (name, code) VALUES
	('Kyiv region', '010101'),
    ('Chernihiv region', '12345'),
    ('Khmelnytsky region', '23183'),
    ('Sumy region', '50020'),
    ('Ternopil region', '35245'),
    ('Luhansk region', '82050'),
    ('Autonomous Republic of Crimea', '60798'),
    ('Lviv region', '30576');
    
INSERT INTO city (name, region_id) VALUES 
	('Kyiv', '1'),
    ('Chernihiv', '2'),
    ('Khmelnytsky', '3'),
    ('Sumy', '4'),
    ('Ternopil', '5'),
    ('Luhansk', '6'),
    ('Crimea', '7'),
    ('Lviv', '8');
    
INSERT INTO academic_debt (name, student_marked_debt_id) VALUES 
	('economics', '1'), ('geography', '2'),
    ('journalism', '3'), ('marketing', '4'),
    ('psychology', '5'), ('sports', '6'),
    ('mathematics', '7'), ('languages', '8');

INSERT INTO completed_secondary_education (name, phone_number, director, city_id, region_id) VALUES 
	('Secondary school #1', '0675646347', 'SVI',  '1', '1'),
    ('Secondary school #2', '0678211234', 'PFN', '2', '2'),
    ('Secondary school #3', '0456372847', 'WNB', '3', '3'),
    ('Secondary school #4', '4573846577', 'DMO', '4', '4'),
    ('Secondary school #5', '0912345684', 'VDV', '5', '5'),
    ('Secondary school #6', '3478192746', 'YBV', '6', '6'),
    ('Secondary school #7', '1234567890', 'PAW', '7', '7'),
    ('Secondary school #8', '3481003400', 'COP', '8', '8');
    
INSERT INTO student_group (name, group_number, entry_year) VALUES 
	('AAA', '11', '2020'),
    ('BBB', '12', '2019'),
    ('CCC', '13', '2020'),
    ('DDD', '14', '2021'),
    ('EEE', '15', '2020'),
    ('FFF', '16', '2020'),
    ('GGG', '17', '2020'),
    ('HHH', '18', '2021');
    
INSERT INTO student (name, surname, overall_rating, birthday_date, entry_date, student_number, email, city_id, student_group_id, completed_secondary_education_id, student_marked_debt_id) VALUES 
	('Polina', 'Kovalchyck', '35', '2002-09-23', '2020-08-23', '12345', 'polina@gmail.com', '1', '1', '1', '1'),
    ('Oleg', 'Krivich', '27', '2002-06-12', '2019-05-18', '435234', 'oleg@gmail.com', '2', '2', '2', '2'),
	('Max', 'Lyachuv', '16', '2003-01-19', '2020-09-01', '500678', 'max@gmail.com', '3', '3', '3', '3'),
	('Katerina', 'Sosedskaya', '45', '2003-09-16', '2021-09-13', '12044', 'kate@gmail.com', '4', '4', '4', '4'),
	('Yelyzaveta', 'Simonenko', '39', '2003-06-04', '2020-08-17', '30009', 'liza@gmail.com', '5', '5', '5', '5'),
	('Nikita', 'Lebid', '39', '2003-04-13', '2020-08-28', '10022', 'nikita@gmail.com', '6', '6', '6', '6'),
	('Dmutro', 'Tukin', '33', '2003-11-19', '2020-08-31', '20334', 'dima@gmail.com', '7', '7', '7', '7'),
	('Svitlana', 'Minaeva', '40', '2002-01-17', '2021-08-16', '80229', 'sveta@gmail.com', '8', '8', '8', '8');

INSERT INTO student_marked_debt (academic_debt_id, student_id) VALUES 
	('1', '1'), ('2', '2'), ('3', '3'),
    ('4', '4'), ('5', '5'), ('6', '6'),
    ('7', '7'), ('8', '8');