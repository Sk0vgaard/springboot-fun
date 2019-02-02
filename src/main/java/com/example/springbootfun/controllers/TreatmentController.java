package com.example.springbootfun.controllers;

import com.example.springbootfun.entities.Treatment;
import com.example.springbootfun.repositories.TreatmentRepository;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bookings")
// For visual json doc visit: @see http://localhost:8080/jsondoc-ui.html#
// Insert http://localhost:8080/jsondoc in the input field.
@Api(name = "Treatment Booking API", description = "Provides a list of methods that manage treatment bookings", stage = ApiStage.RC)
public class TreatmentController {

    private TreatmentRepository treatmentRepository;

    @Autowired
    public TreatmentController(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all treatment bookings from the database")
    public List<Treatment> getAll() {
        return treatmentRepository.findAll();
    }

    /* Filter to show prices equals or below fx 300. */
    @RequestMapping(value = "/affordable/{price}", method = RequestMethod.GET)
    @ApiMethod(description = "Get all treatments where the price is less or equal than the provided value")
    public List<Treatment> getAffordable(@ApiPathParam(name = "price") @PathVariable double price) {
        return treatmentRepository.findByPriceForTreatmentLessThan(price);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create a treatment and saves it to the database")
    public List<Treatment> create(@RequestBody Treatment treatment) {
        treatmentRepository.save(treatment);

        return treatmentRepository.findAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Deletes the treatment booking with the provided ID from the database")
    public List<Treatment> delete(@ApiPathParam(name = "id") @PathVariable long id) {
        treatmentRepository.deleteById(id);

        return treatmentRepository.findAll();
    }
}
