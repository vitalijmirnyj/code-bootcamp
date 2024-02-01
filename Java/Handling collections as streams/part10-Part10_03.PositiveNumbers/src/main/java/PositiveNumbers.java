import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Locale.filter;

public class PositiveNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
    }

    public static List<Integer> positive(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}

