package com.oms.ordermanagement.controller;

import com.oms.ordermanagement.model.Customer;
import com.oms.ordermanagement.model.Order;
import com.oms.ordermanagement.model.Product;
import com.oms.ordermanagement.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @GetMapping("/")
    public String dashboard(Model model) {
        List<Customer> customers = orderService.getAllCustomers();
        List<Product> products = orderService.getAllProducts();
        List<Order> orders = orderService.getAllOrders();
        
        // Basic stats
        model.addAttribute("customers", customers);
        model.addAttribute("products", products);
        model.addAttribute("orders", orders);
        model.addAttribute("totalCustomers", customers.size());
        model.addAttribute("totalProducts", products.size());
        model.addAttribute("totalOrders", orders.size());
        
        // Calculate total revenue
        double totalRevenue = orders.stream()
                .mapToDouble(Order::getTotalAmount)
                .sum();
        model.addAttribute("totalRevenue", totalRevenue);
        
        // Average order value
        double avgOrderValue = orders.isEmpty() ? 0 : totalRevenue / orders.size();
        model.addAttribute("avgOrderValue", avgOrderValue);
        
        // Get most active customers (top 5 by order count)
        List<Customer> activeCustomers = customers.stream()
                .sorted((c1, c2) -> c2.getTotalOrders().compareTo(c1.getTotalOrders()))
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("activeCustomers", activeCustomers);
        
        // Get recent orders
        List<Order> recentOrders = orders.stream()
                .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
                .limit(5)
                .collect(Collectors.toList());
        model.addAttribute("recentOrders", recentOrders);
        
        // Order status distribution
        Map<String, Long> ordersByStatus = new HashMap<>();
        ordersByStatus.put("PENDING", orders.stream().filter(o -> "PENDING".equals(o.getStatus())).count());
        ordersByStatus.put("CONFIRMED", orders.stream().filter(o -> "CONFIRMED".equals(o.getStatus())).count());
        ordersByStatus.put("DELIVERED", orders.stream().filter(o -> "DELIVERED".equals(o.getStatus())).count());
        model.addAttribute("ordersByStatus", ordersByStatus);
        
        // Low stock products
        List<Product> lowStockProducts = products.stream()
                .filter(p -> p.getStock() < 20)
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("lowStockProducts", lowStockProducts);
        
        model.addAttribute("activePage", "dashboard");
        
        return "dashboard";
    }
    
    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", orderService.getAllCustomers());
        model.addAttribute("activePage", "customers");
        return "dashboard";
    }
    
    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", orderService.getAllProducts());
        model.addAttribute("activePage", "products");
        return "dashboard";
    }
    
    @GetMapping("/orders")
    public String orders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        model.addAttribute("activePage", "orders");
        return "dashboard";
    }
    
    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "✅ Application is working with " + 
               orderService.getAllCustomers().size() + " customers, " +
               orderService.getAllProducts().size() + " products, " +
               orderService.getAllOrders().size() + " orders!";
    }
}