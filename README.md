# API Contract

## Customers

### Get All Customers
- **URL:** `/api/customers`
- **Method:** `GET`
- **Parameters:**
  - `name` (optional) - Filter customers by name
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Customer objects

### Get Customer by ID
- **URL:** `/api/customers/{number}`
- **Method:** `GET`
- **Path Variables:**
  - `{number}` - Customer number
- **Response:**
  - Status Code: 200 (OK)
  - Body: Customer object

### Create Customer
- **URL:** `/api/customers`
- **Method:** `POST`
- **Request Body:** Customer object
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created Customer object

### Update Customer
- **URL:** `/api/customers/{number}`
- **Method:** `PUT`
- **Path Variables:**
  - `{number}` - Customer number
- **Request Body:** Updated Customer object
- **Response:**
  - Status Code: 200 (OK)
  - Body: Updated Customer object

### Delete Customer
- **URL:** `/api/customers/{number}`
- **Method:** `DELETE`
- **Path Variables:**
  - `{number}` - Customer number
- **Response:**
  - Status Code: 204 (No Content)

### Find Customers by Zip Code
- **URL:** `/api/customers/{zip}`
- **Method:** `GET`
- **Path Variables:**
  - `{zip}` - Customer zip code
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Customer objects

## Customer Orders

### Get All Customer Orders
- **URL:** `/api/customer_orders`
- **Method:** `GET`
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of CustomerOrder objects

### Get Customer Orders by Customer Number
- **URL:** `/api/customer_orders/`
- **Method:** `GET`
- **Parameters:**
  - `customerNumber` (optional) - Filter customer orders by customer number
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of CustomerOrder objects

### Get Customer Order by ID
- **URL:** `/api/customer_orders/{id}`
- **Method:** `GET`
- **Path Variables:**
  - `{id}` - Customer order ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: CustomerOrder object

### Get Orders by Customer Order ID
- **URL:** `/api/customer_orders/{customerOrderId}/orders`
- **Method:** `GET`
- **Path Variables:**
  - `{customerOrderId}` - Customer order ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of OrderItem objects

### Create Customer Order
- **URL:** `/api/customer_orders`
- **Method:** `POST`
- **Request Body:** CustomerOrder object
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created CustomerOrder object

### Create Order Item
- **URL:** `/api/customer_orders/orders`
- **Method:** `POST`
- **Parameters:**
  - `customerOrderId` (required) - Customer order ID
  - `productId` (required) - Product ID
  - `quantity` (required) - Quantity of the product
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created OrderItem object

### Update Customer Order
- **URL:** `/api/customer_orders/{customerOrderId}`
- **Method:** `PUT`
- **Path Variables:**
  - `{customerOrderId}` - Customer order ID
- **Request Body:** Updated CustomerOrder object
- **Response:**
  - Status Code: 200 (OK)
  - Body: Updated CustomerOrder object

### Delete Customer Order
- **URL:** `/api/customer_orders/{customerOrderId}`
- **Method:** `DELETE`
- **Path Variables:**
  - `{customerOrderId}` - Customer order ID
- **Response:**
  - Status Code: 204 (No Content)

## Employees

### Get All Employees
- **URL:** `/api/employees`
- **Method:** `GET`
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Employee objects

### Get Employee by ID
- **URL:** `/api/employees/{number}`
- **Method:** `GET`
- **Path Variables:**
  - `{number}` - Employee ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: Employee object

### Create Employee
- **URL:** `/api/employees`
- **Method:** `POST`
- **Request Body:** Employee object
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created Employee object

### Delete Employee
- **URL:** `/api/employees/{number}`
- **Method:** `DELETE`
- **Path Variables:**
  - `{number}` - Employee ID
- **Response:**
  - Status Code: 204 (No Content)

### Find Employees by Status
- **URL:** `/api/employees/status/{status}`
- **Method:** `GET`
- **Path Variables:**
  - `{status}` - Employee status
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Employee objects

### Find Employees by Role
- **URL:** `/api/employees/roles/{role}`
- **Method:** `GET`
- **Path Variables:**
  - `{role}` - Employee role
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Employee objects

## Order Details

### Get All Order Details
- **URL:** `/api/order_details`
- **Method:** `GET`
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of OrderDetail objects

### Get Order Detail by Customer Order ID
- **URL:** `/api/order_details/`
- **Method:** `GET`
- **Parameters:**
  - `customerOrderId` (optional) - Filter order details by customer order ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: OrderDetail object

### Get Order Detail by ID
- **URL:** `/api/order_details/{orderDetailId}`
- **Method:** `GET`
- **Path Variables:**
  - `{orderDetailId}` - Order Detail ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: OrderDetail object

### Create Order Detail
- **URL:** `/api/order_details`
- **Method:** `POST`
- **Request Body:** OrderDetail object
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created OrderDetail object

### Update Order Detail
- **URL:** `/api/order_details/{orderDetailId}`
- **Method:** `PUT`
- **Path Variables:**
  - `{orderDetailId}` - Order Detail ID
- **Request Body:** Updated OrderDetail object
- **Response:**
  - Status Code: 200 (OK)
  - Body: Updated OrderDetail object

### Delete Order Detail
- **URL:** `/api/order_details/{orderDetailId}`
- **Method:** `DELETE`
- **Path Variables:**
  - `{orderDetailId}` - Order Detail ID
- **Response:**
  - Status Code: 204 (No Content)

## Products

### Get All Products
- **URL:** `/api/products`
- **Method:** `GET`
- **Parameters:**
  - `name` (optional) - Filter products by name
- **Response:**
  - Status Code: 200 (OK)
  - Body: Array of Product objects

### Get Product by ID
- **URL:** `/api/products/{number}`
- **Method:** `GET`
- **Path Variables:**
  - `{number}` - Product ID
- **Response:**
  - Status Code: 200 (OK)
  - Body: Product object

### Create Product
- **URL:** `/api/products`
- **Method:** `POST`
- **Request Body:** Product object
- **Response:**
  - Status Code: 201 (Created)
  - Body: Created Product object

### Update Product
- **URL:** `/api/products/{number}`
- **Method:** `PUT`
- **Path Variables:**
  - `{number}` - Product ID
- **Request Body:** Updated Product object
- **Response:**
  - Status Code: 200 (OK)
  - Body: Updated Product object

### Delete Product
- **URL:** `/api/products/{number}`
- **Method:** `DELETE`
- **Path Variables:**
  - `{number}` - Product ID
- **Response:**
  - Status Code: 204 (No Content)
