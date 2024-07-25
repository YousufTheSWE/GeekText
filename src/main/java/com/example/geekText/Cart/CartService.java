package com.example.geekText.Cart;

import com.example.geekText.BookLibrary.Book;
import com.example.geekText.BookLibrary.BookRepository;
import com.example.geekText.profile.Profiles;
import com.example.geekText.profile.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    CartRepository cartRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    ProfileRepository profileRepository;

    // get subtotal price in users cart
    public double CalcSubtotal(long userId) {
        List<Cart> bookList =  cartRepository.findCartItemsByUserId(userId);
        double bookPrice;
        Cart currBook;
        double subtotal = 0;

        for (int i = 0; i < bookList.size(); i++) {
            currBook = bookList.get(i);
            bookPrice = currBook.getPrice();
            subtotal += bookPrice;
        }
        return Double.parseDouble(String.format("%.2f", subtotal));
    }

    // add book to shopping cart
    public int addToCart(long bookId, long userId){
        Book addedBook = bookRepository.findBookById(bookId);
        if (addedBook == null) {
            return 0;
        }

        Cart newBook = new Cart(addedBook, userId);
        cartRepository.save(newBook);
        return 1;
    }

    // retrieve books in users cart
    public List<Cart> ShowCartItems(Long userId) {
        List<Cart> cartItems =  cartRepository.findCartItemsByUserId(userId);
        return cartItems;
    }

    // delete a book from users cart
    public int removeFromCart( Long bookId, Long userId){
        List<Cart> bookList = cartRepository.findCartItemsByUserId(userId);
        Cart targetBook2;

        if (bookList.size() < 1) {
            return 0;
        }

        for (int i = 0; i < bookList.size(); i++) {
            targetBook2 = bookList.get(i);

            if (targetBook2.getBookId() == bookId) {
                cartRepository.delete(targetBook2);
            }
        }
        return 1;
    }

}
