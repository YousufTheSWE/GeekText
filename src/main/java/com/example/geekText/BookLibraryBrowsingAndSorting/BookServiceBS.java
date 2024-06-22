package com.example.geekText.BookLibraryBrowsingAndSorting;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceBS {
    private final BookRepositoryBS bookRepository;

    @Autowired
    public BookServiceBS(BookRepositoryBS bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookBS> getBooks() {
        return bookRepository.findAll();
    }

    public void addNewBook(BookBS book) {
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
        BookBS book = bookRepository.findById(id).orElseThrow(() -> new IllegalStateException("Book with Id: " + id + " does not exist."));

        if (authorName != null && !authorName.isEmpty() && !Objects.equals(book.getAuthorName(), authorName)) {
            book.setAuthorName(authorName);
        }

        if (bookName != null && !bookName.isEmpty() && !Objects.equals(book.getBookName(), bookName)) {
            Optional<BookBS> bookOptional = bookRepository.findBookByBookName(bookName);
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



