package com.example.demo;

import com.example.demo.model.Content;
import com.example.demo.model.Status;
import com.example.demo.model.Type;
import com.example.demo.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ContentRepository repository) {
        return args -> {
            // load data in DB
            Content c = new Content(
                    null,
                    "My First Blog Post",
                    Status.IDEA,
                    Type.ARTICLE,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    "");

            repository.save(c);

        };
    }
}
