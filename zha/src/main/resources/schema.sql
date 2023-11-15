CREATE TABLE IF NOT EXISTS CUSTOMER (customer_number INT NOT NULL PRIMARY KEY, customer_address
VARCHAR(100), customer_name VARCHAR(50), zip int);

CREATE TABLE IF NOT EXISTS PRODUCT(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
product_name VARCHAR(50), product_description VARCHAR(255), price float)