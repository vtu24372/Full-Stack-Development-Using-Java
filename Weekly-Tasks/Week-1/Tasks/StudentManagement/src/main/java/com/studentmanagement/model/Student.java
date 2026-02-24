package com.studentmanagement.model;

// ALL IMPORTS MUST COME FIRST, right after the package statement
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component  // This must come AFTER all imports
public class Student {
    
    // Fields
    private int studentId;
    private String name;
    private String email;
    private String course;
    private double gpa;
    private int semester;
    
    // Default constructor
    public Student() {
        System.out.println("Student: Default constructor called");
    }
    
    // Parameterized constructor
    public Student(int studentId, String name, String email, String course, double gpa, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.course = course;
        this.gpa = gpa;
        this.semester = semester;
        System.out.println("Student: Parameterized constructor called for " + name);
    }
    
    // Getters and Setters
    public int getStudentId() {
        return studentId;
    }
    
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
    public int getSemester() {
        return semester;
    }
    
    public void setSemester(int semester) {
        this.semester = semester;
    }
    
    @PostConstruct
    public void init() {
        System.out.println("Student bean initialized for: " + name);
    }
    
    @PreDestroy
    public void destroy() {
        System.out.println("Student bean for " + name + " is being destroyed");
    }
    
    // Method to display student information
    public void displayInfo() {
        System.out.println("\n==================================");
        System.out.println("     STUDENT INFORMATION");
        System.out.println("==================================");
        System.out.println("Student ID  : " + studentId);
        System.out.println("Name        : " + name);
        System.out.println("Email       : " + email);
        System.out.println("Course      : " + course);
        System.out.println("GPA         : " + gpa);
        System.out.println("Semester    : " + semester);
        System.out.println("==================================\n");
    }
    
    @Override
    public String toString() {
        return "Student [ID=" + studentId + ", Name=" + name + ", Course=" + course + 
               ", GPA=" + gpa + ", Semester=" + semester + "]";
    }
}