package com.example.geekText.CommentLibrary;

import jakarta.persistence.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @SequenceGenerator(
            name = "comment_sequence",
            sequenceName = "comment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_sequence"
    )
    private Long id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "datestamp")
    private ZonedDateTime datestamp;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    public Comment(){}

    public Comment(Long bookId, Long userId, String comment){
        this.bookId = bookId;
        this.userId = userId;
        this.comment = comment;
        this.datestamp = ZonedDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        return "Comment{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", datestamp=" + datestamp +
                ", userId=" + userId +
                ", bookId=" + bookId +
                '}';
    }
}