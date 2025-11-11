package com.fundamentals.WebServiceJavaSpringBoot.config;

import com.fundamentals.WebServiceJavaSpringBoot.entities.User;
import com.fundamentals.WebServiceJavaSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "14998888888", "1234");
        User u2 = new User(null, "Joao", "joao@gmail.com", "14997777777", "1234");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }

}
