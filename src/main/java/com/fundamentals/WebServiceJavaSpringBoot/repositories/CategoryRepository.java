package com.fundamentals.WebServiceJavaSpringBoot.repositories;

import com.fundamentals.WebServiceJavaSpringBoot.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
