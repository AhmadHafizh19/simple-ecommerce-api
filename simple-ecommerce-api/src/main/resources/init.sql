-- Create tables
CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100)
);

CREATE TABLE products (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  description VARCHAR(255),
  price NUMERIC,
  stock INT
);

CREATE TABLE orders (
  id SERIAL PRIMARY KEY,
  customer_id INT REFERENCES customers(id),
  order_date TIMESTAMP,
  total_price NUMERIC
);

CREATE TABLE order_items (
  id SERIAL PRIMARY KEY,
  order_id INT REFERENCES orders(id),
  product_id INT REFERENCES products(id),
  quantity INT,
  unit_price NUMERIC
);

-- Seeding customers
INSERT INTO customers (name, email) VALUES
('John Doe', 'john@example.com'),
('Jane Smith', 'jane@example.com'),
('Bob Marley', 'bob@example.com');

-- Seeding products
INSERT INTO products (name, description, price, stock) VALUES
('Wireless Mouse', 'USB wireless mouse', 150000, 50),
('USB Keyboard', 'Mechanical USB keyboard', 200000, 40),
('HDMI Cable', '2 meter HDMI cable', 75000, 100),
('Webcam HD', '1080p HD Webcam', 300000, 25);

-- Seeding orders
INSERT INTO orders (customer_id, order_date, total_price) VALUES
(1, '2025-06-10 10:00:00', 550000),
(2, '2025-06-11 14:30:00', 450000);

-- Seeding order_items
INSERT INTO order_items (order_id, product_id, quantity, unit_price) VALUES
(1, 1, 1, 150000),
(1, 2, 2, 200000),
(2, 4, 1, 300000),
(2, 3, 2, 75000);