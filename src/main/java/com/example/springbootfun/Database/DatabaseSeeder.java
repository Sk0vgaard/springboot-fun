package com.example.springbootfun.Database;

import com.example.springbootfun.models.TreatmentBooking;
import com.example.springbootfun.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// For seeding our database with mock.
@Component
@Order(1) // Can be used if there is more than one CommandLineRunner, and if one has to run before another.
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired // The @Autowired annotation allows you to skip configurations elsewhere fx in the XML file.
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<TreatmentBooking> bookings = new ArrayList<>();

        bookings.add(new TreatmentBooking("Akupunktur", 200, 25, 1));
        bookings.add(new TreatmentBooking("Håndterapi", 500, 45, 2));
        bookings.add(new TreatmentBooking("Tapening", 249, 30, 1));

        bookingRepository.saveAll(bookings);
    }
}
