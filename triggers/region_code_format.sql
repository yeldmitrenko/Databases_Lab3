-- 2 

DROP TRIGGER IF EXISTS region_code_format;

DELIMITER //
CREATE TRIGGER region_code_format
BEFORE INSERT
ON region FOR EACH ROW
BEGIN
	DECLARE new_name VARCHAR(50);
    DECLARE new_code VARCHAR(50);
    DECLARE result VARCHAR(50);
    
    SET new_name = LPAD(new.name, 1, 0);
    SET new_code = LPAD(new.code, 2, 0);
    SET result = CONCAT(new_name, new_code);
    
    SET new.code = result;

END //
DELIMITER ;