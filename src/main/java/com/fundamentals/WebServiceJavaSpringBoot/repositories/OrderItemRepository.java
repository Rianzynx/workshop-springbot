package com.fundamentals.WebServiceJavaSpringBoot.repositories;

import com.fundamentals.WebServiceJavaSpringBoot.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
