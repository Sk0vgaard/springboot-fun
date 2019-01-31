package com.example.springbootfun.models;

public class TreatmentBooking {
    private String treatmentName;
    private double priceForTreatment;
    private double timeOfTreatment;
    private int numberOfTreatments;

    // Empty default constructer for spring to create a object based on the input send via frontend.
    public TreatmentBooking() {}

    public TreatmentBooking(String treatmentName, double priceForTreatment, double timeOfTreatment, int numberOfTreatments) {
        this.treatmentName = treatmentName;
        this.priceForTreatment = priceForTreatment;
        this.numberOfTreatments = numberOfTreatments;
        this.timeOfTreatment = timeOfTreatment;
    }

    public double getTimeOfTreatment() {
        return timeOfTreatment;
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

    public double getTotalPrice() {
        return priceForTreatment * numberOfTreatments;
    }
}
