package com.example.geekText.bookBrowsingAndSorting;

import com.example.geekText.library.Book;
import com.example.geekText.library.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "geekText")
public class BookBSController {
    private final BookBSService bookBSService;

    @Autowired
    public BookBSController(BookBSService bookBSService) {
            this.bookBSService = bookBSService;
        }

        ////////////////////////////////////////////////
        // SPECIFIC FEATURES FOR BOOK BROWSING AND SORTING!
        ////////////////////////////////////////////////

    @GetMapping(path = "books/genre")
    public List<Book> getBooksByGenre(@RequestParam String genre) {
        return bookBSService.getBooksByGenre(genre);
    }
}
