DROP PROCEDURE IF EXISTS insert_into_completed_secondary_education;

DELIMITER //
CREATE PROCEDURE `insert_into_completed_secondary_education` (
	IN name VARCHAR(100),
    IN phone_number VARCHAR(13),
    IN director VARCHAR(150),
    IN city_id INT,
    IN region_id INT
)
BEGIN
	INSERT INTO completed_secondary_education (`name`, `phone_number`, `director` , `city_id`, `region_id` ) VALUES
		(name, phone_number, director, city_id, region_id);
END //
DELIMITER ;
