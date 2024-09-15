package com.example.bmsbookticket.repositories;

import com.example.bmsbookticket.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    //Optional<Movie> findByMovieId(int movieId);
}
