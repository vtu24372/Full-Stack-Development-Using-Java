package com.jobportal.dto;

import java.time.LocalDateTime;

public class ApplicationDTO {
    
    private Long id;
    private Long jobId;
    private String jobTitle;
    private String jobLocation;
    private Long jobSeekerId;
    private String jobSeekerName;
    private String jobSeekerEmail;
    private String status;
    private String coverLetter;
    private String resumePath;
    private LocalDateTime appliedDate;
    private LocalDateTime reviewDate;
    private String employerFeedback;
    
    // Constructors
    public ApplicationDTO() {
    }
    
    public ApplicationDTO(Long id, Long jobId, String jobTitle, String jobLocation, 
                          Long jobSeekerId, String jobSeekerName, String jobSeekerEmail,
                          String status, String coverLetter, String resumePath, 
                          LocalDateTime appliedDate, LocalDateTime reviewDate, String employerFeedback) {
        this.id = id;
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobLocation = jobLocation;
        this.jobSeekerId = jobSeekerId;
        this.jobSeekerName = jobSeekerName;
        this.jobSeekerEmail = jobSeekerEmail;
        this.status = status;
        this.coverLetter = coverLetter;
        this.resumePath = resumePath;
        this.appliedDate = appliedDate;
        this.reviewDate = reviewDate;
        this.employerFeedback = employerFeedback;
    }
    
    // Getters
    public Long getId() {
        return id;
    }
    
    public Long getJobId() {
        return jobId;
    }
    
    public String getJobTitle() {
        return jobTitle;
    }
    
    public String getJobLocation() {
        return jobLocation;
    }
    
    public Long getJobSeekerId() {
        return jobSeekerId;
    }
    
    public String getJobSeekerName() {
        return jobSeekerName;
    }
    
    public String getJobSeekerEmail() {
        return jobSeekerEmail;
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
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    public void setJobLocation(String jobLocation) {
        this.jobLocation = jobLocation;
    }
    
    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }
    
    public void setJobSeekerName(String jobSeekerName) {
        this.jobSeekerName = jobSeekerName;
    }
    
    public void setJobSeekerEmail(String jobSeekerEmail) {
        this.jobSeekerEmail = jobSeekerEmail;
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