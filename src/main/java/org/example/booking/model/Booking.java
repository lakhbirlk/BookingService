package org.example.booking.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long showId;
    private Long seatId;
    private Long slotId;
    private Long userId;
    private Long movieId;
    private Long paymentId;
    private Long theatreId;


    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "booking")
    private BookingDetails bookingDetails;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    @PrePersist
    private void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    private void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
