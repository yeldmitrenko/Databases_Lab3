DROP PROCEDURE IF EXISTS insert_into_junction_table;

DELIMITER //
CREATE PROCEDURE insert_into_junction_table()
BEGIN
	INSERT INTO student (name, surname, overall_rating, birthday_date, entry_date, student_number, email, 
		city_id, student_group_id, completed_secondary_education_id, student_marked_debt_id) VALUES 
		('Svitlana', 'Minaeva', '38', '2001-09-24', '2019-08-28', '340912', 'svitlana@gmail.com', '3', '1', '1', '4'); 
    INSERT INTO academic_debt(name, student_marked_debt_id) VALUES ('physics', '4');
    INSERT INTO student_marked_debt (student_id, academic_debt_id) VALUES ('4', '4');
    
    SELECT student.id, student.name, student.surname, student.overall_rating, student.birthday_date, student.entry_date, 
		student.student_number, student.email, student.city_id, student.student_group_id, student.completed_secondary_education_id
	FROM student
    JOIN student_marked_debt ON (student.id = student_marked_debt.student_id)
    JOIN academic_debt ON (academic_debt.id = student_marked_debt.academic_debt_id);
END //
DELIMITER ;
