package com.example.springbootfun.database;

import com.example.springbootfun.entities.Treatment;
import com.example.springbootfun.repositories.TreatmentRepository;
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

    private TreatmentRepository treatmentRepository;

    @Autowired // The @Autowired annotation allows you to skip configurations elsewhere fx in the XML file.
    public DatabaseSeeder(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<Treatment> bookings = new ArrayList<>();

        bookings.add(new Treatment("Tapening", 249, 30, 1));
        bookings.add(new Treatment("Akupunktur", 200, 25, 1));
        bookings.add(new Treatment("Håndterapi", 500, 45, 2));

        treatmentRepository.saveAll(bookings);
    }
}
