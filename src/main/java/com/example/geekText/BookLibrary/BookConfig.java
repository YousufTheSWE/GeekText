package com.example.geekText.BookLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository repository) {
        return args -> {
            // Either BookName, AuthorName, Genre or
            // BookName, AuthorName, Genre, rating, number of reviews
//            List<Book> books = new ArrayList<>();
//            books.add(new Book(
//                    "Guide: How to find diamonds in Minecraft",
//                    "Mojang",
//                    "Gaming"
//            ));
//            books.add(new Book(
//                    "Crime and Punishment",
//                    "Fyodor Dostoevsky",
//                    "Crime",
//                    4.27,
//                    915943L
//            ));
//            books.add(new Book(
//                    "James",
//                    "Percival Everett",
//                    "Historical",
//                    4.57,
//                    8L
//            ));
//            books.add(new Book(
//                    "Wandering Stars",
//                    "Tommy Orange",
//                    "Historical Fiction"
//            ));
//            books.add(new Book(
//                    "The Book of Doors",
//                    "Gareth Brown",
//                    "Fantasy"
//            ));
//            books.add(new Book(
//                    "When the Moon Hatched",
//                    "Sarah A. Parker",
//                    "Romance"
//            ));
//
//            repository.saveAll(books);
        };
    }
}
