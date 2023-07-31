CREATE TABLE ecommerce_order (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    order_id VARCHAR(255) NOT NULL,
    customer_id VARCHAR(255) NOT NULL,
    items VARCHAR(1000) NOT NULL,
    status VARCHAR(50) NOT NULL
);