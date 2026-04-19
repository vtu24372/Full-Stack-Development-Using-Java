package com.jobportal.repository;

import com.jobportal.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {
    
    private static List<User> users = new ArrayList<>();
    private static AtomicLong idCounter = new AtomicLong(1);
    
    static {
        // Initialize with some dummy data
        User admin = new User("Admin User", "admin@jobportal.com", "admin123", "ADMIN");
        admin.setId(idCounter.getAndIncrement());
        admin.setPhone("9876543210");
        admin.setLocation("Mumbai");
        users.add(admin);
        
        User jobSeeker = new User("John Doe", "john@example.com", "password123", "JOBSEEKER");
        jobSeeker.setId(idCounter.getAndIncrement());
        jobSeeker.setPhone("9876543211");
        jobSeeker.setLocation("Delhi");
        jobSeeker.setSkills("Java, Spring, MySQL");
        users.add(jobSeeker);
        
        User employer = new User("Tech Corp", "employer@jobportal.com", "employer123", "EMPLOYER");
        employer.setId(idCounter.getAndIncrement());
        employer.setPhone("9876543212");
        employer.setLocation("Bangalore");
        employer.setCompanyName("Tech Corp India");
        users.add(employer);
    }
    
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.getAndIncrement());
            users.add(user);
        } else {
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getId().equals(user.getId())) {
                    users.set(i, user);
                    break;
                }
            }
        }
        return user;
    }
    
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }
    
    public Optional<User> findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
    
    public List<User> findAll() {
        return new ArrayList<>(users);
    }
    
    public List<User> findByRole(String role) {
        return users.stream()
                .filter(user -> user.getRole() != null && user.getRole().equals(role))
                .toList();
    }
    
    public boolean existsByEmail(String email) {
        return users.stream()
                .anyMatch(user -> user.getEmail().equals(email));
    }
    
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
    
    public long count() {
        return users.size();
    }
}