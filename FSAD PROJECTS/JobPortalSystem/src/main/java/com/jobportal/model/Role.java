package com.jobportal.model;

public class Role {
    
    private Long id;
    private String name;
    private String description;
    
    public Role() {
    }
    
    public Role(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    // Role constants
    public static final String ROLE_JOBSEEKER = "JOBSEEKER";
    public static final String ROLE_EMPLOYER = "EMPLOYER";
    public static final String ROLE_ADMIN = "ADMIN";
}