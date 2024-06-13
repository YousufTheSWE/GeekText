package com.example.geekText.WishList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WishlistService {
    @Autowired
    public WishlistService(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    private final WishlistRepository wishlistRepository;



    public List<Wishlist> getWishlist(){
        return wishlistRepository.findAll();
    }
}
