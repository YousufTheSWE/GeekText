package com.example.geekText.CommentLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(path = "{id}")
    public List<Comment> getComments(@PathVariable("id") Long bookId) {
        return commentService.getComments(bookId);
    }

    @PostMapping
    public void registerNewComment(@RequestBody Comment comment) {
        commentService.addNewComment(comment);
    }
}
