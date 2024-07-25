package com.example.geekText.RatingLibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/rating")
public class RatingController {
    private final RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public void registerNewRating(@RequestBody Rating rating) {
        ratingService.addNewRating(rating);
    }

    @PutMapping
    public void updateNewRating(@RequestBody Rating rating) {
        ratingService.updateNewRating(rating);
    }

}
