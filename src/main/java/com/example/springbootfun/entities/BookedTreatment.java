package com.example.springbootfun.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class BookedTreatment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id; // Primary key
    @NotEmpty
    private String date;
    @NotEmpty
    private String treatment;
    @NotEmpty
    private String bookingDate;
    private String description;
    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;

    public BookedTreatment() { }

    public BookedTreatment(String date, String treatment, String bookingDate, String description, User user) {
        this.date = date;
        this.treatment = treatment;
        this.bookingDate = bookingDate;
        this.description = description;
        this.user = user;
    }

    public BookedTreatment(String date, String treatment, String bookingDate, String description) {
        this.date = date;
        this.treatment = treatment;
        this.bookingDate = bookingDate;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
