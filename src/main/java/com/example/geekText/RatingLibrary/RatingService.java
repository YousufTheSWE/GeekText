package com.example.geekText.RatingLibrary;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.BookLibrary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class RatingService {
    private final RatingRepository ratingRepository;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public void addNewRating(Rating rating) {
        rating.setDatestamp(ZonedDateTime.now());
        if (rating.getBookId() == null || rating.getUserId() == null)
            throw new IllegalArgumentException("Needs a bookId and a userId");
        if (rating.getRating() < 1 || rating.getRating() > 5)
            throw new IllegalArgumentException("Needs a rating between 1 and 5");

        Book aBook = bookRepository.findById(rating.getBookId()).orElseThrow(()
                -> new IllegalStateException("book with id " + rating.getBookId() + " does not exist"));
        aBook.addRating(rating.getRating());

        ratingRepository.save(rating);
    }
}
