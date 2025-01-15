package com.example.hotel_service.controller;



import com.example.hotel_service.model.Hotel;
import com.example.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;


    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotel not found with ID: " + id));
    }

    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotel.setName(hotelDetails.getName());
            hotel.setLocation(hotelDetails.getLocation());
            hotel.setAvailableRooms(hotelDetails.getAvailableRooms());
            return hotelRepository.save(hotel);
        } else {
            return null;  // Return null if hotel is not found
        }
    }

    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) {
        if (hotelRepository.existsById(id)) {
            hotelRepository.deleteById(id);
            return "Hotel deleted successfully.";
        } else {
            return "Hotel not found.";  // Return a message if hotel is not found
        }
    }
}
