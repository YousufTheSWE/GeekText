package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.Profile.Profiles;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Wishlist")
public class Wishlist {


    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(
            name = "Wishlist_sequence",
            sequenceName = "Wishlist_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Wishlist_sequence"
    )
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Profiles user;

    @ManyToMany()
    @JoinTable(
            name = "wishlist_id",
            joinColumns = @JoinColumn(name = "wishlist_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;



    public Wishlist() {}


    public Wishlist(String name, Profiles user){
        this.name = name;
        this.user = user;
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

    public Profiles getUser() {
        return user;
    }

    public void setUserID(Profiles user) {this.user = user;}

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
                ", userID=" + user +
                ", books='" + books + '\'' +
                '}';
    }


}
