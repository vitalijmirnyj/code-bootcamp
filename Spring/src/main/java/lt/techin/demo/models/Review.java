package lt.techin.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long movieId;
    private String website;
    private String userName;
    private double ratingScore;


    public Review(long id, long movieId, String website, String userName, double ratingScore) {
        this.id = id;
        this.movieId = movieId;
        this.website = website;
        this.userName = userName;
        this.ratingScore = ratingScore;

    }

    public Review() {

    }

    public long getId() {
        return id;
    }

    public long getMovieId() {
        return movieId;
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

    public void setMovieId(long movieId) {
        this.movieId = movieId;
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

