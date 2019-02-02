package com.example.springbootfun.repositories;

import com.example.springbootfun.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
