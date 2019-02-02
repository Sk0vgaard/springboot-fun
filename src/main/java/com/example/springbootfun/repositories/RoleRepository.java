package com.example.springbootfun.repositories;

import com.example.springbootfun.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
