package org.example.booking.service;

import org.example.booking.Respository.BookingRepository;
import org.example.booking.exception.ResourceNotFoundException;
import org.example.booking.model.Booking;
import org.example.rest.Movie;
import org.example.rest.Screen;
import org.example.rest.Show;
import org.example.rest.Slot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Slot fetchSlotData(Long slotId,Long showId) {

        String url = "http://localhost:8081/shows/{showId}/Slot/{slotId}";

        // Fetch data from the API
        return restTemplate.getForObject(url, Slot.class, showId, slotId);
    }

    public Show fetchShowData(Long slotId, Long showId) {

        String url = "http://localhost:8081/shows/{showId}/";

        // Fetch data from the API
        return restTemplate.getForObject(url, Show.class, showId);
    }

    public Movie fetchMovieData(Long movieId) {

        String url = "http://localhost:8083/movies/{movieId}/";

        // Fetch data from the API
        return restTemplate.getForObject(url, Movie.class, movieId);
    }

    public Screen fetchScreenData(Long screenId) {

        String url = "http://localhost:8083/api/v1/screens/{screenId}/";

        // Fetch data from the API
        return restTemplate.getForObject(url, Screen.class, screenId);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    /**
     * Retrieve all bookings.
     *
     * @return List of all bookings
     */
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    /**
     * Retrieve a booking by ID.
     *
     * @param id Booking ID
     * @return Booking entity
     * @throws ResourceNotFoundException if booking is not found
     */
    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with ID: " + id));
    }

    /**
     * Update an existing booking.
     *
     * @param id      Booking ID
     * @param booking Updated booking data
     * @return Updated booking entity
     * @throws ResourceNotFoundException if booking is not found
     */
    public Booking updateBooking(Long id, Booking booking) {
        Booking existingBooking = getBookingById(id);
        existingBooking.setShowId(booking.getShowId());
        existingBooking.setSeatId(booking.getSeatId());
        existingBooking.setSlotId(booking.getSlotId());
        existingBooking.setUserId(booking.getUserId());
        existingBooking.setMovieId(booking.getMovieId());
        existingBooking.setPaymentId(booking.getPaymentId());
        existingBooking.setTheatreId(booking.getTheatreId());
        existingBooking.setBookingStatus(booking.getBookingStatus());
        existingBooking.setBookingDetails(booking.getBookingDetails());

        return bookingRepository.save(existingBooking);
    }

    /**
     * Delete a booking by ID.
     *
     * @param id Booking ID
     * @throws ResourceNotFoundException if booking is not found
     */
    public void deleteBooking(Long id) {
        Booking booking = getBookingById(id);
        bookingRepository.delete(booking);
    }
}




