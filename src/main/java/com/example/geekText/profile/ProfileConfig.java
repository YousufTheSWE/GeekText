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
            Profiles jimmy = new Profiles(
                    "Jimmy",
                    "jimmy.john@gmail.com, ",
                            "password1"
            );
            Profiles michael = new Profiles(
                    "Michael",
                    "michael.man@gmail.com",
                    "password2"
            );
        repository.saveAll(
                List.of(jimmy,michael)
        );
        };
    }
}
