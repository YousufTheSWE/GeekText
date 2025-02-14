package com.example.geekText.BookLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAllByOrderByIdAsc();
    }

    public Double getAverageRatingForBook(Long bookId) {
        Book aBook = bookRepository.findById(bookId).orElseThrow(()
                -> new IllegalStateException("book with id " + bookId + " does not exist"));
        return aBook.getRating();
    }
}
