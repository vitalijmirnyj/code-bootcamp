
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfAList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            numbers.add(input);
        }

        System.out.println("");

        int sum = 0;
        int numberOfInputs = 0;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            sum = sum + numbers.get(i);
            numberOfInputs += 1;
        }
        System.out.println("Average: " + ((double) sum / numberOfInputs));
    }
}