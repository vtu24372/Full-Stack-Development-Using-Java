package com.jobportal.service;

import com.jobportal.model.User;

public class EmailService {
    
    public void sendApplicationStatusEmail(User user, String jobTitle, String status) {
        System.out.println("========================================");
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("========================================");
        System.out.println("To: " + user.getEmail());
        System.out.println("Subject: Application Status Update - " + jobTitle);
        System.out.println("Body: Dear " + user.getName() + ",");
        System.out.println("");
        System.out.println("Your application for the position '" + jobTitle + "' has been " + status.toLowerCase() + ".");
        System.out.println("");
        System.out.println("Thank you for using Job Portal System.");
        System.out.println("========================================");
    }
    
    public void sendJobPostedEmail(User employer, String jobTitle) {
        System.out.println("========================================");
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("========================================");
        System.out.println("To: " + employer.getEmail());
        System.out.println("Subject: Job Posted Successfully - " + jobTitle);
        System.out.println("Body: Dear " + employer.getName() + ",");
        System.out.println("");
        System.out.println("Your job '" + jobTitle + "' has been posted successfully.");
        System.out.println("You can view applications on your dashboard.");
        System.out.println("");
        System.out.println("Thank you for using Job Portal System.");
        System.out.println("========================================");
    }
    
    public void sendNewApplicationEmail(User employer, String jobTitle, String applicantName) {
        System.out.println("========================================");
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("========================================");
        System.out.println("To: " + employer.getEmail());
        System.out.println("Subject: New Application Received - " + jobTitle);
        System.out.println("Body: Dear " + employer.getName() + ",");
        System.out.println("");
        System.out.println("A new application has been submitted for '" + jobTitle + "' by " + applicantName + ".");
        System.out.println("Please review the application on your dashboard.");
        System.out.println("");
        System.out.println("Thank you for using Job Portal System.");
        System.out.println("========================================");
    }
    
    public void sendWelcomeEmail(User user) {
        System.out.println("========================================");
        System.out.println("EMAIL NOTIFICATION");
        System.out.println("========================================");
        System.out.println("To: " + user.getEmail());
        System.out.println("Subject: Welcome to Job Portal System");
        System.out.println("Body: Dear " + user.getName() + ",");
        System.out.println("");
        System.out.println("Welcome to Job Portal System!");
        System.out.println("Your account has been created successfully as " + user.getRole());
        System.out.println("");
        System.out.println("Login to start exploring opportunities.");
        System.out.println("========================================");
    }
}