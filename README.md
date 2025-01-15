# Hotel Management System - Service Integration

This project is a hotel management system composed of three microservices: **Hotel Service**, **Booking Service**, and **Payment Service**, integrated with **Eureka Server** for service discovery. The services are designed to interact with each other, providing a complete solution for booking hotels and processing payments.


## Overview

### Microservices
1. *Hotel Service*: Handles hotel details like availability and pricing.
2. *Booking Service*: Manages booking requests, validating hotel availability and processing bookings.
3. *Payment Service*: Manages payment processing and tracks payment status.
4. *Eureka Server*: A service registry for enabling service discovery among microservices.

Each service is run on a different port:
- *Hotel Service*: Port 8081
- *Booking Service*: Port 8082
- *Payment Service*: Port 8083
- *Eureka Server*: Port 8761

The microservices are registered with the Eureka Server to facilitate seamless communication and service discovery.

## Project Setup

### MySQL Database Setup

1. Open *phpMyAdmin* and create a new database (e.g., hotel_booking_system).
2. Import the SQL schema into the database that defines the necessary tables for *hotels, **bookings, and **payments*.

The project’s database consists of three main tables:
- *Hotels*: Stores hotel details.
- *Bookings*: Stores booking information.
- *Payments*: Stores payment transaction details.

### Spring Initializr Usage for Setup

To create the projects for *Eureka Server, **Hotel Service, **Booking Service, and **Payment Service, use **Spring Initializr*:

1. Navigate to [Spring Initializr](https://start.spring.io/).
2. For each microservice (including the Eureka Server), configure the following:
   - *Project*: Maven
   - *Language*: Java
   - *Spring Boot Version*: Latest stable version
3. Add dependencies:
   - For Eureka Server: *Eureka Server, **Spring Boot Actuator*.
   - For Hotel, Booking, and Payment Services: *Spring Web, **Spring Data JPA, **MySQL Driver, **Spring Boot Actuator, **Eureka Client*.
4. Generate and download the projects.
5. Import the projects into your IDE and configure them as needed.

### Eureka Server Setup

1. Configure the *Eureka Server* to act as a service registry:
   - Set up the application.properties or application.yml file to enable the Eureka Server functionality.
   - Start the server on port 8761.
2. Register each microservice with the Eureka Server by configuring their application.properties or application.yml files to include Eureka Client settings.

### Microservice Communication

- *Hotel Service* validates availability and provides hotel details for the *Booking Service*.
- *Booking Service* communicates with the *Payment Service* for processing payments.
- *Eureka Server* enables service discovery, allowing the microservices to locate and interact with each other dynamically.

## Service Details

### Hotel Service

*Hotel Service* manages hotel-related data, including:

- *ID*: Unique identifier for the hotel.
- *Name*: The name of the hotel.
- *Location*: The geographical location of the hotel.
- *Available Rooms*: The number of rooms available at the hotel.

### Booking Service

*Booking Service* handles the management of hotel bookings, including:

- *Booking ID*: Unique identifier for each booking.
- *Customer Name*: Name of the customer making the booking.
- *Hotel ID*: The unique identifier of the hotel being booked.
- *Room Type*: The type of room being booked (e.g., single, double, suite).
- *Number of Guests*: The number of people for whom the booking is made.

### Payment Service

*Payment Service* processes payments for hotel bookings, including:

- *Payment ID*: Unique identifier for each payment transaction.
- *Booking ID*: The unique identifier of the booking associated with the payment.
- *Amount*: The total amount for the booking.
- *Status*: The current status of the payment (e.g., pending, completed, failed).

## CRUD Operations

Each service supports basic CRUD (Create, Read, Update, Delete) operations for managing hotels, bookings, and payments. 

## Testing

Testing of all services, including CRUD operations, was conducted using *Postman*. Each service was tested independently and in integration to ensure smooth communication and data consistency across the system.

## Conclusion

This hotel booking system uses microservices architecture and service discovery with *Eureka Server* to provide an efficient solution for managing hotels, bookings, and payments. By using Spring Boot and integrating service discovery, the system is designed for scalability and reliability.
