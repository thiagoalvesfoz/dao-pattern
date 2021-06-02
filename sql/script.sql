CREATE DATABASE IF NOT EXISTS aula;

USE aula;

CREATE TABLE IF NOT EXISTS address (
  id INT AUTO_INCREMENT PRIMARY KEY,
  street VARCHAR(100),
  city VARCHAR(100),
  state VARCHAR(100),
  number INT
);

CREATE TABLE IF NOT EXISTS products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255),
  price DOUBLE
);

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  fullname VARCHAR(100),
  phone VARCHAR(15),
  email VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS orders (
  number INT AUTO_INCREMENT PRIMARY KEY,
  ordered DATETIME default now(),
  shipped DATETIME,
  status INT default 1,
  ship_to_id INT,
  product_id INT NOT NULL,
  user_id INT NOT NULL,
  FOREIGN KEY(ship_to_id) REFERENCES address (id),
  FOREIGN KEY(product_id) REFERENCES products (id),
  FOREIGN KEY(user_id) REFERENCES users (id)
);