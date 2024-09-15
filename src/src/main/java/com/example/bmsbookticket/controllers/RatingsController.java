package com.example.bmsbookticket.controllers;

import com.example.bmsbookticket.dtos.*;
import com.example.bmsbookticket.exceptions.MovieNotFoundException;
import com.example.bmsbookticket.models.Rating;
import com.example.bmsbookticket.services.RatingServiceImpl;
import com.example.bmsbookticket.services.RatingsService;

public class RatingsController {
    private RatingServiceImpl ratingServiceImpl;
    public RateMovieResponseDto rateMovie(RateMovieRequestDto requestDto){
        RateMovieResponseDto responseDto = new RateMovieResponseDto();
        try{
            Rating rating = ratingServiceImpl.rateMovie(requestDto.getUserId(),requestDto.getMovieId(),requestDto.getRating());
            responseDto.setRating(rating);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }

    public GetAverageMovieResponseDto getAverageMovieRating(GetAverageMovieRequestDto requestDto){
        GetAverageMovieResponseDto responseDto = new GetAverageMovieResponseDto();
        try{
            Double avgRating = ratingServiceImpl.getAverageRating(requestDto.getMovieId());
            responseDto.setAverageRating(avgRating);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (MovieNotFoundException e) {
            throw new RuntimeException(e);
        }
        return responseDto;
    }
}
