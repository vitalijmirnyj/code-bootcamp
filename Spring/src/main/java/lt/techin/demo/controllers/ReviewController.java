package lt.techin.demo.controllers;

import lt.techin.demo.models.Review;
import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @GetMapping("/reviews")
    public List<Review> getMovies() {
        return this.reviewRepository.findAll();
    }

    @GetMapping("/review/{id}")
    public Review getReview(@PathVariable long id) {
        return this.reviewRepository.findById(id).orElseThrow();
    }

    @PostMapping("/reviews")
    public void insertReview(@RequestBody Review review) {
        this.reviewRepository.save(review);
    }

    @PutMapping("/review/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable long id) {
        if (this.reviewRepository.existsById(id)) {
            Review reviewFromDb = this.reviewRepository.findById(id).orElseThrow();
            reviewFromDb.setWebsite(review.getWebsite());
            reviewFromDb.setUserName(review.getUserName());
            reviewFromDb.setRatingScore(review.getRatingScore());

            return this.reviewRepository.save(reviewFromDb);
        }

        return this.reviewRepository.save(review);
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable long id) {
        this.reviewRepository.deleteById(id);
    }
}