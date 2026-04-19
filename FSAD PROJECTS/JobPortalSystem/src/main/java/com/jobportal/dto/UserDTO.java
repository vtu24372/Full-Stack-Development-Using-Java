package com.jobportal.dto;

public class UserDTO {
    
    private Long id;
    private String name;
    private String email;
    private String password;
    private String confirmPassword;
    private String role;
    private String phone;
    private String location;
    private String skills;
    private String companyName;
    
    // Constructors
    public UserDTO() {
    }
    
    public UserDTO(Long id, String name, String email, String role, String phone, String location, String skills, String companyName) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.phone = phone;
        this.location = location;
        this.skills = skills;
        this.companyName = companyName;
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
    
    public String getConfirmPassword() {
        return confirmPassword;
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
    
    public String getCompanyName() {
        return companyName;
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
    
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
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
    
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}