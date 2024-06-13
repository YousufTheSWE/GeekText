package com.example.geekText.WishList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends
        JpaRepository<Wishlist, Long> {

}
