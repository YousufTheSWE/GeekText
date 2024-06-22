package com.example.geekText.BookBrowsingAndSorting;

import com.example.geekText.BookLibraryBrowsingAndSorting.BookBS;
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
    public List<BookBS> getBooksByGenre(@RequestParam String genre) {
        return bookBSService.getBooksByGenre(genre);
    }

    @GetMapping(path = "books/top-sellers")
    public List<BookBS> getTopSellers() {
        return bookBSService.getTopSellers();
    }
}
