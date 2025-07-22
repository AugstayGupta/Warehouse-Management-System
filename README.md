# Warehouse Management System (WMS)

A Spring Boot-based Warehouse Management System designed for managing products, inventory, orders, and suppliers in a streamlined and efficient way.

## Features

- 🔐 **User Authentication** (Admin, Staff roles)
- 📦 **Product Management**
- 📊 **Inventory Tracking**
- 📋 **Order Management**
- 🤝 **Supplier Management**
- 🌐 **RESTful API** for integration and frontend support

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **H2 Database** (in-memory for testing/demo)

## Getting Started

### Prerequisites

- Java 17+
- Maven



# Build and Run


## Build the Project
mvn clean install


## Run the Application
mvn spring-boot:run



# H2 Database Console
💾 Access the in-memory H2 database for quick testing and debugging:

🔗 URL: http://localhost:8080/h2-console

🛠️ JDBC URL: jdbc:h2:mem:wmsdb

👤 User: sa

🔑 Password: (leave blank)



## API Endpoints

All endpoints are available under the `/api` prefix.

### Sample Endpoints

| Resource    | Endpoint            | Method | Description               |
|-------------|---------------------|--------|---------------------------|
| 🧾 Products | `/api/products`     | GET    | List all products         |
| 📥 Orders   | `/api/orders`       | POST   | Create a new order        |
| 📦 Inventory| `/api/inventory`    | GET    | Get current stock levels  |
| 🤝 Suppliers| `/api/suppliers`    | PUT    | Update supplier info      |

> 🧪 Use Postman or `curl` for testing these endpoints.


