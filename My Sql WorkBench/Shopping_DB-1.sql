USE shopping_db;

-- Disable safe mode
SET SQL_SAFE_UPDATES = 0;

-- Clear all existing products
DELETE FROM products;
ALTER TABLE products AUTO_INCREMENT = 1;

-- Insert products with CORRECT unique images for each
INSERT INTO products (name, description, price, category, brand, image_url, stock_quantity) VALUES

-- Electronics (each with unique image)
('iPhone 15 Pro Max', '6.7-inch Super Retina XDR display, A17 Pro chip, 48MP main camera, Titanium design', 1499.99, 'Electronics', 'Apple', 'https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-15-pro-max.jpg', 25),
('iPhone 15 Pro', '6.1-inch Super Retina XDR display, A17 Pro chip, 48MP camera', 1299.99, 'Electronics', 'Apple', 'https://fdn2.gsmarena.com/vv/bigpic/apple-iphone-15-pro.jpg', 30),
('Google Pixel 8 Pro', '6.7-inch OLED, Tensor G3 chip, 50MP camera with AI features', 1099.99, 'Electronics', 'Google', 'https://fdn2.gsmarena.com/vv/bigpic/google-pixel-8-pro.jpg', 20),
('OnePlus 12', '6.82-inch AMOLED, Snapdragon 8 Gen 3, 50MP camera', 899.99, 'Electronics', 'OnePlus', 'https://fdn2.gsmarena.com/vv/bigpic/oneplus-12.jpg', 35),
('MacBook Pro 16"', '16-inch Liquid Retina XDR, M3 Max chip, 48GB RAM, 1TB SSD', 3999.99, 'Electronics', 'Apple', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/mbp16-spacegray-select-202301', 10),
('MacBook Air 13"', '13.6-inch Liquid Retina, M2 chip, 8GB RAM, 256GB SSD', 1099.99, 'Electronics', 'Apple', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/macbook-air-midnight-select-20220606', 25),
('Dell XPS 15', '15.6-inch OLED 3.5K, Intel Core i9, 32GB RAM, 1TB SSD', 2799.99, 'Electronics', 'Dell', 'https://i.dell.com/is/image/DellContent//content/dam/ss2/product-images/dell-client-products/notebooks/xps-notebooks/xps-15-9530/media-gallery/black/notebook-xps-15-9530-black-gallery-1.psd', 8),
('Apple AirPods Pro 2', 'Active Noise Cancellation, Spatial Audio, MagSafe Case', 249.99, 'Electronics', 'Apple', 'https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/MQD83', 75),

-- Home Appliances (each with unique image)
('Samsung 65" Neo QLED 8K', '65-inch Neo QLED 8K Smart TV, Quantum Processor, 120Hz', 3499.99, 'Home', 'Samsung', 'https://images.samsung.com/is/image/samsung/p6pim/in/qa75qn800ckxxl/feature/neo-qled-8k-qa75qn800ckxxl-535235637', 12),
('LG 65" OLED evo C3', '65-inch OLED evo 4K Smart TV, α9 Gen6 AI Processor, 120Hz', 2299.99, 'Home', 'LG', 'https://www.lg.com/in/images/tvs/md07516706/gallery/OLED65C3PSA-D-01.jpg', 15),
('Sony 65" Bravia XR A95L', '65-inch QD-OLED 4K, Cognitive Processor XR, 120Hz', 3299.99, 'Home', 'Sony', 'https://www.sony.co.in/image/60a557cb67d2b0e3b8865bcf2eb959a1', 8),
('Samsung Family Hub Refrigerator', '4-door French Door, 28 cu. ft., Family Hub touchscreen', 4999.99, 'Home', 'Samsung', 'https://images.samsung.com/is/image/samsung/p6pim/in/rf23r82e31r9-hl/feature/curd-maestro-technology-with-fresh-hybrid-cooling-rf23r82e31r9-hl-535693997', 5),
('LG InstaView Refrigerator', 'French Door, 26 cu. ft., InstaView Door-in-Door, Craft Ice', 3799.99, 'Home', 'LG', 'https://www.lg.com/in/images/refrigerators/md07524019/gallery/GC-B247SLUV-01.jpg', 7),
('Dyson V15 Detect', 'Cordless vacuum, Laser detection, 60-minute runtime', 749.99, 'Home', 'Dyson', 'https://www.dyson.in/content/dam/dyson/images/products/primary/394551-01.png', 25),
('iRobot Roomba j9+', 'Self-emptying robot vacuum, Smart mapping', 899.99, 'Home', 'iRobot', 'https://www.irobot.com/medias/roomba-j9-plus-eco-controller.jpg', 18),
('KitchenAid Stand Mixer', '5-quart tilt-head, 10 speeds, Professional performance', 449.99, 'Home', 'KitchenAid', 'https://www.kitchenaid.in/content/dam/global/shared/kitchenaid/products/stand-mixers/ksm150/hero-ksm150-ps-01.jpg', 30),

-- Fashion (each with unique image)
('Nike Air Max 270', 'Men\'s running shoes, Air Max cushioning, Breathable mesh', 149.99, 'Fashion', 'Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/ca0cd5e5-8e7d-4d3e-9b1a-9d3d7e1b3f2e/air-max-270-mens-shoes.png', 100),
('Nike Air Max 90', 'Classic design, Leather and mesh, Air cushioning', 129.99, 'Fashion', 'Nike', 'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/94b5f6b3-4b3f-4e3b-9e0a-1d3f4b5c6d7e/air-max-90-mens-shoes.png', 85),
('Adidas Ultraboost 23', 'Men\'s running shoes, Boost midsole, Primeknit upper', 179.99, 'Fashion', 'Adidas', 'https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/8b8f7c4d3e4b4f3e8a0aae7f1b2c3d4e_9366/Ultraboost_23_Shoes_Black_HR1269_01_standard.jpg', 75),
('New Balance 990v5', 'Made in USA, Premium suede/mesh, ENCAP midsole', 184.99, 'Fashion', 'New Balance', 'https://nb.scene7.com/is/image/NB/m990gl5_nb_02_i', 40),
('Vans Old Skool', 'Classic skate shoes, Suede/canvas, Padded collar', 69.99, 'Fashion', 'Vans', 'https://images.vans.com/is/image/VansBrand/VN000EE3BLK_HERO', 120),
('Converse Chuck Taylor', 'All Star high-top, Canvas, Iconic style', 59.99, 'Fashion', 'Converse', 'https://www.converse.com/dw/image/v2/BBBV_PRD/on/demandware.static/-/Sites-asics-us-Library/default/dw1e2f3g4h/images/products/M9160-front.jpg', 150),
('Levi\'s 501 Original Jeans', 'Men\'s straight fit, Original button fly, 100% cotton', 79.99, 'Fashion', 'Levi\'s', 'https://lsco.scene7.com/is/image/lsco/005010000-dy3-pdp-1', 80),

-- Books (each with unique image)
('Atomic Habits', 'James Clear - Tiny Changes, Remarkable Results', 24.99, 'Books', 'Penguin', 'https://images-na.ssl-images-amazon.com/images/I/81wgcld4wxL.jpg', 500),
('The Psychology of Money', 'Morgan Housel - Timeless lessons on wealth', 21.99, 'Books', 'Harriman', 'https://images-na.ssl-images-amazon.com/images/I/81Dky+tD+pL.jpg', 450),
('Think and Grow Rich', 'Napoleon Hill - 13 principles for success', 15.99, 'Books', 'Napoleon Hill', 'https://images-na.ssl-images-amazon.com/images/I/71UwSHSZRnS.jpg', 600),
('Rich Dad Poor Dad', 'Robert Kiyosaki - Personal finance classic', 16.99, 'Books', 'Plata', 'https://images-na.ssl-images-amazon.com/images/I/81bsw6fnUiL.jpg', 550),
('The Alchemist', 'Paulo Coelho - A magical fable about following your dreams', 16.99, 'Books', 'HarperOne', 'https://images-na.ssl-images-amazon.com/images/I/71aFt4+OTOL.jpg', 500),
('1984', 'George Orwell - The dystopian classic', 13.99, 'Books', 'Signet', 'https://images-na.ssl-images-amazon.com/images/I/71kxa1-0mfL.jpg', 400),
('Dune', 'Frank Herbert - Epic science fiction masterpiece', 18.99, 'Books', 'Ace', 'https://images-na.ssl-images-amazon.com/images/I/81ymUe8I4lL.jpg', 350),
('Harry Potter', 'J.K. Rowling - The beginning of the Harry Potter series', 19.99, 'Books', 'Scholastic', 'https://images-na.ssl-images-amazon.com/images/I/81iqz2H1x-L.jpg', 600);

-- Re-enable safe mode
SET SQL_SAFE_UPDATES = 1;

-- Show all products with their IDs and images
SELECT id, name, LEFT(image_url, 60) AS image_url FROM products ORDER BY id;

-- Disable safe mode
SET SQL_SAFE_UPDATES = 0;

-- Now delete all cart items
DELETE FROM cart_items;

-- Re-enable safe mode (optional)
SET SQL_SAFE_UPDATES = 1;