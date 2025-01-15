
package com.example.hotel_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {
    @Id
    private Long id;
    private String name;
    private String location;
    private String availableRooms;

    public Hotel()
    {

    }
    // Getters and Setters
    public Hotel(Long id, String name, String location, String availableRooms) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.availableRooms = availableRooms;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(String availableRooms) {
        this.availableRooms = availableRooms;
    }
}

