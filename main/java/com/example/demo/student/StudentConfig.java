package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student jimmy = new Student(

                    "Jimmy",
                    "jimmy.john@gmail.com",
                    LocalDate.of(2000, AUGUST, 6)

            );
            Student michael = new Student(

                    "Michael",
                    "michael.man@gmail.com",
                    LocalDate.of(2002, AUGUST, 6)

            );
        repository.saveAll(
                List.of(jimmy,michael)
        );
        };
    }
}
