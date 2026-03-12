DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS users;

CREATE TABLE category (
    categoryid BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE book (
    id BIGINT PRIMARY KEY,
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
    id BIGINT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

INSERT INTO users (username, password, email, role) VALUES
('admin', '$2a$10$Dow1eY9G7sQq8j9YQJk4Uu4K5q8zZq9Vq3K1p1y4NQyJXkKq5W1yK', 'admin@bookstore.com', 'ADMIN'),
('user1', '$2a$10$Dow1eY9G7sQq8j9YQJk4Uu4K5q8zZq9Vq3K1p1y4NQyJXkKq5W1yK', 'user1@email.com', 'USER'),
('user2', '$2a$10$Dow1eY9G7sQq8j9YQJk4Uu4K5q8zZq9Vq3K1p1y4NQyJXkKq5W1yK', 'user2@email.com', 'USER');

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