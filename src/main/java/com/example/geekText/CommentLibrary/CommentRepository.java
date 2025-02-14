package com.example.geekText.CommentLibrary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT b FROM Comment b WHERE bookId = ?1")
    List<Comment> findAllByBookId(Long bookId);
}
