package com.example.booking_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-service") // Service name registered in Eureka
public interface HotelServiceClient {

    @GetMapping("/hotels") // Endpoint to fetch all hotels
    List<Object> getAllHotels();

    @GetMapping("/hotels/{id}") // Fetch a specific hotel by ID
    Object getHotelById(@PathVariable("id") Long id);

    @GetMapping("/bookings/{id}") // Endpoint to fetch a booking by ID
    Object getBookingById(@PathVariable("id") Long bookingId);

}