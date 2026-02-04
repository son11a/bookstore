package sammi.bookstore1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import sammi.bookstore1.domain.Book;
import sammi.bookstore1.domain.BookRepository;


@SpringBootApplication
public class Bookstore1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}

@Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book(
                "Clean Code",
                "Robert C. Martin",
                2008,
                "9780132350884",
                45.99
            ));

            repository.save(new Book(
                "Effective Java",
                "Joshua Bloch",
                2018,
                "9780134685991",
                55.00
            ));

            repository.save(new Book(
                "Spring in Action",
                "Craig Walls",
                2022,
                "9781617297571",
                49.99
            ));
        };
    }


}
