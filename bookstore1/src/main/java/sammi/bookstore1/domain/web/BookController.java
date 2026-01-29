package sammi.bookstore1.domain.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class BookController {

@GetMapping("/index")
public String getMethodName(@RequestParam String param) {
    return new String();
}



}
