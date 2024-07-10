package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlist")
public class WishlistController {


    private final WishlistService wishlistService;
    //private final WishlistRepository wishlistRepository;

    @Autowired
    public WishlistController(WishlistService wishlistService, WishlistRepository wishlistRepository) {
        this.wishlistService = wishlistService;
        //this.wishlistRepository = wishlistRepository;
    }

    //Returns all wishlists
    @GetMapping
    public List<Wishlist> getWishlists(){
        return wishlistService.getWishlists();

    }

    //create a new wishlist
    @PostMapping
    public void createWishlist(@RequestBody WishlistRequest wishlistRequest){
        Wishlist wishlist = new Wishlist(wishlistRequest.getName(), wishlistRequest.getUserId(), new ArrayList<>());
        wishlistService.addWishlist(wishlist);
        }

        //Add a book to a wishlist
        @PostMapping(path = "{wishlistId}/books")
    public void addBookToWishlist(@PathVariable ("wishlistId") Long wishlistId, @RequestBody Long bookId){
        wishlistService.addBookToWishlist(wishlistId, bookId);
        }

        //Remove a book from a wishlist
        @DeleteMapping(path = "{wishlistId}/books/{bookId}")
    public void removeBookFromWishlist(@PathVariable("wishlistId") Long wishlistId, @PathVariable("bookId") Long bookId){
        wishlistService.removeBookFromWishlist(wishlistId, bookId);
        }

        //Get books in a wishlist
        @GetMapping(path = "{wishlistId}/books")
    public List<Book> getBooksInWishlist(@PathVariable("wishlistId") Long wishlistId){
        return wishlistService.getBooksInWishlist(wishlistId);
        }

        //Delete a wishlist
        @DeleteMapping(path = "{id}")
    public void deleteWishlist(@PathVariable("id") Long id){
        wishlistService.removeWishlist(id);
        }








}
