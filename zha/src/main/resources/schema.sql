CREATE TABLE IF NOT EXISTS CUSTOMER (
    customer_number INT NOT NULL PRIMARY KEY,
    customer_address VARCHAR(100),
    customer_name VARCHAR(50),
    zip int
);
CREATE TABLE IF NOT EXISTS EMPLOYEE (
    id INT NOT NULL AUTO_INCREMENT,
    employee_name VARCHAR(50),
    employment_status VARCHAR(50),
    pin INT,
    employee_role VARCHAR(50),
    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS PRODUCT(
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(50),
    product_description VARCHAR(255),
    price float
);
CREATE TABLE IF NOT EXISTS CUSTOMER_ORDER (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    employee_id int NOT NULL,
    customer_number int NOT NULL,
    date_time TIMESTAMP,
    foreign key (employee_id) references EMPLOYEE(id),
    foreign key (customer_number) references CUSTOMER(customer_number)
);
CREATE TABLE IF NOT EXISTS Order_Item (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    product_id int NOT NULL,
    customer_order_id int NOT NULL,
    quantity int NOT NULL ,
    foreign key (product_id) references PRODUCT(id),
    foreign key (customer_order_id) references CUSTOMER_ORDER(id)
);
CREATE TABLE IF NOT EXISTS Order_Detail (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    customer_order_id int NOT NULL,
    discount int,
    total float NOT NULL,
    foreign key (customer_order_id) references CUSTOMER_ORDER(id)
);

