package com.example.bmsbookticket.repositories;

import com.example.bmsbookticket.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RatingRepository extends JpaRepository<Rating, Integer> {
    //Optional<Rating> getRating(int id);
   // Optional<Integer> getRatingByMovieId(int movieId);
    //Optional<Rating> save(Rating rating);
    @Query("SELECT AVG(r.rating) FROM Rating r WHERE r.movie.id = ?1")
    Double getAverageRatingForMovie(Integer movieId);
}
