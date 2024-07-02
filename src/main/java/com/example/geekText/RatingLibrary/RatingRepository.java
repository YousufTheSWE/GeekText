package com.example.geekText.RatingLibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT b FROM Rating b WHERE bookId = ?1 AND userId = ?2")
    List<Rating> findAllByBookIdAndUserId(Long bookId, Long userId);
}
