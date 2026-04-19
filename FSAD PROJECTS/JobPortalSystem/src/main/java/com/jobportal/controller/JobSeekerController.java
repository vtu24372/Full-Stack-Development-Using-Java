package com.jobportal.controller;

import com.jobportal.model.Job;
import com.jobportal.model.User;
import com.jobportal.model.Application;
import com.jobportal.repository.JobRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/jobseeker")
public class JobSeekerController {

    @Autowired
    private JobRepository jobRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private ApplicationRepository applicationRepository;

    private User getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();
        return userRepository.findByEmail(email).orElse(null);
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        User currentUser = getCurrentUser();
        List<Job> recentJobs = jobRepository.findByStatus("OPEN");
        if (recentJobs.size() > 5) {
            recentJobs = recentJobs.subList(0, 5);
        }
        
        long appliedCount = applicationRepository.findByJobSeeker(currentUser).size();
        long shortlistedCount = applicationRepository.findByJobSeeker(currentUser).stream()
                .filter(a -> "SHORTLISTED".equals(a.getStatus()))
                .count();
        
        model.addAttribute("user", currentUser);
        model.addAttribute("recentJobs", recentJobs);
        model.addAttribute("appliedCount", appliedCount);
        model.addAttribute("shortlistedCount", shortlistedCount);
        return "jobseeker/dashboard";
    }

    @GetMapping("/profile")
    public String viewProfile(Model model) {
        User currentUser = getCurrentUser();
        model.addAttribute("user", currentUser);
        return "jobseeker/profile";
    }

    @GetMapping("/jobs")
    public String viewJobs(@RequestParam(required = false) String keyword,
                           @RequestParam(required = false) String category,
                           @RequestParam(required = false) String location,
                           Model model) {
        List<Job> jobs = jobRepository.findByStatus("OPEN");
        model.addAttribute("jobs", jobs);
        return "jobseeker/jobs";
    }

    @GetMapping("/applications")
    public String viewApplications(Model model) {
        User currentUser = getCurrentUser();
        List<Application> applications = applicationRepository.findByJobSeeker(currentUser);
        model.addAttribute("applications", applications);
        return "jobseeker/applications";
    }
    
    @GetMapping("/notifications")
    public String viewNotifications(Model model) {
        return "jobseeker/notifications";
    }
    
    @GetMapping("/apply/{jobId}")
    public String applyForJob(@PathVariable Long jobId, RedirectAttributes redirectAttributes) {
        User currentUser = getCurrentUser();
        Job job = jobRepository.findById(jobId).orElse(null);
        
        if (job == null) {
            redirectAttributes.addFlashAttribute("error", "Job not found");
            return "redirect:/jobseeker/jobs";
        }
        
        if (applicationRepository.findByJobAndJobSeeker(job, currentUser).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "You have already applied for this job");
            return "redirect:/jobseeker/jobs";
        }
        
        Application application = new Application();
        application.setJob(job);
        application.setJobSeeker(currentUser);
        application.setStatus("PENDING");
        application.setAppliedDate(LocalDateTime.now());
        
        applicationRepository.save(application);
        redirectAttributes.addFlashAttribute("message", "Application submitted successfully");
        return "redirect:/jobseeker/applications";
    }
}