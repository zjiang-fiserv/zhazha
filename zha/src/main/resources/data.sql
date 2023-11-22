INSERT INTO CUSTOMER (
        customer_number,
        customer_address,
        customer_name,
        zip,
        id
    )
VALUES ('1234567890', '123 Connell Dr', 'Frank', '12345', 888);
INSERT INTO EMPLOYEE (
        id,
        employee_name,
        employment_status,
        pin,
        employee_role
    )
VALUES (111, 'Guy', 'Active', 1234, 'Manager');
INSERT INTO PRODUCT (
    id, 
    product_name, 
    product_description, 
    price)
VALUES 
(222, 'Pepperoni', '18 inches', 20.00),
(301, 'Soda', '2 liter bottle', 3.25),
(302, 'Breadsticks', '8 per pack', 2.50),
(303, 'Pizza - small Pepperoni', '8 inch', 7.35),
(304, 'Pizza - medium Pepperoni', '12 inch', 9.35),
(305, 'Pizza - large Pepperoni', '18 inch', 14.00),
(306, 'small House special', '8 inch', 8.50),
(307, 'medium House special', '12 inch', 10.50),
(308, 'Pizza – large House special', '18 inch', 16.00);
INSERT INTO CUSTOMER_ORDER (
    id, 
    employee_id, 
    customer_number, 
    date_time)
VALUES (333, 111, '1234567890', '2023-11-20 00:00:00');
INSERT INTO Order_Item (
    id, 
    product_id, 
    customer_order_id, 
    quantity)
VALUES (444, 222, 333, 5);
INSERT INTO Order_Detail (
    id, 
    customer_order_id, 
    discount, 
    total)
VALUES (555, 333, 10, 90)