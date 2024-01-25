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
    private String userName;
    private double ratingScore;


    public Review(Movie movie, String website, String userName, double ratingScore) {

        this.movie = movie;
        this.website = website;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setRatingScore(double ratingScore) {
        this.ratingScore = ratingScore;
    }
}


