package com.example.geekText.WishList;

import jakarta.persistence.*;

@Entity
@Table
public class Wishlist {

    @Id
    @SequenceGenerator(
            name = "wishlist_sequence",
            sequenceName = "wishlist_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "wishlist_sequence"
    )

    private Long id;
    private String name;
    private long userID;
    private String[] books;


    public Wishlist() {
    }

    public Wishlist(Long id, String name, long userID, String[] books) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.books = books;
    }

    public Wishlist(String name, long userID, String[] books) {
        this.name = name;
        this.userID = userID;
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String[] getBooks() {
        return books;
    }

    public void setBooks(String[] books) {
        this.books = new String[]{};
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userID=" + userID +
                ", books='" + books + '\'' +
                '}';
    }


}
