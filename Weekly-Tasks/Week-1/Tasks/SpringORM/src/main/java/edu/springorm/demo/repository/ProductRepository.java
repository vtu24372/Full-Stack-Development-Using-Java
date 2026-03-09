package edu.springorm.demo.repository;

import edu.springorm.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    
    // Custom query methods
    List<Product> findByNameContaining(String name);
    
    List<Product> findByPriceLessThan(Double price);
    
    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}