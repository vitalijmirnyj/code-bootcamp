package lt.techin.demo.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Directors")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long director_id;

    private String directorName;

    private LocalDate dateOfBirth;

    private String nationality;

    private String biography;

    private String awards;

    public Director(long director_id, String directorName, LocalDate dateOfBirth, String nationality, String biography, String awards) {
        this.director_id = director_id;
        this.directorName = directorName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.biography = biography;
        this.awards = awards;
    }

    public long getDirector_id() {
        return director_id;
    }

    public String getDirectorName() {
        return directorName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public String getBiography() {
        return biography;
    }

    public String getAwards() {
        return awards;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public Director() {

    }
}
