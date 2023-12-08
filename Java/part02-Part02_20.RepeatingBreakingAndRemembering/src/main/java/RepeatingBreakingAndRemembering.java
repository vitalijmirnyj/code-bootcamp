//testgit 
import java.util.Scanner;

public class RepeatingBreakingAndRemembering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give numbers:");
        int sum = 0;
        int numberOfNumbers = 0;
        int evenNumbers = 0;
        int oddNumbers = 0;
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());

            if (number != -1) {
                sum = sum + number;
                numberOfNumbers = numberOfNumbers + 1;

            }
            if (number % 2 == 0) {
                evenNumbers = evenNumbers + 1;

            } else if (number != -1) {
                oddNumbers = oddNumbers + 1;
            }
            if (number == -1) {
                break;
            }
        }
        System.out.println("Thx! Bye!");
        System.out.println("Sum: " + sum);
        System.out.println("Numbers: " + numberOfNumbers);
        System.out.println("Average: " + ((double)sum / numberOfNumbers));
        System.out.println("Even: " + evenNumbers );
        System.out.println("Odd: " + oddNumbers);
    }
}
