package edu.springorm.demo;

import edu.springorm.demo.entity.Product;
import edu.springorm.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringOrmApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringOrmApplication.class, args);
    }
}

@Component
class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // Test data
        if (productRepository.count() == 0) {
            productRepository.save(new Product("Laptop", "High-performance laptop", 999.99));
            productRepository.save(new Product("Mouse", "Wireless mouse", 29.99));
            productRepository.save(new Product("Keyboard", "Mechanical keyboard", 89.99));
            
            System.out.println("Sample products created!");
        }
    }
}