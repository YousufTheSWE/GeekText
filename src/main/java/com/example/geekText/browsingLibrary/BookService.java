package com.example.geekText.browsingLibrary;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {
    private final com.example.geekText.browsingLibrary.BookRepository bookRepository;

    @Autowired
    public BookService(com.example.geekText.browsingLibrary.BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);

        if (!exists) {
            throw new IllegalStateException("Book with id: " + bookId + " does not exist.");
        }

        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long id, String authorName, String bookName, String genre, Double rating, Integer copiesSold) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book with Id: " + id + " does not exist."));

        if (authorName != null && !authorName.isEmpty() && !Objects.equals(book.getAuthorName(), authorName)) {
            book.setAuthorName(authorName);
        }

        if (bookName != null && !bookName.isEmpty() && !Objects.equals(book.getBookName(), bookName)) {
            Optional<Book> bookOptional = bookRepository.findBookByBookName(bookName);
            if (bookOptional.isPresent()) {
                throw new IllegalStateException("This book name already exists.");
            }
            book.setBookName(bookName);
        }

        if (genre != null && !genre.isEmpty() && !Objects.equals(book.getGenre(), genre)) {
            book.setGenre(genre);
        }

        if (rating != null && rating >= 0 && !Objects.equals(book.getRating(), rating)) {
            book.setRating(rating);
        }

        if (copiesSold != null && copiesSold >= 0 && !Objects.equals(book.getCopiesSold(), copiesSold)) {
            book.setCopiesSold(copiesSold);
        }
    }
}



