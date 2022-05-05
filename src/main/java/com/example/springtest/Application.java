package com.example.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RestController
public class Application {

    private static final List<String> firstNames = List.of("Clémentine", "Julien", "Carole", "Vincent", "John", "Elsa");
    private static final List<String> lastNames = List.of("Durand", "Monin", "Eclair", "Hach", "Weber", "Grey");


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping("/person")
    public Person getRandomPerson() {
        return new Person(firstNames.get(ThreadLocalRandom.current().nextInt(0, 6)),
                lastNames.get(ThreadLocalRandom.current().nextInt(0, 6)));
    }

}
