package com.example.geekText.BookBrowsingAndSorting;

import com.example.geekText.BookLibraryBrowsingAndSorting.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBSRepository extends JpaRepository<Book, Long> {

    ////////////////////////////////////////////////
    // SPECIFIC FEATURES FOR BOOK BROWSING AND SORTING!
    ////////////////////////////////////////////////

    List<Book> findByGenre(String genre);

    @Query("SELECT b FROM Book b ORDER BY b.copiesSold DESC")
    List<Book> findTop10ByCopiesSold();

}
