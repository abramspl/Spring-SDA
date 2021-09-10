package pl.sda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.service.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ModelAndView bookList() {
        ModelAndView modelAndView = new ModelAndView("book-list"); //nazwa widoku /html
        modelAndView.addObject("books", bookService.getAll());
        return modelAndView;
    }

    @GetMapping("/books/{bookId}")
    public ModelAndView bookDetails(@PathVariable Integer bookId) {
        ModelAndView modelAndView = new ModelAndView("book-details");
        modelAndView.addObject("book", bookService.getById(bookId));
        return modelAndView;
    }


}
