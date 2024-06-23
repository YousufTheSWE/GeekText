package com.example.geekText.WishList;

import com.example.geekText.BookLibrary.Book;
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
            Wishlist horror;
            horror = new Wishlist(
                    "Horror",
                    1L,
                    null);
            Wishlist stealth = new Wishlist(
                    "Slice of Life",
                    2L,
                    null);

            repository.saveAll(
                    List.of(horror, stealth)
            );


        };
    }
}
