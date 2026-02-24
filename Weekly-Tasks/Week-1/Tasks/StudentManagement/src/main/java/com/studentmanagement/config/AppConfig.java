package com.studentmanagement.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // Marks this as a configuration class
@ComponentScan(basePackages = "com.studentmanagement")  // Scans for components
public class AppConfig {
    
    public AppConfig() {
        System.out.println("⚙️ AppConfig: Configuration class loaded");
    }
}