package sammi.bookstore1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import sammi.bookstore1.domain.Book;
import sammi.bookstore1.domain.BookRepository;
import sammi.bookstore1.domain.CategoryRepository;
import sammi.bookstore1.domain.Category;


@SpringBootApplication
public class Bookstore1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}

@Bean
    public CommandLineRunner demo(BookRepository bookRepository,
                                   CategoryRepository categoryRepository) {
        return (args) -> {
           
Category fiction = new Category("Fiction");
            Category technology = new Category("Technology");
            Category history = new Category("History");

            categoryRepository.save(fiction);
            categoryRepository.save(technology);
            categoryRepository.save(history);

            // create books
            Book book1 = new Book(
                "1984",
                "George Orwell",
                1949,
                "9780451524935",
                12.99,
                fiction
            );

            Book book2 = new Book(
                "Clean Code",
                "Robert C. Martin",
                2008,
                "9780132350884",
                39.99,
                technology
            );

            Book book3 = new Book(
                "Sapiens",
                "Yuval Noah Harari",
                2011,
                "9780062316097",
                19.99,
                history
            );

            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);

        };
    }


}
