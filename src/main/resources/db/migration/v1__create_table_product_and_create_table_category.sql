
CREATE TABLE Category (
    idCategory UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE Product (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price DOUBLE NOT NULL,
    description TEXT,
    category_id UUID,
    branch VARCHAR(255),
    quantity INT NOT NULL,
    is_available BOOLEAN NOT NULL,
    FOREIGN KEY (category_id) REFERENCES Category(idCategory)
);
