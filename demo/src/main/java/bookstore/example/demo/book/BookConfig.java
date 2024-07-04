package bookstore.example.demo.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository){
        return args ->{
            Book harryPotter = new Book(
                    "Harry Potter",
                    "J. K. Rowling",
                    "Fantasy",
                    438,
                    14.99

            );

            Book dune = new Book(
                    "Dune",
                    "Frank Herbert",
                    "Fantasy",
                    323,
                    9.99

            );

            repository.saveAll(
                    List.of(harryPotter, dune)
            );

        };
    }

}
