DROP PROCEDURE IF EXISTS insert_into_junction_table;
DELIMITER //
CREATE PROCEDURE insert_into_junction_table(
	academic_debt_id INT,
	student_id INT
)
BEGIN
	IF (SELECT id FROM academic_debt WHERE id = academic_debt_id)
    AND (SELECT id FROM student WHERE id = student_id)
    THEN
	INSERT INTO student_marked_debt (academic_debt_id, student_id) VALUES (academic_dept_id, student_id);
    END IF;
END //
DELIMITER ;
