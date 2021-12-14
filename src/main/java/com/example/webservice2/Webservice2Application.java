package com.example.webservice2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Webservice2Application {

    public static void main(String[] args) {
        SpringApplication.run(Webservice2Application.class, args);
    }

    @Bean
    public CommandLineRunner firstGroups(GroupRepository groupRepository){
        return args -> {
            groupRepository.save(new Groups("Barn", List.of("Teo", "Tobbe", "Tove")));
            groupRepository.save(new Groups("Föräldrar", List.of("Pernilla", "Fredrik")));

        };
    }
}
