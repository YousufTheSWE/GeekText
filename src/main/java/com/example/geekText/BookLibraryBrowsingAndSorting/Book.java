package com.example.geekText.BookLibraryBrowsingAndSorting;

import jakarta.persistence.*;

@Entity
@Table(name = "library")
public class Book {
    @Id
    @Column(name = "book_id") // Use the exact column name as in the database
    private Long id;

    @Column(name = "author_name") // Use the exact column name as in the database
    private String authorName;

    @Column(name = "book_name") // Use the exact column name as in the database
    private String bookName;

    @Column(name = "genre") // Use the exact column name as in the database
    private String genre;

    @Column(name = "rating") // Use the exact column name as in the database
    private Double rating;

    @Column(name = "copies_sold")
    private Integer copiesSold;

    // Constructors, getters, setters, and toString()
    public Book() {}

    public Book(String authorName, String bookName, String genre, Double rating, Integer copiesSold) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = rating;
        this.copiesSold = copiesSold;
    }

    public Book(Long id, String authorName, String bookName, String genre, Double rating, Integer copiesSold) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = rating;
        this.copiesSold = copiesSold;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getCopiesSold() {
        return copiesSold;
    }

    public void setCopiesSold(Integer copiesSold) {
        this.copiesSold = copiesSold;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", copiesSold=" + copiesSold +
                '}';
    }
}
