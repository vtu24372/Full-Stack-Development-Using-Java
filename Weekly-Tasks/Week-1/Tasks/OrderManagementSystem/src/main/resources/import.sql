INSERT INTO customers (name, email, phone, address, city, country, registration_date, total_orders, total_spent, status) VALUES 
('John Smith', 'john.smith@email.com', '+1-555-0123', '123 Main St', 'New York', 'USA', NOW(), 1, 1099.99, 'ACTIVE'),
('Emma Wilson', 'emma.wilson@email.com', '+1-555-0124', '456 Oak Ave', 'Los Angeles', 'USA', NOW(), 1, 2499.99, 'ACTIVE'),
('Michael Brown', 'michael.brown@email.com', '+1-555-0125', '789 Pine Rd', 'Chicago', 'USA', NOW(), 0, 0, 'ACTIVE');

INSERT INTO products (name, description, price, stock, category, image_url, created_at, status) VALUES 
('iPhone 14 Pro', 'Latest Apple smartphone', 1099.99, 50, 'Electronics', '/images/iphone14.jpg', NOW(), 'AVAILABLE'),
('Samsung Galaxy S23', 'Flagship Android', 999.99, 35, 'Electronics', '/images/samsung23.jpg', NOW(), 'AVAILABLE'),
('MacBook Pro 16', 'Professional laptop', 2499.99, 20, 'Computers', '/images/macbook.jpg', NOW(), 'AVAILABLE');

INSERT INTO orders (order_number, customer_id, product_id, quantity, total_amount, order_date, status, payment_method, delivery_address) VALUES 
('ORD-20240225-001', 1, 1, 1, 1099.99, DATE_SUB(NOW(), INTERVAL 5 DAY), 'DELIVERED', 'Credit Card', '123 Main St, New York, USA'),
('ORD-20240225-002', 2, 3, 1, 2499.99, DATE_SUB(NOW(), INTERVAL 4 DAY), 'CONFIRMED', 'PayPal', '456 Oak Ave, Los Angeles, USA');