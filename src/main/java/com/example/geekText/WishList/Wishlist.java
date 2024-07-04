package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Wishlist {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private long userID;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "wishlist_id")
    private List<Book> books;






    public Wishlist() {
    }

    public Wishlist(Long id, String name, long userID, List<Book> books) {
        this.id = id;
        this.name = name;
        this.userID = userID;
        this.books = books;
    }

    public Wishlist(String name, long userID, List<Book> books) {
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
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
