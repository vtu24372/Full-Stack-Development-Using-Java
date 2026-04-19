package com.jobportal.repository;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class JobRepository {
    
    private static List<Job> jobs = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong(1);
    
    public Job save(Job job) {
        if (job.getId() == null) {
            job.setId(idCounter.getAndIncrement());
            jobs.add(job);
        } else {
            for (int i = 0; i < jobs.size(); i++) {
                if (jobs.get(i).getId().equals(job.getId())) {
                    jobs.set(i, job);
                    break;
                }
            }
        }
        return job;
    }
    
    public Optional<Job> findById(Long id) {
        return jobs.stream()
                .filter(job -> job.getId().equals(id))
                .findFirst();
    }
    
    public List<Job> findAll() {
        return new ArrayList<>(jobs);
    }
    
    public List<Job> findByEmployer(User employer) {
        return jobs.stream()
                .filter(job -> job.getEmployer() != null && job.getEmployer().getId().equals(employer.getId()))
                .collect(Collectors.toList());
    }
    
    public List<Job> findByStatus(String status) {
        return jobs.stream()
                .filter(job -> job.getStatus() != null && job.getStatus().equals(status))
                .collect(Collectors.toList());
    }
    
    public List<Job> searchJobs(String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return new ArrayList<>(jobs);
        }
        String lowerKeyword = keyword.toLowerCase();
        return jobs.stream()
                .filter(job -> (job.getTitle() != null && job.getTitle().toLowerCase().contains(lowerKeyword)) ||
                              (job.getDescription() != null && job.getDescription().toLowerCase().contains(lowerKeyword)) ||
                              (job.getSkills() != null && job.getSkills().toLowerCase().contains(lowerKeyword)))
                .collect(Collectors.toList());
    }
    
    public List<Job> filterJobs(String category, String location, String experience) {
        return jobs.stream()
                .filter(job -> (category == null || category.isEmpty() || 
                               (job.getCategory() != null && job.getCategory().equals(category))))
                .filter(job -> (location == null || location.isEmpty() || 
                               (job.getLocation() != null && job.getLocation().equals(location))))
                .filter(job -> (experience == null || experience.isEmpty() || 
                               (job.getExperience() != null && job.getExperience().equals(experience))))
                .collect(Collectors.toList());
    }
    
    public void deleteById(Long id) {
        jobs.removeIf(job -> job.getId().equals(id));
    }
    
    public long count() {
        return jobs.size();
    }
}