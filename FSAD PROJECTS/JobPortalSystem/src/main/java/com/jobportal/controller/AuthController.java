package com.jobportal.controller;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping("/login")
    public String showLoginForm(@RequestParam(value = "error", required = false) String error,
                                @RequestParam(value = "logout", required = false) String logout,
                                @RequestParam(value = "registered", required = false) String registered,
                                Model model) {
        if (error != null) {
            model.addAttribute("error", "Invalid email or password");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out successfully");
        }
        if (registered != null) {
            model.addAttribute("message", "Registration successful! Please login.");
        }
        return "auth/login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "auth/register";
    }

    @PostMapping("/save-user")
    public String registerUser(@ModelAttribute User user,
                               @RequestParam String confirmPassword,
                               Model model) {
        
        // Check if email already exists in your static list
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            model.addAttribute("error", "Email already registered");
            return "auth/register";
        }

        // Check password match
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "auth/register";
        }

        // Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        
        // Set default role if not set
        if (user.getRole() == null || user.getRole().isEmpty()) {
            user.setRole("JOBSEEKER");
        }
        
        userRepository.save(user);
        return "redirect:/auth/login?registered=true";
    }
}