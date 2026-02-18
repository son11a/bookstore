package sammi.bookstore1.domain.web;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sammi.bookstore1.domain.Book;
import sammi.bookstore1.domain.BookRepository;
import sammi.bookstore1.domain.CategoryRepository;

import org.springframework.ui.Model;

@Controller
public class BookController {

private BookRepository repository;
private CategoryRepository crepository;
	
	public BookController(BookRepository repository, CategoryRepository crepository) {
		this.repository = repository;
		this.crepository = crepository;
	}


	@RequestMapping(value= {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

@RequestMapping(value = "/add")
public String addBook(Model model){
    model.addAttribute("book", new Book());
	model.addAttribute("categories", crepository.findAll());
    return "addbook";
}

@RequestMapping(value = "/save", method = RequestMethod.POST)
public String save(Book book){
     repository.save(book);
     return "redirect:booklist";
}

@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
public String deleteBook(@PathVariable("id") Long id, Model model) {
	repository.deleteById(id);
	return "redirect:/booklist";
}

// Edit student
@RequestMapping(value = "/edit/{id}")
public String editBook(@PathVariable("id") Long id, Model model){
	repository.findById(id).ifPresent(book -> model.addAttribute("book", book));
	model.addAttribute("catogories", crepository.findAll());
	return "editbook";
}

@RequestMapping(value="/books", method = RequestMethod.GET)
public @ResponseBody List<Book> bookListRest() {
	return (List<Book>) repository.findAll();
}

@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id){
	return repository.findById(id);
}

}
