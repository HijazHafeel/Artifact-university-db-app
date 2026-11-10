
-- ============================================================
-- Lab Sheet 06: Anomaly Tests
-- File: anomaly-tests.sql
-- Run after anomaly-demo.sql
-- Execute each section separately
-- ============================================================

USE university_db;

-- A. REDUNDANCY + UPDATE ANOMALY

-- Count how many times Dr. Perera's email appears
SELECT COUNT(*) AS copies
FROM registration_flat
WHERE lecturer_email = 'perera@uni.lk';

-- Change email in only one row
UPDATE registration_flat
SET lecturer_email = 'perera.new@uni.lk'
WHERE student_id = 'S001'
AND course_code = 'CS101';

-- Check the inconsistent lecturer emails
SELECT DISTINCT lecturer_name, lecturer_email
FROM registration_flat
WHERE lecturer_name = 'Dr. Perera';


-- B. INSERT ANOMALY

-- This should FAIL because student_id is NOT NULL
INSERT INTO registration_flat
(
    course_code,
    course_title,
    credits,
    lecturer_name,
    lecturer_email,
    department_code,
    department_name
)
VALUES
(
    'CS301',
    'Software Engineering',
    3,
    'Dr. Fernando',
    'fernando@uni.lk',
    'D01',
    'Computer Science'
);


-- C. DELETE ANOMALY

-- Delete Dilini's registration
DELETE FROM registration_flat
WHERE student_id = 'S004';

-- Check whether CS201 still exists
SELECT *
FROM registration_flat
WHERE course_code = 'CS201';
