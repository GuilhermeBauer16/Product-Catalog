-- USE product_catalog;

CREATE TABLE IF NOT EXISTS Category (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Product (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description TEXT,
    category_id VARCHAR(36),
    branch VARCHAR(255),
    quantity INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Category(id)
);
