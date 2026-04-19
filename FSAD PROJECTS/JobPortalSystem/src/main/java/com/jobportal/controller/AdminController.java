package com.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("message", "Welcome to Admin Dashboard");
        return "admin/dashboard";
    }

    @GetMapping("/users")
    public String manageUsers() {
        return "admin/users";
    }

    @GetMapping("/reports")
    public String viewReports() {
        return "admin/reports";
    }
}