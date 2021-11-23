USE student_db;

-- region

DROP TRIGGER IF EXISTS region_delete;

DELIMITER //
CREATE TRIGGER region_delete
BEFORE DELETE
ON region FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT region.id FROM city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete region, some city still have fk to region";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS region_update;

DELIMITER //
CREATE TRIGGER region_update
BEFORE UPDATE
ON region FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT region_id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update region, some city still have fk to region";
    END IF;
END //
DELIMITER ;

-- city

DROP TRIGGER IF EXISTS city_insert;

DELIMITER //
CREATE TRIGGER city_insert
BEFORE INSERT
ON city FOR EACH ROW
BEGIN
	IF (new.region_id NOT IN (SELECT id from region))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check city for insert, no such region id";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS city_update;

DELIMITER //
CREATE TRIGGER city_update
BEFORE UPDATE
ON city FOR EACH ROW
BEGIN
	IF (new.region_id NOT IN (SELECT id from region))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update city, no such region id";
    END IF;
    IF (old.id  IN (SELECT city_id from completed_secondary_education))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update city, some school still have fk to city";
    END IF;
    IF (old.id  IN (SELECT city_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update city, some student still have fk to city";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS city_delete;

DELIMITER //
CREATE TRIGGER city_delete
BEFORE DELETE
ON city FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT city_id from completed_secondary_education))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete city, some school still have fk to city";
    END IF;
    IF (old.id IN (SELECT city_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete city some student still have fk to city";
    END IF;
END //
DELIMITER ;

-- completed_secondary_education

DROP TRIGGER IF EXISTS secondary_education_insert;

DELIMITER //
CREATE TRIGGER secondary_education_insert
BEFORE INSERT
ON completed_secondary_education FOR EACH ROW
BEGIN
	IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Check school for insert, no such city id";
    END IF;
END //
DELIMITER ;

DROP TRIGGER IF EXISTS secondary_education_update;

DELIMITER //
CREATE TRIGGER secondary_education_update
BEFORE UPDATE
ON completed_secondary_education FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT completed_secondary_education_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update completed secondary education, some student still have fk to secondary education";
    END IF;
    IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update completed secondary education, some student still have fk to secondary education";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS secondary_education_delete;

DELIMITER //
CREATE TRIGGER secondary_education_delete
BEFORE DELETE
ON completed_secondary_education FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT completed_secondary_education_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot delete school some student, still have fk to secondary education";
    END IF;
END //
DELIMITER ;


-- student

DROP TRIGGER IF EXISTS student_insert;

DELIMITER //
CREATE TRIGGER student_insert
BEFORE INSERT
ON student FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    IF (new.student_marked_debt_id NOT IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
	IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such city";
    END IF;
    IF (new.completed_secondary_education_id NOT IN (SELECT id from completed_secondary_education))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such secondary education";
    END IF;
    
    IF (new.student_group_id NOT IN (SELECT id from student_group))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such student group";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS student_update;

DELIMITER //
CREATE TRIGGER student_update
BEFORE UPDATE
ON student FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update student some debt, still have fk to student";
    END IF;
    IF (new.id NOT IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update student some debt, still have fk to student";
    END IF;
	IF (new.city_id NOT IN (SELECT id from city))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such city";
    END IF;
    IF (new.completed_secondary_education_id NOT IN (SELECT id from completed_secondary_education))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such secondary education";
    END IF;
    
    IF (new.student_group_id NOT IN (SELECT id from student_group))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such student_group";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS student_delete;

DELIMITER //
CREATE TRIGGER student_delete
BEFORE DELETE
ON student FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update student, some student_marked_debt still have fk to student";
    END IF;
    IF (old.student_marked_debt_id IN (SELECT student_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "Cannot update student, some student_marked_debt still have fk to student";
    END IF;
END //
DELIMITER ;

-- academic debt

DROP TRIGGER IF EXISTS academic_debt_insert;
DELIMITER //
CREATE TRIGGER academic_debt_insert
BEFORE INSERT
ON academic_debt FOR EACH ROW
BEGIN
	IF (new.id NOT IN (SELECT academic_debt_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    IF (new.student_marked_debt_id NOT IN (SELECT academic_debt_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS academic_debt_update;

DELIMITER //
CREATE TRIGGER academic_debt_update
BEFORE UPDATE
ON academic_debt FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT academic_debt_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    
    IF (new.id NOT IN (SELECT academic_debt_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS academic_debt_delete;

DELIMITER //
CREATE TRIGGER academic_debt_delete
BEFORE DELETE
ON academic_debt FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT academic_debt_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    
    IF (old.student_marked_debt_id IN (SELECT arrear_id from student_marked_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;

-- student_marked_debt

DROP TRIGGER IF EXISTS student_marked_debt_update;
DELIMITER //
CREATE TRIGGER student_marked_debt_update
BEFORE UPDATE
ON academic_debt FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_marked_debt_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    IF (old.id IN (SELECT student_marked_debt_id from academic_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    IF (new.id NOT IN (SELECT student_marked_debt_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
    IF (new.id NOT IN (SELECT student_marked_debt_id from academic_debt))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;

-- student group

DROP TRIGGER IF EXISTS student_group_insert;

DELIMITER //
CREATE TRIGGER student_group_insert
BEFORE UPDATE
ON student_group FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_group_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;


DROP TRIGGER IF EXISTS student_group_delete;

DELIMITER //
CREATE TRIGGER student_group_delete
BEFORE DELETE
ON student_group FOR EACH ROW
BEGIN
	IF (old.id IN (SELECT student_group_id from student))
		THEN SIGNAL SQLSTATE "45000"
			SET MESSAGE_TEXT = "No such debt";
    END IF;
END //
DELIMITER ;
