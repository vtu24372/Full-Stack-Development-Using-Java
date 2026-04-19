package com.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "Welcome to Employer Dashboard");
        return "employer/dashboard";
    }

    @GetMapping("/post-job")
    public String showPostJobForm() {
        return "employer/post-job";
    }

    @GetMapping("/my-jobs")
    public String viewMyJobs() {
        return "employer/my-jobs";
    }

    @GetMapping("/applicants")
    public String viewApplicants() {
        return "employer/applicants";
    }
    
    @GetMapping("/analytics")
    public String viewAnalytics() {
        return "employer/analytics";
    }
}