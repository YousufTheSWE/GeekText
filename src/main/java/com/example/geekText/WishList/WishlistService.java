package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.BookLibrary.BookRepository;
import com.example.geekText.profile.ProfileRepository;
import com.example.geekText.profile.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

 @Autowired
    private WishlistRepository wishlistRepository;

 @Autowired
    private BookRepository bookRepository;

 public void createWishlist(String name, Profiles user){
     //check if user already has 3 Wishlists created
     List<Wishlist> existingWishlists = wishlistRepository.findAllByUserId(user.getId());
     if(existingWishlists.size() >= 3){
         throw new IllegalArgumentException("User can only have 3 Wishlists.");
     }
     // create and save the new wishlist
     Wishlist wishlist = new Wishlist(name, user);
     wishlistRepository.save(wishlist);
 }

 public void addBookToWishlist(Long wishlistId, Long bookId){

     // check if wishlist exists
     Wishlist wishlist = wishlistRepository.findById(wishlistId)
             .orElseThrow(() -> new IllegalArgumentException("Wishlist with id" + wishlistId + " does not exist."));

     // check if book is in book library
     Book book = bookRepository.findById(bookId)
             .orElseThrow(() -> new IllegalArgumentException("Book with id" + bookId + " does not exist."));
     // check if book is in wishlist
     List<Book> books = wishlist.getBooks();
     if (books.contains(book)){
         throw new IllegalArgumentException("Book already in the wishlist. Please choose another one");
     }

     books.add(book);
     wishlist.setBooks(books);
     wishlistRepository.save(wishlist);
 }

 public void removeBookFromWishlist(Long wishlistId, Long bookId) {
     Wishlist wishlist = wishlistRepository.findById(wishlistId)
             .orElseThrow(() -> new IllegalArgumentException("Wishlist with id" + wishlistId + " does not exist."));

     Book book = bookRepository.findById(bookId)
             .orElseThrow(() -> new IllegalArgumentException("Book with id" + bookId + " does not exist."));


     List<Book> books = wishlist.getBooks();
     if (!books.contains(book)) {
         throw new IllegalArgumentException("Book doesn't exist in the wishlist");
     }

     books.remove(book);
     wishlist.setBooks(books);
     wishlistRepository.save(wishlist);

 }

 public List<Book> listBooksInWishlist(Long wishlistId){
     Wishlist wishlist = wishlistRepository.findById(wishlistId)
             .orElseThrow(() -> new IllegalArgumentException("Wishlist with id" + wishlistId + " does not exist."));
     return wishlist.getBooks();
 }

}
