package com.example.geekText.Cart;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.profile.Profiles;
import jakarta.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "book_id")
    private long bookId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "quantity")
    private int quantity;

    private double price;

    public Cart(){

    }

    public Cart(Book book, long userId){
        this.bookId = book.getId();
        this.userId = userId;
        this.price = book.getPrice();
        this.quantity = 1;
    }

    public long getUserId() {
        return userId;
    }

    public long getId() {
        return id;
    }

    public void setUserId(long userId) {
        this.setUserId(userId);
    }


    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
