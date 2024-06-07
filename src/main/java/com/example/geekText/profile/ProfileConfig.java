package com.example.geekText.profile;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class ProfileConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProfileRepository repository){
        return args -> {
            Profile jimmy = new Profile(
                    "Jimmy",
                    "jimmy.john@gmail.com"
            );
            Profile michael = new Profile(
                    "Michael",
                    "michael.man@gmail.com"
            );
        repository.saveAll(
                List.of(jimmy,michael)
        );
        };
    }
}
