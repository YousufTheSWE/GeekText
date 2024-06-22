package com.example.geekText.Cart;

import com.example.geekText.BookLibrary.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService cartService;

    // given user ID, calculate subtotal in cart
    @GetMapping("/{userId}/cart/subtotal")
    public double Subtotal(@PathVariable("userId") long userId) {
        return cartService.CalcSubtotal(userId);
    }

    // add book to user's shopping cart
    @PostMapping("cart/addBook")
    public ResponseEntity<String> addBookToCart(@RequestParam("bookId") long bookId, @RequestParam("userId") long userId){
        try {
            int result = cartService.addToCart(bookId, userId); // Pass userId appropriately
            if (result == 1) {
                return new ResponseEntity<>("Book added to cart", HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // given user ID, return all books in cart
    @GetMapping("/{userId}/cart/books")
    public List<Cart> showBooksInCart(@PathVariable("userId") long userId){
        return cartService.ShowCartItems(userId);
    }

    // delete a book from user's cart
    @DeleteMapping("/{userId}/cart/removeBook/{bookId}")
    public String RemoveBook(@PathVariable("userId") long userId, @PathVariable("bookId") long bookId) {
        if (cartService.removeFromCart(bookId,userId) > 0) {
            return "[@DeleteMapping] Book ID: " + bookId + " removed from User ID: " + userId + " shopping cart.";
        } else {
            return "Error - [BookID: " + bookId + "] not found in [UserID: " + userId + "] cart.";
        }
    }
}


