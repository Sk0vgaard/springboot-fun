package com.example.springbootfun.controllers;

import com.example.springbootfun.models.TreatmentBooking;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {
    private List<TreatmentBooking> bookings;

    public BookingController() {
        bookings = new ArrayList<>();

        bookings.add(new TreatmentBooking("Akupunktur", 200, 25, 1));
        bookings.add(new TreatmentBooking("Håndterapi", 500, 45, 2));
        bookings.add(new TreatmentBooking("Tapening", 249, 30, 1));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TreatmentBooking> getAll() {
        return bookings;
    }

    /*
    Filter to show prices equals or below fx 300.
     */
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<TreatmentBooking> getAffordable(@PathVariable double price) {
        return bookings.stream().filter(all -> all.getPriceForTreatment() <= price)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<TreatmentBooking> create(@RequestBody TreatmentBooking treatmentBooking) {
        bookings.add(treatmentBooking);

        return bookings;
    }
}
