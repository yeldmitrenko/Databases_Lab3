DROP PROCEDURE IF EXISTS create_tables;

DELIMITER //
CREATE PROCEDURE create_tables()
BEGIN
	DECLARE done INT DEFAULT FALSE;
	DECLARE name VARCHAR(45);
	DECLARE city_cursor CURSOR FOR SELECT city.name FROM cite;
	DECLARE CONTINUE HANDLER FOR NOT FOUND
    SET done = TRUE;
OPEN city_cursor;
city_loop: LOOP
   FETCH city_cursor INTO name;
   IF done = TRUE THEN LEAVE city_loop;
   END IF;
   SET @table_count = 1;
while_loop: WHILE @table_count < 5 DO
    SET @new_table = CONCAT('CREATE TABLE IF NOT EXISTS ', name, '(id INT, name VARCHAR(45));');
    SELECT @new_table;
    PREPARE myquery FROM @new_table;
    EXECUTE myquery;
    SET @table_count = @table_count + 1;
   END WHILE;
  END LOOP;
  CLOSE city_cursor;
END ;
//
