package com.example.geekText.WishList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class WishlistConfiguration {

    @Bean
    CommandLineRunner commandLineRunner2(
            WishlistRepository repository){
        return args -> {
            String[] myArray = Arrays.asList("the").toArray(new String[0]);
            Wishlist horror = new Wishlist(
                    "Jaws",
                    1L,
                    myArray );
            Wishlist stealth = new Wishlist(
                    "Splinter Cell",
                    1L,
                    myArray);

            repository.saveAll(
                    List.of(horror, stealth)
            );


        };
    }
}
