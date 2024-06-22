package com.example.geekText.BookBrowsingAndSorting;

import com.example.geekText.BookLibraryBrowsingAndSorting.BookBS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBSRepository extends JpaRepository<BookBS, Long> {

    ////////////////////////////////////////////////
    // SPECIFIC FEATURES FOR BOOK BROWSING AND SORTING!
    ////////////////////////////////////////////////

    List<BookBS> findByGenre(String genre);

    @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<BookBS> findTop10ByCopiesSold();

}
