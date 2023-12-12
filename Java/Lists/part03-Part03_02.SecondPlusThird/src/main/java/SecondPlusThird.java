
import java.util.ArrayList;
import java.util.Scanner;

public class SecondPlusThird {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();
        while (true) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number == 0) {
                break;
            }

            numbers.add(number);
        }
        int number1 = numbers.get(1);
        int number2 = numbers.get(2);
        System.out.println(number1 + number2);
    }
}
