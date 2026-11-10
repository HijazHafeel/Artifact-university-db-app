package com.example.Artifact.university_db_app.repository; 
  
 

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query; 

import com.example.Artifact.university_db_app.dto.CourseEnrollmentCount;
import com.example.Artifact.university_db_app.model.Enrollment;
  
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> { 
  
    List<Enrollment> findByStudent_StudentCode(String studentCode); 
  
    List<Enrollment> findByCourse_Code(String courseCode); 
  
    List<Enrollment> findByGrade(String grade); 
  
    // WHERE grade IN (?, ?, ...) 
    List<Enrollment> findByGradeIn(Collection<String> grades); 
  
    // WHERE student.student_code = ? AND grade = ? 
    List<Enrollment> findByStudent_StudentCodeAndGrade(String studentCode, String grade); 
  
    long countByCourse_Code(String courseCode); 
  
    // A report with GROUP BY: number of students in every course 
    @Query("SELECT c.code AS courseCode, c.title AS title, COUNT(e) AS studentCount " + 
           "FROM Enrollment e JOIN e.course c " + 
           "GROUP BY c.code, c.title " + 
           "ORDER BY COUNT(e) DESC, c.code") 
    List<CourseEnrollmentCount> countStudentsPerCourse(); 
} 