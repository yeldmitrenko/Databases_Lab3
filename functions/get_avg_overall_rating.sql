USE student_db;

DROP FUNCTION IF EXISTS get_avg_overall_rating;
DELIMITER //
CREATE FUNCTION get_avg_overall_rating()
RETURNS DECIMAL
BEGIN
	return(SELECT AVG(overall_rating) FROM student);
END;
SELECT * FROM student WHERE overall_rating < get_avg_overall_rating()//
DELIMITER ;

