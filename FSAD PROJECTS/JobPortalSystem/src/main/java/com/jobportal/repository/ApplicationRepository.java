package com.jobportal.repository;

import com.jobportal.model.Application;
import com.jobportal.model.Job;
import com.jobportal.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class ApplicationRepository {
    
    private static List<Application> applications = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong(1);
    
    static {
        // Sample applications will be added dynamically when users apply
        // Applications are created when job seekers click Apply Now
    }
    
    public Application save(Application application) {
        if (application.getId() == null) {
            application.setId(idCounter.getAndIncrement());
            applications.add(application);
        } else {
            for (int i = 0; i < applications.size(); i++) {
                if (applications.get(i).getId().equals(application.getId())) {
                    applications.set(i, application);
                    break;
                }
            }
        }
        return application;
    }
    
    public Optional<Application> findById(Long id) {
        return applications.stream()
                .filter(app -> app.getId().equals(id))
                .findFirst();
    }
    
    public List<Application> findAll() {
        return new ArrayList<>(applications);
    }
    
    public List<Application> findByJobSeeker(User jobSeeker) {
        return applications.stream()
                .filter(app -> app.getJobSeeker() != null && app.getJobSeeker().getId().equals(jobSeeker.getId()))
                .collect(Collectors.toList());
    }
    
    public List<Application> findByJob(Job job) {
        return applications.stream()
                .filter(app -> app.getJob() != null && app.getJob().getId().equals(job.getId()))
                .collect(Collectors.toList());
    }
    
    public Optional<Application> findByJobAndJobSeeker(Job job, User jobSeeker) {
        return applications.stream()
                .filter(app -> app.getJob() != null && app.getJob().getId().equals(job.getId()) &&
                              app.getJobSeeker() != null && app.getJobSeeker().getId().equals(jobSeeker.getId()))
                .findFirst();
    }
    
    public List<Application> findByJob_Employer(User employer) {
        return applications.stream()
                .filter(app -> app.getJob() != null && app.getJob().getEmployer() != null &&
                              app.getJob().getEmployer().getId().equals(employer.getId()))
                .collect(Collectors.toList());
    }
    
    public long count() {
        return applications.size();
    }
    
    public long countByJob_EmployerAndStatus(User employer, String status) {
        return applications.stream()
                .filter(app -> app.getJob() != null && app.getJob().getEmployer() != null &&
                              app.getJob().getEmployer().getId().equals(employer.getId()) &&
                              app.getStatus() != null && app.getStatus().equals(status))
                .count();
    }
    
    public void deleteById(Long id) {
        applications.removeIf(app -> app.getId().equals(id));
    }
    
    // New method to update application status
    public Application updateStatus(Long id, String status, String feedback) {
        Optional<Application> appOpt = findById(id);
        if (appOpt.isPresent()) {
            Application app = appOpt.get();
            app.setStatus(status);
            if (feedback != null) {
                app.setEmployerFeedback(feedback);
            }
            app.setReviewDate(java.time.LocalDateTime.now());
            return save(app);
        }
        return null;
    }
}