package com.oms.ordermanagement.service;

import com.oms.ordermanagement.model.Customer;
import com.oms.ordermanagement.model.Order;
import com.oms.ordermanagement.model.Product;
import java.util.List;

public interface OrderService {
    List<Customer> getAllCustomers();
    List<Product> getAllProducts();
    List<Order> getAllOrders();
    Customer getCustomerById(Long id);
    Product getProductById(Long id);
    Order getOrderById(Long id);
}