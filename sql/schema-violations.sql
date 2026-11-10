
-- ============================================================
-- Lab Sheet 06: Fixed Schema Experiments
-- File: schema-violations.sql
-- Run ONE statement at a time
-- ============================================================

USE university_db;

-- 1. Unknown column
INSERT INTO student
(student_code, full_name, email, phone)
VALUES
('S010', 'Test One', 'test1@example.com', '0771234567');


-- 2. Missing NOT NULL column
INSERT INTO student
(student_code, full_name)
VALUES
('S011', 'Test Two');


-- 3. Wrong data type
INSERT INTO course
(code, title, credits, lecturer_id)
VALUES
('CS301', 'Test Course', 'three', 1);


-- 4. Duplicate UNIQUE value
INSERT INTO student
(student_code, full_name, email)
VALUES
('S001', 'Test Three', 'test3@example.com');


-- 5. Value longer than VARCHAR(10)
INSERT INTO department
(code, name)
VALUES
('D0000000001', 'Too Long Code');


-- 6. Invalid foreign key
INSERT INTO enrollment
(student_id, course_id, grade)
VALUES
(1, 999, 'A');


-- 7. Delete a department referenced by lecturers
DELETE FROM department
WHERE code = 'D01';


-- 8. CHECK constraint violation
INSERT INTO course
(code, title, credits, lecturer_id)
VALUES
('CS302', 'Test Course', 10, 1);


-- 9. Deliberately change the schema
-- This statement should SUCCESSFULLY add a column
ALTER TABLE student
ADD COLUMN phone VARCHAR(15);

-- Inspect the changed structure
DESCRIBE student;

SELECT * FROM student;

-- 10. Restore the original schema
ALTER TABLE student
DROP COLUMN phone;

-- Confirm restoration
DESCRIBE student;
