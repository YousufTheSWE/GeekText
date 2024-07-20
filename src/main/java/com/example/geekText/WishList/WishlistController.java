package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.Profile.ProfileRepository;
import com.example.geekText.Profile.Profiles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/wishlists")
public class WishlistController {

@Autowired
private WishlistService wishlistService;

@Autowired
private ProfileRepository profileRepository;


// POST mapping creating wishlist
@PostMapping
    public void createWishlist(@RequestParam String name, @RequestParam Long userID){
    Profiles user = profileRepository.findById(userID)
            .orElseThrow(() -> new IllegalArgumentException("User with ID " + userID + " does not exist."));
    wishlistService.createWishlist(name, user);
}
// POST mapping adding book to existing wishlist
@PostMapping( "/{wishlistID}/books")
    public void addBookToWishlist(@PathVariable Long wishlistID, @RequestParam Long bookId){
    wishlistService.addBookToWishlist(wishlistID, bookId);
}
// DELETE mapping removing book from wishlist
@DeleteMapping("/{wishlistID}/books/{bookId}")
    public void removeBookFromWishlist(@PathVariable Long wishlistID, @PathVariable Long bookId){
    wishlistService.removeBookFromWishlist(wishlistID, bookId);
}
// GET mapping lists books in wishlist
@GetMapping("/{wishlistID}/books")
    public List<Book> listBooksInWishlist(@PathVariable Long wishlistID){
    return wishlistService.listBooksInWishlist(wishlistID);
}









}
