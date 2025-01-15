package com.example.payment_service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "booking-service") // Replace with the actual URL of the Booking Service
public interface BookingServiceClient {

    @GetMapping("/bookings") // Endpoint to fetch all bookings
    List<Object> getAllBookings();

    @GetMapping("/bookings/{id}") // Endpoint to fetch a booking by ID
    Object getBookingById(@PathVariable("id") Long bookingId);
}