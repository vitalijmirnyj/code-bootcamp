package lt.techin.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity

@Table(name = "Movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Size(min = 1, message = "First name should be at least 1 characters long")
    private String title;
    @NotNull
    private String director;
    @NotNull
    @Min(value = 1900, message = "Year of release should be 1900 or later")
    @Past(message = "Release date cannot be in the future")
    private short yearRelease;
    @Min(value = 30, message = "Length should not be lower than 30 minutes")
    @Max(value = 600, message = "Length should not be longer than 600 minutes")
    private short lengthMinutes;

    public Movie(String title, String director, short yearRelease, short lengthMinutes) {

        this.title = title;
        this.director = director;
        this.yearRelease = yearRelease;
        this.lengthMinutes = lengthMinutes;
    }

    public Movie() {

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public short getYearRelease() {
        return yearRelease;
    }

    public short getLengthMinutes() {
        return lengthMinutes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setYearRelease(short yearRelease) {
        this.yearRelease = yearRelease;
    }

    public void setLengthMinutes(short lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}
