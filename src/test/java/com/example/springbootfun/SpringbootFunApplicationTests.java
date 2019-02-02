package com.example.springbootfun;

import com.example.springbootfun.controllers.TreatmentController;
import com.example.springbootfun.entities.Booking;
import com.example.springbootfun.entities.Treatment;
import com.example.springbootfun.entities.User;
import com.example.springbootfun.services.BookingService;
import com.example.springbootfun.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootFunApplicationTests {

    @Autowired
    private UserService userService;
    @Autowired
    private BookingService bookingService;
    // @Autowired
    // private TreatmentController treatmentController;

    @Before
    public void initDb() {
        {
            User newUser = new User(
                    "Rikke",
                    "Baden",
                    "Rikke Baden",
                    "123456",
                    "Rikke_baden@gmail.com",
                    "87654321");
            userService.createUser(newUser);
        }
        {
            User newUser = new User(
                    "Mathias",
                    "Skovgaard",
                    "Mathias Skovgaard",
                    "654321",
                    "MathiasSkovgaardRasmussen@gmail.com",
                    "12345678");
            userService.createUser(newUser);
        }

        Booking userBooking = new Booking("18:01:33, 02/02/2019", "Håndterapi", "12/02/2019, 16:00", "Mange smerter.");
        User user = userService.findUserByEmail("Rikke_baden@gmail.com");

        bookingService.addBooking(userBooking, user);
    }

    @Test
    public void testUser() {
        User user = userService.findUserByEmail("MathiasSkovgaardRasmussen@gmail.com");
        assertNotNull(user);

        User admin = userService.findUserByEmail("MathiasSkovgaardRasmussen@gmail.com");
        assertEquals(admin.getEmail(), "MathiasSkovgaardRasmussen@gmail.com");
    }

    @Test
    public void testFullName() {
        User user = userService.findUserByEmail("Rikke_baden@gmail.com");
        assertNotNull(user);

        assertEquals(user.getFullName(), "Rikke Baden");
    }

    @Test
    public void testBooking() {
        User user = userService.findUserByEmail("Rikke_baden@gmail.com");
        List<Booking> booking = bookingService.findUserBooking(user);

        assertNotNull(booking);
    }

}

