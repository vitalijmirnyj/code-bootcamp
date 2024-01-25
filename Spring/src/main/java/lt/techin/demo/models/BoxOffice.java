package lt.techin.demo.models;

import lt.techin.demo.models.Movie;
import jakarta.persistence.*;

@Entity

@Table(name = "boxoffice")
public class BoxOffice {
    @Id
    private long movieId;

    @OneToOne
    @JoinColumn(name = "Movie_id")
    @MapsId
    private Movie movie;
    private double rating;
    private long domesticSales;
    private long internationalSales;

    public BoxOffice(long movieId, double rating, long domesticSales, long internationalSales) {

        this.movieId = movieId;
        this.rating = rating;
        this.domesticSales = domesticSales;
        this.internationalSales = internationalSales;
    }

    public BoxOffice() {

    }

    public long getMovieId() {
        return movieId;
    }

    public double getRating() {
        return rating;
    }

    public long getDomesticSales() {
        return domesticSales;
    }

    public long getInternationalSales() {
        return internationalSales;
    }


    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDomesticSales(long domesticSales) {
        this.domesticSales = domesticSales;
    }

    public void setInternationalSales(long internationalSales) {
        this.internationalSales = internationalSales;
    }
}
