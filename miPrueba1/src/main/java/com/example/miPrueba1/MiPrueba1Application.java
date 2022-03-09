package com.example.miPrueba1;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.miPrueba1.entities.User;
import com.example.miPrueba1.repository.UserRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MiPrueba1Application {

	public static void main(String[] args) {
		SpringApplication.run(MiPrueba1Application.class, args);
	}
	
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                User user = new User(name, name.toLowerCase() + "@domain.com");
                userRepository.save(user);
            });
            userRepository.findAll().forEach(System.out::println);
        };
    }

}
