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
    
    static {
        // Create a dummy employer to avoid null pointer exception
        User dummyEmployer = new User();
        dummyEmployer.setId(1L);
        dummyEmployer.setName("Tech Corp India");
        dummyEmployer.setCompanyName("Tech Corp India Pvt Ltd");
        
        // JOB 1: Senior Java Developer
        Job job1 = new Job();
        job1.setId(idCounter.getAndIncrement());
        job1.setTitle("Senior Java Developer");
        job1.setDescription("Looking for experienced Java developer for enterprise applications");
        job1.setCategory("IT");
        job1.setLocation("Bangalore");
        job1.setExperience("3-5 years");
        job1.setSkills("Java, Spring Boot, MySQL, Microservices");
        job1.setSalary("12-15 LPA");
        job1.setStatus("OPEN");
        job1.setEmployer(dummyEmployer);
        job1.setPostedDate(java.time.LocalDateTime.now().minusDays(2));
        jobs.add(job1);
        
        // JOB 2: Frontend Developer
        Job job2 = new Job();
        job2.setId(idCounter.getAndIncrement());
        job2.setTitle("Frontend Developer");
        job2.setDescription("React.js developer needed for web applications");
        job2.setCategory("IT");
        job2.setLocation("Mumbai");
        job2.setExperience("2-4 years");
        job2.setSkills("React, JavaScript, HTML/CSS, Redux");
        job2.setSalary("8-12 LPA");
        job2.setStatus("OPEN");
        job2.setEmployer(dummyEmployer);
        job2.setPostedDate(java.time.LocalDateTime.now().minusDays(5));
        jobs.add(job2);
        
        // JOB 3: Data Scientist
        Job job3 = new Job();
        job3.setId(idCounter.getAndIncrement());
        job3.setTitle("Data Scientist");
        job3.setDescription("Looking for experienced Data Scientist");
        job3.setCategory("IT");
        job3.setLocation("Remote");
        job3.setExperience("4-6 years");
        job3.setSkills("Python, Machine Learning, TensorFlow, SQL");
        job3.setSalary("18-25 LPA");
        job3.setStatus("OPEN");
        job3.setEmployer(dummyEmployer);
        job3.setPostedDate(java.time.LocalDateTime.now().minusDays(7));
        jobs.add(job3);
        
        // JOB 4: Python Developer
        Job job4 = new Job();
        job4.setId(idCounter.getAndIncrement());
        job4.setTitle("Python Developer");
        job4.setDescription("Looking for experienced Python developer");
        job4.setCategory("IT");
        job4.setLocation("Chennai");
        job4.setExperience("2-4 years");
        job4.setSkills("Python, Django, Flask, PostgreSQL");
        job4.setSalary("10-14 LPA");
        job4.setStatus("OPEN");
        job4.setEmployer(dummyEmployer);
        job4.setPostedDate(java.time.LocalDateTime.now().minusDays(3));
        jobs.add(job4);
        
        // JOB 5: DevOps Engineer
        Job job5 = new Job();
        job5.setId(idCounter.getAndIncrement());
        job5.setTitle("DevOps Engineer");
        job5.setDescription("Kubernetes and AWS expert needed");
        job5.setCategory("IT");
        job5.setLocation("Hyderabad");
        job5.setExperience("4-6 years");
        job5.setSkills("AWS, Docker, Kubernetes, Jenkins");
        job5.setSalary("15-20 LPA");
        job5.setStatus("OPEN");
        job5.setEmployer(dummyEmployer);
        job5.setPostedDate(java.time.LocalDateTime.now().minusDays(1));
        jobs.add(job5);
        
        // JOB 6: UI/UX Designer
        Job job6 = new Job();
        job6.setId(idCounter.getAndIncrement());
        job6.setTitle("UI/UX Designer");
        job6.setDescription("Creative designer for web and mobile applications");
        job6.setCategory("Design");
        job6.setLocation("Pune");
        job6.setExperience("2-4 years");
        job6.setSkills("Figma, Adobe XD, Sketch, Photoshop");
        job6.setSalary("8-12 LPA");
        job6.setStatus("OPEN");
        job6.setEmployer(dummyEmployer);
        job6.setPostedDate(java.time.LocalDateTime.now().minusDays(4));
        jobs.add(job6);
        
        // JOB 7: HR Manager
        Job job7 = new Job();
        job7.setId(idCounter.getAndIncrement());
        job7.setTitle("HR Manager");
        job7.setDescription("Experienced HR professional needed");
        job7.setCategory("HR");
        job7.setLocation("Mumbai");
        job7.setExperience("5-8 years");
        job7.setSkills("Recruitment, Employee Relations, Performance Management");
        job7.setSalary("10-15 LPA");
        job7.setStatus("OPEN");
        job7.setEmployer(dummyEmployer);
        job7.setPostedDate(java.time.LocalDateTime.now().minusDays(6));
        jobs.add(job7);
        
        // JOB 8: Digital Marketing Manager
        Job job8 = new Job();
        job8.setId(idCounter.getAndIncrement());
        job8.setTitle("Digital Marketing Manager");
        job8.setDescription("Lead marketing campaigns and social media strategy");
        job8.setCategory("Marketing");
        job8.setLocation("Bangalore");
        job8.setExperience("3-5 years");
        job8.setSkills("SEO, Social Media, Google Analytics, Content Strategy");
        job8.setSalary("12-18 LPA");
        job8.setStatus("OPEN");
        job8.setEmployer(dummyEmployer);
        job8.setPostedDate(java.time.LocalDateTime.now().minusDays(2));
        jobs.add(job8);
    }
    
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