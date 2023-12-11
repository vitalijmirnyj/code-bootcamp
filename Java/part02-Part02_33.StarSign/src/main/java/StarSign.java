
public class StarSign {

    public static void main(String[] args) {

        printStars(5);
        printStars(3);
        printStars(9);

        printSquare(4);

        printRectangle(17, 3);
    }

    public static void printStars(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void printSquare(int size) {
        for (int i = 1; i <= size; i++) {
            printStars(size);
        }

    }

    public static void printRectangle(int width, int height) {
        printStars(width);
        printStars(height);
    }

    public static void printTriangle(int size) {
        // fourth part of the exercise
    }
}
