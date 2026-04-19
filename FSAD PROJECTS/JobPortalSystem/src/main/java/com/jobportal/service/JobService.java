package com.jobportal.service;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.repository.JobRepository;
import java.util.List;

public class JobService {
    
    private JobRepository jobRepository = new JobRepository();
    
    public Job postJob(Job job) {
        job.setStatus("OPEN");
        return jobRepository.save(job);
    }
    
    public List<Job> getAllOpenJobs() {
        return jobRepository.findByStatus("OPEN");
    }
    
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }
    
    public List<Job> getJobsByEmployer(User employer) {
        return jobRepository.findByEmployer(employer);
    }
    
    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }
    
    public Job updateJob(Long id, Job jobDetails) {
        Job job = getJobById(id);
        if (job != null) {
            job.setTitle(jobDetails.getTitle());
            job.setDescription(jobDetails.getDescription());
            job.setCategory(jobDetails.getCategory());
            job.setLocation(jobDetails.getLocation());
            job.setExperience(jobDetails.getExperience());
            job.setSkills(jobDetails.getSkills());
            job.setSalary(jobDetails.getSalary());
            return jobRepository.save(job);
        }
        return null;
    }
    
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }
    
    public List<Job> searchJobs(String keyword) {
        return jobRepository.searchJobs(keyword);
    }
    
    public List<Job> filterJobs(String category, String location, String experience) {
        return jobRepository.filterJobs(category, location, experience);
    }
    
    public void closeJob(Long id) {
        Job job = getJobById(id);
        if (job != null) {
            job.setStatus("CLOSED");
            jobRepository.save(job);
        }
    }
    
    public long getTotalJobs() {
        return jobRepository.count();
    }
    
    public long getOpenJobsCount() {
        return jobRepository.findByStatus("OPEN").size();
    }
}