package com.example.geekText.BookBrowsingAndSorting;

import com.example.geekText.BookLibraryBrowsingAndSorting.BookBS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBSService {
    private final BookBSRepository bookBSRepository;

    @Autowired
    public BookBSService(BookBSRepository bookBSRepository) {
        this.bookBSRepository = bookBSRepository;
    }

    ////////////////////////////////////////////////
    // SPECIFIC FEATURES FOR BOOK BROWSING AND SORTING!
    ////////////////////////////////////////////////

    public List<BookBS> getBooksByGenre(String genre) {
        return bookBSRepository.findByGenre(genre);
    }

    public List<BookBS> getTopSellers() {
        return bookBSRepository.findTop10ByCopiesSold();
    }
}
