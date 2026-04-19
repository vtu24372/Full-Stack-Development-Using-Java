package com.jobportal.service;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.ApplicationRepository;
import java.util.List;

public class ApplicationService {
    
    private ApplicationRepository applicationRepository = new ApplicationRepository();
    
    public Application applyForJob(Application application) {
        application.setStatus("PENDING");
        return applicationRepository.save(application);
    }
    
    public List<Application> getApplicationsByJobSeeker(User jobSeeker) {
        return applicationRepository.findByJobSeeker(jobSeeker);
    }
    
    public List<Application> getApplicationsByJob(Job job) {
        return applicationRepository.findByJob(job);
    }
    
    public List<Application> getApplicationsByEmployer(User employer) {
        return applicationRepository.findByJob_Employer(employer);
    }
    
    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }
    
    public Application updateApplicationStatus(Long id, String status) {
        Application application = getApplicationById(id);
        if (application != null) {
            application.setStatus(status);
            return applicationRepository.save(application);
        }
        return null;
    }
    
    public Application updateApplicationStatus(Long id, String status, String feedback) {
        Application application = getApplicationById(id);
        if (application != null) {
            application.setStatus(status);
            application.setEmployerFeedback(feedback);
            return applicationRepository.save(application);
        }
        return null;
    }
    
    public boolean hasApplied(Job job, User jobSeeker) {
        return applicationRepository.findByJobAndJobSeeker(job, jobSeeker).isPresent();
    }
    
    public long getTotalApplications() {
        return applicationRepository.count();
    }
    
    public long getPendingApplicationsCount() {
        return applicationRepository.findByJob_Employer(null).stream()
                .filter(a -> "PENDING".equals(a.getStatus()))
                .count();
    }
    
    public long getShortlistedCountByEmployer(User employer) {
        return applicationRepository.countByJob_EmployerAndStatus(employer, "SHORTLISTED");
    }
}