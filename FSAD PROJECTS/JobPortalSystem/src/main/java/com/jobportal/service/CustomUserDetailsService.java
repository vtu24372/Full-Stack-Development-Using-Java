package com.jobportal.service;

import com.jobportal.model.User;
import com.jobportal.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomUserDetailsService {
    
    private UserRepository userRepository = new UserRepository();
    
    public UserDetails loadUserByUsername(String email) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        
        if (!userOptional.isPresent()) {
            throw new RuntimeException("User not found with email: " + email);
        }
        
        User user = userOptional.get();
        
        if (!user.isEnabled()) {
            throw new RuntimeException("User account is disabled");
        }
        
        return new UserDetails(user);
    }
    
    public class UserDetails {
        private User user;
        
        public UserDetails(User user) {
            this.user = user;
        }
        
        public String getUsername() {
            return user.getEmail();
        }
        
        public String getPassword() {
            return user.getPassword();
        }
        
        public List<String> getAuthorities() {
            List<String> authorities = new ArrayList<>();
            String role = user.getRole();
            
            if (role.equals("ADMIN")) {
                authorities.add("ROLE_ADMIN");
                authorities.add("ROLE_EMPLOYER");
                authorities.add("ROLE_JOBSEEKER");
            } else if (role.equals("EMPLOYER")) {
                authorities.add("ROLE_EMPLOYER");
            } else if (role.equals("JOBSEEKER")) {
                authorities.add("ROLE_JOBSEEKER");
            }
            
            return authorities;
        }
        
        public boolean isAccountNonExpired() {
            return true;
        }
        
        public boolean isAccountNonLocked() {
            return true;
        }
        
        public boolean isCredentialsNonExpired() {
            return true;
        }
        
        public boolean isEnabled() {
            return user.isEnabled();
        }
        
        public User getUser() {
            return user;
        }
    }
}