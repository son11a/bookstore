package sammi.bookstore1;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import sammi.bookstore1.domain.Book;
import sammi.bookstore1.domain.BookRepository;
import sammi.bookstore1.domain.CategoryRepository;
 import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest 
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTests {

 @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository crepository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("The Hobbit");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.R.R. Tolkien");
    }

    @Test
    public void createNewBook() {

    Book book = new Book("A Head Full of Ghosts", "Paul Trembley", 2015, "ISBN434345621394", 16.40, crepository.findByName("Fiction").get(0));
    repository.save(book);
    assertThat(book.getId()).isNotNull();
    }

    @Test
public void deleteBook() {
List<Book> books = repository.findByAuthor("Paul Trembley");
Book book = books.get(0);
repository.delete(book);
List<Book> newBooks = repository.findByAuthor("Paul Trembley");
assertThat(newBooks).hasSize(0);
}

}
