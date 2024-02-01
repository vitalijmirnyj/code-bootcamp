import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            inputs.add(row);
        }
        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String chooseNOrP = scanner.nextLine();
        if (chooseNOrP.equals("p")) {
            OptionalDouble averageOfPositive = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number > 0)
                    .average();
            System.out.println("Average of the positive numbers: " + averageOfPositive);
        }
        if (chooseNOrP.equals("n")) {
            OptionalDouble averageOfNegative = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number < 0)
                    .average();
            System.out.println("Average of the negative numbers: " + averageOfNegative);
        }
    }
}