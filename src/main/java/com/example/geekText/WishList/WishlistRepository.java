package com.example.geekText.WishList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends
        JpaRepository<Wishlist, Long> {

//this was added earlier today. unsure if this is how
// one would write the business logic for CRUD/REST API calls.
// For detailed list of RESTAPI options needed, can look at TeamProject-3.pdf

    @Query("SELECT w FROM Wishlist w")
    Optional<Wishlist> findWishlistById(Long id);
    // continued in service class;

}
