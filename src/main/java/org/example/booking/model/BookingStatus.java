package org.example.booking.model;

public enum BookingStatus {
    BOOKED,
    FAILED,
    PAYMENT_FAILED,
    PAYEMNT_PENDIND;

    @Override
    public String toString() {
        // Capitalize each word for better readability
        return name().charAt(0) + name().substring(1).toLowerCase().replace("_", " ");
    }
}