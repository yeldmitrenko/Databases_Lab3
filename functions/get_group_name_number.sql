USE student_db;

DROP FUNCTION IF EXISTS get_group_name_number;
DELIMITER //
CREATE FUNCTION get_group_name_number(
	student_group_id INT
)
RETURNS VARCHAR(45)
BEGIN
	return(
		SELECT CONCAT(student_group.name, student_group.group_number) FROM student_group
			WHERE id = (SELECT student_group_id  FROM student WHERE id = student_group_id)
    );
END //
DELIMITER ;
