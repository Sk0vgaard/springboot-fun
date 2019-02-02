package com.example.springbootfun.services;

import com.example.springbootfun.entities.Role;
import com.example.springbootfun.entities.User;
import com.example.springbootfun.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(User user) {
        encodingPassword(user);

        // Sets the role of the new created user.
        Role userRole = new Role("USER");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
    }

    public void createAdmin(User user) {
        encodingPassword(user);

        // Sets the role of the new created user.
        Role userRole = new Role("ADMIN");
        List<Role> roles = new ArrayList<>();
        roles.add(userRole);
        user.setRoles(roles);

        userRepository.save(user);
    }

    private void encodingPassword(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
    }

    public User findUserByEmail(String email) {

        return userRepository.findById(email).orElse(null);
    }
}
