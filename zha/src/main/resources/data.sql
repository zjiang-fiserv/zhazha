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
VALUES (111, 'Guy', 'Full', 1234, 'Manager');
INSERT INTO PRODUCT (
    id, 
    product_name, 
    product_description, 
    price)
VALUES (222, 'Pepperoni', '18 inches', 20.00);
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