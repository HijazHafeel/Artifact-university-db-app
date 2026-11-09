package com.example.Artifact.university_db_app.model;

  
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 
  
@Entity 
@Table(name = "department") 
@Getter 
@Setter 
@NoArgsConstructor 
public class Department {
    
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code",nullable=false,unique=true,length=10)
    private String code;

    @Column(name="name",nullable=false,length=100)
    private String name;

    @OneToMany(mappedBy ="department")
    private List<Course> courses = new ArrayList<>();

}
