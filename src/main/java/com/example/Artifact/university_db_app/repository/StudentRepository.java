package com.example.Artifact.university_db_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Artifact.university_db_app.model.Student;

  
public interface StudentRepository extends JpaRepository<Student, Long> {

 Optional<Student> findByStudentCode(String studentCode); 

    // Search students by name, ignoring uppercase/lowercase
     List<Student> findByFullNameContainingIgnoreCase(String text); 

    // Get all students ordered by full name
     List<Student> findAllByOrderByFullNameAsc(); 

    // Check whether an email exists
    boolean existsByEmail(String email);

    // Count students whose email ends with a domain
    long countByEmailEndingWith(String domain);   
    
}
