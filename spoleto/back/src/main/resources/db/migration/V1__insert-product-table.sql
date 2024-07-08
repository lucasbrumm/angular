CREATE TABLE IF NOT EXISTS product (
                         id BIGSERIAL PRIMARY KEY,
                         name VARCHAR(255) NOT NULL UNIQUE,
                         price VARCHAR(255),
                         dtype varchar(31) NOT NULL
);