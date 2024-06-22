package com.example.geekText.bookBrowsingAndSorting;

import com.example.geekText.browsingLibrary.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "geekText/browsing")
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

    @GetMapping(path = "books/top-sellers")
    public List<Book> getTopSellers() {
        return bookBSService.getTopSellers();
    }
}
