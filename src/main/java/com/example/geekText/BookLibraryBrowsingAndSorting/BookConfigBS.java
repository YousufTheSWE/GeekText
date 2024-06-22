package com.example.geekText.BookLibraryBrowsingAndSorting;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfigBS {
    @Bean
    CommandLineRunner commandLineRunner(BookRepositoryBS repository) {
        return args -> {
            List<BookBS> books = repository.findAll();

            // Print each book to the console
            books.forEach(System.out::println);
        };
    }
}
