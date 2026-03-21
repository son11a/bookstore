DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;

CREATE TABLE category (
    categoryid BIGSERIAL PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    publication_year INTEGER,
    isbn VARCHAR(50),
    price DOUBLE PRECISION,
    categoryid BIGINT,
    CONSTRAINT fk_book_category
        FOREIGN KEY (categoryid)
        REFERENCES category(categoryid)
);

CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, email, role) VALUES
('admin', '$2a$10$cDZgyF4xaPMmmoRW3OVcmuf.8o2YSx8.M7CeRKqi.1PVw.t3E8uEC', 'admin@bookstore.com', 'ROLE_ADMIN'),
('user', '$2a$10$1DTvwpXVBArGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou', 'user1@email.com', 'ROLE_USER');


INSERT INTO category (name) VALUES
('Fiction'),
('Science'),
('Programming'),
('History'),
('Fantasy');

INSERT INTO book (title, author, publication_year, isbn, price, categoryid) VALUES
('The Hobbit', 'J.R.R. Tolkien', 1937, '9780547928227', 12.99, 5),
('Clean Code', 'Robert C. Martin', 2008, '9780132350884', 39.99, 3),
('A Brief History of Time', 'Stephen Hawking', 1988, '9780553380163', 15.50, 2),
('1984', 'George Orwell', 1949, '9780451524935', 10.99, 1),
('Sapiens', 'Yuval Noah Harari', 2011, '9780062316097', 18.99, 4);