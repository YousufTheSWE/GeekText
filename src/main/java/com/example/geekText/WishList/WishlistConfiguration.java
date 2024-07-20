package com.example.geekText.WishList;

import com.example.geekText.Profile.ProfileRepository;
import com.example.geekText.Profile.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

@Configuration
@Order(3)
public class WishlistConfiguration {

    @Bean
    CommandLineRunner WishlistCommandLineRunner(
            ProfileRepository profileRepository, WishlistRepository repository){
        return args -> {




            Profiles jimmy = profileRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("Profile not found"));

            Profiles michael = profileRepository.findById(2L)
                    .orElseThrow(() -> new RuntimeException("Profile not found"));





            Wishlist wishlist1 = new Wishlist(
                    "Christmas Wishlist",
                    jimmy
                    );
            Wishlist wishlist2 = new Wishlist(
                    "Birthday Wishlist",
                    michael
                    );

            repository.saveAll(
                    List.of(wishlist1, wishlist2)
            );



        };
    }
}
