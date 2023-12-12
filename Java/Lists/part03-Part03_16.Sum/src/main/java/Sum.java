
import java.util.ArrayList;

public class Sum {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        sum(numbers);
    }

    public static int sum(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int i = 0; i <= numbers.size() - 1; i++) {
            sum = sum + numbers.get(i);

        }
        return sum;
    }
}