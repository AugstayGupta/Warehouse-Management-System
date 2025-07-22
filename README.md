# Warehouse Management System (WMS)

A Spring Boot-based Warehouse Management System for managing products, inventory, orders, and suppliers.

## Features
- User authentication (Admin, Staff)
- Product management
- Inventory tracking
- Order management
- Supplier management
- Reporting
- RESTful API

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Spring Security
- H2 Database (in-memory)

## Getting Started

1. **Build the project:**
   ```
   mvn clean install
   ```
2. **Run the application:**
   ```
   mvn spring-boot:run
   ```
3. **Access H2 Console:**
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:wmsdb`

## API Endpoints
See `/api/*` endpoints for managing warehouse resources. 