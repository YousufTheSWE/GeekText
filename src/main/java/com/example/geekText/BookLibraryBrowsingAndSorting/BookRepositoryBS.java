package com.example.geekText.BookLibraryBrowsingAndSorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepositoryBS extends JpaRepository<BookBS, Long> {
    @Query("SELECT b FROM Book b WHERE b.bookName = ?1")
    Optional<BookBS> findBookByBookName(String bookName);
}
