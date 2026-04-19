package com.jobportal.model;

import java.time.LocalDateTime;

public class Notification {
    
    private Long id;
    private User user;
    private String title;
    private String message;
    private String type;
    private boolean isRead;
    private LocalDateTime createdAt;
    private Long relatedId;
    private String relatedType;
    
    public Notification() {
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }
    
    public Notification(User user, String title, String message, String type) {
        this.user = user;
        this.title = title;
        this.message = message;
        this.type = type;
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public User getUser() {
        return user;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getType() {
        return type;
    }
    
    public boolean isRead() {
        return isRead;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public Long getRelatedId() {
        return relatedId;
    }
    
    public String getRelatedType() {
        return relatedType;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }
    
    public void setRelatedType(String relatedType) {
        this.relatedType = relatedType;
    }
}