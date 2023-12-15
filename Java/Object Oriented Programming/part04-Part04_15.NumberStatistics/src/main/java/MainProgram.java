
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      Statistics stat = new Statistics();
      Statistics stat2 = new Statistics();
      Statistics stat3 = new Statistics();
        System.out.println("Enter numbers:");
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            stat.addNumber(input);
            if (input % 2 == 0) {
                stat2.addNumber(input);
            } else {
                stat3.addNumber(input);
            }

        }
        System.out.println("Sum: " + stat.sum());
        System.out.println("Sum of even numbers: " + stat2.sum());
        System.out.println("Sum of odd numbers: " + stat3.sum());
    }
}
