package com.studentmanagement.service;

import com.studentmanagement.model.Student;
import com.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.stream.Collectors;

@Service  // Marks this as a Service layer bean
public class StudentServiceImpl implements StudentService {
    
    // Field injection with @Autowired
    @Autowired
    private StudentRepository studentRepository;
    
    public StudentServiceImpl() {
        System.out.println("📋 StudentServiceImpl: Constructor called");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("📋 StudentServiceImpl: Initialized");
        System.out.println("📋 Repository injected: " + (studentRepository != null ? "✅ Success" : "❌ Failed"));
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("📋 StudentServiceImpl: Cleaning up...");
    }
    
    @Override
    public Student registerStudent(Student student) {
        System.out.println("📝 Registering student: " + student.getName());
        
        // Validation
        if (student.getName() == null || student.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be empty");
        }
        if (student.getEmail() == null || !student.getEmail().contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (student.getGpa() < 0 || student.getGpa() > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        
        Student saved = studentRepository.save(student);
        System.out.println("✅ Student registered with ID: " + saved.getStudentId());
        return saved;
    }
    
    @Override
    public Student getStudentById(int id) {
        System.out.println("🔍 Fetching student with ID: " + id);
        return studentRepository.findById(id);
    }
    
    @Override
    public List<Student> getAllStudents() {
        System.out.println("📋 Fetching all students");
        return studentRepository.findAll();
    }
    
    @Override
    public Student updateStudent(Student student) {
        System.out.println("📝 Updating student ID: " + student.getStudentId());
        
        if (!studentRepository.exists(student.getStudentId())) {
            System.out.println("❌ Student not found with ID: " + student.getStudentId());
            return null;
        }
        
        Student updated = studentRepository.update(student);
        System.out.println("✅ Student updated successfully");
        return updated;
    }
    
    @Override
    public boolean removeStudent(int id) {
        System.out.println("🗑️ Removing student with ID: " + id);
        
        if (!studentRepository.exists(id)) {
            System.out.println("❌ Student not found with ID: " + id);
            return false;
        }
        
        studentRepository.delete(id);
        System.out.println("✅ Student removed successfully");
        return true;
    }
    
    @Override
    public double calculateAverageGPA() {
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            return 0.0;
        }
        
        double average = students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
        
        System.out.printf("📊 Average GPA: %.2f\n", average);
        return average;
    }
    
    @Override
    public List<Student> getStudentsByCourse(String course) {
        System.out.println("🔍 Fetching students by course: " + course);
        
        List<Student> result = studentRepository.findAll().stream()
                .filter(s -> s.getCourse().equalsIgnoreCase(course))
                .collect(Collectors.toList());
        
        System.out.println("✅ Found " + result.size() + " students in " + course);
        return result;
    }
    
    @Override
    public List<Student> getHonorRollStudents() {
        System.out.println("🏆 Fetching honor roll students (GPA >= 3.5)");
        
        List<Student> honorRoll = studentRepository.findAll().stream()
                .filter(s -> s.getGpa() >= 3.5)
                .collect(Collectors.toList());
        
        System.out.println("✅ Found " + honorRoll.size() + " honor roll students");
        return honorRoll;
    }
    
    @Override
    public Student promoteStudent(int id) {
        System.out.println("⬆️ Promoting student ID: " + id);
        
        Student student = studentRepository.findById(id);
        if (student == null) {
            System.out.println("❌ Student not found");
            return null;
        }
        
        student.setSemester(student.getSemester() + 1);
        Student promoted = studentRepository.update(student);
        System.out.println("✅ Student promoted to semester " + student.getSemester());
        
        return promoted;
    }
}