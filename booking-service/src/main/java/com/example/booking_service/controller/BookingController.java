package com.example.booking_service.controller;

import com.example.booking_service.feign.HotelServiceClient;
import com.example.booking_service.model.Booking;
import com.example.booking_service.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private HotelServiceClient hotelServiceClient;

    @GetMapping("/hotels")
    public List<Object> getAllHotels() {
        return hotelServiceClient.getAllHotels(); // Calls Hotel Service to fetch all hotels
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

   // @PostMapping
  //  public Booking createBooking(@RequestBody Booking booking) {
  //      return bookingRepository.save(booking);
 //   }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        // Validate the hotelId
        try {
            Object hotel = hotelServiceClient.getHotelById(Long.parseLong(booking.getHotelId()));

            if (hotel == null) {
                throw new RuntimeException("Invalid hotel ID: " + booking.getHotelId());
            }
        } catch (Exception e) {
            throw new RuntimeException("Invalid hotel ID: " + booking.getHotelId(), e);
        }

        // Save the booking if hotelId is valid
        return bookingRepository.save(booking);
    }
}
