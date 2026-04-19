package com.jobportal.service;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService {
    
    private UserRepository userRepository = new UserRepository();
    
    public User registerUser(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
    
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public List<User> getJobSeekers() {
        return userRepository.findByRole("JOBSEEKER");
    }
    
    public List<User> getEmployers() {
        return userRepository.findByRole("EMPLOYER");
    }
    
    public User updateUser(Long id, User userDetails) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(userDetails.getName());
            user.setPhone(userDetails.getPhone());
            user.setLocation(userDetails.getLocation());
            user.setSkills(userDetails.getSkills());
            if (userDetails.getCompanyName() != null) {
                user.setCompanyName(userDetails.getCompanyName());
            }
            return userRepository.save(user);
        }
        return null;
    }
    
    public void updateResumePath(Long userId, String resumePath) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            user.get().setResumePath(resumePath);
            userRepository.save(user.get());
        }
    }
    
    public boolean authenticate(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
    
    public long getTotalUsers() {
        return userRepository.count();
    }
}