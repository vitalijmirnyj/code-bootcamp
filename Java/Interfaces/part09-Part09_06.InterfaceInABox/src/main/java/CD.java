public class CD implements Packable {
    double weight = 0.1;
    String artist;
    String cdName;
    int publicationYear;

    public CD(String artist, String cdName, int publicationYear) {
        this.artist = artist;
        this.cdName = cdName;
        this.publicationYear = publicationYear;
    }

    @Override
    public double weight() {
        return weight;
    }


    @Override
    public String toString() {
        return artist + ":" + " " + cdName + " " + "(" + publicationYear + ")";
    }
}
