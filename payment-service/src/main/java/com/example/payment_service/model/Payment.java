package com.example.payment_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {
    @Id
    private Long id ;
    private String bookingId;
    private double amount;
    private String status;

    // Getters and Setters
    public Payment() {}

    // Parameterized constructor
    public Payment(Long id, String bookingId, double amount, String status) {
        this.id = id;
        this.bookingId = bookingId;
        this.amount = amount;
        this.status = status;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}