package com.example.geekText.CommentLibrary;

import com.example.geekText.BookLibrary.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    @Autowired
    private ApplicationContext appContext;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Long bookId) {
        return commentRepository.findAllByBookId(bookId);
    }

    public void addNewComment(Comment comment) {
        comment.setDatestamp(ZonedDateTime.now());
        if (comment.getBookId() == null || comment.getUserId() == null || comment.getComment() == null)
            throw new IllegalArgumentException("Needs a bookId and a userId");
        if (!bookRepository.findById(comment.getBookId()).isPresent())
            throw new IllegalStateException("book with id " + comment.getBookId() + " does not exist");
        commentRepository.save(comment);
    }
}
