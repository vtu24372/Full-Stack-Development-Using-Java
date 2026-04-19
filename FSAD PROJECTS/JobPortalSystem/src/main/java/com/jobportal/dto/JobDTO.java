package com.jobportal.dto;

import java.time.LocalDateTime;

public class JobDTO {
    
    private Long id;
    private String title;
    private String description;
    private String category;
    private String location;
    private String experience;
    private String skills;
    private String salary;
    private String status;
    private String employerName;
    private String employerCompany;
    private LocalDateTime postedDate;
    private LocalDateTime lastDate;
    
    // Constructors
    public JobDTO() {
    }
    
    public JobDTO(Long id, String title, String description, String category, String location, 
                  String experience, String skills, String salary, String status, 
                  String employerName, String employerCompany, LocalDateTime postedDate, LocalDateTime lastDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.location = location;
        this.experience = experience;
        this.skills = skills;
        this.salary = salary;
        this.status = status;
        this.employerName = employerName;
        this.employerCompany = employerCompany;
        this.postedDate = postedDate;
        this.lastDate = lastDate;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getExperience() {
        return experience;
    }
    
    public String getSkills() {
        return skills;
    }
    
    public String getSalary() {
        return salary;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getEmployerName() {
        return employerName;
    }
    
    public String getEmployerCompany() {
        return employerCompany;
    }
    
    public LocalDateTime getPostedDate() {
        return postedDate;
    }
    
    public LocalDateTime getLastDate() {
        return lastDate;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setExperience(String experience) {
        this.experience = experience;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public void setSalary(String salary) {
        this.salary = salary;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    public void setEmployerCompany(String employerCompany) {
        this.employerCompany = employerCompany;
    }
    
    public void setPostedDate(LocalDateTime postedDate) {
        this.postedDate = postedDate;
    }
    
    public void setLastDate(LocalDateTime lastDate) {
        this.lastDate = lastDate;
    }
}