package com.studentmanagement;

import com.studentmanagement.config.AppConfig;
import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    
    // ANSI color codes
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    
    public static void main(String[] args) {
        printHeader();
        
        // Create Spring Container
        System.out.println(YELLOW + "\n🔧 Creating Spring Container..." + RESET);
        
        try (AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(AppConfig.class)) {
            
            System.out.println(GREEN + "✅ Spring Container created!" + RESET);
            
            // Get service bean
            StudentService studentService = context.getBean(StudentService.class);
            
            // Run interactive menu
            runMenu(studentService);
            
        }
    }
    
    private static void runMenu(StudentService studentService) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            printMenu();
            System.out.print(YELLOW + "Enter your choice: " + RESET);
            
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                
                switch (choice) {
                    case 1:
                        viewAllStudents(studentService);
                        break;
                    case 2:
                        addStudent(studentService, scanner);
                        break;
                    case 3:
                        calculateAverageGPA(studentService);
                        break;
                    case 4:
                        viewHonorRoll(studentService);
                        break;
                    case 5:
                        System.out.println(PURPLE + "\n👋 Goodbye!" + RESET);
                        return;
                    default:
                        System.out.println(RED + "❌ Invalid choice!" + RESET);
                }
            } catch (Exception e) {
                System.out.println(RED + "❌ Error: " + e.getMessage() + RESET);
            }
            
            System.out.println(YELLOW + "\nPress Enter to continue..." + RESET);
            scanner.nextLine();
        }
    }
    
    private static void viewAllStudents(StudentService studentService) {
        List<Student> students = studentService.getAllStudents();
        System.out.println(CYAN + "\n📋 ALL STUDENTS:" + RESET);
        for (Student s : students) {
            System.out.println("   🆔 " + s.getStudentId() + " | 👤 " + s.getName() + 
                             " | 📚 " + s.getCourse() + " | 📊 " + s.getGpa() +
                             " | 📖 Sem " + s.getSemester());
        }
    }
    
    private static void addStudent(StudentService studentService, Scanner scanner) {
        System.out.println(YELLOW + "\n📝 Add New Student:" + RESET);
        
        Student student = new Student();
        
        System.out.print("   Name: ");
        student.setName(scanner.nextLine());
        
        System.out.print("   Email: ");
        student.setEmail(scanner.nextLine());
        
        System.out.print("   Course: ");
        student.setCourse(scanner.nextLine());
        
        System.out.print("   GPA: ");
        student.setGpa(Double.parseDouble(scanner.nextLine()));
        
        System.out.print("   Semester: ");
        student.setSemester(Integer.parseInt(scanner.nextLine()));
        
        Student saved = studentService.registerStudent(student);
        System.out.println(GREEN + "   ✅ Student added with ID: " + saved.getStudentId() + RESET);
    }
    
    private static void calculateAverageGPA(StudentService studentService) {
        double avg = studentService.calculateAverageGPA();
        System.out.println(PURPLE + "\n📊 Average GPA: " + String.format("%.2f", avg) + RESET);
    }
    
    private static void viewHonorRoll(StudentService studentService) {
        List<Student> honorRoll = studentService.getHonorRollStudents();
        System.out.println(GREEN + "\n🏆 HONOR ROLL STUDENTS:" + RESET);
        for (Student s : honorRoll) {
            System.out.println("   👤 " + s.getName() + " | 📚 " + s.getCourse() + " | 📊 " + s.getGpa());
        }
    }
    
    private static void printMenu() {
        System.out.println(BLUE + "\n" + "=".repeat(50));
        System.out.println("        STUDENT MANAGEMENT MENU");
        System.out.println("=".repeat(50) + RESET);
        System.out.println("   " + GREEN + "1." + RESET + " View All Students");
        System.out.println("   " + GREEN + "2." + RESET + " Add New Student");
        System.out.println("   " + GREEN + "3." + RESET + " Calculate Average GPA");
        System.out.println("   " + GREEN + "4." + RESET + " View Honor Roll Students");
        System.out.println("   " + RED + "5." + RESET + " Exit");
        System.out.println(BLUE + "=".repeat(50) + RESET);
    }
    
    private static void printHeader() {
        System.out.println(PURPLE + "\n" + "⭐".repeat(60));
        System.out.println("          STUDENT MANAGEMENT SYSTEM");
        System.out.println("     Inversion of Control & Dependency Injection");
        System.out.println("⭐".repeat(60) + RESET);
    }
}