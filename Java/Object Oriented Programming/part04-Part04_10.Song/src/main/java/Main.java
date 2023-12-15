
public class Main {

  public static void main(String[] args) {
    Song song = new Song("Garden", 3000);
    System.out.println("The song " + song.name() + "has a length of " + song.length() + " seconds.");
  }
}
