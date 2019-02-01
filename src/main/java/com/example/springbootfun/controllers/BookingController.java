package com.example.springbootfun.controllers;

import com.example.springbootfun.models.TreatmentBooking;
import com.example.springbootfun.repositories.BookingRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
@Api(name = "Treatment Booking API", description = "Provides a list of methods that manage treatment bookings", stage = ApiStage.RC)
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all treatment bookings from the database")
    public List<TreatmentBooking> getAll() {
        return bookingRepository.findAll();
    }

    /* Filter to show prices equals or below fx 300. */
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all treatments where the price is less or equal than the provided value")
    public List<TreatmentBooking> getAffordable(@ApiPathParam(name = "price") @PathVariable double price) {
        return bookingRepository.findByPriceForTreatmentLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a treatment and saves it to the database")
    public List<TreatmentBooking> create(@RequestBody TreatmentBooking treatmentBooking) {
        bookingRepository.save(treatmentBooking);

        return bookingRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Deletes the treatment booking with the provided ID from the database")
    public List<TreatmentBooking> delete(@ApiPathParam(name = "id") @PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
