package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "Movie_id")
    private Movie movie;
    private String website;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private User user;
    private double ratingScore;


    public Review(Movie movie, String website, User user, double ratingScore) {

        this.movie = movie;
        this.website = website;
        this.user = user;
        this.ratingScore = ratingScore;

    }

    public Review() {

    }

    public long getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getWebsite() {
        return website;
    }

    public User getUserName() {
        return user;
    }

    public double getRatingScore() {
        return ratingScore;
    }

    public void setMovieId(Movie movie) {
        this.movie = movie;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setUserName(User userName) {
        this.user = user;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }
}


