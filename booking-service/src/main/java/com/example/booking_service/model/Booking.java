package com.example.booking_service.model;



import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    private String id;
    @Column
    private String customerName;
    @Column
    private String hotelId;
    @Column
    private String roomType;
    @Column
    private String numberOfGuests;

    // Getters and Setters
    public Booking() {}

    // Parameterized constructor
    public Booking( String id,String customerName, String hotelId, String roomType, String numberOfGuests) {
        this.id=id;
        this.customerName = customerName;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.numberOfGuests = numberOfGuests;
    }

    // Getters and Setters
    public String getId() { // Fix getter
        return id;
    }

    public void setId(String id) { // Fix setter
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(String numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
}
