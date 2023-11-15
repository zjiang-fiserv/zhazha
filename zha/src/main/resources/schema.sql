CREATE TABLE IF NOT EXISTS CUSTOMER (customer_number INT NOT NULL PRIMARY KEY, customer_address
VARCHAR(100), customer_name VARCHAR(50), zip int);




CREATE TABLE IF NOT EXISTS CUSTOMER_ORDER (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
employee_id int, customer_id int, date_time TIMESTAMP)