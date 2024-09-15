package com.example.bmsbookticket.services;

import com.example.bmsbookticket.exceptions.MovieNotFoundException;
import com.example.bmsbookticket.exceptions.UserNotFoundException;
import com.example.bmsbookticket.models.Movie;
import com.example.bmsbookticket.models.Rating;
import com.example.bmsbookticket.models.User;
import com.example.bmsbookticket.repositories.MovieRepository;
import com.example.bmsbookticket.repositories.RatingRepository;
import com.example.bmsbookticket.repositories.UserRepository;

import java.util.Optional;

public class RatingServiceImpl implements RatingsService{
    private RatingRepository ratingRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    public Rating rateMovie(int userId, int movieId, int rating) throws UserNotFoundException, MovieNotFoundException{
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }
        User user = userOptional.get();

        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if(movieOptional.isEmpty()){
            throw new MovieNotFoundException("Movie Not Found");
        }
        Movie movie = movieOptional.get();
        Rating userRating = new Rating();
        userRating.setUser(user);
        userRating.setMovie(movie);
        userRating.setRating(rating);
        ratingRepository.save(userRating);
        return userRating;
    }

    public double getAverageRating(int movieId) throws MovieNotFoundException{
        Optional<Movie> movieOptional = movieRepository.findById(movieId);
        if(movieOptional.isEmpty()){
            throw new MovieNotFoundException("Movie Not Found");
        }
        Double avgRating = ratingRepository.getAverageRatingForMovie(movieId);
        return avgRating;
    }
}
