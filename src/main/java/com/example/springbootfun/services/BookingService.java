package com.example.springbootfun.services;

import com.example.springbootfun.entities.Booking;
import com.example.springbootfun.entities.User;
import com.example.springbootfun.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public void addBooking(Booking booking, User user) {
        booking.setUser(user);
        bookingRepository.save(booking);
    }

    public List<Booking> findUserBooking(User user) {
        return bookingRepository.findByUser(user);
    }

}
