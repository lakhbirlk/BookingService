package org.example.rest;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId; // Primary key

    private String title; // Movie title
    private String genre; // Genre of the movie
    private LocalDate releaseDate; // Release date of the movie
    private String director; // Director of the movie
    private double duration; // Duration in hours

    // Additional attributes
    private String description;
    private String language;
    private double rating; // Rating (e.g., IMDB)

}