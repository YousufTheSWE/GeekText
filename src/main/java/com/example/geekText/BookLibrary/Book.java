package com.example.geekText.BookLibrary;

import jakarta.persistence.*;

@Entity
@Table(name = "library")
public class Book {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)
        Make changes to Book class to automatically generate book_id
        whenever new book information is addede into the database
        through any CRUD operation. (It is nice to have, not mandatory,
        but we will see towards later sprints).

     */
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

    // Constructors, getters, setters, and toString()
    public Book() {}

    public Book(String authorName, String bookName, String genre, Double rating) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = rating;
    }

    public Book(Long id, String authorName, String bookName, String genre, Double rating) {
        this.id = id;
        this.authorName = authorName;
        this.bookName = bookName;
        this.genre = genre;
        this.rating = rating;
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
