package com.oms.ordermanagement.service;

import com.oms.ordermanagement.model.Customer;
import com.oms.ordermanagement.model.Order;
import com.oms.ordermanagement.model.Product;
import com.oms.ordermanagement.repository.CustomerRepository;
import com.oms.ordermanagement.repository.OrderRepository;
import com.oms.ordermanagement.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @PostConstruct
    @Transactional
    public void initData() {
        try {
            if (customerRepository.count() == 0) {
                System.out.println("📝 Adding sample data...");
                
                // ============ ADD MORE CUSTOMERS ============
                Customer c1 = new Customer();
                c1.setName("John Smith");
                c1.setEmail("john.smith@email.com");
                c1.setPhone("+1-555-0123");
                c1.setAddress("123 Main St");
                c1.setCity("New York");
                c1.setCountry("USA");
                c1.setTotalOrders(0);
                c1.setTotalSpent(0.0);
                c1.setStatus("ACTIVE");
                c1 = customerRepository.save(c1);
                
                Customer c2 = new Customer();
                c2.setName("Emma Wilson");
                c2.setEmail("emma.wilson@email.com");
                c2.setPhone("+1-555-0124");
                c2.setAddress("456 Oak Ave");
                c2.setCity("Los Angeles");
                c2.setCountry("USA");
                c2.setTotalOrders(0);
                c2.setTotalSpent(0.0);
                c2.setStatus("ACTIVE");
                c2 = customerRepository.save(c2);
                
                // NEW CUSTOMERS
                Customer c3 = new Customer();
                c3.setName("Michael Brown");
                c3.setEmail("michael.brown@email.com");
                c3.setPhone("+1-555-0125");
                c3.setAddress("789 Pine Rd");
                c3.setCity("Chicago");
                c3.setCountry("USA");
                c3.setTotalOrders(0);
                c3.setTotalSpent(0.0);
                c3.setStatus("ACTIVE");
                c3 = customerRepository.save(c3);
                
                Customer c4 = new Customer();
                c4.setName("Sarah Davis");
                c4.setEmail("sarah.davis@email.com");
                c4.setPhone("+1-555-0126");
                c4.setAddress("321 Elm St");
                c4.setCity("Houston");
                c4.setCountry("USA");
                c4.setTotalOrders(0);
                c4.setTotalSpent(0.0);
                c4.setStatus("ACTIVE");
                c4 = customerRepository.save(c4);
                
                Customer c5 = new Customer();
                c5.setName("Robert Johnson");
                c5.setEmail("robert.johnson@email.com");
                c5.setPhone("+1-555-0127");
                c5.setAddress("654 Maple Dr");
                c5.setCity("Phoenix");
                c5.setCountry("USA");
                c5.setTotalOrders(0);
                c5.setTotalSpent(0.0);
                c5.setStatus("ACTIVE");
                c5 = customerRepository.save(c5);
                
                Customer c6 = new Customer();
                c6.setName("Jennifer Lee");
                c6.setEmail("jennifer.lee@email.com");
                c6.setPhone("+1-555-0128");
                c6.setAddress("987 Cedar Ln");
                c6.setCity("San Francisco");
                c6.setCountry("USA");
                c6.setTotalOrders(0);
                c6.setTotalSpent(0.0);
                c6.setStatus("ACTIVE");
                c6 = customerRepository.save(c6);
                
                // ============ ADD MORE PRODUCTS ============
                Product p1 = new Product();
                p1.setName("iPhone 14 Pro");
                p1.setDescription("Latest Apple smartphone with A16 chip");
                p1.setPrice(1099.99);
                p1.setStock(50);
                p1.setCategory("Electronics");
                p1.setImageUrl("/images/iphone14.jpg");
                p1.setStatus("AVAILABLE");
                p1 = productRepository.save(p1);
                
                Product p2 = new Product();
                p2.setName("MacBook Pro 16");
                p2.setDescription("Professional laptop with M2 chip");
                p2.setPrice(2499.99);
                p2.setStock(20);
                p2.setCategory("Computers");
                p2.setImageUrl("/images/macbook.jpg");
                p2.setStatus("AVAILABLE");
                p2 = productRepository.save(p2);
                
                // NEW PRODUCTS
                Product p3 = new Product();
                p3.setName("Samsung Galaxy S23");
                p3.setDescription("Flagship Android smartphone");
                p3.setPrice(999.99);
                p3.setStock(35);
                p3.setCategory("Electronics");
                p3.setImageUrl("/images/samsung23.jpg");
                p3.setStatus("AVAILABLE");
                p3 = productRepository.save(p3);
                
                Product p4 = new Product();
                p4.setName("Sony WH-1000XM4");
                p4.setDescription("Wireless noise-cancelling headphones");
                p4.setPrice(349.99);
                p4.setStock(100);
                p4.setCategory("Audio");
                p4.setImageUrl("/images/sony-headphones.jpg");
                p4.setStatus("AVAILABLE");
                p4 = productRepository.save(p4);
                
                Product p5 = new Product();
                p5.setName("iPad Air");
                p5.setDescription("10.9-inch tablet with M1 chip");
                p5.setPrice(599.99);
                p5.setStock(45);
                p5.setCategory("Tablets");
                p5.setImageUrl("/images/ipad-air.jpg");
                p5.setStatus("AVAILABLE");
                p5 = productRepository.save(p5);
                
                Product p6 = new Product();
                p6.setName("Apple Watch Series 8");
                p6.setDescription("Smartwatch with health features");
                p6.setPrice(399.99);
                p6.setStock(60);
                p6.setCategory("Wearables");
                p6.setImageUrl("/images/apple-watch.jpg");
                p6.setStatus("AVAILABLE");
                p6 = productRepository.save(p6);
                
                Product p7 = new Product();
                p7.setName("Dell XPS 15");
                p7.setDescription("Premium Windows laptop");
                p7.setPrice(1899.99);
                p7.setStock(15);
                p7.setCategory("Computers");
                p7.setImageUrl("/images/dell-xps.jpg");
                p7.setStatus("AVAILABLE");
                p7 = productRepository.save(p7);
                
                Product p8 = new Product();
                p8.setName("AirPods Pro");
                p8.setDescription("Wireless earbuds with ANC");
                p8.setPrice(249.99);
                p8.setStock(80);
                p8.setCategory("Audio");
                p8.setImageUrl("/images/airpods.jpg");
                p8.setStatus("AVAILABLE");
                p8 = productRepository.save(p8);
                
                // ============ ADD MORE ORDERS ============
                // Order 1
                Order o1 = new Order();
                o1.setOrderNumber("ORD-20240225-001");
                o1.setCustomer(c1);
                o1.setProduct(p1);
                o1.setQuantity(1);
                o1.setTotalAmount(1099.99);
                o1.setOrderDate(LocalDateTime.now().minusDays(5));
                o1.setStatus("DELIVERED");
                o1.setPaymentMethod("Credit Card");
                o1.setDeliveryAddress("123 Main St, New York, USA");
                orderRepository.save(o1);
                
                // Order 2
                Order o2 = new Order();
                o2.setOrderNumber("ORD-20240225-002");
                o2.setCustomer(c2);
                o2.setProduct(p3);
                o2.setQuantity(1);
                o2.setTotalAmount(999.99);
                o2.setOrderDate(LocalDateTime.now().minusDays(4));
                o2.setStatus("DELIVERED");
                o2.setPaymentMethod("PayPal");
                o2.setDeliveryAddress("456 Oak Ave, Los Angeles, USA");
                orderRepository.save(o2);
                
                // Order 3
                Order o3 = new Order();
                o3.setOrderNumber("ORD-20240225-003");
                o3.setCustomer(c3);
                o3.setProduct(p2);
                o3.setQuantity(1);
                o3.setTotalAmount(2499.99);
                o3.setOrderDate(LocalDateTime.now().minusDays(3));
                o3.setStatus("CONFIRMED");
                o3.setPaymentMethod("Credit Card");
                o3.setDeliveryAddress("789 Pine Rd, Chicago, USA");
                orderRepository.save(o3);
                
                // Order 4
                Order o4 = new Order();
                o4.setOrderNumber("ORD-20240225-004");
                o4.setCustomer(c4);
                o4.setProduct(p4);
                o4.setQuantity(2);
                o4.setTotalAmount(699.98);
                o4.setOrderDate(LocalDateTime.now().minusDays(2));
                o4.setStatus("CONFIRMED");
                o4.setPaymentMethod("Debit Card");
                o4.setDeliveryAddress("321 Elm St, Houston, USA");
                orderRepository.save(o4);
                
                // Order 5
                Order o5 = new Order();
                o5.setOrderNumber("ORD-20240225-005");
                o5.setCustomer(c5);
                o5.setProduct(p5);
                o5.setQuantity(1);
                o5.setTotalAmount(599.99);
                o5.setOrderDate(LocalDateTime.now().minusDays(1));
                o5.setStatus("PENDING");
                o5.setPaymentMethod("PayPal");
                o5.setDeliveryAddress("654 Maple Dr, Phoenix, USA");
                orderRepository.save(o5);
                
                // Order 6
                Order o6 = new Order();
                o6.setOrderNumber("ORD-20240225-006");
                o6.setCustomer(c6);
                o6.setProduct(p6);
                o6.setQuantity(2);
                o6.setTotalAmount(799.98);
                o6.setOrderDate(LocalDateTime.now());
                o6.setStatus("PENDING");
                o6.setPaymentMethod("Credit Card");
                o6.setDeliveryAddress("987 Cedar Ln, San Francisco, USA");
                orderRepository.save(o6);
                
                // Order 7
                Order o7 = new Order();
                o7.setOrderNumber("ORD-20240225-007");
                o7.setCustomer(c2);
                o7.setProduct(p8);
                o7.setQuantity(3);
                o7.setTotalAmount(749.97);
                o7.setOrderDate(LocalDateTime.now().minusHours(5));
                o7.setStatus("CONFIRMED");
                o7.setPaymentMethod("Credit Card");
                o7.setDeliveryAddress("456 Oak Ave, Los Angeles, USA");
                orderRepository.save(o7);
                
                // Order 8
                Order o8 = new Order();
                o8.setOrderNumber("ORD-20240225-008");
                o8.setCustomer(c3);
                o8.setProduct(p7);
                o8.setQuantity(1);
                o8.setTotalAmount(1899.99);
                o8.setOrderDate(LocalDateTime.now().minusDays(1));
                o8.setStatus("PENDING");
                o8.setPaymentMethod("Debit Card");
                o8.setDeliveryAddress("789 Pine Rd, Chicago, USA");
                orderRepository.save(o8);
                
                // ============ UPDATE CUSTOMER TOTALS ============
                c1.setTotalOrders(1);
                c1.setTotalSpent(1099.99);
                customerRepository.save(c1);
                
                c2.setTotalOrders(2);
                c2.setTotalSpent(1749.96); // 999.99 + 749.97
                customerRepository.save(c2);
                
                c3.setTotalOrders(2);
                c3.setTotalSpent(4399.98); // 2499.99 + 1899.99
                customerRepository.save(c3);
                
                c4.setTotalOrders(1);
                c4.setTotalSpent(699.98);
                customerRepository.save(c4);
                
                c5.setTotalOrders(1);
                c5.setTotalSpent(599.99);
                customerRepository.save(c5);
                
                c6.setTotalOrders(1);
                c6.setTotalSpent(799.98);
                customerRepository.save(c6);
                
                System.out.println("✅ All sample data added successfully!");
                System.out.println("📊 Total Customers: " + customerRepository.count());
                System.out.println("📊 Total Products: " + productRepository.count());
                System.out.println("📊 Total Orders: " + orderRepository.count());
            }
        } catch (Exception e) {
            System.err.println("❌ Error adding sample data: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    
    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }
    
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}