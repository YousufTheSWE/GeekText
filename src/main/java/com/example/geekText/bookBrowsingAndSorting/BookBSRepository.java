package com.example.geekText.bookBrowsingAndSorting;

import com.example.geekText.library.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookBSRepository extends JpaRepository<Book, Long> {

    ////////////////////////////////////////////////
    // SPECIFIC FEATURES FOR BOOK BROWSING AND SORTING!
    ////////////////////////////////////////////////

    List<Book> findByGenre(String genre);

}
