package com.example.springbootfun.repositories;

import com.example.springbootfun.entities.Booking;
import com.example.springbootfun.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
}
