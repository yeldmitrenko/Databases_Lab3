-- 3

DROP TRIGGER IF EXISTS student_number_format;

DELIMITER //
CREATE TRIGGER student_number_format
BEFORE INSERT 
ON student FOR EACH ROW
BEGIN
	DECLARE student_num VARCHAR(15);
    
    SELECT student_number INTO student_num FROM student
    WHERE student.student_number = new.student_number
    LIMIT 1;
    
    IF new.student_number RLIKE "^(99).+" THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "INSERT Error (code can't start with 99).";
	END IF;
END //
DELIMITER ;