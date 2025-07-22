INSERT INTO users (username, password, role) VALUES ('admin', 'adminpass', 'ADMIN');
INSERT INTO users (username, password, role) VALUES ('staff', 'staffpass', 'STAFF');

INSERT INTO supplier (name, contact) VALUES ('Acme Corp', 'acme@example.com');
INSERT INTO supplier (name, contact) VALUES ('Global Supplies', 'global@example.com');

INSERT INTO product (name, description, supplier_id) VALUES ('Widget', 'Standard widget', 1);
INSERT INTO product (name, description, supplier_id) VALUES ('Gadget', 'Advanced gadget', 2);

INSERT INTO inventory (product_id, quantity) VALUES (1, 100);
INSERT INTO inventory (product_id, quantity) VALUES (2, 50); 