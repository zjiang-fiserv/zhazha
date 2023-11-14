CREATE TABLE IF NOT EXISTS CUSTOMER (customer_number INT NOT NULL PRIMARY KEY, customer_address
VARCHAR(100), customer_name VARCHAR(50), zip int);

CREATE TABLE IF NOT EXISTS EMPLOYEE (employee_ID INT NOT NULL AUTO_INCREMENT, employee_name VARCHAR(50), employment_status VARCHAR(50), pin INT, employee_role VARCHAR(50), PRIMARY KEY (employee_ID));

