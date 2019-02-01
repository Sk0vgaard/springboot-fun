package com.example.springbootfun.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Entity annotation marks this class as being an entity so it can be mapped to a table.
@Entity
public class TreatmentBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // For the id to be generated sequentially.
    private long id;

    private String treatmentName;
    private double priceForTreatment;
    private double lengthOfTreatment;
    private int numberOfTreatments;

    // Empty default constructer for spring to create a object based on the input send via frontend.
    public TreatmentBooking() {}

    public TreatmentBooking(String treatmentName, double priceForTreatment, double lengthOfTreatment, int numberOfTreatments) {
        this.treatmentName = treatmentName;
        this.priceForTreatment = priceForTreatment;
        this.numberOfTreatments = numberOfTreatments;
        this.lengthOfTreatment = lengthOfTreatment;
    }

    public long getId() {
        return id;
    }

    public double getLengthOfTreatment() {
        return lengthOfTreatment;
    }

    public String getTreatmentName() {
        return treatmentName;
    }

    public double getPriceForTreatment() {
        return priceForTreatment;
    }

    public int getNumberOfTreatments() {
        return numberOfTreatments;
    }

    public double getTotalPrice() { return priceForTreatment * numberOfTreatments; }
}
