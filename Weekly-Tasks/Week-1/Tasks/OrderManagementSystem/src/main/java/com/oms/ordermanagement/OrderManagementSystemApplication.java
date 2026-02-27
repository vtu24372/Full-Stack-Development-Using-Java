package com.oms.ordermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderManagementSystemApplication.class, args);
        System.out.println("\n==========================================");
        System.out.println("✅ Order Management System Started Successfully!");
        System.out.println("🔗 Access: http://localhost:8080");
        System.out.println("==========================================\n");
    }
}