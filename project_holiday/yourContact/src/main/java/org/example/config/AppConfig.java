package org.example.config;

import org.example.data.repositories.UserRepository;
import org.example.data.repositories.UserRepositoryImpl;
import org.example.services.UserServiceJson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRepository userRepository() {
        UserRepository repository = new UserRepositoryImpl();
        return repository;
    }

    @Bean
    public UserServiceJson userServiceJson() {
        UserRepository repository = userRepository();
        UserServiceJson service = new UserServiceJson(repository);
        return service;
    }
}
