package com.example.Artifact.university_db_app.repository; 
  
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.example.Artifact.university_db_app.model.Lecture;
  
public interface LecturerRepository extends JpaRepository<Lecture, Long> { 
  
    Optional<Lecture> findByEmail(String email); 
  
    // property path: Lecturer.department.code  (underscore = go into the related object) 
    List<Lecture> findByDepartment_Code(String departmentCode); 
} 