# Hotel Management System - Service Integration

This project is a hotel management system composed of three microservices: 
- **Hotel Service**
- **Booking Service**
- **Payment Service**
  
The services are designed to interact with each other, providing a complete solution for booking hotels and processing payments.

## Overview

### Microservices
1. *Hotel Service*: Handles hotel details like availability and pricing.
2. *Booking Service*: Manages booking requests, validating hotel availability and processing bookings.
3. *Payment Service*: Manages payment processing and tracks payment status.

Each service is run on a different port:
- *Hotel Service*: Port 8081
- *Booking Service*: Port 8082
- *Payment Service*: Port 8083

These services communicate with each other to validate data and ensure proper booking and payment processing.

## Project Setup

The database used for the project is MySQL, managed via *phpMyAdmin*. The services interact with the database to store and retrieve data about hotels, bookings, and payments.

### MySQL Database Setup

1. Open *phpMyAdmin* and create a new database (e.g., hotel_booking_system).
2. Import the SQL schema into the database that defines the necessary tables for *hotels, **bookings, and **payments*.

The project’s database consists of three main tables:
- *Hotels*: Stores hotel details.
- *Bookings*: Stores booking information.
- *Payments*: Stores payment transaction details.

### Microservice Communication

- *Hotel Service* can be accessed via *Booking Service*.
- *Booking Service* communicates with *Payment Service*.

The communication between these services ensures validation of data across the system.

## Service Details

### Hotel Service

*Hotel Service* is responsible for managing hotel data. It stores information about hotels, including:

- *ID*: Unique identifier for the hotel.
- *Name*: The name of the hotel.
- *Location*: The geographical location of the hotel.
- *Available Rooms*: The number of rooms available at the hotel.

### Booking Service

*Booking Service* handles the process of booking a hotel room. It stores and manages the following details:

- *Booking ID*: Unique identifier for each booking.
- *Customer Name*: Name of the customer making the booking.
- *Hotel ID*: The unique identifier of the hotel being booked.
- *Room Type*: The type of room being booked (e.g., single, double, suite).
- *Number of Guests*: The number of people for whom the booking is made.

### Payment Service

*Payment Service* is responsible for processing payments related to hotel bookings. It stores and manages the following details:

- *ID*: Unique identifier for each payment.
- *Booking ID*: The unique identifier of the booking for which the payment is being made.
- *Amount*: The total amount for the booking.
- *Status*: The current status of the payment (e.g., pending, completed, failed).

## CRUD Operations

Each service performs basic CRUD (Create, Read, Update, Delete) operations for managing hotels, bookings, and payments.

## Conclusion

This hotel booking system uses microservices to effectively manage hotel data, bookings, and payments. The services interact with each other to ensure a smooth booking and payment process, and all data is validated to maintain consistency across the system.
