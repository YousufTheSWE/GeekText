package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.BookLibrary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final BookRepository bookRepository;

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, BookRepository bookRepository) {
        this.wishlistRepository = wishlistRepository;
        this.bookRepository = bookRepository;
    }

    public List<Wishlist> getWishlists() {
        return wishlistRepository.findAll();
    }

    public void addWishlist(Wishlist wishlist){
        wishlistRepository.save(wishlist);
    }

    public void addBookToWishlist(Long wishlistID, Long bookId){
        Wishlist wishlist = wishlistRepository.findById(wishlistID)
                .orElseThrow(() -> new IllegalArgumentException("Wishlist with ID " + wishlistID + " does not exist"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book with ID "
                + bookId + " does not exist"));
        wishlist.getBooks().add(book);
        wishlistRepository.save(wishlist);
    }

    public void removeBookFromWishlist(Long wishlistID, Long bookId){
        Wishlist wishlist = wishlistRepository.findById(wishlistID).orElseThrow(() -> new IllegalArgumentException(
                "Wishlist with ID " + wishlistID + " does not exist"));
        wishlist.getBooks().removeIf(book -> book.getId().equals(bookId));
        wishlistRepository.save(wishlist);
    }

    public List<Book> getBooksInWishlist(Long wishlistID){
        Wishlist wishlist = wishlistRepository.findById(wishlistID).orElseThrow(() -> new IllegalArgumentException(
                "Wishlist with ID " + wishlistID + " does not exist"));
        return wishlist.getBooks();
    }

    public void removeWishlist(Long wishlistID){
        wishlistRepository.deleteById(wishlistID);
    }






}
