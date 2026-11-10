package com.example.Artifact.university_db_app.repository; 
  
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
 
import com.example.Artifact.university_db_app.model.Department; 
  
public interface DepartmentRepository extends JpaRepository<Department, Long> { 
  
    Optional<Department> findByCode(String code); 
  

    // JOIN FETCH loads the department AND its lecturers with ONE SQL query 
    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.lectures WHERE d.code = :code")
    Optional<Department> findByCodeWithLectures(@Param("code") String code);

    public Object findWithLecturers(String code);

    
    
} 
