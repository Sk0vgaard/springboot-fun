package com.example.springbootfun.controllers;

import com.example.springbootfun.models.TreatmentBooking;
import com.example.springbootfun.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<TreatmentBooking> getAll() {
        return bookingRepository.findAll();
    }


    /* Filter to show prices equals or below fx 300. */
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    public List<TreatmentBooking> getAffordable(@PathVariable double price) {
        return bookingRepository.findByPriceForTreatmentLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<TreatmentBooking> create(@RequestBody TreatmentBooking treatmentBooking) {
        bookingRepository.save(treatmentBooking);

        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public List<TreatmentBooking> delete(@PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
