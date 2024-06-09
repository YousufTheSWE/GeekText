package com.example.geekText.BookLibrary;

import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_sequence"
    )
    private Long id;

    @Column(name = "author_name") // Use the exact column name as in the database
    private String authorName;

    @Column(name = "book_name") // Use the exact column name as in the database
    private String bookName;

    @Column(name = "genre") // Use the exact column name as in the database
    private String genre;

    @Column(name = "rating") // Use the exact column name as in the database
    private Double rating;

    @Column(name = "number_of_reviews")
    private Long numberOfReviews;

    // Constructors, getters, setters, and toString()
    public Book() {}

    public Book(String bookName, String authorName, String genre) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = null;
        this.numberOfReviews = 0L;
    }

    public Book(String bookName, String authorName, String genre,
                Double rating, Long numberOfReviews) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = rating;
        this.numberOfReviews = numberOfReviews;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Double getRating() {
        return rating;
    }

    public void addRating(Double newRating) {
        if (rating != null && numberOfReviews > 0)
            this.rating = (rating * numberOfReviews + newRating) / (numberOfReviews + 1);
        else {
            this.rating = newRating;
            this.numberOfReviews = 0L;
        }
        this.numberOfReviews++;
    }

    public void removeRating(Double oldRating) {
        if (numberOfReviews < 2 || rating == null) {
            this.rating = null;
            this.numberOfReviews = 1L;
        } else
            this.rating = (numberOfReviews * rating - oldRating) / (numberOfReviews - 1);

        numberOfReviews--;
    }

    public Long getNumberOfReviews(){
        return this.numberOfReviews;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setNumberOfReviews(Long numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
    
}
