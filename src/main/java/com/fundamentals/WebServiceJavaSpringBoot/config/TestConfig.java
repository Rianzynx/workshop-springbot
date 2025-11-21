package com.fundamentals.WebServiceJavaSpringBoot.config;

import com.fundamentals.WebServiceJavaSpringBoot.entities.*;
import com.fundamentals.WebServiceJavaSpringBoot.entities.enums.OrderStatus;
import com.fundamentals.WebServiceJavaSpringBoot.repositories.*;
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

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Smartphone Samsung Galaxy S23",
                "Smartphone com câmera tripla, bateria de longa duração e tela AMOLED.",
                3999.00, "");

        Product p2 = new Product(null, "Fone de Ouvido JBL Tune 510BT",
                "Fone Bluetooth com graves potentes e bateria de até 40 horas.",
                249.99, "");


        Product p3 = new Product(null, "Notebook Dell Inspiron 15",
                "Notebook com processador Intel i5, 8GB RAM e SSD de 256GB.",
                2899.90, "");

        Product p4 = new Product(null, "Monitor LG UltraWide 29'",
                "Monitor 29'' ultrawide com resolução Full HD e proporção 21:9.",
                1499.00, "");

        Product p5 = new Product(null, "Clean Code",
                "Livro clássico sobre boas práticas de programação e código limpo.",
                120.00, "");



        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));


        User u1 = new User(null, "Maria", "maria@gmail.com", "14998888888", "1234");
        User u2 = new User(null, "Joao", "joao@gmail.com", "14997777777", "1234");

        Order o1 = new Order(null, Instant.parse("2025-11-11T16:21:09Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2025-12-23T18:29:01Z"), OrderStatus.WAITING_PAYMENTE,u2);
        Order o3 = new Order(null, Instant.parse("2025-05-16T16:23:09Z"), OrderStatus.WAITING_PAYMENTE, u1);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2, o3));

        OrderItem oi1 = new OrderItem(o1,p1, 2, p1.getPrice());
        OrderItem oi2 = new OrderItem(o1,p3, 1, p4.getPrice());
        OrderItem oi3 = new OrderItem(o2,p3, 2, p1.getPrice());
        OrderItem oi4 = new OrderItem(o3,p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
    }



}
