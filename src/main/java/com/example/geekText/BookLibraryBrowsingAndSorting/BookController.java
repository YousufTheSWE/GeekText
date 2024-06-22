package com.example.geekText.BookLibraryBrowsingAndSorting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "geekText/browsing")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(path = "add")
    public void registerNewBooks(@RequestBody Book book) {
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{id}")
    public void updateBook(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String authorName,
            @RequestParam(required = false) String bookName,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double rating,
            @RequestParam(required = false) Integer copiesSold) {
        bookService.updateBook(id, authorName, bookName, genre, rating, copiesSold);
    }
}
