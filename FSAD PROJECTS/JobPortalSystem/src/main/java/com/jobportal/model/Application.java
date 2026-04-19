package com.jobportal.model;

import java.time.LocalDateTime;

public class Application {
    
    private Long id;
    private Job job;
    private User jobSeeker;
    private String status;
    private String coverLetter;
    private String resumePath;
    private LocalDateTime appliedDate;
    private LocalDateTime reviewDate;
    private String employerFeedback;
    
    public Application() {
        this.status = "PENDING";
        this.appliedDate = LocalDateTime.now();
    }
    
    public Application(Job job, User jobSeeker, String coverLetter, String resumePath) {
        this.job = job;
        this.jobSeeker = jobSeeker;
        this.coverLetter = coverLetter;
        this.resumePath = resumePath;
        this.status = "PENDING";
        this.appliedDate = LocalDateTime.now();
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public Job getJob() {
        return job;
    }
    
    public User getJobSeeker() {
        return jobSeeker;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getCoverLetter() {
        return coverLetter;
    }
    
    public String getResumePath() {
        return resumePath;
    }
    
    public LocalDateTime getAppliedDate() {
        return appliedDate;
    }
    
    public LocalDateTime getReviewDate() {
        return reviewDate;
    }
    
    public String getEmployerFeedback() {
        return employerFeedback;
    }
    
    // Setters
    public void setId(Long id) {
        this.id = id;
    }
    
    public void setJob(Job job) {
        this.job = job;
    }
    
    public void setJobSeeker(User jobSeeker) {
        this.jobSeeker = jobSeeker;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setCoverLetter(String coverLetter) {
        this.coverLetter = coverLetter;
    }
    
    public void setResumePath(String resumePath) {
        this.resumePath = resumePath;
    }
    
    public void setAppliedDate(LocalDateTime appliedDate) {
        this.appliedDate = appliedDate;
    }
    
    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }
    
    public void setEmployerFeedback(String employerFeedback) {
        this.employerFeedback = employerFeedback;
    }
}