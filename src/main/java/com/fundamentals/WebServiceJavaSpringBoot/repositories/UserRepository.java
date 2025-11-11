package com.fundamentals.WebServiceJavaSpringBoot.repositories;

import com.fundamentals.WebServiceJavaSpringBoot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
