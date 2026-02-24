package com.studentmanagement.repository;

import com.studentmanagement.model.Student;
import java.util.List;

public interface StudentRepository {
    
    // Save a student
    Student save(Student student);
    
    // Find student by ID
    Student findById(int id);
    
    // Find all students
    List<Student> findAll();
    
    // Update a student
    Student update(Student student);
    
    // Delete a student
    void delete(int id);
    
    // Check if student exists
    boolean exists(int id);
    
    // Count total students
    int count();
}