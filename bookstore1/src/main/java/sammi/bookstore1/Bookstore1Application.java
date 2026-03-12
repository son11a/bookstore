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

}
