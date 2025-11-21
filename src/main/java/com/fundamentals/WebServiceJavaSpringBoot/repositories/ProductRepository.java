package com.fundamentals.WebServiceJavaSpringBoot.repositories;

import com.fundamentals.WebServiceJavaSpringBoot.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
