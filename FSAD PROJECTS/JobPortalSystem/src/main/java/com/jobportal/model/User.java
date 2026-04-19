package com.jobportal.model;

import java.time.LocalDateTime;

public class User {
    
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String phone;
    private String location;
    private String skills;
    private String resumePath;
    private String companyName;
    private String profilePicture;
    private LocalDateTime createdAt;
    private boolean enabled;
    
    public User() {
        this.createdAt = LocalDateTime.now();
        this.enabled = true;
    }
    
    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdAt = LocalDateTime.now();
        this.enabled = true;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getLocation() {
        return location;
    }
    
    public String getSkills() {
        return skills;
    }
    
    public String getResumePath() {
        return resumePath;
    }
    
    public String getCompanyName() {
        return companyName;
    }
    
    public String getProfilePicture() {
        return profilePicture;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public boolean isEnabled() {
        return enabled;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setSkills(String skills) {
        this.skills = skills;
    }
    
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}