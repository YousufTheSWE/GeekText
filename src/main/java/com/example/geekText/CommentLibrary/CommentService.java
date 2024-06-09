package com.example.geekText.CommentLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Long bookId) {
        return commentRepository.findAllByBookId(bookId);
    }

    public void addNewComment(Comment comment) {
        commentRepository.save(comment);
    }
}
