
public class AdvancedAstrology {

    public static void printStars(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void printSpaces(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(" ");
        }
    }

    public static void printTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printSpaces(size - i);
            printStars(i);
        }

    }


    public static void christmasTree(int height) {

        for (int i = 1; i <= height; i++) {
            if (i == 1) {
                printSpaces(height - i);
                printStars(i);
            }

            if (i % 2 == 0 && i != 1) {
                printSpaces(height - i);
                printStars((i * 2) - 1);
            }

            if (i % 2 != 0 && i != 1) {
                printSpaces(height - i);
                printStars(i + (i - 1));
            }

        }
      int countOfStarsInLastRow = (((height * 2) - 1) - 3) / 2;
        printSpaces(countOfStarsInLastRow);
        printStars(3);
        printSpaces(countOfStarsInLastRow);
        printStars(3);

    }

    public static void main(String[] args) {
        christmasTree(6);
    }
}


