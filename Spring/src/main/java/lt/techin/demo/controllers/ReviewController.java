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
    public List<Review> getReview() {
        return this.reviewRepository.findAll();
    }

    @GetMapping("/reviews/{id}")
    public Review getReview(@PathVariable long id) {
        return this.reviewRepository.findById(id).orElseThrow();
    }

    @PostMapping("/reviews")
    public Review insertReview(@RequestBody Review review) {
        return this.reviewRepository.save(review);
    }

    @PutMapping("/reviews/{id}")
    public Review updateReview(@RequestBody Review review, @PathVariable long id) {
        if (this.reviewRepository.existsById(id)) {
            Review reviewFromDb = this.reviewRepository.findById(id).orElseThrow();
            reviewFromDb.setMovieId(review.getMovie());
            reviewFromDb.setWebsite(review.getWebsite());
            reviewFromDb.setUser(review.getUserName());
            reviewFromDb.setRatingScore(review.getRatingScore());

            return this.reviewRepository.save(reviewFromDb);
        } else {

            return this.reviewRepository.save(review);
        }
    }

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable long id) {
        this.reviewRepository.deleteById(id);
    }
}