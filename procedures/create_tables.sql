DROP PROCEDURE IF EXISTS create_tables;
DELIMITER //
CREATE PROCEDURE create_tables()
BEGIN
	DECLARE done BOOL DEFAULT FALSE;
	DECLARE new_name VARCHAR(45);
	DECLARE city_cursor CURSOR FOR SELECT name FROM city;
	DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;
OPEN city_cursor;
city_loop: LOOP
	FETCH city_cursor INTO new_name;
    IF done THEN LEAVE city_loop;
    END IF;
    SET @city_db := CONCAT('CREATE DATABASE IF NOT EXISTS ', new_name, ';');
    PREPARE my_query from @city_db;
		EXECUTE my_query;
    SET @table_count := 1;

	WHILE @table_count < rand() * 4 
    DO
		SET @new_city_table = CONCAT('CREATE TABLE IF NOT EXISTS', new_name, '.', new_name, @table_count, '(id INT, name VARCHAR(45));');
		SELECT @new_city_table;
		PREPARE table_query FROM @new_city_table;
		EXECUTE my_query;
		SET @table_count = @table_count + 1;
		END WHILE;
        
	END LOOP;
	CLOSE city_cursor;
END //
DELIMITER ;
