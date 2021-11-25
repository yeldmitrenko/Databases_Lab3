-- 4

DROP TRIGGER IF EXISTS student_logs;

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
	INSERT INTO student_journal(name, timestamp) VALUES 
		(new.name, current_timestamp());
END //
DELIMITER ;
