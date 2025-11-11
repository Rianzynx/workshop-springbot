package com.fundamentals.WebServiceJavaSpringBoot.repositories;

import com.fundamentals.WebServiceJavaSpringBoot.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
