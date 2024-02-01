import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

public class PositiveNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-3);
        numbers.add(2);
        numbers.add(-6);

        List<Integer> positiveNumbers = positive(numbers);

        System.out.println("Positive Numbers: " + positiveNumbers);
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream().filter(num -> num > 0).collect(Collectors.toCollection(ArrayList::new));
    }
}

