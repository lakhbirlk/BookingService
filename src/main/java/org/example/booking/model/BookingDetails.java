package org.example.booking.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bookingDetails")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String theaterName;      // Name of the theater
    private String theaterAddress;   // Address of the theater
    private String movieName;        // Name of the movie
    private String showTime;         // Timing of the show (e.g., "7:00 PM")
    private String showDate;         // Date of the show (e.g., "2024-11-20")
    private int seatNumber;          // Seat number reserved for the booking
    private double ticketPrice;      // Price of the ticket
    private String screenNumber;


    @OneToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

}