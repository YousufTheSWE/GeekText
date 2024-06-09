package com.example.geekText.CommentLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
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
        comment.setDatestamp(ZonedDateTime.now());
        if (comment.getBookId() == null || comment.getUserId() == null)
            throw new IllegalArgumentException("Needs a bookId and a userId");
        if (comment.getComment() == null) comment.setComment("");
        commentRepository.save(comment);
    }
}
