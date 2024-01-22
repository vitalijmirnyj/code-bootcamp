package lt.techin.demo.models;

public class Movie {
    private long id;
    private String title;
    private String Director;
    private short yearRelease;
    private short lengthMinutes;

    public Movie(long id, String title, String director, short yearRelease, short lengthMinutes) {
        this.id = id;
        this.title = title;
        Director = director;
        this.yearRelease = yearRelease;
        this.lengthMinutes = lengthMinutes;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return Director;
    }

    public short getYearRelease() {
        return yearRelease;
    }

    public short getLengthMinutes() {
        return lengthMinutes;
    }
}
