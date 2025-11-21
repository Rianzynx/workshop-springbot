package com.fundamentals.WebServiceJavaSpringBoot.config;

import com.fundamentals.WebServiceJavaSpringBoot.entities.Order;
import com.fundamentals.WebServiceJavaSpringBoot.entities.User;
import com.fundamentals.WebServiceJavaSpringBoot.entities.enums.OrderStatus;
import com.fundamentals.WebServiceJavaSpringBoot.repositories.OrderRepository;
import com.fundamentals.WebServiceJavaSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria", "maria@gmail.com", "14998888888", "1234");
        User u2 = new User(null, "Joao", "joao@gmail.com", "14997777777", "1234");

        Order o1 = new Order(null, Instant.parse("2025-11-11T16:21:09Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-12-23T18:29:01Z"), OrderStatus.WAITING_PAYMENTE,u2);
        Order o3 = new Order(null, Instant.parse("2025-05-16T16:23:09Z"), OrderStatus.WAITING_PAYMENTE, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2, o3));
    }



}
