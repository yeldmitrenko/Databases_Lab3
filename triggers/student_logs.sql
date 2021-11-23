-- 4

DROP TRIGGER IF EXISTS student_logs;
DROP TABLE IF EXISTS student_journal;

CREATE TABLE student_journal (
	id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    timestamp TIMESTAMP,
    PRIMARY KEY(id)
);

DELIMITER //
CREATE TRIGGER student_logs
BEFORE UPDATE
ON student FOR EACH ROW
BEGIN
	INSERT INTO student_logs(name, timestamp) VALUES 
		(new.name, current_timestamp());
END //
DELIMITER ;