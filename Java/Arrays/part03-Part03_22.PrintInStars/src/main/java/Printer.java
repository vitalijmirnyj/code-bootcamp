
public class Printer {

    public static void main(String[] args) {

        int[] array = {5, 1, 3, 4, 2};
        printArrayInStars(array);

    }

    public static void printArrayInStars(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            printStars(array[i]);
        }
    }

    public static void printStars(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print("*");

        }
        System.out.println();
    }
}