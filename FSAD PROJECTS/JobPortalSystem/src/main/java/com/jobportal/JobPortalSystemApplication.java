package com.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobPortalSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobPortalSystemApplication.class, args);
        System.out.println("========================================");
        System.out.println("JOB PORTAL SYSTEM STARTED SUCCESSFULLY!");
        System.out.println("========================================");
        System.out.println("Access the application at: http://localhost:8080");
        System.out.println("========================================");
    }
}