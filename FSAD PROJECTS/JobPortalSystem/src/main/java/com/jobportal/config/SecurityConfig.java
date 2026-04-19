package com.jobportal.config;

import com.jobportal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserRepository userRepository;  // This will now work

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(AntPathRequestMatcher.antMatcher("/")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/index")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/login")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/register")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/auth/save-user")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/css/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/js/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/images/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/uploads/**")).permitAll()
                .requestMatchers(AntPathRequestMatcher.antMatcher("/jobseeker/**")).hasRole("JOBSEEKER")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/employer/**")).hasRole("EMPLOYER")
                .requestMatchers(AntPathRequestMatcher.antMatcher("/admin/**")).hasRole("ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/auth/login")
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/", true)
                .failureUrl("/auth/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/auth/login?logout=true")
                .permitAll()
            );
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                com.jobportal.model.User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + email));
                
                return User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getRole())
                    .build();
            }
        };
    }
}