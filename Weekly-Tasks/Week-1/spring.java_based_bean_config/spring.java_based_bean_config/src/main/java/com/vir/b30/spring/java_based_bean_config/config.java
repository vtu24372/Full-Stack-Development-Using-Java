package com.vir.b30.spring.java_based_bean_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.vir.b30.spring.java_based_bean_config")
public class config {

    // Creating Book bean manually because constructor has values
    @Bean
    public Book book() {
        return new Book("Harry Potter", 500);
    }
}
