package com.example.geekText.RatingLibrary;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "Rating")
public class Rating {
    @Id
    @SequenceGenerator(
            name = "rating_sequence",
            sequenceName = "rating_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rating_sequence"
    )
    private Long id;

    @Column(name = "rating")
    private int rating; // From 1 to 5

    @Column(name = "datestamp")
    private ZonedDateTime datestamp;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    public Rating() {}

    public Rating(Long bookId, Long userId, int rating) {
        this.bookId = bookId;
        this.userId = userId;
        this.rating = rating;
        this.datestamp = ZonedDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ZonedDateTime getDatestamp() {
        return datestamp;
    }

    public void setDatestamp(ZonedDateTime datestamp) {
        this.datestamp = datestamp;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating=" + rating +
                ", datestamp=" + datestamp +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}
