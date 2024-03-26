package com.example.spring.repositories;

import com.example.spring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional <User> findByEmail (String email);
}
