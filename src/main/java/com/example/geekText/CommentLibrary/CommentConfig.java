package com.example.geekText.CommentLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CommentConfig {

    @Bean
    CommandLineRunner commentCommandLineRunner(CommentRepository repository) {
        return args -> {
//            List<Comment> comments = new ArrayList<>();
//            comments.add(new Comment(1L, 1L, "The book at 1 is nice"));
//            comments.add(new Comment(2L, 1L, "The book at 2 is nicish"));
//            comments.add(new Comment(2L, 2L, "The book at 2 is meh"));
//            comments.add(new Comment(1L, 2L, "The book at 1 is terrible"));
//            comments.add(new Comment(1L, 3L, "The book at 1 is amazing"));
//
//            repository.saveAll(comments);
        };
    }
}
