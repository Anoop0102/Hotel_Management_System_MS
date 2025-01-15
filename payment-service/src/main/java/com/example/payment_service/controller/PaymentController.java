package com.example.payment_service.controller;

import com.example.payment_service.model.Payment;
import com.example.payment_service.client.BookingServiceClient;
import com.example.payment_service.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private BookingServiceClient bookingServiceClient;

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @GetMapping("/bookings")
    public List<Object> getAllBookings() {
        return bookingServiceClient.getAllBookings(); // Calls Booking Service to fetch all bookings
    }
  //  @PostMapping
   // public Payment createPayment(@RequestBody Payment payment) {
   //     return paymentRepository.save(payment);
  //  }
  @PostMapping
  public Payment createPayment(@RequestBody Payment payment) {
      // Validate booking ID by calling Booking Service
      try {
          bookingServiceClient.getBookingById(Long.parseLong(payment.getBookingId()));
      } catch (Exception e) {
          throw new IllegalArgumentException("Invalid booking ID: " + payment.getBookingId());
      }

      // Save the payment in the repository
      return paymentRepository.save(payment);
}


}