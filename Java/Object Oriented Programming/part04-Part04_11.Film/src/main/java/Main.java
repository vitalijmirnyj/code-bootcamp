
public class Main {

    public static void main(String[] args) {
       Film film = new Film("Titanic", 12);
        System.out.println("People from age " + film.ageRating() + " can watch a movie " + film.name());

    }
}
