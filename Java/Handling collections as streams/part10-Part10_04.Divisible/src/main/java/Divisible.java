import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Divisible {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(3);
        numbers.add(2);
        numbers.add(11);
        numbers.add(10);
        numbers.add(13);
        numbers.add(4);
        numbers.add(12);
        numbers.add(13);
        numbers.add(20);
        numbers.add(15);

        ArrayList<Integer> divisibleNumbers = divisible(numbers);
        System.out.println("Divisible Numbers: " + divisibleNumbers);
    }

    public static ArrayList<Integer> divisible(ArrayList<Integer> numbers) {
        return numbers.stream()
                .filter(value -> value % 2 == 0 || value % 3 == 0 || value % 5 == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

}