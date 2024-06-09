package com.example.geekText.RatingLibrary;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RatingConfig {

    @Bean
    CommandLineRunner ratingCommandLineRunner(RatingRepository repository) {
        return args -> {
            List<Rating> ratings = new ArrayList<>();

            repository.saveAll(ratings);
        };
    }
}
