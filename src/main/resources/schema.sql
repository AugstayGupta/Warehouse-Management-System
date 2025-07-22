CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);

CREATE TABLE supplier (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    contact VARCHAR(255)
);

CREATE TABLE product (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255),
    supplier_id BIGINT,
    CONSTRAINT fk_product_supplier FOREIGN KEY (supplier_id) REFERENCES supplier(id)
);

CREATE TABLE inventory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT,
    quantity INT,
    CONSTRAINT fk_inventory_product FOREIGN KEY (product_id) REFERENCES product(id)
);

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT,
    quantity INT,
    order_type VARCHAR(255) NOT NULL,
    order_date TIMESTAMP,
    CONSTRAINT fk_orders_product FOREIGN KEY (product_id) REFERENCES product(id)
); 