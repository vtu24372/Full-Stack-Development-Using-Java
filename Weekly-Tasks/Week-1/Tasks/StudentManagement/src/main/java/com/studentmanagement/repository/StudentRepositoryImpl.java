package com.studentmanagement.repository;

import com.studentmanagement.model.Student;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository  // Spring annotation for repository layer
public class StudentRepositoryImpl implements StudentRepository {
    
    // In-memory storage using ConcurrentHashMap (thread-safe)
    private final Map<Integer, Student> studentStorage = new ConcurrentHashMap<>();
    
    // Atomic counter for generating IDs
    private final AtomicInteger idCounter = new AtomicInteger(1000);
    
    public StudentRepositoryImpl() {
        System.out.println("📦 StudentRepositoryImpl: Constructor called");
    }
    
    @PostConstruct
    public void init() {
        System.out.println("📦 StudentRepositoryImpl: Initializing with sample data...");
        addSampleStudents();
        System.out.println("📦 StudentRepositoryImpl: Ready with " + count() + " students");
    }
    
    @PreDestroy
    public void cleanup() {
        System.out.println("📦 StudentRepositoryImpl: Cleaning up...");
        studentStorage.clear();
    }
    
    private void addSampleStudents() {
        Student s1 = new Student(idCounter.getAndIncrement(), "John Doe", "john@email.com", "Computer Science", 3.8, 3);
        Student s2 = new Student(idCounter.getAndIncrement(), "Jane Smith", "jane@email.com", "Mathematics", 3.9, 5);
        Student s3 = new Student(idCounter.getAndIncrement(), "Bob Johnson", "bob@email.com", "Physics", 3.5, 2);
        
        studentStorage.put(s1.getStudentId(), s1);
        studentStorage.put(s2.getStudentId(), s2);
        studentStorage.put(s3.getStudentId(), s3);
    }
    
    @Override
    public Student save(Student student) {
        if (student.getStudentId() == 0) {
            student.setStudentId(idCounter.getAndIncrement());
        }
        studentStorage.put(student.getStudentId(), student);
        System.out.println("✅ Student saved: " + student.getName());
        return student;
    }
    
    @Override
    public Student findById(int id) {
        Student student = studentStorage.get(id);
        if (student != null) {
            System.out.println("✅ Student found: " + student.getName());
        } else {
            System.out.println("❌ Student not found with ID: " + id);
        }
        return student;
    }
    
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentStorage.values());
    }
    
    @Override
    public Student update(Student student) {
        if (studentStorage.containsKey(student.getStudentId())) {
            studentStorage.put(student.getStudentId(), student);
            System.out.println("✅ Student updated: " + student.getName());
            return student;
        }
        System.out.println("❌ Student not found for update: " + student.getStudentId());
        return null;
    }
    
    @Override
    public void delete(int id) {
        Student removed = studentStorage.remove(id);
        if (removed != null) {
            System.out.println("✅ Student deleted: " + removed.getName());
        } else {
            System.out.println("❌ Student not found for deletion: " + id);
        }
    }
    
    @Override
    public boolean exists(int id) {
        return studentStorage.containsKey(id);
    }
    
    @Override
    public int count() {
        return studentStorage.size();
    }
}