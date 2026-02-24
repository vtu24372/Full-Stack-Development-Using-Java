package com.studentmanagement.service;

import com.studentmanagement.model.Student;
import java.util.List;

public interface StudentService {
    
    // Register a new student
    Student registerStudent(Student student);
    
    // Get student by ID
    Student getStudentById(int id);
    
    // Get all students
    List<Student> getAllStudents();
    
    // Update student information
    Student updateStudent(Student student);
    
    // Remove a student
    boolean removeStudent(int id);
    
    // Calculate average GPA
    double calculateAverageGPA();
    
    // Get students by course
    List<Student> getStudentsByCourse(String course);
    
    // Get honor roll students (GPA >= 3.5)
    List<Student> getHonorRollStudents();
    
    // Promote student to next semester
    Student promoteStudent(int id);
}